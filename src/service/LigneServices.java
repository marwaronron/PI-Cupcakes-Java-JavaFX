/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Interface.ILignes;
import entities.Ligne_Commande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DataSource;

/**
 *
 * @author beryl kristina
 */
public class LigneServices implements ILignes {
    
    Connection connection;
    
    public LigneServices()
    {
        connection = DataSource.getInsatance().getConnection();
    }
    
    
    @Override
    public List<Ligne_Commande> getBycom(Integer commande) {
        List<Ligne_Commande> li = new ArrayList<>();
       String req = "select * from Ligne_Commande where commande=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, commande);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Ligne_Commande lc;
                //(int id, float prixp, int quantite, Commandes commande, Produits produit)
                lc = new Ligne_Commande(resultSet.getInt(1), resultSet.getDouble(5),resultSet.getInt(4),new CommandesServices().findById(resultSet.getInt(2)), new ProduitService().findById(resultSet.getInt(3)));
                li.add(lc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return li;
    }
    
    @Override
     public void add(Ligne_Commande t) {
       
        try {
            String requete = "INSERT INTO ligne_commande(id,commande,produit,quantite,prixp) VALUES (?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(1, t.getId());
            pst.setInt(2, t.getCommande().getId());
            pst.setInt(3, t.getProduit().getIdProduit());
            pst.setInt(4, t.getQuantite());
            pst.setDouble(5,t.getPrixp());
            System.out.println(requete);
            pst.executeUpdate();
            System.out.println("Insertion effectué avec succés");

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }

   
     }
     
     @Override
      public int Countprod(int produit){
        int v1=0;
        String req1 = "select count(*) from ligne_commande where produit =?";
        PreparedStatement preparedStatement1;
        try {
            preparedStatement1 = connection.prepareStatement(req1);
            preparedStatement1.setInt(1, produit);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
            v1= resultSet1.getInt(1); }
            System.out.println(v1);
        } catch (SQLException ex) {
             ex.printStackTrace();
        } 
        return v1;
    }
      
    @Override
       public List<Ligne_Commande> getAll()
    {
     List<Ligne_Commande> com = new ArrayList<>();
        String req = "select * from ligne_commande";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Ligne_Commande c;
                c = new Ligne_Commande(resultSet.getInt(1), resultSet.getFloat(5),resultSet.getInt(4),new CommandesServices().findById(resultSet.getInt(2)), new ProduitService().findById(resultSet.getInt(3)));
                com.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return com;   
    }
       
    @Override
        public void remove(Integer id) {
        String req = "delete from ligne_commande where id =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
   
    
    
    
}
