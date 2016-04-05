
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


public class SearchQuery {
   
 private Connection conn;
 private ResultSet results;
 
 public SearchQuery (){
     
     Properties props = new Properties();//MWC
     InputStream instr = getClass().getResourceAsStream("dbConn.properties");
     try {
         props.load(instr);
     } catch (IOException ex) {
         Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
     }
     try {
         instr.close();
     } catch (IOException ex) {
         Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
     }
     
    String driver = props.getProperty ("driver.name");
    String url=props.getProperty("server.name");
    String username = props.getProperty ("user.name");
    String passwd = props.getProperty ("user.password");
     try {
         Class.forName(driver);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
     }
     try {
         conn = DriverManager.getConnection(url, username, passwd);
     } catch (SQLException ex) {
         Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
     }
    
    }

public void doSearch(String PlayerName){
    
     
     try {
         String query = "Select * from ClevelandIndiansRoster WHERE Upper (PlayerName) LIKE ?";
         
         PreparedStatement ps = conn.prepareStatement (query);
         ps.setString(1, "%" + PlayerName.toUpperCase() + "%" );
         this.results = ps.executeQuery();
     } catch (SQLException ex) {
         Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
     }
     
}
     public String getHTMLTable (){
    
    String table = "";
    
    table += "<table border=1>";
    
     try {
         while (this.results.next ()){
             
             ClevelandIndians player = new ClevelandIndians();
             player.setPlayerID(this.results.getInt("PlayerID"));
             player.setPlayerName(this.results.getString("PlayerName"));
             player.setCollege(this.results.getString("College"));
             player.setPlayerPosition(this.results.getString("PlayerPosition"));
             player.setAge(this.results.getInt("Age"));
             player.setHometown(this.results.getString("Hometown"));
             
        table += "<tr>";
             
             table += "<td>";
             table += player.getPlayerID();
             table += "</td>";
             
             table += "<td>";
             table += player.getPlayerName();
             table += "</td>";
             
             table += "<td>";
             table += player.getCollege();
             table += "</td>";
             
             table += "<td>";
             table += player.getAge();
             table += "</td>";
             
             table += "<td>";
             table += player.getHometown();
             table += "</td>";
             
             table += "<td>";
             table += "<a href=update?PlayerID="+ player.getPlayerID()+ "> Update </a>" + "<a href=delete?PlayerID="+ player.getPlayerID()+ ">Delete</a>";
             table += "</td>";
                    
       table += "</tr>";
       
         }} catch (SQLException ex) {
         Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
     }
    
    table+= "</table>";
            
            return table;
            
    }
}

    
   
 
    
    

