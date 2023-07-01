package Hero;

import javafx.scene.image.Image;

public class Dragon extends Hero {

    String image1=this.getClass().getResource("/com/example/game/images/infoScreen_barbarian1.png").toString();

    public Dragon() {
        super(1, 100, 200);

        setImage(new Image(image1));
    }


}
