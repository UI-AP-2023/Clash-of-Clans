package model;

import Hero.Hero;
import com.example.game.HelloApplication;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DefensiveBuilding_g3 extends Building{
    public DefensiveBuilding_g3(ImageView imageView, double x, double y,ImageView arrow) {
        super(imageView, x, y, BuildingType.DEFENSIVE, 80, 20);
        //setImageView(new ImageView(new Image(String.valueOf(HelloApplication.class.getResource("images/seeking_air_mine_3.png")))));
        setArrow(arrow);
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
