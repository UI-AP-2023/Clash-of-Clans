package com.example.game;

import controller.MapController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MapTwoPageController implements Initializable {

    @FXML
    private ImageView g2_castle1;

    @FXML
    private ImageView g2_castle2;

    @FXML
    private ImageView g2_castle3;

    @FXML
    private ImageView g2_castle4;

    @FXML
    private ImageView g2_defensive1;

    @FXML
    private ImageView g2_defensive2;

    @FXML
    private ImageView g2_defensive3;

    @FXML
    private ImageView g2_defensive4;

    @FXML
    private AnchorPane gameGround2;

    @FXML
    private ImageView mapImage2;

    //------------------------------------------------------------------------------------------------------------------
    private final MapController mapController=new MapController();
    private void addBuildings() {
        mapController.addCommonBuilding_g2(g2_castle1, g2_castle2, g2_castle3, g2_castle4);
        mapController.addDefensiveBuilding_g2(g2_defensive1, g2_defensive2, g2_defensive3,g2_defensive4);
        mapController.addBuildingsToMap2();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addBuildings();
        if (LoginPageController.loginPlayer.getPlayerLevel() >= 1 && LoginPageController.loginPlayer.getPlayerLevel() <= 3) {

            g2_castle1.setVisible(true);
            g2_castle2.setVisible(true);
            g2_castle3.setVisible(true);
            g2_castle4.setVisible(true);

            g2_defensive1.setVisible(false);
            g2_defensive2.setVisible(false);
            g2_defensive3.setVisible(false);
            g2_defensive4.setVisible(false);

        } else {

            g2_castle1.setVisible(true);
            g2_castle2.setVisible(true);
            g2_castle3.setVisible(true);
            g2_castle4.setVisible(true);

            g2_defensive1.setVisible(true);
            g2_defensive2.setVisible(true);
            g2_defensive3.setVisible(true);
            g2_defensive4.setVisible(true);

        }

    }
}
