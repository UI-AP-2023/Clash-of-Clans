package model;

import Hero.Hero;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


abstract public class Building extends ImageView {
    private ImageView imageView;
    private double layoutX;
    private double layoutY;
    private BuildingType buildingType;
    private int health;
    private int power;
    private ImageView arrow;

    public Building(ImageView imageView,double x, double y, BuildingType buildingType, int health, int power) {
        this.imageView = imageView;
        this.layoutX = x;
        this.layoutY = y;
        this.buildingType = buildingType;
        this.health = health;
        this.power = power;
    }

    public Building(){}

    public ImageView getArrow() {
        return arrow;
    }

    public void setArrow(ImageView arrow) {
        this.arrow = arrow;
    }

    public boolean isAlive() {
        return getHealth() >= 0;
    }

    public abstract void attack(Hero hero);

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public void setLayoutX(int layoutX) {
        this.layoutX = layoutX;
    }

    public void setLayoutY(int layoutY) {
        this.layoutY = layoutY;
    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingType=" + buildingType +
                ", health=" + health +
                ", power=" + power +
                '}';
    }

}
