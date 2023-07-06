/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoding.bank.entities;

import com.summercoding.bank.utils.JDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS STRIX GAMING
 */
public class Compte {
    private static Object addstmt;
    int idcompte;
   float solde;
    int iduser;
    int idadmin;

    public int getIdcompte() {
        return idcompte;
    }

    public void setIdcompte(int idcompte) {
        this.idcompte = idcompte;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }
   
    public static void save(float solde , int iduser, int idadmin)throws SQLException{
            PreparedStatement addstmt = null;
     
            String command = "INSERT INTO compte ( solde ,iduser ,idadmin ) VALUES (?,?,?)";
            
            addstmt =
                    JDBC.getConnexion().prepareStatement(command);
            addstmt.setObject(1, solde);
            addstmt.setObject(2, iduser);
            addstmt.setObject(3, idadmin);
            addstmt.execute();

    }
    public void update(float solde,int iduser,int idadmin) throws SQLException{
        
            String command = "UPDATE compte SET solde = ? WHERE compte.idcompte = ? ";
            
            PreparedStatement addstmt =
                    JDBC.getConnexion().prepareStatement(command);
                    addstmt.setObject(1, solde);
            addstmt.setObject(2, iduser);
            addstmt.setObject(3, idadmin);
            addstmt.execute();
    }
      public void Delete(int idcompte) throws SQLException{
        
            String command = "DELETE FROM compte WHERE compte.idcompte = ? »";
            
            PreparedStatement addstmt =
                    JDBC.getConnexion().prepareStatement(command);
            addstmt.setObject(1, idcompte);
            addstmt.execute();
        
    }
      
     public Compte getOne(int idcompte) throws SQLException{
             String cmd = "select * from compte where idcompte = ?";
             PreparedStatement stmt
                     =JDBC.getConnexion().prepareStatement(cmd);
             stmt.setObject(1, idadmin);
             ResultSet rs =stmt.executeQuery();
             while(rs.next()){
                 return new Compte(rs.getInt(1),rs.getFloat(2),
                 rs.getInt(3),rs.getInt(4));
             }
             return null;
    }
     public List <Compte> getAllCompte() throws SQLException{
             String cmd = "select * from admin ";
             PreparedStatement stmt
                     =JDBC.getConnexion().prepareStatement(cmd);
             ResultSet rs =stmt.executeQuery();
             List<Compte> listCompte = new ArrayList<>();
             
             while(rs.next()){
                 listCompte.add(new Compte(rs.getInt(1),rs.getFloat(2),
                         rs.getInt(3),rs.getInt(4)));
             }
             return listCompte;
    }

    public Compte() {
    }

    public Compte(int idcompte, float solde, int iduser, int idadmin) {
        this.idcompte = idcompte;
        this.solde = solde;
        this.iduser = iduser;
        this.idadmin = idadmin;
    }
    
    public static void main (String arg[]){
        try {
            Compte compte = new Compte();
            compte.Delete(5);
        } catch (SQLException ex) {
            Logger.getLogger(Compte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
