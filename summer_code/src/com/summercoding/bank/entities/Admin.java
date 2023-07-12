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
public class Admin {
    int idadmin;
    String login;
    String password;
    String nom;

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void save (String login , String password , String nom) throws SQLException{
        
            String command = "INSERT INTO admin ( login , password ,nom ) VALUES (?,?,?)";
            
            PreparedStatement addstmt =
                    JDBC.getConnexion().prepareStatement(command);
            addstmt.setObject(1, login);
            addstmt.setObject(2, password);
            addstmt.setObject(3, nom);
            addstmt.execute();
        
    }
    public void update(int idadmin ,String login , String password , String nom) throws SQLException{
        
            String command = "UPDATE admin SET login = ?, password = ?, nom = ? WHERE  admin .idadmin = ? ";
            
            PreparedStatement addstmt =
                    JDBC.getConnexion().prepareStatement(command);
            addstmt.setObject(1, login);
            addstmt.setObject(2, password);
            addstmt.setObject(3, nom);
            addstmt.setObject(4, idadmin);
            addstmt.execute();
    }
     public void Delete(int idadmin ) throws SQLException{
        
            String command = "DELETE FROM admin WHERE admin.idadmin = ?";
            
            PreparedStatement addstmt =
                    JDBC.getConnexion().prepareStatement(command);
            addstmt.setObject(1, idadmin);
            addstmt.execute();
        
    }
    public Admin getOne(int idadmin) throws SQLException{
             String cmd = "select * from admin where idadmin = ?";
             PreparedStatement stmt
                     =JDBC.getConnexion().prepareStatement(cmd);
             stmt.setObject(1, idadmin);
             ResultSet rs =stmt.executeQuery();
             while(rs.next()){
                 return new Admin(rs.getInt(1),rs.getString(2),
                 rs.getString(3),rs.getString(4));
             }
             return null;
    }
    
     public Admin getByLoginAndPassword(String login,String password) throws SQLException{
             String cmd = "select * from admin where login = ? and password = ?";
             PreparedStatement stmt
                     =JDBC.getConnexion().prepareStatement(cmd);
             stmt.setObject(1, login);
             stmt.setObject(2, password);
             ResultSet rs =stmt.executeQuery();
             while(rs.next()){
                 return new Admin(rs.getInt(1),rs.getString(2),
                 rs.getString(3),rs.getString(4));
             }
             return null;
    }
     
     public List <Admin> getAllAdmin() throws SQLException{
             String cmd = "select * from admin ";
             PreparedStatement stmt
                     =JDBC.getConnexion().prepareStatement(cmd);
             ResultSet rs =stmt.executeQuery();
             List<Admin> listAdmin = new ArrayList<>();
             
             while(rs.next()){
                 listAdmin.add(new Admin(rs.getInt(1),rs.getString(2),
                         rs.getString(3),rs.getString(4)));
             }
             return listAdmin;
    }
     

    public Admin() {
    }

    public Admin(int idadmin, String login, String password, String nom) {
        this.idadmin = idadmin;
        this.login = login;
        this.password = password;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Admin{" + "idadmin=" + idadmin + ", login=" + login + ", password=" + password + ", nom=" + nom + '}';
    }
    
    
    
    

    /**
     *
     * @param arg
     */
    public static void main (String arg[]) {
        try {
            Admin admin = new Admin();
            //admin.save("Tamo", "ricko", "franc");
           String result = admin.getOne(1).toString();
           System.out.println(result);
            String result1 = admin.getAllAdmin().toString();
           System.out.println(result1);
           String result2 = admin.getByLoginAndPassword("root1", "root0").toString();
           System.out.println(result2);
           admin.Delete(3);
           admin.update(1, "admin", "rick", "super");
         
           
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public String getIduser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
} 
