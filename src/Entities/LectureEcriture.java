/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moham
 */
public class LectureEcriture {

	public static String lire(String fichier) {
		/* Le chemin vers le fichier à lire */
		BufferedReader fluxEntree = null;
		try {
			/* Création du flux vers le fichier texte */
			fluxEntree = new BufferedReader(new FileReader(fichier));
			/* Lecture d'une ligne */
			String ligneLue = fluxEntree.readLine();
			if (ligneLue != null) {
				return ligneLue;
			}
		} catch (IOException exc) {
			exc.printStackTrace();
		} finally {
			try {
				if (fluxEntree != null) {
					/* Fermeture du flux vers le fichier */
					fluxEntree.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	public static void ecrire(String fichier, String username, String password) {
		PrintWriter out = null;
		try {
			/* Ouverture du fichier en écriture */
			out = new PrintWriter(new BufferedWriter(new FileWriter(fichier)));
			/* Ecriture d'une ligne puis saut de ligne */
			out.print(username);
			out.print(" ");
			out.print(password);
		} catch (IOException exc) {
			exc.printStackTrace();
		} finally {
			if (out != null) {
				/* Fermeture du flux */
				out.close();
			}
		}
	}

	public static String getUsername(String fichier) {
		String login = "";
		login = lire(fichier);
		boolean test = false;
		for (int i = 0; i < login.length(); i++) {
			char c = login.charAt(i);
			if (c == ' ') {
				test = true;
			}
			if (test) {
				login = login.substring(0, i);
				break;
			}
		}
		return login;
	}

	public static String getPasword(String fichier) {
		String mdp = "";
		mdp = lire(fichier);
		boolean test = false;
		for (int i = 0; i < mdp.length(); ++i) {
			char c = mdp.charAt(i);
			if (c == ' ') {
				test = true;
			}
			if (test) {
				mdp = mdp.substring(i + 1, mdp.length());
				break;
			}
		}
		return mdp;
	}
	
	public static List<String> getReportSettings(String fichier){
		List<String>l=new ArrayList<>();
		String s=lire(fichier);
		int j=0;
		for(int i=0;i<s.length();++i){
			char a=s.charAt(i);
			if(a==' '||i==s.length()-1){
				l.add(s.substring(j,i));
				j=i+1;
			}
		}
		return l;
	}
	public static void ecrire2(String fichier , List<String> l){
		PrintWriter out = null;
		try {
			/* Ouverture du fichier en écriture */
			out = new PrintWriter(new BufferedWriter(new FileWriter(fichier)));
			/* Ecriture d'une ligne puis saut de ligne */
			for(int i=0;i<l.size();++i){
				out.print(l.get(i));
				out.print(" ");
			}
		} catch (IOException exc) {
			exc.printStackTrace();
		} finally {
			if (out != null) {
				/* Fermeture du flux */
				out.close();
			}
		}
	}
}
