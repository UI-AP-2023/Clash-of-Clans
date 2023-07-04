package Hero;

import javafx.scene.image.ImageView;

public class Archer extends Hero {
    String image = this.getClass().getResource("/com/example/game/images/58eeb0c0ee9418469d17edf1.png").toString();
    public Archer(ImageView imageView,ImageView arrow) {
        super(3, 20, 100,20);
        setHeroImage(imageView);
        setArrow(arrow);
        //setImage(new Image(image));
    }
}
