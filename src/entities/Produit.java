/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author CSS
 */
public class Produit {
    private  int idProduit;
    private  String nom;
    private double prix;
    private String stock;
    private Categorie categorie;  
    private String nomImage;
    private int quantite;
   // private byte[] imageProduit;

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
        public Produit() {

    
    }


    public Produit(int idProduit, String nom, double prix, String stock, Categorie categorie, String nomImage ) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
        this.categorie = categorie;
        this.nomImage = nomImage;
    
    }
        public Produit(String nom, double prix, String stock, Categorie categorie ) {

        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
        this.categorie = categorie;
    
    
    }

    
        public Produit(String nom, double prix, String stock, Categorie categorie, String nomImage  ) {

        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
        this.categorie = categorie;
         this.nomImage = nomImage;

    }

    @Override
    public String toString() {
        return "Produit{" + "idProduit=" + idProduit + ", nom=" + nom + ", prix=" + prix + ", stock=" + stock + ", categorie=" + categorie + ", image=" + nomImage + '}';
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }


    public String getNomImage() {
        return nomImage;
    }

    public void setNomImage(String nomImage) {
        this.nomImage= nomImage;
    }
    
    

    
    
    
}