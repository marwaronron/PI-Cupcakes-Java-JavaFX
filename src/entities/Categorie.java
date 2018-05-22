/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;
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
public class Categorie {
    private int id_Categorie;
    private String nom;
    private Patisserie patisserie;
     
 
    public Categorie() {

    }

    public Categorie(int id_Categorie, String nom, Patisserie patisserie) {
        this.id_Categorie = id_Categorie;
        this.nom = nom;
        this.patisserie = patisserie;
    }
        public Categorie(String nom, Patisserie patisserie) {

        this.nom = nom;
        this.patisserie = patisserie;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id_Categorie=" + id_Categorie + ", nom=" + nom + ", patisserie=" + patisserie + '}';
    }

    public int getId_Categorie() {
        return id_Categorie;
    }

    public void setId_Categorie(int id_Categorie) {
        this.id_Categorie = id_Categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Patisserie getPatisserie() {
        return patisserie;
    }

    public void setPatisserie(Patisserie patisserie) {
        this.patisserie = patisserie;
    }




 
 
}
