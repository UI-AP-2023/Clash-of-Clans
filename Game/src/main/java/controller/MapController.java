package controller;

import com.example.game.MapOnePageController;
import javafx.scene.image.ImageView;
import model.*;

import java.util.ArrayList;

public class MapController {
//    private static MapController mapController;
//    public static MapController getInstance() {
//        if (mapController == null) {
//            mapController = new MapController();
//        }
//        return mapController;
//    }
//
//    public static MapController getMapController() {
//        return mapController;
//    }
//----------------------------Map one-----------------------------------------------------------------------------------
    private final ArrayList<Building> buildings_g1 = new ArrayList<>();

    public void addCommonBuilding_g1(ImageView im1, ImageView im2, ImageView im3, ImageView im4, ImageView im5, ImageView im6) {
        CommonBuilding_g1 c1 = new CommonBuilding_g1(im1, im1.getLayoutX(), im1.getLayoutY());
        CommonBuilding_g1 c2 = new CommonBuilding_g1(im2, im2.getLayoutX(), im2.getLayoutY());
        CommonBuilding_g1 c3 = new CommonBuilding_g1(im3, im3.getLayoutX(), im3.getLayoutY());
        CommonBuilding_g1 c4 = new CommonBuilding_g1(im4, im4.getLayoutX(), im4.getLayoutY());
        CommonBuilding_g1 c5 = new CommonBuilding_g1(im5, im5.getLayoutX(), im5.getLayoutY());
        CommonBuilding_g1 c6 = new CommonBuilding_g1(im6, im6.getLayoutX(), im6.getLayoutY());
        buildings_g1.add(c1);
        buildings_g1.add(c2);
        buildings_g1.add(c3);
        buildings_g1.add(c4);
        buildings_g1.add(c5);
        buildings_g1.add(c6);
    }

    public void addDefensiveBuilding_g1(ImageView im1, ImageView im2, ImageView im3) {
        DefensiveBuilding_g1 d1 = new DefensiveBuilding_g1(im1, im1.getLayoutX(), im1.getLayoutY());
        DefensiveBuilding_g1 d2 = new DefensiveBuilding_g1(im2, im2.getLayoutX(), im2.getLayoutY());
        DefensiveBuilding_g1 d3 = new DefensiveBuilding_g1(im3, im3.getLayoutX(), im3.getLayoutY());
        buildings_g1.add(d1);
        buildings_g1.add(d2);
        buildings_g1.add(d3);
    }

    public void addBuildingsToMap() {
        Map map = new Map(buildings_g1, 12);
        GameController.listOfMaps.put(1, map);
    }
    //--------------------Map two---------------------------------------------------------------------------------------
    private final ArrayList<Building> buildings_g2 = new ArrayList<>();

    public void addCommonBuilding_g2(ImageView im1, ImageView im2, ImageView im3, ImageView im4) {
        CommonBuilding_g2 c1 = new CommonBuilding_g2(im1, im1.getLayoutX(), im1.getLayoutY());
        CommonBuilding_g2 c2 = new CommonBuilding_g2(im2, im2.getLayoutX(), im2.getLayoutY());
        CommonBuilding_g2 c3 = new CommonBuilding_g2(im3, im3.getLayoutX(), im3.getLayoutY());
        CommonBuilding_g2 c4 = new CommonBuilding_g2(im4, im4.getLayoutX(), im4.getLayoutY());

        buildings_g2.add(c1);
        buildings_g2.add(c2);
        buildings_g2.add(c3);
        buildings_g2.add(c4);

    }

    public void addDefensiveBuilding_g2(ImageView im1, ImageView im2, ImageView im3,ImageView im4) {
        DefensiveBuilding_g2 d1 = new DefensiveBuilding_g2(im1, im1.getLayoutX(), im1.getLayoutY());
        DefensiveBuilding_g2 d2 = new DefensiveBuilding_g2(im2, im2.getLayoutX(), im2.getLayoutY());
        DefensiveBuilding_g2 d3 = new DefensiveBuilding_g2(im3, im3.getLayoutX(), im3.getLayoutY());
        DefensiveBuilding_g2 d4 = new DefensiveBuilding_g2(im4, im4.getLayoutX(), im4.getLayoutY());
        buildings_g2.add(d1);
        buildings_g2.add(d2);
        buildings_g2.add(d3);
        buildings_g2.add(d4);
    }

    public void addBuildingsToMap2() {
        Map map = new Map(buildings_g2, 10);
        GameController.listOfMaps.put(2, map);
    }
    //--------------------Map three-------------------------------------------------------------------------------------
    private final ArrayList<Building> buildings_g3 = new ArrayList<>();

    public void addCommonBuilding_g3(ImageView im1, ImageView im2, ImageView im3, ImageView im4) {
        CommonBuilding_g3 c1 = new CommonBuilding_g3(im1, im1.getLayoutX(), im1.getLayoutY());
        CommonBuilding_g3 c2 = new CommonBuilding_g3(im2, im2.getLayoutX(), im2.getLayoutY());
        CommonBuilding_g3 c3 = new CommonBuilding_g3(im3, im3.getLayoutX(), im3.getLayoutY());
        CommonBuilding_g3 c4 = new CommonBuilding_g3(im4, im4.getLayoutX(), im4.getLayoutY());

        buildings_g3.add(c1);
        buildings_g3.add(c2);
        buildings_g3.add(c3);
        buildings_g3.add(c4);

    }

    public void addDefensiveBuilding_g3(ImageView im1, ImageView im2, ImageView im3) {
        DefensiveBuilding_g3 d1 = new DefensiveBuilding_g3(im1, im1.getLayoutX(), im1.getLayoutY());
        DefensiveBuilding_g3 d2 = new DefensiveBuilding_g3(im2, im2.getLayoutX(), im2.getLayoutY());
        DefensiveBuilding_g3 d3 = new DefensiveBuilding_g3(im3, im3.getLayoutX(), im3.getLayoutY());

        buildings_g3.add(d1);
        buildings_g3.add(d2);
        buildings_g3.add(d3);

    }

    public void addBuildingsToMap3() {
        Map map = new Map(buildings_g3, 10);
        GameController.listOfMaps.put(3, map);
    }
    //--------------------Map four--------------------------------------------------------------------------------------
    private final ArrayList<Building> buildings_g4 = new ArrayList<>();

    public void addCommonBuilding_g4(ImageView im1, ImageView im2, ImageView im3, ImageView im4) {
        CommonBuilding_g4 c1 = new CommonBuilding_g4(im1, im1.getLayoutX(), im1.getLayoutY());
        CommonBuilding_g4 c2 = new CommonBuilding_g4(im2, im2.getLayoutX(), im2.getLayoutY());
        CommonBuilding_g4 c3 = new CommonBuilding_g4(im3, im3.getLayoutX(), im3.getLayoutY());
        CommonBuilding_g4 c4 = new CommonBuilding_g4(im4, im4.getLayoutX(), im4.getLayoutY());

        buildings_g4.add(c1);
        buildings_g4.add(c2);
        buildings_g4.add(c3);
        buildings_g4.add(c4);

    }

    public void addDefensiveBuilding_g4(ImageView im1, ImageView im2, ImageView im3) {
        DefensiveBuilding_g4 d1 = new DefensiveBuilding_g4(im1, im1.getLayoutX(), im1.getLayoutY());
        DefensiveBuilding_g4 d2 = new DefensiveBuilding_g4(im2, im2.getLayoutX(), im2.getLayoutY());
        DefensiveBuilding_g4 d3 = new DefensiveBuilding_g4(im3, im3.getLayoutX(), im3.getLayoutY());

        buildings_g4.add(d1);
        buildings_g4.add(d2);
        buildings_g4.add(d3);

    }

    public void addBuildingsToMap4() {
        Map map = new Map(buildings_g4, 12);
        GameController.listOfMaps.put(4, map);
    }
}
