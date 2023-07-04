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
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class MapThreePageController implements Initializable {

    @FXML
    private ImageView g3_bom1;

    @FXML
    private ImageView g3_bom2;

    @FXML
    private ImageView g3_bom3;

    @FXML
    private ImageView g3_castle1;

    @FXML
    private ImageView g3_castle2;

    @FXML
    private ImageView g3_castle3;

    @FXML
    private ImageView g3_castle4;

    @FXML
    private AnchorPane gameGround3;

    @FXML
    private ImageView mapImage3;

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
    //------------------------------------------------------------------------------------------------------------------
    private final MapController mapController = new MapController();
    private final GameController gameController=new GameController();
    public static ArrayList<Hero> exitedHeroes3 = new ArrayList<>();


    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView arrow;
    private ImageView bom;
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

    private int counter1 = 0;

    @FXML
    void archerImage(MouseEvent event) {
        if (counter1 < archer) {
            imageView1 = new ImageView(new Image(this.getClass().getResource("images/58eeb0c0ee9418469d17edf1.png").toString()));
            arrow=new ImageView(new Image((this.getClass().getResource("images/arrow2.png").toString())));
            imageView1.setLayoutX(851);
            imageView1.setLayoutY(138);
            imageView1.setFitWidth(archerImage.getFitWidth());
            imageView1.setFitHeight(archerImage.getFitHeight());
            arrow.setFitWidth(20);
            arrow.setFitHeight(40);
            arrow.setVisible(false);
            gameGround3.getChildren().add(imageView1);
            gameGround3.getChildren().add(arrow);
            Archer archer = new Archer(imageView1,arrow);
            DraggableMarker.makeDraggable(imageView1, archer, exitedHeroes3);
            counter1++;
        }
    }

    int counter2 = 0;

    @FXML
    void balloonImage(MouseEvent event) {
        if (counter2 < balloon) {
            imageView3 = new ImageView(new Image(this.getClass().getResource("images/infoScreen_balloon.png").toString()));
            imageView3.setLayoutX(851);
            imageView3.setLayoutY(337);
            imageView3.setFitWidth(balloonImage.getFitWidth());
            imageView3.setFitHeight(balloonImage.getFitHeight());
            gameGround3.getChildren().add(imageView3);
            Balloon balloon=new Balloon(imageView3);
            DraggableMarker.makeDraggable(imageView3,balloon,exitedHeroes3);
            counter2++;
        }
    }

    int counter3 = 0;

    @FXML
    void barbarianImage(MouseEvent event) {
        if(counter3 < barbarian) {
            imageView2 = new ImageView(new Image(this.getClass().getResource("images/infoScreen_barbarian1.png").toString()));
            imageView2.setLayoutX(851);
            imageView2.setLayoutY(76);
            imageView2.setFitWidth(barbarianImage.getFitWidth());
            imageView2.setFitHeight(barbarianImage.getFitHeight());
            gameGround3.getChildren().add(imageView2);
            Barbarian barbarian=new Barbarian(imageView2);
            DraggableMarker.makeDraggable(imageView2,barbarian,exitedHeroes3);
            counter3++;
        }
    }

    int counter4 = 0;

    @FXML
    void dragonImage(MouseEvent event) {
        if (counter4 < dragon) {
            imageView4 = new ImageView(new Image(this.getClass().getResource("images/infoScreen_dragon.png").toString()));
            arrow=new ImageView(new Image((this.getClass().getResource("images/flame-fire-clip-art-flame-transparent-png-clip-art-image-d1dfa52a023e5c1c118abbe1bb626704.png").toString())));
            imageView4.setLayoutX(851);
            imageView4.setLayoutY(271);
            imageView4.setFitWidth(dragonImage.getFitWidth());
            imageView4.setFitHeight(dragonImage.getFitHeight());
            arrow.setFitWidth(20);
            arrow.setFitHeight(40);
            arrow.setVisible(false);
            gameGround3.getChildren().add(imageView4);
            gameGround3.getChildren().add(arrow);
            Dragon dragon = new Dragon(imageView4,arrow);
            DraggableMarker.makeDraggable(imageView4, dragon, exitedHeroes3);
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
            gameGround3.getChildren().add(imageView5);
            Valkyrie valkyrie=new Valkyrie(imageView5);
            DraggableMarker.makeDraggable(imageView5,valkyrie,exitedHeroes3);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bom=new ImageView(new Image(this.getClass().getResource("images/machupicchu-imports-s-a-c-explosion-bomb-pyrotechnics-euclidean-vector-vector-explosion-f2ea07fc28b0d7dde4808833e2711374.png").toString()));

        if (LoginPageController.loginPlayer.getPlayerLevel() >= 1 && LoginPageController.loginPlayer.getPlayerLevel() <= 3) {

            g3_castle1.setVisible(true);
            g3_castle2.setVisible(true);
            g3_castle3.setVisible(true);
            g3_castle4.setVisible(true);

            g3_bom1.setVisible(true);
            g3_bom2.setVisible(false);
            g3_bom3.setVisible(false);

            mapController.addCommonBuilding_g3(g3_castle1);
            mapController.addCommonBuilding_g3(g3_castle2);
            mapController.addCommonBuilding_g3(g3_castle3);
            mapController.addCommonBuilding_g3(g3_castle4);

            mapController.addDefensiveBuilding_g3(g3_bom1,bom);


        } else {

            g3_castle1.setVisible(true);
            g3_castle2.setVisible(true);
            g3_castle3.setVisible(true);
            g3_castle4.setVisible(true);

            g3_bom1.setVisible(true);
            g3_bom2.setVisible(true);
            g3_bom3.setVisible(true);

            mapController.addCommonBuilding_g3(g3_castle1);
            mapController.addCommonBuilding_g3(g3_castle2);
            mapController.addCommonBuilding_g3(g3_castle3);
            mapController.addCommonBuilding_g3(g3_castle4);

            mapController.addDefensiveBuilding_g3(g3_bom1,bom);
            mapController.addDefensiveBuilding_g3(g3_bom2,bom);
            mapController.addDefensiveBuilding_g3(g3_bom3,bom);
        }

        Timeline t3 = new Timeline();
        t3.setCycleCount(Timeline.INDEFINITE);
        t3.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                (ActionEvent e) -> {
                    if (MapController.buildings_g3.size() != 0) {
                        for (Hero h : exitedHeroes3) {
                            if (h instanceof Archer) {
                                if (!h.isAttacking() && h.isWalking()) {
                                    gameController.shoot(gameGround3, h, MapController.buildings_g3,3);
                                }

                            } else if (h instanceof Dragon) {
                                gameController.fire(gameGround3, h, MapController.buildings_g3,3);
                            } else {
                                if (!h.isAttacking() && h.isWalking()) {
                                    try {
                                        gameController.walk(gameGround3, h, MapController.buildings_g3,3);
                                    } catch (InterruptedException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                }
        ));
        t3.play();

        Timeline t33 = new Timeline();
        t33.setCycleCount(Timeline.INDEFINITE);
        t33.getKeyFrames().add(new KeyFrame(Duration.seconds(1.5),
                (ActionEvent e) -> {
                    if (MapController.buildings_g3.size()==0)
                    {
                        t3.stop();
                        System.out.println("win");
                        //gameGround1.getScene().getWindow().hide();
                        mapImage3.setOnMouseClicked(event->{
                            Parent parent = null;
                            try {
                                parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("win-page.fxml")));
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.setTitle("WinPage");
                            Scene scene = new Scene(parent);
                            stage.setScene(scene);
                            stage.show();});
                        t33.pause();


                    }
                    if (PlayerPageController.entryHeroes==0)
                    {
                        t3.stop();
                        System.out.println("lose");
                        mapImage3.setOnMouseClicked(event->{
                            Parent parent = null;
                            try {
                                parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loss-page.fxml")));
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.setTitle("LossPage");
                            Scene scene = new Scene(parent);
                            stage.setScene(scene);
                            stage.show();});
                        t33.pause();
                    }
                }
        ));
        t33.play();
    }
}