/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Siala
 */
public class Reclamation {
    private int id;
    private Patisserie patisserie_id;
    private String mail;
    private String description;

    public Reclamation() {
    }

    public Reclamation(int id, Patisserie patisserie_id, String mail, String description) {
        this.id = id;
        this.patisserie_id = patisserie_id;
        this.mail = mail;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patisserie getPatisserie_id() {
        return patisserie_id;
    }

    public void setPatisserie_id(Patisserie patisserie_id) {
        this.patisserie_id = patisserie_id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
