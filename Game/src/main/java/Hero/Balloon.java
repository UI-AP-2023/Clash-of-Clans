package Hero;

import javafx.scene.image.Image;

public class Balloon extends Hero {

    String image=this.getClass().getResource("com/example/game/images/infoScreen_balloon.png").toString();

    public Balloon(int speed, int power, int health) {
        super(1, 200, 100);

        setImage(new Image(image));
    }
}
