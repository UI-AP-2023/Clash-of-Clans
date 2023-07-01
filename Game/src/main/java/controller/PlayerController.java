package controller;

import exception.DuplicatePlayerID;
import exception.InvalidID;
import exception.InvalidPassword;
import model.Player;
import mysql.MySQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerController {
    private Player player;
//-------check signup information---------------------------------------------------------------------------------------

    public boolean checkPlayerID(String playerID) throws DuplicatePlayerID, SQLException, ClassNotFoundException {
        String sqlCmd = "Select playerID from players";
        MySQLConnection mySQLConnection = new MySQLConnection();
        ResultSet rs = mySQLConnection.executeQuery(sqlCmd);
            while (rs.next()) {
                if (Objects.equals(rs.getString("playerID"), playerID)) {
                    throw new DuplicatePlayerID();
                }
            }
            return true;//accepted playerID
    }

    public boolean checkPatternPassword(String password) throws InvalidPassword {
        Pattern pattern = Pattern.compile("\\w{8}$");
        Matcher matcher = pattern.matcher(password);
        if (matcher.find())
            return true;
        throw new InvalidPassword();
    }

    //--------------save to database------------------------------------------------------------------------------------
    public int findMaxID() throws SQLException, ClassNotFoundException {
        String sqlCmd = "Select MAX(ID) from players";
        MySQLConnection mySQLConnection = new MySQLConnection();
        ResultSet rs = mySQLConnection.executeQuery(sqlCmd);
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }

    public void insertPlayer(Player p) throws SQLException, ClassNotFoundException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = String.format("INSERT INTO players (ID,playerID, password, playerLevel, numberOfWins, numberOfLosses, mapID) " +
                        "VALUES ('%d', '%s','%s', '%d','%d','%d', '%d')",
                (findMaxID() + 1), p.getPlayerID(), p.getPassword(), p.getPlayerLevel(), p.getNumberOfWins(), p.getNumberOfLosses(), p.getPlayerMapID());
        mySQLConnection.executeSQL(sql);
    }

//---------------------- Login -----------------------------------------------------------------------------------------

    public boolean checkLoginInformation(String ID, String password1) throws SQLException, ClassNotFoundException, InvalidPassword, InvalidID {
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = "Select `playerID`, `password` From players";
        ResultSet rs = mySQLConnection.executeQuery(sql);

        while (rs.next()) {
            if (Objects.equals(rs.getString("playerID"), ID)) {
                if (Objects.equals(rs.getString("password"), password1)) {
                    return true;
                } else
                    throw new InvalidPassword();
            }
        }
        return false;
    }

    //------------------------------------------------------------------------------------------------------------------
    public Player findPlayer(String playerID) throws SQLException, ClassNotFoundException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = "SELECT `ID`, `playerID`, `password`, `playerLevel`, `numberOfWins`, `numberOfLosses`, `mapID` FROM `players`";
        ResultSet rs = mySQLConnection.executeQuery(sql);

            while (rs.next()) {
                if (Objects.equals(rs.getString("playerID"), playerID)) {
                    player = new Player(rs.getString("playerID"), rs.getString("password"), rs.getInt("playerLevel"),
                            rs.getInt("numberOfWins"), rs.getInt("numberOfLosses"), rs.getInt("mapID"));
                    return player;
                }
            }
        return null;
    }

}
