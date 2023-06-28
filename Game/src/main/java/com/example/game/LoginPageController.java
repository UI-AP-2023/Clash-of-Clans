package com.example.game;

import controller.PlayerController;
import exception.InvalidID;
import exception.InvalidPassword;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class LoginPageController {
    private final PlayerController playerController = new PlayerController();
    @FXML
    private Button loginButton;

    @FXML
    private ImageView loginImage;

    @FXML
    private AnchorPane loginPane;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField playerIDField;

    @FXML
    private Button signupButton;

    @FXML
    void loginButton(MouseEvent event) {
            try {
                playerController.checkLoginInformation(playerIDField.getText(), passwordField.getText());
                Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("player-page.fxml")));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("Home");
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();
            } catch (SQLException | ClassNotFoundException | IOException e) {
                e.printStackTrace();
            } catch (InvalidPassword e) {
                Alert error = new Alert(Alert.AlertType.ERROR, "Your password is not correct!");
                error.setTitle("Error!");
                error.setHeaderText("Input error!");
                error.show();
            } catch (InvalidID e) {
                Alert error = new Alert(Alert.AlertType.ERROR, "Your ID is Invalid!");
                error.setTitle("Error!");
                error.setHeaderText("Input error!");
                error.show();
            }
    }

    @FXML
    void signupButton(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signup-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Signup");
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

}
