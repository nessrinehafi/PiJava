/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Forum;
import Model.User;
import Util.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author nessrine
 */
public class UserService {
    private static UserService UserService;

    private Connection con;
    private Statement st;
    private PreparedStatement ps;
    public ResultSet res;
    

    public UserService() {
        con = Connexion.getInstance().getConnection();
    }
   public static UserService getInstance() {
        if (UserService == null) {
            return UserService = new UserService();
        }
        return UserService;
    }
    public void ajouter(User u) {

        String pw_hash = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());

        String query = "insert into User (username,username_canonical,email,email_canonical,enabled,password,last_login,roles,nom,prenom,numtel,Datenaiss,adresse,image,role,fenable) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        try {
            ps = con.prepareStatement(query);
            // ps.setInt(1, se.getId());
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getUsername().toLowerCase());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getEmail().toLowerCase());
            ps.setBoolean(5, true);
            ps.setString(6, pw_hash);
            ps.setDate(7, date_sql);
            ps.setString(8, "a:1:{i:0;s:9:\"ROLE_USER\";}");
            ps.setString(9, u.getNom());
            ps.setString(10, u.getPrenom());
            ps.setInt(11, u.getNumtel());
            ps.setString(12, u.getDatenaiss());
            ps.setString(13, u.getAdresse());
            ps.setString(14, "image");
            ps.setString(15, "utilisateur simple");
            ps.setInt(16, 1);
            ps.executeUpdate();
            System.out.println("User est ajoutée avec succés");
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public User login(User u, String password) {
        
        List<User> l = new ArrayList<>();
        try {
            String rq = "select * from User where username= '" + u.getUsername() + "' and password='" + u.getPassword() + "'";
            st = con.createStatement();
            res = st.executeQuery(rq);

            while (res.next()) {
                l.add(new User(res.getString("nom"), res.getString("prenom"), res.getString("email"), res.getString("adresse"),
                        res.getString("username"), res.getString("password"), res.getInt("numtel"), res.getInt("id"), res.getDate(6),
                        res.getString("datenaiss")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!l.isEmpty()&&BCrypt.checkpw(password, u.getPassword())) {
            return l.get(0);
        } else {
            u.setId(-1);
            return u;
        }
    }

    public String getType_compte(int id) {
        String type_compte = "";
        try {
            String rq = "select * from user where id='" + id + "'";
            st = con.createStatement();
            res = st.executeQuery(rq);
            while (res.next()) {
                type_compte = res.getString(13);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return type_compte;
    }

    public void setConnected(User u) {
        String rq = "update user set connected=? where id=?";
        try {
            ps = con.prepareStatement(rq);
            ps.setBoolean(1, u.getConnected());
            ps.setInt(2, u.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
	   public  boolean IsActif (String lg,String pw) throws SQLException
     {
         User u = null ;
         String req = "select * from user where username=? and password =?" ;
         PreparedStatement ste= con.prepareStatement(req);
         ste.setString(1,lg) ;
		 ste.setString(2,pw);
         ResultSet result=ste.executeQuery();

		
         if(result.next())
            {
		u = new User (result.getString("nom"), 
                 result.getString("prenom"),
                 
                 result.getString("email"),
                 result.getLong("numtel"),
                 result.getString("username"),
                 result.getString("password"),
                 result.getString("enligne"), 
                 result.getString("etat"),
				 result.getInt("adresse_u"),
				a= s.findById(result.getInt("adresse_u")));
				
				 if(u.getEtat().toLowerCase().equals("actif"))
					{return true;}
				
            }
		return false;
	     
     }
     */
    	 public  User findByLgPw (String lg,String pw) throws SQLException
     {
         User utilisateur = null ;
         String req = "select * from user where username=? and password =?" ;
         PreparedStatement ste= con.prepareStatement(req);
         ste.setString(1,lg);
		 ste.setString(2,pw) ;
         ResultSet result=ste.executeQuery();
		
         if(result.next())
            {
           utilisateur = new User (result.getString("nom"), 
                      result.getString("prenom"),
                    result.getString("email"),
                 result.getInt("numtel"),
                 result.getString("username"),
                 result.getString("password"));
		
    
            }
		
         return utilisateur ;
		 
         
     }
         	 public  boolean CanLog (String lg,String pw) throws SQLException
     {	
         User u = null ;
         String req = "select * from user where username=? and password =?" ;
         PreparedStatement ste= con.prepareStatement(req);
         ste.setString(1,lg);
		 ste.setString(2,pw) ;
         ResultSet result=ste.executeQuery();
		
		
         if(result.next())
            {
				
           u =new User (result.getString("nom"), 
                      result.getString("prenom"),
                    result.getString("email"),
                 result.getInt("numtel"),
                 result.getString("username"),
                 result.getString("password"));
		
				return true;
				
            }
		return false;
   
     }
                  public  int findByLogPass (String lg,String pw) throws SQLException
     {
         int i =0 ;
         String req = "select * from user where username=? and password =?" ;
         PreparedStatement ste= con.prepareStatement(req);
         ste.setString(1,lg);
		 ste.setString(2,pw) ;
         ResultSet result=ste.executeQuery();
		
		
         if(result.next())
            {
           i = result.getInt("id"); 
                
            }
		
         return i ;
		 
         
     }
                  
	 public User get(User obj) throws SQLException {
        String condition = "Where role = "+User.role;
        if (obj.getId() != 0) {
            condition += " and id = " + obj.getId();
        } else if (obj.getUsername()!= null) {
            condition += " and pseudo = '" + obj.getUsername() + "'";
        } else if (obj.getEmail() != null) {
            condition += " and email = '" + obj.getEmail() + "'";
        }
        String req = "Select * from user " + condition;
        st = con.createStatement();
        res = st.executeQuery(req);

        if (res.next()) {
            obj.setId(res.getInt("id"));
            obj.setUsername(res.getString("username"));
            obj.setNom(res.getString("nom"));
            obj.setPrenom(res.getString("prenom"));
            obj.setEmail(res.getString("email"));
            obj.setPassword(res.getString("password"));
            obj.setDatenaiss(res.getString("datenaiss"));
    
       
     
            obj.setNumtel(res.getInt("numtel"));
            obj.setLast_login(res.getTimestamp("last_login"));

            obj.setConnected(res.getBoolean("connected"));
      
      
            return obj;
        }
        return null;
    }
         	  public  boolean IsModerateur (String lg,String pw) throws SQLException
     {
         User u = null ;
         String req = "select * from user where username=? and password =?" ;
         PreparedStatement ste= con.prepareStatement(req);
         ste.setString(1,lg) ;
		 ste.setString(2,pw);
         ResultSet result=ste.executeQuery();
		
		
         if(result.next())
            {
						
           u =new User (result.getString("nom"), 
                      result.getString("prenom"),
                    result.getString("email"),
                 result.getInt("numtel"),
                 result.getString("username"),
                 result.getString("password"),
                 result.getString("role"));
           
				
				 if(u.getRole().equals("moderateur"))
					{return true;}
				
            }
		return false;
	     
     }
                  	public ObservableList<User> selectUsers() throws SQLException {
		
		ObservableList<User> list= FXCollections.observableArrayList();

		String req = "SELECT `id`,`nom`, `prenom`, `username`,`fenable` FROM `user`";
		PreparedStatement ste = con.prepareStatement(req);
		ResultSet result = ste.executeQuery();

		while (result.next()) {
			User F = new User(result.getInt("id"),result.getString("nom"),
					result.getString("prenom"),
					
					result.getString("username"),
                                result.getInt("fenable")
			);

			list.add(F);
		}
		return list;
	}
   public void BanirForum(int id) throws SQLException {
		String req = "Update `user` SET fenable=1  WHERE id=" + id;
		Statement pre = con.createStatement();
		pre.executeUpdate(req);
		System.out.println("user bani du forum");
	}
   
   
   
}
