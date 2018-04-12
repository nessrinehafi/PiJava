/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */

public class Connexion {
     String url = "jdbc:mysql://localhost:3306/animauxtn";
    String username = "root";
    String password = "";
    private static Connexion data;
    public Connection con;//pont de connexion

    private Connexion() {
        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            System.out.println(ex);
            //Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getConnection(){
        return con;
    }
    public static Connexion getInstance()
    {
        if(data==null)
    data=new Connexion();
     return data;
    
     }


}