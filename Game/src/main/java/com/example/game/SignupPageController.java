package com.example.game;

import controller.GameController;
import controller.PlayerController;
import exception.DuplicatePlayerID;
import exception.InvalidPassword;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Player;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class SignupPageController implements Initializable {
    private final PlayerController playerController=new PlayerController();

    @FXML
    private ImageView backImage;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField playerIDField;

    @FXML
    private Button saveButton;

    @FXML
    private Button chooseMapButton;


    @FXML
    private AnchorPane signupPane;

    @FXML
    private AnchorPane chooseMapPane;

    @FXML
    private ImageView map1;

    @FXML
    private ImageView map2;

    @FXML
    private ImageView map3;

    @FXML
    private ImageView map4;

    @FXML
    void backImage(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
    private int playerMapID;
    @FXML
    void map1(MouseEvent event) {
        playerMapID=1;
        chooseMapPane.setVisible(false);
    }

    @FXML
    void map2(MouseEvent event) {
        playerMapID=2;
        chooseMapPane.setVisible(false);
    }

    @FXML
    void map3(MouseEvent event) {
        playerMapID=3;
        chooseMapPane.setVisible(false);
    }

    @FXML
    void map4(MouseEvent event) {
        playerMapID=4;
        chooseMapPane.setVisible(false);
    }

    @FXML
    void chooseMapButton(MouseEvent event) {
        chooseMapPane.setVisible(true);
    }

    @FXML
    void saveButton(MouseEvent event) {
        if (playerMapID != 0) {
            try {
                playerController.checkPlayerID(playerIDField.getText());
                playerController.checkPatternPassword(passwordField.getText());
                Player newPlayer = new Player(playerIDField.getText(), passwordField.getText(), playerMapID);
                playerController.insertPlayer(newPlayer);
                GameController.players.add(newPlayer);
                Alert successfully = new Alert(Alert.AlertType.INFORMATION, "You are registered!");
                successfully.setTitle("Successfully!");
                successfully.setHeaderText("Successfully!");
                successfully.show();
                Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-page.fxml")));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();
            } catch (DuplicatePlayerID e) {
                Alert error = new Alert(Alert.AlertType.ERROR, "Your ID is available!");
                error.setTitle("Error!");
                error.setHeaderText("Input error!");
                error.show();
            } catch (SQLException | ClassNotFoundException | IOException e) {
                e.printStackTrace();
            } catch (InvalidPassword e) {
                Alert error = new Alert(Alert.AlertType.ERROR, "Your password pattern is not correct!\nIt should be at least a combination of 8 numbers and letters!");
                error.setTitle("Error!");
                error.setHeaderText("Input error!");
                error.show();
            }
            playerIDField.clear();
            passwordField.clear();
        }
        else
        {
            Alert error = new Alert(Alert.AlertType.ERROR, "You have not choose map yet!\nFirst choose your map!");
            error.setTitle("Error!");
            error.setHeaderText("Error!");
            error.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
