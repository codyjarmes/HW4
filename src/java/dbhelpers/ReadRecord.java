/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ClevelandIndians;

/**
 *
 * @author jarmes
 */
public class ReadRecord {
    
 private Connection conn;
 private ResultSet results;
 
 private ClevelandIndians player = new ClevelandIndians ();
 private int PlayerID;
    
    public ReadRecord (int PlayerID) {
    
         Properties props = new Properties();//MWC
         InputStream instr = getClass().getResourceAsStream("dbConn.properties");
         try {
             props.load(instr);
         } catch (IOException ex) {
             Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             instr.close();
         } catch (IOException ex) {
             Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
         }
         String driver = props.getProperty ("driver.name");
         String url=props.getProperty("server.name");
         String username = props.getProperty ("user.name");
         String passwd = props.getProperty ("user.password");
         
         this.PlayerID=PlayerID;
         
         try {
             Class.forName(driver);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             conn = DriverManager.getConnection(url, username, passwd);
         } catch (SQLException ex) {
             Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
         }
         
    }
    
public void doRead (){
    
    
        try {
            //set up a string to hold our query
            String query = "SELECT * FROM ClevelandIndiansRoster WHERE PlayerID =?";
            
            //create a preparedstatement using our query string
            PreparedStatement ps = conn.prepareStatement (query);
            
            //fill in the preparedstatement
            ps.setInt(1,PlayerID);
            
            //execute the query
            this.results = ps.executeQuery ();
            
            this.results.next();
            
            player.setPlayerID(this.results.getInt("PlayerID"));
            player.setPlayerName(this.results.getString("PlayerName"));
            player.setCollege(this.results.getString("College"));
            player.setPlayerPosition(this.results.getString("PlayerPosition"));
            player.setAge(this.results.getInt("Age"));
            player.setHometown(this.results.getString("Hometown"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    public ClevelandIndians getPlayer (){
        
        return this.player;
    }
 } 




    
   
    
     
     
      
     
     
    


