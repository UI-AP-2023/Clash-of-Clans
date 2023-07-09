package controller;

import Hero.Hero;
import Hero.Archer;
import com.example.game.*;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import model.Building;
import model.BuildingType;
import model.Map;
import model.Player;
import mysql.MySQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class GameController {
    private static GameController gameController;
    public static ArrayList<Player> players = new ArrayList<>();
    public static HashMap<Integer, Map> listOfMaps = new HashMap<>();
    private Player player;
    //    private GameController() {
//    }
//
//    public static GameController getInstance() {
//        if (gameController == null) {
//            gameController = new GameController();
//        }
//        return gameController;
//    }
//
//    public static GameController getGameController() {
//        return gameController;
//    }

    //----------------functions related to opponent player--------------------------------------------------------------
    private final PlayerController playerController = new PlayerController();

    public Player randomMap() throws SQLException, ClassNotFoundException {
        Random random = new Random();
        int ID = random.nextInt(1, playerController.findMaxID());
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = "SELECT `ID`, `playerID`, `password`, `playerLevel`, `numberOfWins`, `numberOfLosses`, `mapID` FROM `players`";
        ResultSet rs = mySQLConnection.executeQuery(sql);

        while (rs.next()) {
            if (Objects.equals(rs.getInt("ID"), ID)) {
                if (!Objects.equals(rs.getString("playerID"), LoginPageController.loginPlayer.getPlayerID())) {
                    player = new Player(rs.getString("playerID"), rs.getString("password"), rs.getInt("playerLevel"),
                            rs.getInt("numberOfWins"), rs.getInt("numberOfLosses"), rs.getInt("mapID"));
                    return player;
                }
            }
        }
        return randomMap();
    }

    //------------------------------------------------------------------------------------------------------------------
    double deltaX;
    double deltaY;
    double resultX;
    double resultY;
    boolean negativeX;
    boolean negativeY;
    public static Building nearestBuilding = null;
    public static Hero nearestHero=null;
    int delta = 0;


    public void walk(AnchorPane anchorPane, Hero hero, ArrayList<Building> buildings,int mapID) throws InterruptedException {
        //Thread thread = new Thread(() -> {
        hero.setAttacking(false);
        if (!hero.isAttacking() && hero.isWalking()) {
            hero.setAttacking(false);
            TranslateTransition transition = new TranslateTransition();
            transition.setDuration(Duration.millis(1000));
            double min = Double.MAX_EXPONENT;
            for (Building b : buildings) {
                deltaX = b.getImageView().getLayoutX() - hero.getHeroImage().getLayoutX();
                deltaY = b.getImageView().getLayoutY() - hero.getHeroImage().getLayoutY();
                if (Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)) < min) {
                    min = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
                    resultX = Math.abs(b.getImageView().getLayoutX() - hero.getHeroImage().getLayoutX());
                    resultY = Math.abs(b.getImageView().getLayoutY() - hero.getHeroImage().getLayoutY());
                    if (b.getImageView().getLayoutX() - hero.getHeroImage().getLayoutX() < 0 && b.getImageView().getLayoutY() - hero.getHeroImage().getLayoutY() > 0) {
                        negativeX = true;
                        negativeY = false;
                    } else if (b.getImageView().getLayoutX() - hero.getHeroImage().getLayoutX() > 0 && b.getImageView().getLayoutY() - hero.getHeroImage().getLayoutY() < 0) {
                        negativeY = true;
                        negativeX = false;
                    } else if (b.getImageView().getLayoutX() - hero.getHeroImage().getLayoutX() < 0 && b.getImageView().getLayoutY() - hero.getHeroImage().getLayoutY() < 0) {
                        negativeY = true;
                        negativeX = true;
                    } else if (b.getImageView().getLayoutX() - hero.getHeroImage().getLayoutX() > 0 && b.getImageView().getLayoutY() - hero.getHeroImage().getLayoutY() > 0) {
                        negativeY = false;
                        negativeX = false;
                    }
                    nearestBuilding = b;
                }
            }
            transition.setNode(hero.getHeroImage());
            System.out.println("min:" + min);
            if (negativeX) {
                resultX = -resultX;
            }
            if (negativeY) {
                resultY = -resultY;
            }
            transition.setToX(resultX);
            transition.setToY(resultY);
            transition.play();
            hero.setWalking(false);
        }

        if (target(hero.getHeroImage(), nearestBuilding, hero) && !hero.isWalking()) {

            try {
                attack1(anchorPane, hero, nearestBuilding, buildings,mapID);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if (!target(hero.getHeroImage(),nearestBuilding,hero)){
            hero.setAttacking(false);
            hero.setWalking(true);
        }
    }

    public boolean target(ImageView imageView, Building building, Hero hero) {
        System.out.println((Math.sqrt(Math.pow((imageView.getBoundsInLocal().getCenterY() - building.getImageView().getBoundsInLocal().getCenterY()), 2) + Math.pow((imageView.getBoundsInLocal().getCenterX() - building.getBoundsInLocal().getCenterX()), 2))));
        System.out.println("b:" + (imageView.getBoundsInLocal().getCenterY() - building.getImageView().getBoundsInLocal().getCenterY()));
        System.out.println("v:" + (imageView.getLayoutY() - building.getImageView().getLayoutY()));
        if (Math.abs(imageView.getBoundsInParent().getMaxY() - building.getImageView().getBoundsInParent().getMaxY())<=hero.getRadius()) {
            return true;
        }
        if (Math.abs(imageView.getBoundsInParent().getMaxX() - building.getImageView().getBoundsInParent().getMaxX())<=hero.getRadius()) {
            return true;
        }
        if (Math.abs(imageView.getBoundsInParent().getMinX() - building.getImageView().getBoundsInParent().getMinX())<=hero.getRadius()) {
            return true;
        }
        if (Math.abs(imageView.getBoundsInParent().getMinY() - building.getImageView().getBoundsInParent().getMinY())<=hero.getRadius()) {
            return true;
        }
        return false;
    }


    public void attack1(AnchorPane anchorPane, Hero hero, Building building, ArrayList<Building> buildings,int mapID) throws InterruptedException {

        Thread thread = new Thread(() -> {
            hero.setAttacking(true);
            while (hero.getHealth() > 0 && nearestBuilding.getHealth() > 0) {
                hero.setHealth(hero.getHealth() - nearestBuilding.getPower());
                nearestBuilding.setHealth(nearestBuilding.getHealth() - hero.getPower());
            }

            if (hero.getHealth() <= 0 && nearestBuilding.getHealth() <= 0) {
                System.out.println("hero & building");
                delta = 1;
            } else if (nearestBuilding.getHealth() <= 0) {
                System.out.println("building");
                delta = 2;
            } else if (hero.getHealth() <= 0) {
                System.out.println("hero");
                delta = 3;
            }

        });
        thread.start();

        Thread thread1 = new Thread(() -> {
            if (delta == 1) {
                //anchorPane.getChildren().remove(nearestBuilding.getImageView());
                nearestBuilding.getImageView().setVisible(false);
                buildings.remove(nearestBuilding);
                //anchorPane.getChildren().remove(hero.getHeroImage());
                hero.getHeroImage().setVisible(false);
                hero.setWalking(false);
                hero.setAttacking(false);
                if (mapID==1)
                    MapOnePageController.exitedHeroes.remove(hero);
                else if (mapID==2)
                    MapTwoPageController.exitedHeroes2.remove(hero);
                else if (mapID==3)
                    MapThreePageController.exitedHeroes3.remove(hero);
                else if (mapID==4)
                    MapFourPageController.exitedHeroes4.remove(hero);

                PlayerPageController.entryHeroes--;

            } else if (delta == 2) {
                //anchorPane.getChildren().remove(nearestBuilding.getImageView());
                nearestBuilding.getImageView().setVisible(false);
                buildings.remove(nearestBuilding);
                hero.setWalking(true);
                hero.setAttacking(false);

            } else if (delta == 3) {
                //anchorPane.getChildren().remove(hero.getHeroImage());
                hero.getHeroImage().setVisible(false);
                System.out.println("error");
                if (mapID==1)
                    MapOnePageController.exitedHeroes.remove(hero);
                else if (mapID==2)
                    MapTwoPageController.exitedHeroes2.remove(hero);
                else if (mapID==3)
                    MapThreePageController.exitedHeroes3.remove(hero);
                else if (mapID==4)
                    MapFourPageController.exitedHeroes4.remove(hero);
                hero.setWalking(false);
                hero.setAttacking(false);

                PlayerPageController.entryHeroes--;
            }

            delta = 0;
        });
        thread1.start();

    }

    //--------------------Archer----------------------------------------------------------------------------------------
    public void shoot(AnchorPane anchorPane, Hero hero, ArrayList<Building> buildings,int mapID) {
        if (!hero.isAttacking() && hero.isWalking()) {
            hero.setAttacking(false);
            TranslateTransition transition = new TranslateTransition();
            transition.setDuration(Duration.millis(2000));
            double min = Double.MAX_EXPONENT;
            for (Building b : buildings) {
                deltaX = b.getImageView().getLayoutX() - hero.getHeroImage().getLayoutX();
                deltaY = b.getImageView().getLayoutY() - hero.getHeroImage().getLayoutY();
                if (Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)) < min) {
                    min = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
                    resultX = Math.abs(b.getImageView().getLayoutX() - hero.getHeroImage().getLayoutX());
                    resultY = Math.abs(b.getImageView().getLayoutY() - hero.getHeroImage().getLayoutY());
                    if (b.getImageView().getLayoutX() - hero.getHeroImage().getLayoutX() < 0 && b.getImageView().getLayoutY() - hero.getHeroImage().getLayoutY() > 0) {
                        negativeX = true;
                        negativeY = false;
                    } else if (b.getImageView().getLayoutX() - hero.getHeroImage().getLayoutX() > 0 && b.getImageView().getLayoutY() - hero.getHeroImage().getLayoutY() < 0) {
                        negativeY = true;
                        negativeX = false;
                    } else if (b.getImageView().getLayoutX() - hero.getHeroImage().getLayoutX() < 0 && b.getImageView().getLayoutY() - hero.getHeroImage().getLayoutY() < 0) {
                        negativeY = true;
                        negativeX = true;
                    } else if (b.getImageView().getLayoutX() - hero.getHeroImage().getLayoutX() > 0 && b.getImageView().getLayoutY() - hero.getHeroImage().getLayoutY() > 0) {
                        negativeY = false;
                        negativeX = false;
                    }
                    nearestBuilding = b;
                }
            }
            hero.getArrow().setVisible(true);
            hero.getArrow().setLayoutX(hero.getHeroImage().getLayoutX());
            hero.getArrow().setLayoutY(hero.getHeroImage().getLayoutY());
            transition.setNode(hero.getArrow());
            System.out.println("min:" + min);
            if (negativeX) {
                resultX = -resultX;
            }
            if (negativeY) {
                resultY = -resultY;
            }
            transition.setToX(resultX);
            transition.setToY(resultY);
            transition.setCycleCount(5);
            transition.play();
        }
        hero.setWalking(false);
        if (target(hero.getArrow(), nearestBuilding, hero) && !hero.isWalking()) {
            hero.setAttacking(true);
            try {
                attack2(anchorPane, hero, nearestBuilding, buildings,mapID);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void attack2(AnchorPane anchorPane, Hero hero, Building building, ArrayList<Building> buildings,int mapID) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (hero.getHealth() > 0 && nearestBuilding.getHealth() > 0) {
                hero.setHealth(hero.getHealth() - nearestBuilding.getPower());
                nearestBuilding.setHealth(nearestBuilding.getHealth() - hero.getPower());
            }

            if (hero.getHealth() <= 0 && nearestBuilding.getHealth() <= 0) {
                System.out.println("hero & building");
                delta = 1;
            } else if (nearestBuilding.getHealth() <= 0) {
                System.out.println("building");
                delta = 2;
            } else if (hero.getHealth() <= 0) {
                System.out.println("hero");
                delta = 3;
            }
            hero.setAttacking(false);
            //hero.setWalking(true);

        });
        thread.start();

        Thread thread2 = new Thread(() -> {
            if (delta == 1) {
                //anchorPane.getChildren().remove(nearestBuilding.getImageView());
                nearestBuilding.getImageView().setVisible(false);
                buildings.remove(nearestBuilding);
                //anchorPane.getChildren().remove(hero.getHeroImage());
                hero.getHeroImage().setVisible(false);
                hero.getArrow().setVisible(false);
                if (mapID==1)
                    MapOnePageController.exitedHeroes.remove(hero);
                else if (mapID==2)
                    MapTwoPageController.exitedHeroes2.remove(hero);
                else if (mapID==3)
                    MapThreePageController.exitedHeroes3.remove(hero);
                else if (mapID==4)
                    MapFourPageController.exitedHeroes4.remove(hero);
                PlayerPageController.entryHeroes--;

            } else if (delta == 2) {
                //anchorPane.getChildren().remove(nearestBuilding.getImageView());
                nearestBuilding.getImageView().setVisible(false);
                buildings.remove(nearestBuilding);
                hero.getArrow().setVisible(false);
                hero.getHeroImage().setVisible(false);
                if (mapID==1)
                    MapOnePageController.exitedHeroes.remove(hero);
                else if (mapID==2)
                    MapTwoPageController.exitedHeroes2.remove(hero);
                else if (mapID==3)
                    MapThreePageController.exitedHeroes3.remove(hero);
                else if (mapID==4)
                    MapFourPageController.exitedHeroes4.remove(hero);
                PlayerPageController.entryHeroes--;

            } else if (delta == 3) {
                //anchorPane.getChildren().remove(hero.getHeroImage());
                hero.getArrow().setVisible(false);
                hero.getHeroImage().setVisible(false);
                if (mapID==1)
                    MapOnePageController.exitedHeroes.remove(hero);
                else if (mapID==2)
                    MapTwoPageController.exitedHeroes2.remove(hero);
                else if (mapID==3)
                    MapThreePageController.exitedHeroes3.remove(hero);
                else if (mapID==4)
                    MapFourPageController.exitedHeroes4.remove(hero);

                PlayerPageController.entryHeroes--;
                System.out.println("error");
            }
            delta = 0;
        });
        thread2.start();
    }

    //------------------------Dragon------------------------------------------------------------------------------------
    public void fire(AnchorPane anchorPane, Hero hero, ArrayList<Building> buildings,int mapID)
    {
        if (!hero.isAttacking() && hero.isWalking()) {
            hero.setAttacking(false);
            TranslateTransition transition = new TranslateTransition();
            transition.setDuration(Duration.millis(1000));
            double min = Double.MAX_EXPONENT;
            for (Building b : buildings) {
                if (b.getBuildingType() == BuildingType.DEFENSIVE) {
                    deltaX = b.getImageView().getLayoutX() - hero.getHeroImage().getLayoutX();
                    deltaY = b.getImageView().getLayoutY() - hero.getHeroImage().getLayoutY();
                    if (Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)) < min) {
                        min = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
                        resultX = Math.abs(b.getImageView().getLayoutX() - hero.getHeroImage().getLayoutX());
                        resultY = Math.abs(b.getImageView().getLayoutY() - hero.getHeroImage().getLayoutY());
                        if (b.getImageView().getLayoutX() - hero.getHeroImage().getLayoutX() < 0 && b.getImageView().getLayoutY() - hero.getHeroImage().getLayoutY() > 0) {
                            negativeX = true;
                            negativeY = false;
                        } else if (b.getImageView().getLayoutX() - hero.getHeroImage().getLayoutX() > 0 && b.getImageView().getLayoutY() - hero.getHeroImage().getLayoutY() < 0) {
                            negativeY = true;
                            negativeX = false;
                        } else if (b.getImageView().getLayoutX() - hero.getHeroImage().getLayoutX() < 0 && b.getImageView().getLayoutY() - hero.getHeroImage().getLayoutY() < 0) {
                            negativeY = true;
                            negativeX = true;
                        } else if (b.getImageView().getLayoutX() - hero.getHeroImage().getLayoutX() > 0 && b.getImageView().getLayoutY() - hero.getHeroImage().getLayoutY() > 0) {
                            negativeY = false;
                            negativeX = false;
                        }
                        nearestBuilding = b;
                    }
                }
            }
            hero.getArrow().setVisible(true);
            hero.getArrow().setLayoutX(hero.getHeroImage().getLayoutX()+20);
            hero.getArrow().setLayoutY(hero.getHeroImage().getLayoutY()+30);
            transition.setNode(hero.getArrow());
            System.out.println("min:" + min);
            if (negativeX) {
                resultX = -resultX;
            }
            if (negativeY) {
                resultY = -resultY;
            }
            transition.setToX(resultX);
            transition.setToY(resultY);
            transition.setCycleCount(1);
            transition.play();
        }
        hero.setWalking(false);
        if (target(hero.getArrow(), nearestBuilding, hero) && !hero.isWalking()) {
            hero.setAttacking(true);
            try {
                attack3(anchorPane, hero, nearestBuilding, buildings,mapID);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void attack3(AnchorPane anchorPane, Hero hero, Building building, ArrayList<Building> buildings,int mapID) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (hero.getHealth() > 0 && nearestBuilding.getHealth() > 0) {
                hero.setHealth(hero.getHealth() - nearestBuilding.getPower());
                nearestBuilding.setHealth(nearestBuilding.getHealth() - hero.getPower());
            }

            if (hero.getHealth() <= 0 && nearestBuilding.getHealth() <= 0) {
                System.out.println("hero & building");
                delta = 1;
            } else if (nearestBuilding.getHealth() <= 0) {
                System.out.println("building");
                delta = 2;
            } else if (hero.getHealth() <= 0) {
                System.out.println("hero");
                delta = 3;
            }
            hero.setAttacking(false);
            //hero.setWalking(true);

        });
        thread.start();

        Thread thread2 = new Thread(() -> {
            if (delta == 1) {
                //anchorPane.getChildren().remove(nearestBuilding.getImageView());
                nearestBuilding.getImageView().setVisible(false);
                buildings.remove(nearestBuilding);
                //anchorPane.getChildren().remove(hero.getHeroImage());
                hero.getHeroImage().setVisible(false);
                hero.getArrow().setVisible(false);
                if (mapID==1)
                MapOnePageController.exitedHeroes.remove(hero);
                else if (mapID==2)
                    MapTwoPageController.exitedHeroes2.remove(hero);
                else if (mapID==3)
                    MapThreePageController.exitedHeroes3.remove(hero);
                else if (mapID==4)
                    MapFourPageController.exitedHeroes4.remove(hero);
                PlayerPageController.entryHeroes--;
            } else if (delta == 2) {
                //anchorPane.getChildren().remove(nearestBuilding.getImageView());
                nearestBuilding.getImageView().setVisible(false);
                buildings.remove(nearestBuilding);
                hero.getArrow().setVisible(false);
                hero.getHeroImage().setVisible(false);
                if (mapID==1)
                    MapOnePageController.exitedHeroes.remove(hero);
                else if (mapID==2)
                    MapTwoPageController.exitedHeroes2.remove(hero);
                else if (mapID==3)
                    MapThreePageController.exitedHeroes3.remove(hero);
                else if (mapID==4)
                    MapFourPageController.exitedHeroes4.remove(hero);

                PlayerPageController.entryHeroes--;
            } else if (delta == 3) {
                //anchorPane.getChildren().remove(hero.getHeroImage());
                hero.getArrow().setVisible(false);
                hero.getHeroImage().setVisible(false);
                if (mapID==1)
                    MapOnePageController.exitedHeroes.remove(hero);
                else if (mapID==2)
                    MapTwoPageController.exitedHeroes2.remove(hero);
                else if (mapID==3)
                    MapThreePageController.exitedHeroes3.remove(hero);
                else if (mapID==4)
                    MapFourPageController.exitedHeroes4.remove(hero);

                PlayerPageController.entryHeroes--;
                System.out.println("error");
            }

            delta = 0;

        });
        thread2.start();
    }

    //--------------update number wins and loss-------------------------------------------------------------------------
    public void updateWins(int wins,String playerID) throws SQLException, ClassNotFoundException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = String.format("UPDATE `players` SET `numberOfWins` ='%s' WHERE `playerID`='%s'",wins,playerID);
        mySQLConnection.executeSQL(sql);
    }

    public void updateLosses(int losses,String playerID) throws SQLException, ClassNotFoundException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = String.format("UPDATE `players` SET `numberOfLosses`='%s' WHERE `playerID`='%s'",losses,playerID);
        mySQLConnection.executeSQL(sql);
    }


}

