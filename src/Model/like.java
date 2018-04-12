/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author sahar ghorch
 */
public class like {
  int id;
  int blog;
  String user;

    public like() {
    }

    public like(int id, int blog, String user) {
        this.id = id;
        this.blog = blog;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlog() {
        return blog;
    }

    public void setBlog(int blog) {
        this.blog = blog;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "jaime{" + "id=" + id + ", blog=" + blog + ", user=" + user + '}';
    }
      public like(int blog, String user) {
        this.blog = blog;
        this.user = user;
        
    }
      
  
  
}
