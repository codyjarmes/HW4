/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jarmes
 */
public class ClevelandIndians {
    
private int PlayerID;
private String PlayerName;
private String College;
private String PlayerPosition;
private int Age;
private String Hometown;

public ClevelandIndians() {
        this.PlayerID = 0;
        this.PlayerName = "";
        this.College = "";
        this.PlayerPosition = "";
        this.Age = 0;
        this.Hometown = "";
    }

public ClevelandIndians(int PlayerID, String PlayerName, String College, String PlayerPosition, int Age, String Hometown) {
        this.PlayerID = PlayerID;
        this.PlayerName = PlayerName;
        this.College = College;
        this.PlayerPosition = PlayerPosition;
        this.Age = Age;
        this.Hometown = Hometown;
    }


    public int getPlayerID() {
        return PlayerID;
    }

    public void setPlayerID(int PlayerID) {
        this.PlayerID = PlayerID;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public void setPlayerName(String PlayerName) {
        this.PlayerName = PlayerName;
    }

    public String getCollege() {
        return College;
    }

    public void setCollege(String College) {
        this.College = College;
    }

    public String getPlayerPosition() {
        return PlayerPosition;
    }

    public void setPlayerPosition(String PlayerPosition) {
        this.PlayerPosition = PlayerPosition;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getHometown() {
        return Hometown;
    }

    public void setHometown(String Hometown) {
        this.Hometown = Hometown;
    }

    @Override
    public String toString() {
        return "ClevelandIndians{" + "PlayerID=" + PlayerID + ", PlayerName=" + PlayerName + ", College=" + College + ", PlayerPosition=" + PlayerPosition + ", Age=" + Age + ", Hometown=" + Hometown + '}';
    }

    
}
