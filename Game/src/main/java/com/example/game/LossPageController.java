package com.example.game;

import controller.GameController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class LossPageController implements Initializable {
    private final GameController gameController=new GameController();

    @FXML
    private ImageView backImage;

    @FXML
    void backImage(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("player-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home");
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            gameController.updateWins((PlayerPageController.opponentPlayer.getNumberOfWins()+1),PlayerPageController.opponentPlayer.getPlayerID());
            PlayerPageController.opponentPlayer.setNumberOfWins(PlayerPageController.opponentPlayer.getNumberOfWins()+1);
            gameController.updateLosses((LoginPageController.loginPlayer.getNumberOfLosses()+1),LoginPageController.loginPlayer.getPlayerID());
            LoginPageController.loginPlayer.setNumberOfLosses(LoginPageController.loginPlayer.getNumberOfLosses()+1);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
