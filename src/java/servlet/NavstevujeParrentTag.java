/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.IOException;
import java.util.Iterator;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 *
 * @author Dave
 */
public class NavstevujeParrentTag extends BodyTagSupport{

    private Iterator<Prubeh> pr;
    Predmet predmet;

    @Override
    public int doStartTag(){
        predmet = (Predmet) pageContext.getAttribute("predmet");
        pr = Data.prubeh.iterator();
        if(iterate()) {
            return EVAL_BODY_INCLUDE;
        }
        try {
            pageContext.getOut().write("Daný předmět nemá zapsán žádný student");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    @Override
    public int doAfterBody() {
        if(iterate()) {
            return EVAL_BODY_AGAIN;
        }
        return EVAL_PAGE;
    }

    public boolean iterate(){
        while(pr.hasNext()) {
            Prubeh prubeh = pr.next();
            if(prubeh.getIdPredmet() == predmet.getIdPredmet()) {
                Student student = new Student(-1, "", "");
                Iterator<Rozvrh> ro = Data.rozvrh.iterator();
                Iterator<Student> st = Data.student.iterator();
                while(st.hasNext() && student.getIdStudent() != prubeh.getIdStudent()){
                    student = st.next();
                }
                Rozvrh rozvrh = new Rozvrh(-1, -1, "", "", "");
                while(ro.hasNext() && rozvrh.getIdRozvrh() != prubeh.getIdRozvrh()) {
                    rozvrh = ro.next();
                }
                pageContext.setAttribute("prubeh", prubeh);
                pageContext.setAttribute("student", student);
                pageContext.setAttribute("rozvrh", rozvrh);
                return true;
            }
        }
        return false;
    }

}
