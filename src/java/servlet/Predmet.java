/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

/**
 *
 * @author Dave
 */
public class Predmet {

    private int idPredmet;
    private String nazev;
    private int kredity;
    private int garant;

    public Predmet(int idPredmet, String nazev, int kredity, int garant) {
        this.idPredmet = idPredmet;
        this.nazev = nazev;
        this.kredity = kredity;
        this.garant = garant;
    }

    public int getGarant() {
        return garant;
    }

    public void setGarant(int garant) {
        this.garant = garant;
    }

    public int getIdPredmet() {
        return idPredmet;
    }

    public void setIdPredmet(int idPredmet) {
        this.idPredmet = idPredmet;
    }

    public int getKredity() {
        return kredity;
    }

    public void setKredity(int kredity) {
        this.kredity = kredity;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

}
