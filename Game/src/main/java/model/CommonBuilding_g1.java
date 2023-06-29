package model;

import com.example.game.HelloApplication;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CommonBuilding_g1 extends Building {
    public CommonBuilding_g1(ImageView imageView, double x, double y) {
        super(new ImageView(new Image(String.valueOf(HelloApplication.class.getResource("images/town_hall_16.png")))),x, y, BuildingType.COMMON, 50, 0);
    }

}
