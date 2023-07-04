package Hero;

import controller.DraggableMarker;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import model.Building;

public class Barbarian extends Hero {

    String image=this.getClass().getResource("/com/example/game/images/infoScreen_barbarian1.png").toString();

    public Barbarian(ImageView imageView) {
        super(2, 10, 50,0);

        //setImage(new Image(image));
        setHeroImage(imageView);
    }
}
