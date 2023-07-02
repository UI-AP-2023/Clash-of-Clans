package model;

import Hero.Hero;
import com.example.game.HelloApplication;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DefensiveBuilding_g4 extends Building{
    public DefensiveBuilding_g4(ImageView imageView, double x, double y) {
        super(imageView, x, y, BuildingType.DEFENSIVE, 80, 5);
       // setImageView(new ImageView(new Image(String.valueOf(HelloApplication.class.getResource("images/town_hall_15.png")))));
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
