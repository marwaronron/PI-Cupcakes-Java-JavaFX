/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.DataSource;

/**
 *
 * @author Siala
 */
public class ReclamationService {
     Connection connection;

    public ReclamationService() {
        connection = DataSource.getInsatance().getConnection();
    }
    
   
    public void add(Reclamation c) {
            System.out.println(c.toString());
        String req = "insert into reclamation (patisserie_id,mail,description )"
                + " values (?,?,?)";
        PreparedStatement preparedStatement;
  

        try {
            preparedStatement = connection.prepareStatement(req);
            
            preparedStatement.setInt(1, c.getPatisserie_id().getIdPatisserie());
            preparedStatement.setString(2, c.getMail());
            
            preparedStatement.setString(3, c.getDescription());
           
                       

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            // throw new RuntimeException(ex); 
             ex.printStackTrace();
        }
    }

    
    
      public ObservableList<Reclamation> getAll() {
      ObservableList<Reclamation> listeCommentaires=FXCollections.observableArrayList();
       String req="select * from reclamation";
       PreparedStatement preparedStatement;
       try {
           preparedStatement=connection.prepareStatement(req);
         
           ResultSet resultSet=preparedStatement.executeQuery();
           while(resultSet.next()){
              Reclamation r= new Reclamation(
                      resultSet.getInt(1),
                       new PatisserieService().findById(resultSet.getInt(2)),
                       resultSet.getString(3),
                     
                      
                      resultSet.getString(4)
                       );
               listeCommentaires.add(r);
               
           }
       }catch (SQLException ex){
         //  Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null , ex);
           
       }
        
        
        
        return listeCommentaires;
             
    }
}
