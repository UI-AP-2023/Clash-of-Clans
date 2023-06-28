package model;

import java.util.Random;

public class Player {
    private String playerID;
    private String password;
    private int playerLevel;
    private int numberOfWins;
    private int numberOfLosses;
    private int playerMapID;

    public Player(String playerID, String password, int playerMapID) {
        this.playerID = playerID;
        this.password = password;
        this.playerLevel = setPlayerLevel();
        this.playerMapID=playerMapID;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    private int setPlayerLevel() {
        Random random=new Random();
        this.playerLevel = random.nextInt(1,5);
        return this.playerLevel;
    }
    public int getPlayerMapID() {
        return playerMapID;
    }

    public void setPlayerMapID(int playerMapID) {
        this.playerMapID = playerMapID;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public int getNumberOfLosses() {
        return numberOfLosses;
    }

    public void setNumberOfLosses(int numberOfLosses) {
        this.numberOfLosses = numberOfLosses;
    }
    @Override
    public String toString() {
        return "Player{" +
                "playerID='" + playerID + '\'' +
                ", password='" + password + '\'' +
                ", playerLevel=" + playerLevel +
                ", numberOfWins=" + numberOfWins +
                ", numberOfLosses=" + numberOfLosses +
                '}';
    }

}
