package Hero;

import controller.DraggableMarker;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import model.Building;

public class Balloon extends Hero {

   String image=this.getClass().getResource("/com/example/game/images/infoScreen_balloon.png").toString();

    public Balloon(ImageView imageView) {
        super(1, 200, 100,0);

        //setImage(new Image(image));
        setHeroImage(imageView);
    }
}
