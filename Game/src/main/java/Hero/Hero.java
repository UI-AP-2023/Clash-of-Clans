package Hero;


import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import model.Building;


abstract public class Hero extends ImageView {
    private int speed;
    private int power;
    private int health;
    private ImageView heroImage;
    private ImageView arrow;
    private double newX;
    private double newY;
    private boolean attacking=false;
    private boolean walking=true;
    private int radius;

    public Hero(int speed, int power, int health,int radius) {
        this.speed = speed;
        this.power = power;
        this.health = health;
        this.radius=radius;
    }

    public ImageView getArrow() {
        return arrow;
    }

    public void setArrow(ImageView arrow) {
        this.arrow = arrow;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public boolean isWalking() {
        return walking;
    }

    public void setWalking(boolean walking) {
        this.walking = walking;
    }
    public double getNewX() {
        return newX;
    }

    public void setNewX(double newX) {
        this.newX = newX;
    }

    public double getNewY() {
        return newY;
    }

    public void setNewY(double newY) {
        this.newY = newY;
    }

    public Bounds getBound(){
        return this.localToScene(this.getBoundsInLocal());
    }

    public boolean isAlive() {
        return getHealth() >= 0;
    }

    public boolean isAttacking() {
        return this.attacking;
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
