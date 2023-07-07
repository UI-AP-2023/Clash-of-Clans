package com.example.game;

import controller.GameController;
import controller.PlayerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Player;
import model.Map;
import mysql.MySQLConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class PlayerPageController implements Initializable {
    private final GameController gameController = new GameController();

    @FXML
    private Button acceptButton;

    @FXML
    private ImageView archerImage;

    @FXML
    private ImageView archerLockImage;

    @FXML
    private TextField archerNumField;

    @FXML
    private Button attackButton;

    @FXML
    private AnchorPane attackPane;

    @FXML
    private ImageView backImage;

    @FXML
    private ImageView balloonImage;

    @FXML
    private ImageView balloonLockImage;

    @FXML
    private TextField balloonNumField;

    @FXML
    private ImageView barbarianImage;

    @FXML
    private TextField barbarianNumField;

    @FXML
    private AnchorPane chooseHeroPane;

    @FXML
    private ImageView dragonImage;

    @FXML
    private ImageView dragonLockImage;

    @FXML
    private TextField dragonNumField;

    @FXML
    private AnchorPane heroPane;

    @FXML
    private Button heroesButton;

    @FXML
    private Label informationLabel;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private ImageView mapImage;

    @FXML
    private Pane menuPane;

    @FXML
    private Label numberOfHeroesLabel;

    @FXML
    private Button playButton;

    @FXML
    private Label playerIDLabel;

    @FXML
    private ImageView playerMapImage;

    @FXML
    private Button profileButton;

    @FXML
    private AnchorPane profilePane;

    @FXML
    private Button rejectButton;

    @FXML
    private ImageView valkyrieImage;

    @FXML
    private ImageView valkyrieLockImage;

    @FXML
    private TextField valkyrieNumField;


    //------------------------------------------------------------------------------------------------------------------
    public static Player opponentPlayer;
    private int mapID;
    public static int numberOfAttackingHeroes;
    public static int entryHeroes;

    @FXML
    void acceptButton(MouseEvent event) {
        mapID=opponentPlayer.getPlayerMapID();
        chooseHeroPane.setVisible(true);
    }

    @FXML
    void rejectButton(MouseEvent event) throws SQLException, ClassNotFoundException {
        attackButton(event);
    }

    @FXML
    void attackButton(MouseEvent event) throws SQLException, ClassNotFoundException {
        attackPane.setVisible(true);
        profilePane.setVisible(false);
        heroPane.setVisible(false);
        chooseHeroPane.setVisible(false);

        opponentPlayer=gameController.randomMap();
        if (opponentPlayer.getPlayerMapID()==1)
        {
            mapImage.setImage(new Image(this.getClass().getResource("images/map11.jpg").toString()));
            numberOfHeroesLabel.setText("Number of Heroes:8");
        }
        else if (opponentPlayer.getPlayerMapID()==2)
        {
            mapImage.setImage(new Image(this.getClass().getResource("images/map22.jpg").toString()));
            numberOfHeroesLabel.setText("Number of Heroes:6");
        }
        else if (opponentPlayer.getPlayerMapID()==3)
        {
            mapImage.setImage(new Image(this.getClass().getResource("images/map33.jpg").toString()));
            numberOfHeroesLabel.setText("Number of Heroes:5");
        }
        else if (opponentPlayer.getPlayerMapID()==4)
        {
            mapImage.setImage(new Image(this.getClass().getResource("images/map44.jpg").toString()));
            numberOfHeroesLabel.setText("Number of Heroes:5");
        }
        playerIDLabel.setText(opponentPlayer.getPlayerID());

    }

    //------------------------------------------------------------------------------------------------------------------
    public static HashMap<String, Integer> listOfHeroes = new HashMap<>();

    private void setHeroesToMap() {
        checkNumberOfField();
        listOfHeroes.put("Archer", Integer.parseInt(archerNumField.getText()));
        listOfHeroes.put("Barbarian", Integer.parseInt(barbarianNumField.getText()));
        listOfHeroes.put("Balloon", Integer.parseInt(balloonNumField.getText()));
        listOfHeroes.put("Dragon", Integer.parseInt(dragonNumField.getText()));
        listOfHeroes.put("Valkyrie", Integer.parseInt(valkyrieNumField.getText()));
    }

    private void showHeroes() {
        if (LoginPageController.loginPlayer.getPlayerLevel() == 1) {
            archerLockImage.setVisible(true);
            archerNumField.setVisible(false);
            valkyrieLockImage.setVisible(true);
            valkyrieNumField.setVisible(false);
            dragonLockImage.setVisible(true);
            dragonNumField.setVisible(false);
            balloonLockImage.setVisible(true);
            balloonNumField.setVisible(false);
        } else if (LoginPageController.loginPlayer.getPlayerLevel() == 2) {
            archerLockImage.setVisible(false);
            archerNumField.setVisible(true);
            valkyrieLockImage.setVisible(true);
            valkyrieNumField.setVisible(false);
            dragonLockImage.setVisible(true);
            dragonNumField.setVisible(false);
            balloonLockImage.setVisible(true);
            balloonNumField.setVisible(false);
        } else if (LoginPageController.loginPlayer.getPlayerLevel() == 3) {
            archerLockImage.setVisible(false);
            archerNumField.setVisible(true);
            valkyrieLockImage.setVisible(false);
            valkyrieNumField.setVisible(true);
            dragonLockImage.setVisible(true);
            dragonNumField.setVisible(false);
            balloonLockImage.setVisible(true);
            balloonNumField.setVisible(false);
        } else if (LoginPageController.loginPlayer.getPlayerLevel() == 4) {
            archerLockImage.setVisible(false);
            archerNumField.setVisible(true);
            valkyrieLockImage.setVisible(false);
            valkyrieNumField.setVisible(true);
            dragonLockImage.setVisible(false);
            dragonNumField.setVisible(true);
            balloonLockImage.setVisible(true);
            balloonNumField.setVisible(false);
        } else if (LoginPageController.loginPlayer.getPlayerLevel() == 5) {
            archerLockImage.setVisible(false);
            archerNumField.setVisible(true);
            valkyrieLockImage.setVisible(false);
            valkyrieNumField.setVisible(true);
            dragonLockImage.setVisible(false);
            dragonNumField.setVisible(true);
            balloonLockImage.setVisible(false);
            balloonNumField.setVisible(true);
        }
    }

    private boolean calculateNumberOfHeroes(int mapID) {
        int totalHeroes = 1;
        if (mapID == 1) {
            totalHeroes = 8;
            checkNumberOfField();
        } else if (mapID == 2) {
            totalHeroes = 6;
            checkNumberOfField();
        } else if (mapID == 3) {
            totalHeroes = 5;
            checkNumberOfField();
        } else if (mapID == 4) {
            totalHeroes = 5;
            checkNumberOfField();
        }

        entryHeroes = Integer.parseInt(barbarianNumField.getText()) + Integer.parseInt(archerNumField.getText()) + Integer.parseInt(valkyrieNumField.getText()) + Integer.parseInt(dragonNumField.getText()) + Integer.parseInt(balloonNumField.getText());
        if (entryHeroes <= totalHeroes) {
            numberOfAttackingHeroes = entryHeroes;
            setHeroesToMap();
            return true;
        } else {
            return false;
        }
    }

    private void checkNumberOfField() {
        if (Objects.equals(balloonNumField.getText(), "")) {
            balloonNumField.setText("0");
        }
        if (Objects.equals(barbarianNumField.getText(), "")) {
            barbarianNumField.setText("0");
        }
        if (Objects.equals(archerNumField.getText(), "")) {
            archerNumField.setText("0");
        }
        if (Objects.equals(valkyrieNumField.getText(), "")) {
            valkyrieNumField.setText("0");
        }
        if (Objects.equals(dragonNumField.getText(), "")) {
            dragonNumField.setText("0");
        }
    }

    @FXML
    void playButton(MouseEvent event) throws IOException {
        if (calculateNumberOfHeroes(mapID)) {
            if (mapID == 1) {
                Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("map-one.fxml")));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("Map One");
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();
            } else if (mapID == 2) {
                Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("map-two.fxml")));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("Map Two");
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();
            } else if (mapID == 3) {
                Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("map-three.fxml")));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("Map Three");
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();
            } else if (mapID == 4) {
                Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("map-four.fxml")));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("Map Four");
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();
            }
        } else {
            Alert error = new Alert(Alert.AlertType.ERROR, "The number of heroes entered is not valid!");
            error.setTitle("Error!");
            error.setHeaderText("Error!");
            error.show();
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    @FXML
    void heroesButton(MouseEvent event) {
        heroPane.setVisible(true);
        profilePane.setVisible(false);
        attackPane.setVisible(false);
        chooseHeroPane.setVisible(false);
    }

    //------------------------------------------------------------------------------------------------------------------
    @FXML
    void profileButton(MouseEvent event) {
        profilePane.setVisible(true);
        heroPane.setVisible(false);
        attackPane.setVisible(false);
        chooseHeroPane.setVisible(false);
        if (LoginPageController.loginPlayer.getPlayerMapID() == 1) {
            playerMapImage.setImage(new Image(this.getClass().getResource("images/map1.jpg").toString()));
        } else if (LoginPageController.loginPlayer.getPlayerMapID() == 2) {
            playerMapImage.setImage(new Image(this.getClass().getResource("images/map2.jpg").toString()));
        } else if (LoginPageController.loginPlayer.getPlayerMapID() == 3) {
            playerMapImage.setImage(new Image(this.getClass().getResource("images/map3.jpg").toString()));
        } else if (LoginPageController.loginPlayer.getPlayerMapID() == 4) {
            playerMapImage.setImage(new Image(this.getClass().getResource("images/map4.jpg").toString()));
        }
        informationLabel.setText(LoginPageController.loginPlayer.toString());
    }

    //------------------------------------------------------------------------------------------------------------------
    @FXML
    void backImage(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Login");
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showHeroes();

    }
}
