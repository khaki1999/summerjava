/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoding.bank.gestionnaires;

import com.summercoding.bank.entities.Admin;
import com.summercoding.bank.entities.Utilisateur;
import com.summercoding.bank.entities.Compte;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ASUS STRIX GAMING
 */
public class GestionnaireCompte {
    
    private Compte compte = new Compte() ;
    
    public void saveCompte(float solde , int iduser, int idadmin) throws SQLException{
        compte.save(solde, iduser, idadmin);
    }
    
    public List<Compte> listAllCompte() throws SQLException{
        return compte.getAllCompte();
    }
    
    
}
