package com.summercoding.bank.gestionnaires;


import com.summercoding.bank.entities.Admin;
import com.summercoding.bank.entities.Utilisateur;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS STRIX GAMING
 */
public class GestionnaireUtilisateur {
    private Utilisateur utilisateur = new Utilisateur();
    
     public Utilisateur login(String login,String pwd) throws SQLException{
        
        return utilisateur.getByLoginAndPassword(login, pwd);
        
    }
    
    public  void saveUtilisateur(int iduser,String login , String password , String nom, String prenom , LocalDate datenaiss , String genre ,int idadminn) throws SQLException {
        utilisateur.save(iduser, login, password, nom, prenom, datenaiss, genre, idadminn);
        
    }
    
     public void updateUtilisateur(int iduser ,String login , String password , String nom, String prenom ,LocalDate datenaiss, String genre , int idadmin) throws SQLException{
        utilisateur.update(idadmin, login, password, nom, nom,datenaiss, nom, idadmin);
    }
     
     public Utilisateur getUtilisateurDetails(int iduser) throws SQLException{
        return utilisateur.getOne(iduser);
    }
    

    public List<Utilisateur> listAllUtilisateur() throws SQLException {
        return utilisateur.getAllUtilisateur();
       //To change body of generated methods, choose Tools | Templates.
    }
    
}
