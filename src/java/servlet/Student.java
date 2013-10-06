/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

/**
 *
 * @author Dave
 */
public class Student {

    int idStudent;
    String jmeno;
    String heslo;

    public Student(int idStudent, String jmeno, String heslo) {
        this.idStudent = idStudent;
        this.jmeno = jmeno;
        this.heslo = heslo;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

}
