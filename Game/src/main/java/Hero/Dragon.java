package Hero;

import controller.DraggableMarker;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import model.Building;

public class Dragon extends Hero {

    String image1=this.getClass().getResource("/com/example/game/images/infoScreen_barbarian1.png").toString();

    public Dragon(ImageView imageView,ImageView fire) {
        super(1, 200, 200,15);

        //setImage(new Image(image1));
        setHeroImage(imageView);
        setArrow(fire);
    }
}
