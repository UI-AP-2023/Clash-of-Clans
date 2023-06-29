package model;

import com.example.game.HelloApplication;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DefensiveBuilding_g2 extends Building {
    public DefensiveBuilding_g2(ImageView imageView, double x, double y) {
        super(new ImageView(new Image(String.valueOf(HelloApplication.class.getResource("images/town_hall_11.png")))), x, y, BuildingType.DEFENSIVE, 120, 20);
    }
}
