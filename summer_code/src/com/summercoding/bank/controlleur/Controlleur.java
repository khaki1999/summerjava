package com.summercoding.bank.controlleur;


import com.summercoding.bank.gestionnaires.GestionnaireUtilisateur;
import com.summercoding.bank.gestionnaires.GestionnaireAdmin;
import com.summercoding.bank.entities.Admin;
import com.summercoding.bank.entities.Compte;
import com.summercoding.bank.entities.Utilisateur;
import com.summercoding.bank.gestionnaires.GestionnaireCompte;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import static sun.security.jgss.GSSUtil.login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS STRIX GAMING
 */
public class Controlleur {
    
    GestionnaireAdmin gestionnaireAdmin = new GestionnaireAdmin();
    GestionnaireUtilisateur gestionnaireUtilisateur = new GestionnaireUtilisateur();
    GestionnaireCompte gestionnaireCompte = new GestionnaireCompte();
   
       public void routeverssaveUtilisateur(int iduser,String login , String password , String nom , String prenom,LocalDate datenaiss,String genre,int idadmin) throws SQLException{
        gestionnaireUtilisateur.saveUtilisateur(iduser, login, password, nom, prenom, datenaiss, genre, idadmin);
       } 
   
    public Admin routeVerslogin(String login , String pwd) throws SQLException{
        return gestionnaireAdmin.login(login, pwd);
    }
    public Utilisateur routeVersloginuser(String login , String pwd) throws SQLException{
        return gestionnaireUtilisateur.login(login, pwd);
    }
    public List<Admin> routeVersListAllAdmin() throws SQLException{
        return gestionnaireAdmin.listAllAdmin();
    }
    public List<Compte> routeVersListAllCompte() throws SQLException{
        return gestionnaireCompte.listAllCompte();
    }
    public List<Utilisateur> routeVersListAllUtilisateur() throws SQLException{
        return gestionnaireUtilisateur.listAllUtilisateur();
    }
    public void routeVerssaveCompte(float solde , int iduser, int idadmin) throws SQLException{
        gestionnaireCompte.saveCompte(solde, iduser, idadmin);
    }
    public void routeVerssaveAdmin(String login , String password , String nom) throws SQLException{
        gestionnaireAdmin.saveAdmin(login, password, nom);
    }
    public Admin routeVersAdminDetails(int idadmin) throws SQLException{
        return gestionnaireAdmin.getAdminDetails(idadmin);
    }
    
    public Utilisateur routeVersUtilisateurDetails(int iduser) throws SQLException{
        return gestionnaireUtilisateur.getUtilisateurDetails(iduser);
    }
     public void routeVersUpdate(int idadmin ,String login , String password ,String nom) throws SQLException{
         gestionnaireAdmin.updateAdmin(idadmin, login, password, nom);
    }
     
      public void routeVersUpdateUser(int iduser ,String login , String password , String nom, String prenom ,LocalDate datenaiss, String genre , int idadmin) throws SQLException{
         gestionnaireUtilisateur.updateUtilisateur(iduser, login, password, nom, prenom, datenaiss, genre, idadmin);
    }
     
      public void routeVersDelete(int idadmin ,String login , String password ,String nom) throws SQLException{
         gestionnaireAdmin.deleteAdmin(idadmin);
    }

    public void routeVerssaveCompte(double solde, int Iduser, int Idadmin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void routeVerssaveAdmin(String login, String pwd, String nom, String idAdmin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
