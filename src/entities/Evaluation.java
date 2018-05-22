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
public class Evaluation {
    private int id;
    private Patisserie patisserie_id;
    private String mail;
    private Integer local;
    private Integer service;
    private Integer noteprix;
    private Integer noteproduit;
    private Integer decor;

    public Evaluation() {
    }

    public Evaluation(int id, Patisserie patisserie_id, String mail, Integer local, Integer service, Integer noteprix, Integer noteproduit, Integer decor) {
        this.id = id;
        this.patisserie_id = patisserie_id;
        this.mail = mail;
        this.local = local;
        this.service = service;
        this.noteprix = noteprix;
        this.noteproduit = noteproduit;
        this.decor = decor;
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

    public Integer getLocal() {
        return local;
    }

    public void setLocal(Integer local) {
        this.local = local;
    }

    public Integer getService() {
        return service;
    }

    public void setService(Integer service) {
        this.service = service;
    }

    public Integer getNoteprix() {
        return noteprix;
    }

    public void setNoteprix(Integer noteprix) {
        this.noteprix = noteprix;
    }

    public Integer getNoteproduit() {
        return noteproduit;
    }

    public void setNoteproduit(Integer noteproduit) {
        this.noteproduit = noteproduit;
    }

    public Integer getDecor() {
        return decor;
    }

    public void setDecor(Integer decor) {
        this.decor = decor;
    }

  
    
}
