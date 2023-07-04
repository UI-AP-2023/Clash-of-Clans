package controller;

import Hero.Hero;
import com.example.game.MapOnePageController;
import javafx.scene.image.Image;
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
    public static final ArrayList<Building> buildings_g1 = new ArrayList<>();
    public final ArrayList<Hero> exitedHeroes=new ArrayList<>();
    public ImageView arrow;


    public void addCommonBuilding_g1(ImageView im1) {
        CommonBuilding_g1 c1 = new CommonBuilding_g1(im1, im1.getLayoutX(), im1.getLayoutY());
        buildings_g1.add(c1);
        addBuildingsToMap();
    }

    public void addDefensiveBuilding_g1(ImageView im1,ImageView arrow) {
        DefensiveBuilding_g1 d1 = new DefensiveBuilding_g1(im1, im1.getLayoutX(), im1.getLayoutY(), arrow);
        buildings_g1.add(d1);
        addBuildingsToMap();
        System.out.println("m:"+d1.getImageView().getLayoutX());
    }

    public void addBuildingsToMap() {
        Map map = new Map(buildings_g1, 15);
        GameController.listOfMaps.put(1, map);
    }
    //--------------------Map two---------------------------------------------------------------------------------------
    public static final ArrayList<Building> buildings_g2 = new ArrayList<>();

    public void addCommonBuilding_g2(ImageView im1) {
        CommonBuilding_g2 c1 = new CommonBuilding_g2(im1, im1.getLayoutX(), im1.getLayoutY());
        buildings_g2.add(c1);
       addBuildingsToMap2();

    }

    public void addDefensiveBuilding_g2(ImageView im1,ImageView arrow) {
        DefensiveBuilding_g2 d1 = new DefensiveBuilding_g2(im1, im1.getLayoutX(), im1.getLayoutY(),arrow);
        buildings_g2.add(d1);
        addBuildingsToMap2();
    }

    public void addBuildingsToMap2() {
        Map map = new Map(buildings_g2, 12);
        GameController.listOfMaps.put(2, map);
    }
    //--------------------Map three-------------------------------------------------------------------------------------
    public static final ArrayList<Building> buildings_g3 = new ArrayList<>();

    public void addCommonBuilding_g3(ImageView im1) {
        CommonBuilding_g3 c1 = new CommonBuilding_g3(im1, im1.getLayoutX(), im1.getLayoutY());
        buildings_g3.add(c1);
       addBuildingsToMap3();

    }

    public void addDefensiveBuilding_g3(ImageView im1,ImageView arrow) {
        DefensiveBuilding_g3 d1 = new DefensiveBuilding_g3(im1, im1.getLayoutX(), im1.getLayoutY(),arrow);
        buildings_g3.add(d1);
        addBuildingsToMap3();


    }

    public void addBuildingsToMap3() {
        Map map = new Map(buildings_g3, 10);
        GameController.listOfMaps.put(3, map);
    }
    //--------------------Map four--------------------------------------------------------------------------------------
    public static final ArrayList<Building> buildings_g4 = new ArrayList<>();

    public void addCommonBuilding_g4(ImageView im1) {
        CommonBuilding_g4 c1 = new CommonBuilding_g4(im1, im1.getLayoutX(), im1.getLayoutY());
        buildings_g4.add(c1);
        addBuildingsToMap4();
    }

    public void addDefensiveBuilding_g4(ImageView im1,ImageView arrow) {
        DefensiveBuilding_g4 d1 = new DefensiveBuilding_g4(im1, im1.getLayoutX(), im1.getLayoutY(),arrow);
        buildings_g4.add(d1);
       addBuildingsToMap4();

    }

    public void addBuildingsToMap4() {
        Map map = new Map(buildings_g4, 10);
        GameController.listOfMaps.put(4, map);
    }

}
