package Hero;

import Hero.Hero;
import javafx.scene.image.Image;

public class Archer extends Hero {

    String image = this.getClass().getResource("/com/example/game/images/58eeb0c0ee9418469d17edf1.png").toString();
    public Archer() {
        super(3, 20, 100);
        //setHeroImage(new ImageView(new Image(image)));
        setImage(new Image(image));
    }
}
