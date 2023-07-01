package model;

import model.Building;

import java.util.ArrayList;

public class Map {

    public Map(ArrayList<Building> buildings, int numberOfHeroes) {
        this.buildings = buildings;
        this.numberOfHeroes = numberOfHeroes;
    }
    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }

    public int getNumberOfHeroes() {
        return numberOfHeroes;
    }

    public void setNumberOfHeroes(int numberOfHeroes) {
        this.numberOfHeroes = numberOfHeroes;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    private ArrayList<Building> buildings;
    private int numberOfHeroes;
    @Override
    public String toString() {
        return "Map{" +
                "buildings=" + buildings +
                ", numberOfHeroes=" + numberOfHeroes +
                '}';
    }

}
