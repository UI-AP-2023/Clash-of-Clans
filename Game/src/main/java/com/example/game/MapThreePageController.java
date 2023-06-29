package com.example.game;

import controller.MapController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
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
    //------------------------------------------------------------------------------------------------------------------
    private final MapController mapController = new MapController();

    private void addBuildings() {
        mapController.addCommonBuilding_g3(g3_castle1, g3_castle2, g3_castle3, g3_castle4);
        mapController.addDefensiveBuilding_g3(g3_bom1, g3_bom2, g3_bom3);
        mapController.addBuildingsToMap3();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addBuildings();
        if (LoginPageController.loginPlayer.getPlayerLevel() >= 1 && LoginPageController.loginPlayer.getPlayerLevel() <= 3) {

            g3_castle1.setVisible(true);
            g3_castle2.setVisible(true);
            g3_castle3.setVisible(true);
            g3_castle4.setVisible(true);

            g3_bom1.setVisible(true);
            g3_bom2.setVisible(false);
            g3_bom3.setVisible(false);

        } else {

            g3_castle1.setVisible(true);
            g3_castle2.setVisible(true);
            g3_castle3.setVisible(true);
            g3_castle4.setVisible(true);

            g3_bom1.setVisible(true);
            g3_bom2.setVisible(true);
            g3_bom3.setVisible(true);
        }

    }
}