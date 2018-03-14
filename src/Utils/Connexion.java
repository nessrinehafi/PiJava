/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haythem
 */
public class Connexion {
    
    
        private static Connexion C; 
        String url="jdbc:mysql://localhost:3306/animauxtn";
	String user="root";
	String pw="";
	
	Connection cnx;
        
private Connexion(){
		try {
                    			
                    //Class.forName("com.mysql.jdbc.Driver");

			cnx= DriverManager.getConnection(url, user, pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
        	}

public static Connexion getInstance(){
        
        if(C==null){
        C=new Connexion();
        }
        return C;
        }
public Connection getConnexion(){
    return cnx;
}
       

}
