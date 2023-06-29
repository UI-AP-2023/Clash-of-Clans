package com.example.game;

import controller.MapController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MapOnePageController implements Initializable {
    private final MapController mapController = new MapController();

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

    //------------------------------------------------------------------------------------------------------------------
    private void addBuildings() {
        mapController.addCommonBuilding_g1(g1_castle1, g1_castle2, g1_castle3, g1_castle4, g1_castle5, g1_castle6);
        mapController.addDefensiveBuilding_g1(g1_defensive1, g1_defensive2, g1_defensive3);
        mapController.addBuildingsToMap();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addBuildings();
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

        }

    }
}
