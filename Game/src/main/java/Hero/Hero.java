package Hero;


import javafx.scene.image.ImageView;


abstract public class Hero extends ImageView{
    private int speed;
    private int power;
    private int health;
    private ImageView heroImage;

    public Hero(int speed, int power, int health) {
        this.speed = speed;
        this.power = power;
        this.health = health;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public ImageView getHeroImage() {return heroImage;}

    public void setHeroImage(ImageView heroImage) {this.heroImage = heroImage;}

    @Override
    public String toString() {
        return "Hero{" +
                "speed=" + speed +
                ", power=" + power +
                ", health=" + health +
                '}';
    }
}
