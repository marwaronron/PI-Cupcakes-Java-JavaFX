/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Evaluation;
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
public class EvaluationService {
      Connection connection;

    public EvaluationService() {
        connection = DataSource.getInsatance().getConnection();
    }
    
   
    public void add(Evaluation c) {
            System.out.println(c.toString());
        String req = "insert into evaluation (patisserie_id,mail,local,service,noteprix,noteproduit,decor )"
                + " values (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
  

        try {
            preparedStatement = connection.prepareStatement(req);
            
            preparedStatement.setInt(1, c.getPatisserie_id().getIdPatisserie());
            preparedStatement.setString(2, c.getMail());
            
            preparedStatement.setInt(3, c.getLocal());
              preparedStatement.setInt(4, c.getService());
                preparedStatement.setInt(5, c.getNoteprix());
                  preparedStatement.setInt(6, c.getNoteproduit());
                    preparedStatement.setInt(7, c.getDecor());
           
                       

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            // throw new RuntimeException(ex); 
             ex.printStackTrace();
        }
    }

    
    
      public ObservableList<Evaluation> getAll() {
      ObservableList<Evaluation> listeCommentaires=FXCollections.observableArrayList();
       String req="select * from evaluation";
       PreparedStatement preparedStatement;
       try {
           preparedStatement=connection.prepareStatement(req);
         
           ResultSet resultSet=preparedStatement.executeQuery();
           while(resultSet.next()){
              Evaluation r= new Evaluation(
                      resultSet.getInt(1),
                       new PatisserieService().findById(resultSet.getInt(2)),
                       resultSet.getString(3),
                     
                      
                      resultSet.getInt(4),
                      resultSet.getInt(5),
                              resultSet.getInt(6),
                                      resultSet.getInt(7),
                       resultSet.getInt(8)
                                             
                       );
               listeCommentaires.add(r);
               
           }
       }catch (SQLException ex){
         //  Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null , ex);
           
       }
        
        
        
        return listeCommentaires;
             
    }
}
