package Hero;

import controller.DraggableMarker;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import model.Building;

public class Valkyrie extends Hero {

    String image=this.getClass().getResource("/com/example/game/images/clash-of-clans-clash-royale-troop-golem-game-coc-f17fc20b1485aa19bb6ac453b6b04e98.png").toString();

    public Valkyrie(ImageView imageView) {
        super(5, 20, 100,0);
        //setImage(new Image(image));
        setHeroImage(imageView);
    }
}
