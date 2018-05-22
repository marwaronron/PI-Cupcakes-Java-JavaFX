/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Interface.ICommandes;
import entities.Commandes;
import entities.Recette;
import entities.User;
import entities.Utilisateurs_Adresses;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.DataSource;

/**
 *
 * @author beryl kristina
 */
public class CommandesServices implements ICommandes {
    
    Connection connection;
    
    public CommandesServices()
    {
        connection = DataSource.getInsatance().getConnection();
    }
     @Override
    public List<Commandes> getAll()
    {
     List<Commandes> com = new ArrayList<>();
        String req = "select * from commandes";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Commandes c;
                c = new Commandes (resultSet.getInt(1),new UserService().findById(resultSet.getInt(2)),resultSet.getDate(3),resultSet.getFloat(4),new UtilisateursService().findById(resultSet.getInt(5)) );
                com.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return com;   
    }
    
     @Override
     public void remove(Integer id) {
        String req = "delete from commandes where id =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
   
    @Override
      public Commandes findById(Integer id) {
       Commandes  com = null;
        String req = "select * from commandes  where id =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 
                com = new Commandes (resultSet.getInt(1),new UserService().findById(resultSet.getInt(2)),resultSet.getDate(3),resultSet.getFloat(4),new UtilisateursService().findById(resultSet.getInt(5))  );
                 }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return com;
     
    }
       public Commandes findByDate(Date date) {
       Commandes  com = null;
       java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        String req = "select * from commandes  where date =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setDate(1, date_sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 
                com = new Commandes (resultSet.getInt(1),new UserService().findById(resultSet.getInt(2)),resultSet.getDate(3),resultSet.getFloat(4),new UtilisateursService().findById(resultSet.getInt(5)) );
                 }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return com;
     
    }
    @Override
      public void add(Commandes t) {
          java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
           System.out.println("---------------------------"+t);
       
        try {
            String requete = "INSERT INTO commandes(user_id,date,prixtotal,adresse_id) VALUES (?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(requete);
            
            pst.setInt(1, t.getUser_id().getId());
            pst.setDate(2, date_sql);
            pst.setFloat(3, t.getPrixtotal());
            pst.setInt(4, t.getAdresse_id().getId());
            
            pst.executeUpdate();
            System.out.println("Insertion effectué avec succés");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
      
    @Override
      public ObservableList<Commandes> findBy(User user_id){
           ObservableList<Commandes> list= FXCollections.observableArrayList();
           java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
           String req = "select * from commandes where user_id=? ";
           PreparedStatement preparedStatement;
       try {
           preparedStatement=connection.prepareStatement(req);
           preparedStatement.setString(1,user_id.getUsername());
           ResultSet resultSet=preparedStatement.executeQuery();
           while(resultSet.next()){
              Commandes r= new Commandes(resultSet.getInt(1),new UserService().findById(resultSet.getInt(2)),resultSet.getDate(3),resultSet.getFloat(4),new UtilisateursService().findById(resultSet.getInt(5)) );
               list.add(r);
               
           }
       }catch (SQLException ex){
           Logger.getLogger(CommandesServices.class.getName()).log(Level.SEVERE, null , ex);
           
       }
       return list;
      } 

    @Override
       public ObservableList<Commandes> DisplayAll(){
             ObservableList<Commandes> list=FXCollections.observableArrayList();
       String req="select * from commandes ";
       PreparedStatement preparedStatement;
       try {
           preparedStatement=connection.prepareStatement(req);
           
           ResultSet resultSet=preparedStatement.executeQuery();
           while(resultSet.next()){
              Commandes r= new Commandes(resultSet.getInt(1),new UserService().findById(resultSet.getInt(2)),resultSet.getDate(3),resultSet.getFloat(4),new UtilisateursService().findById(resultSet.getInt(5)) );
               list.add(r);     
           }
       }catch (SQLException ex){
           Logger.getLogger(CommandesServices.class.getName()).log(Level.SEVERE, null , ex);          
       }
        return list;   
    }
      
       @Override
       public int CountCom(int user_id){
        int v1=0;
        String req1 = "select count(*) from commandes where user_id =?";
        PreparedStatement preparedStatement1;
        try {
            preparedStatement1 = connection.prepareStatement(req1);
            preparedStatement1.setInt(1, user_id);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
               v1= resultSet1.getInt(1); }
            System.out.println(v1);
        } catch (SQLException ex) {
             ex.printStackTrace();
        } 
        return v1;
    }
    
}
