/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Entities.Evenement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Sms {
    public static void send(Evenement event){
        String api="gcaU1m5Fw14-pZGq4spbeNeGFaDVJEySvFlksUDGm4";
         String mess="L'evenement a été modifier"
                 + ""+event.getNom() +" :D modifie";
         String send="dali";
         String num="+21655220290";
         try {      
                        String user = "username=" + "mohamedali.brahem.1@esprit.tn";
			String apiKey ="&apiKey="+api;
			String message = "&message="+mess;
			String sender = "&sender="+send;
			String numbers = "&numbers=" +num;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = user +apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
                            JOptionPane.showMessageDialog(null,"message"+line);
			}
			rd.close();			
		} catch (Exception e) {
                    JOptionPane.showMessageDialog(null,e);
		}
         
    }
   
}
