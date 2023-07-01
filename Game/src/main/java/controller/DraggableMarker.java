package controller;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;

public class DraggableMarker {
    public static double mouseAnchorX;
    public static double mouseAnchorY;

    public static void makeDraggable(Node node, TranslateTransition transition) {
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
        node.setOnMouseReleased(e->
        {
            transition.play();
        });
    }
}
