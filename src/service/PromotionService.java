/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Promotion;
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
public class PromotionService {
     Connection connection;

    public PromotionService() {
        connection = DataSource.getInsatance().getConnection();
    }
    
   
    public void add(Promotion c) {
            System.out.println(c.toString());
        String req = "insert into promotion (produit_id,pourcentage )"
                + " values (?,?)";
        PreparedStatement preparedStatement;
  

        try {
            preparedStatement = connection.prepareStatement(req);
            
            preparedStatement.setInt(1, c.getProduit_id().getIdProduit());
            preparedStatement.setInt(2, c.getPourcentage());
          
           
                       

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            // throw new RuntimeException(ex); 
             ex.printStackTrace();
        }
    }

    
    
      public ObservableList<Promotion> getAll() {
      ObservableList<Promotion> listeCommentaires=FXCollections.observableArrayList();
       String req="select id,produit_id,pourcentage from promotion";
       PreparedStatement preparedStatement;
       try {
           preparedStatement=connection.prepareStatement(req);
         
           ResultSet resultSet=preparedStatement.executeQuery();
           while(resultSet.next()){
             Promotion r= new Promotion(
                      resultSet.getInt(1),
                       new ProduitService().findById(resultSet.getInt(2)),
                       resultSet.getInt(3)
                     
                       );
               listeCommentaires.add(r);
               
           }
       }catch (SQLException ex){
         //  Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null , ex);
           
       }
        
        
        
        return listeCommentaires;
             
    }
}
