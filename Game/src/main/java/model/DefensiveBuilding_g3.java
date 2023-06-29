package model;

import com.example.game.HelloApplication;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DefensiveBuilding_g3 extends Building{
    public DefensiveBuilding_g3(ImageView imageView, double x, double y) {
        super(new ImageView(new Image(String.valueOf(HelloApplication.class.getResource("images/seeking_air_mine_3.png")))), x, y, BuildingType.DEFENSIVE, 500, 100);
    }
}
