package model;

import Hero.Hero;
import com.example.game.HelloApplication;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CommonBuilding_g3 extends Building{
    public CommonBuilding_g3(ImageView imageView, double x, double y) {
        super(imageView,x, y, BuildingType.COMMON, 60, 0);
       // setImageView(new ImageView(new Image(String.valueOf(HelloApplication.class.getResource("images/town_hall_10.png")))));
    }

    @Override
    public void attack(Hero hero) {
        while (this.getHealth()!=0 && hero.getHealth()!=0)
        {
            this.setHealth(this.getHealth()-hero.getHealth());
            hero.setHealth(hero.getHealth()-this.getHealth());
        }
    }
}
