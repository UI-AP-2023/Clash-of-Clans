package Hero;

import javafx.scene.image.Image;

public class Barbarian extends Hero {

    String image=this.getClass().getResource("/com/example/game/images/infoScreen_barbarian1.png").toString();

    public Barbarian() {
        super(2, 10, 50);

        setImage(new Image(image));
    }
}
