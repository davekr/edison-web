/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

/**
 *
 * @author Dave
 */
public class Prubeh {

    private int idStudent;
    private int idPredmet;
    private int idRozvrh;
    private int body;
    private String zapsan;

    public Prubeh(int idStudent, int idPredmet, int idRozvrh, int body, String zapsan) {
        this.idStudent = idStudent;
        this.idPredmet = idPredmet;
        this.idRozvrh = idRozvrh;
        this.body = body;
        this.zapsan = zapsan;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public int getIdPredmet() {
        return idPredmet;
    }

    public void setIdPredmet(int idPredmet) {
        this.idPredmet = idPredmet;
    }

    public int getIdRozvrh() {
        return idRozvrh;
    }

    public void setIdRozvrh(int idRozvrh) {
        this.idRozvrh = idRozvrh;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getZapsan() {
        return zapsan;
    }

    public void setZapsan(String zapsan) {
        this.zapsan = zapsan;
    }

}
