package Hero;

import Hero.Hero;
import javafx.scene.image.Image;

public class Valkyrie extends Hero {

    String image=this.getClass().getResource("com/example/game/images/clash-of-clans-clash-royale-troop-golem-game-coc-f17fc20b1485aa19bb6ac453b6b04e98.png").toString();

    public Valkyrie(int speed, int power, int health) {
        super(5, 20, 100);

        setImage(new Image(image));
    }
}
