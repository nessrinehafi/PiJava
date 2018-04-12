/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class MyDB {
   Connection connexion;
    final  String url = "jdbc:mysql://localhost/animauxtn"; // pidev1
    final  String user = "root";
    final  String password = "";
    private static MyDB instance=null;
    
    private MyDB() {
        try {
            connexion = DriverManager.getConnection(url, user, password);
            System.out.println("\nConnexion établie");
        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static MyDB getInstance(){
        if( instance == null)
            instance = new MyDB();
        
        return instance;
    }
    
    public Connection getConnexion() {
        return connexion;
    }

}
