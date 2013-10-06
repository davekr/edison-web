/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

/**
 *
 * @author Dave
 */
public class Rozvrh {

    public Rozvrh(int idRozvrh, int idPredmet, String den, String from, String to) {
        this.idRozvrh = idRozvrh;
        this.den = den;
        this.from = from;
        this.to = to;
        this.idPredmet = idPredmet;
    }

    public String getDen() {
        return den;
    }

    public void setDen(String den) {
        this.den = den;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getIdRozvrh() {
        return idRozvrh;
    }

    public void setIdRozvrh(int idRozvrh) {
        this.idRozvrh = idRozvrh;
    }

    public int getIdPredmet() {
        return idPredmet;
    }

    public void setIdPredmet(int idPredmet) {
        this.idPredmet = idPredmet;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
    private int idRozvrh;
    private String den;
    private String from;
    private String to;
    private int idPredmet;

}
