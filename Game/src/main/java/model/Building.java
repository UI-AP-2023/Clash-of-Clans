package model;

import javafx.scene.image.ImageView;


abstract public class Building {
    private ImageView imageView;
    private double layoutX;
    private double layoutY;
    private BuildingType buildingType;
    private int health;
    private int power;

    public Building(ImageView imageView,double x, double y, BuildingType buildingType, int health, int power) {
        this.imageView = imageView;
        this.layoutX = x;
        this.layoutY = y;
        this.buildingType = buildingType;
        this.health = health;
        this.power = power;
    }

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

    public double getLayoutX() {
        return layoutX;
    }

    public void setLayoutX(int layoutX) {
        this.layoutX = layoutX;
    }

    public double getLayoutY() {
        return layoutY;
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
