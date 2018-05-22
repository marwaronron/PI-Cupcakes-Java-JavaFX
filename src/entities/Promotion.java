/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author Siala
 */
public class Promotion {
    private Integer id ;
    private Produit produit_id;
  
    private Integer pourcentage;

    public Promotion(){
        
    }
    public Promotion(Integer id, Produit produit_id,  Integer pourcentage) {
        this.id = id;
        this.produit_id = produit_id;
      
        this.pourcentage = pourcentage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produit getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(Produit produit_id) {
        this.produit_id = produit_id;
    }



    public Integer getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(Integer pourcentage) {
        this.pourcentage = pourcentage;
    }
    
    
    
    
}
