package com.example.game;

import Hero.Hero;
import Hero.Archer;
import Hero.Balloon;
import Hero.Barbarian;
import Hero.Dragon;
import Hero.Valkyrie;
import controller.DraggableMarker;
import controller.GameController;
import controller.MapController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Building;
import model.CommonBuilding_g1;

import java.io.IOException;
import java.math.MathContext;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class MapOnePageController implements Initializable {
    private final MapController mapController = new MapController();
    public static ArrayList<Hero> exitedHeroes = new ArrayList<>();
    private final GameController gameController = new GameController();

    @FXML
    private ImageView g1_castle1;

    @FXML
    private ImageView g1_castle2;

    @FXML
    private ImageView g1_castle3;

    @FXML
    private ImageView g1_castle4;

    @FXML
    private ImageView g1_castle5;

    @FXML
    private ImageView g1_castle6;

    @FXML
    private ImageView g1_defensive1;

    @FXML
    private ImageView g1_defensive2;

    @FXML
    private ImageView g1_defensive3;

    @FXML
    private AnchorPane gameGround1;

    @FXML
    private ImageView mapImage1;

    @FXML
    private ImageView archerImage;

    @FXML
    private ImageView balloonImage;

    @FXML
    private ImageView barbarianImage;

    @FXML
    private ImageView dragonImage;

    @FXML
    private ImageView valkyrieImage;

    @FXML
    private ImageView logoutImage;

    @FXML
    private Pane menuBarPane;

    @FXML
    private ImageView smoke1;

    @FXML
    private ImageView smoke11;

    @FXML
    private ImageView smoke12;

    @FXML
    private Pane winPane;

    @FXML
    private Pane losePane;
    //------------------------------------------------------------------------------------------------------------------
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView arrow;
    private ImageView smoke;
    private int archer;
    private int barbarian;
    private int balloon;
    private int dragon;
    private int valkyrie;

    @FXML
    void menuImage(MouseEvent event) {
        menuBarPane.setVisible(true);
        archer = PlayerPageController.listOfHeroes.get("Archer");
        barbarian = PlayerPageController.listOfHeroes.get("Barbarian");
        balloon = PlayerPageController.listOfHeroes.get("Balloon");
        dragon = PlayerPageController.listOfHeroes.get("Dragon");
        valkyrie = PlayerPageController.listOfHeroes.get("Valkyrie");
        if (archer != 0) {
            archerImage.setVisible(true);
        }
        if (barbarian != 0) {
            barbarianImage.setVisible(true);
        }
        if (balloon != 0) {
            balloonImage.setVisible(true);
        }
        if (dragon != 0) {
            dragonImage.setVisible(true);
        }
        if (valkyrie != 0) {
            valkyrieImage.setVisible(true);
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    private int counter1 = 0;

    @FXML
    void archerImage(MouseEvent event) {
        if (counter1 < archer) {
            imageView1 = new ImageView(new Image(this.getClass().getResource("images/58eeb0c0ee9418469d17edf1.png").toString()));
            arrow = new ImageView(new Image((this.getClass().getResource("images/arrow2.png").toString())));
            imageView1.setLayoutX(851);
            imageView1.setLayoutY(138);
            imageView1.setFitWidth(archerImage.getFitWidth());
            imageView1.setFitHeight(archerImage.getFitHeight());
            arrow.setFitWidth(20);
            arrow.setFitHeight(40);
            arrow.setVisible(false);
            gameGround1.getChildren().add(imageView1);
            gameGround1.getChildren().add(arrow);
            Archer archer = new Archer(imageView1, arrow);
            DraggableMarker.makeDraggable(imageView1, archer, exitedHeroes);
            counter1++;
        }
    }

    int counter2 = 0;

    @FXML
    void balloonImage(MouseEvent event) {
        if (counter2 < balloon) {
            System.out.println(exitedHeroes.get(0).getNewX());
            imageView3 = new ImageView(new Image(this.getClass().getResource("images/infoScreen_balloon.png").toString()));
            imageView3.setLayoutX(851);
            imageView3.setLayoutY(337);
            imageView3.setFitWidth(balloonImage.getFitWidth());
            imageView3.setFitHeight(balloonImage.getFitHeight());
            gameGround1.getChildren().add(imageView3);
            Balloon balloon = new Balloon(imageView3);
            DraggableMarker.makeDraggable(imageView3, balloon, exitedHeroes);
            counter2++;
        }
    }

    int counter3 = 0;

    @FXML
    void barbarianImage(MouseEvent event) {
        if (counter3 < barbarian) {
            System.out.println();
            imageView2 = new ImageView(new Image(this.getClass().getResource("images/infoScreen_barbarian1.png").toString()));
            imageView2.setLayoutX(851);
            imageView2.setLayoutY(65);
            imageView2.setFitWidth(barbarianImage.getFitWidth());
            imageView2.setFitHeight(barbarianImage.getFitHeight());
            gameGround1.getChildren().add(imageView2);
            Barbarian barbarian = new Barbarian(imageView2);
            DraggableMarker.makeDraggable(imageView2, barbarian, exitedHeroes);
            counter3++;
        }
    }

    int counter4 = 0;

    @FXML
    void dragonImage(MouseEvent event) {
        if (counter4 < dragon) {
            imageView4 = new ImageView(new Image(this.getClass().getResource("images/infoScreen_dragon.png").toString()));
            arrow = new ImageView(new Image((this.getClass().getResource("images/flame-fire-clip-art-flame-transparent-png-clip-art-image-d1dfa52a023e5c1c118abbe1bb626704.png").toString())));
            imageView4.setLayoutX(851);
            imageView4.setLayoutY(271);
            imageView4.setFitWidth(dragonImage.getFitWidth());
            imageView4.setFitHeight(dragonImage.getFitHeight());
            arrow.setFitWidth(30);
            arrow.setFitHeight(15);
            arrow.setVisible(false);
            gameGround1.getChildren().add(imageView4);
            gameGround1.getChildren().add(arrow);
            Dragon dragon = new Dragon(imageView4, arrow);
            DraggableMarker.makeDraggable(imageView4, dragon, exitedHeroes);
            counter4++;
        }
    }

    int counter5 = 0;

    @FXML
    void valkyrieImage(MouseEvent event) {
        if (counter5 < valkyrie) {
            imageView5 = new ImageView(new Image(this.getClass().getResource("images/clash-of-clans-clash-royale-troop-golem-game-coc-f17fc20b1485aa19bb6ac453b6b04e98.png").toString()));
            imageView5.setLayoutX(851);
            imageView5.setLayoutY(219);
            imageView5.setFitWidth(valkyrieImage.getFitWidth());
            imageView5.setFitHeight(valkyrieImage.getFitHeight());
            gameGround1.getChildren().add(imageView5);
            Valkyrie valkyrie = new Valkyrie(imageView5);
            DraggableMarker.makeDraggable(imageView5, valkyrie, exitedHeroes);
            counter5++;
        }
    }

    @FXML
    void logoutImage(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("player-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home");
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    void setBom() {
        if (g1_defensive1.isVisible()) {
            smoke1.setVisible(true);
            TranslateTransition transition11 = new TranslateTransition();
            transition11.setDuration(Duration.millis(1000));
            transition11.setNode(smoke1);
            transition11.setToY(-10);
            transition11.setCycleCount(1);
            transition11.play();
        } else if (!g1_defensive1.isVisible()) {
            smoke1.setVisible(false);
        }
        if (g1_defensive3.isVisible()) {
            smoke11.setVisible(true);
            TranslateTransition transition12 = new TranslateTransition();
            transition12.setDuration(Duration.millis(1000));
            transition12.setNode(smoke11);
            transition12.setToY(-10);
            transition12.setCycleCount(1);
            transition12.play();
        } else if (!g1_defensive3.isVisible()) {
            smoke11.setVisible(false);
        }
        if (g1_defensive2.isVisible()) {
            smoke12.setVisible(true);
            TranslateTransition transition13 = new TranslateTransition();
            transition13.setDuration(Duration.millis(1000));
            transition13.setNode(smoke12);
            transition13.setToY(-10);
            transition13.setCycleCount(1);
            transition13.play();
        } else if (!g1_defensive2.isVisible()) {
            smoke12.setVisible(false);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        winPane.setVisible(false);
        losePane.setVisible(false);
        smoke = new ImageView(new Image(this.getClass().getResource("images/smoke-clip-art-black-fume-png-clip-art-image-12a8e78b3278d04765b917cab1ff1858.png").toString()));
        if (LoginPageController.loginPlayer.getPlayerLevel() >= 1 && LoginPageController.loginPlayer.getPlayerLevel() <= 3) {

            g1_castle1.setVisible(true);
            g1_castle2.setVisible(true);
            g1_castle3.setVisible(true);
            g1_castle4.setVisible(true);
            g1_castle5.setVisible(true);
            g1_castle6.setVisible(true);

            g1_defensive1.setVisible(false);
            g1_defensive2.setVisible(false);
            g1_defensive3.setVisible(false);

            mapController.addCommonBuilding_g1(g1_castle1);
            mapController.addCommonBuilding_g1(g1_castle2);
            mapController.addCommonBuilding_g1(g1_castle3);
            mapController.addCommonBuilding_g1(g1_castle4);
            mapController.addCommonBuilding_g1(g1_castle5);
            mapController.addCommonBuilding_g1(g1_castle6);


        } else {

            g1_castle1.setVisible(true);
            g1_castle2.setVisible(true);
            g1_castle3.setVisible(true);
            g1_castle4.setVisible(true);
            g1_castle5.setVisible(true);
            g1_castle6.setVisible(true);

            g1_defensive1.setVisible(true);
            g1_defensive2.setVisible(true);
            g1_defensive3.setVisible(true);

            mapController.addCommonBuilding_g1(g1_castle1);
            mapController.addCommonBuilding_g1(g1_castle2);
            mapController.addCommonBuilding_g1(g1_castle3);
            mapController.addCommonBuilding_g1(g1_castle4);
            mapController.addCommonBuilding_g1(g1_castle5);
            mapController.addCommonBuilding_g1(g1_castle6);

            mapController.addDefensiveBuilding_g1(g1_defensive1, smoke);
            mapController.addDefensiveBuilding_g1(g1_defensive2, smoke);
            mapController.addDefensiveBuilding_g1(g1_defensive3, smoke);

        }

        Timeline t = new Timeline();
        t.setCycleCount(Timeline.INDEFINITE);
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(0.3),
                (ActionEvent e) -> {
                    setBom();
                }
        ));
        t.play();

        Timeline t1 = new Timeline();
        t1.setCycleCount(Timeline.INDEFINITE);
        t1.getKeyFrames().add(new KeyFrame(Duration.seconds(2),
                (ActionEvent e) -> {
                    if (MapController.buildings_g1.size() != 0) {

                        for (Hero h : exitedHeroes) {
                            if (h instanceof Archer) {
                                if (!h.isAttacking() && h.isWalking()) {
                                    gameController.shoot(gameGround1, h, MapController.buildings_g1, 1);
                                }

                            } else if (h instanceof Dragon) {
                                gameController.fire(gameGround1, h, MapController.buildings_g1, 1);
                            } else {
                                if (!h.isAttacking() && h.isWalking()) {
                                    try {
                                        gameController.walk(gameGround1, h, MapController.buildings_g1, 1);
                                    } catch (InterruptedException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                }
        ));
        t1.play();

        Timeline t2 = new Timeline();
        t2.setCycleCount(Timeline.INDEFINITE);
        t2.getKeyFrames().add(new KeyFrame(Duration.seconds(2),
                (ActionEvent e) -> {
                    if (MapController.buildings_g1.size() == 0) {
                        t.stop();
                        System.out.println("win");
//                        mapImage1.setOnMouseClicked(event -> {
//                            Parent parent = null;
//                            try {
//                                parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("win-page.fxml")));
//                            } catch (IOException ex) {
//                                ex.printStackTrace();
//                            }
//                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                            stage.setTitle("WinPage");
//                            Scene scene = new Scene(parent);
//                            stage.setScene(scene);
//                            stage.show();
//                        });
                        winPane.setVisible(true);
                        t2.pause();


                    }
                    if (PlayerPageController.entryHeroes == 0) {
                        t.stop();
                        System.out.println("lose");

//                        mapImage1.setOnMouseClicked(event -> {
//                            Parent parent = null;
//                            try {
//                                parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loss-page.fxml")));
//                            } catch (IOException ex) {
//                                ex.printStackTrace();
//                            }
//                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                            stage.setTitle("LossPage");
//                            Scene scene = new Scene(parent);
//                            stage.setScene(scene);
//                            stage.show();
//                        });
                        losePane.setVisible(true);
                        t2.pause();
                    }
                }
        ));
        t2.play();
    }

}
