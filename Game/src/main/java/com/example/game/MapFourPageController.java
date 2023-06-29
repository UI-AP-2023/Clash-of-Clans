package com.example.game;

import controller.MapController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MapFourPageController implements Initializable {

    @FXML
    private ImageView g4_castle1;

    @FXML
    private ImageView g4_castle2;

    @FXML
    private ImageView g4_castle3;

    @FXML
    private ImageView g4_castle4;

    @FXML
    private ImageView g4_defensive1;

    @FXML
    private ImageView g4_defensive2;

    @FXML
    private ImageView g4_defensive3;

    @FXML
    private AnchorPane gameGround4;

    @FXML
    private ImageView mapImage4;
    //------------------------------------------------------------------------------------------------------------------
    private final MapController mapController = new MapController();

    private void addBuildings() {
        mapController.addCommonBuilding_g4(g4_castle1, g4_castle2, g4_castle3, g4_castle4);
        mapController.addDefensiveBuilding_g4(g4_defensive1, g4_defensive2, g4_defensive3);
        mapController.addBuildingsToMap4();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addBuildings();
        if (LoginPageController.loginPlayer.getPlayerLevel() >= 1 && LoginPageController.loginPlayer.getPlayerLevel() <= 3) {

            g4_castle1.setVisible(true);
            g4_castle2.setVisible(true);
            g4_castle3.setVisible(true);
            g4_castle4.setVisible(true);

            g4_defensive1.setVisible(false);
            g4_defensive2.setVisible(false);
            g4_defensive3.setVisible(false);

        } else {

            g4_castle1.setVisible(true);
            g4_castle2.setVisible(true);
            g4_castle3.setVisible(true);
            g4_castle4.setVisible(true);

            g4_defensive1.setVisible(true);
            g4_defensive2.setVisible(true);
            g4_defensive3.setVisible(true);
        }

    }
}
