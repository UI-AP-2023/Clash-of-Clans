package Hero;

import Hero.Hero;
import javafx.scene.image.Image;

public class Dragon extends Hero {

    String image1=this.getClass().getResource("com/example/game/images/infoScreen_dragon.png").toString();

    public Dragon(int speed, int power, int health) {
        super(1, 100, 200);

        setImage(new Image(image1));
    }


}
