package model;

import com.example.game.HelloApplication;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CommonBuilding_g4 extends Building{
    public CommonBuilding_g4(ImageView imageView, double x, double y) {
        super(new ImageView(new Image(String.valueOf(HelloApplication.class.getResource("images/archer_tower_19.png")))),x, y, BuildingType.COMMON, 50, 0);
    }
}
