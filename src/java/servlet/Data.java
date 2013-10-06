/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dave
 */
public class Data {
    static ArrayList<Student> student = new ArrayList<Student>();
    static ArrayList<Student> garant = new ArrayList<Student>();
    static ArrayList<Predmet> predmet = new ArrayList<Predmet>();
    static ArrayList<Rozvrh> rozvrh = new ArrayList<Rozvrh>();
    static ArrayList<Prubeh> prubeh = new ArrayList<Prubeh>();

    public void setStudent(Connection con){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Student");
            student = new ArrayList<Student>();
            while(rs.next()){
                student.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setGarant(Connection con){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Garant");
            garant = new ArrayList<Student>();
            while(rs.next()){
                garant.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setPredmet(Connection con){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Predmet");
            predmet = new ArrayList<Predmet>();
            while(rs.next()){
                predmet.add(new Predmet(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getInt(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setRozvrh(Connection con){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Rozvrh");
            rozvrh = new ArrayList<Rozvrh>();
            while(rs.next()){
                rozvrh.add(new Rozvrh(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setPrubeh(Connection con){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Prubeh");
            prubeh = new ArrayList<Prubeh>();
            while(rs.next()){
                prubeh.add(new Prubeh(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getInt(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
