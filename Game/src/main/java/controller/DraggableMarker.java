package controller;

import Hero.Hero;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;

import java.util.ArrayList;

public class DraggableMarker {
    public static double mouseAnchorX;
    public static double mouseAnchorY;

    public static void makeDraggable(Node node, Hero hero, ArrayList<Hero> heroes) {
        node.setOnMousePressed(mouseEvent ->
        {
            mouseAnchorX = mouseEvent.getX();
            mouseAnchorY = mouseEvent.getY();
        });

        node.setOnMouseDragged(mouseEvent ->
        {
            node.setLayoutX(mouseEvent.getSceneX() - mouseAnchorX);
            node.setLayoutY(mouseEvent.getSceneY() - mouseAnchorY);

        });
        node.setOnMouseReleased(e ->
        {
            heroes.add(hero);

        });

    }
}
