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
public class PrubehParrentTag extends BodyTagSupport {

    private Iterator<Prubeh> pr;
    Student st;

    @Override
    public int doStartTag(){
        st = (Student) pageContext.getAttribute("student");
        pr = Data.prubeh.iterator();
        if(iterate()) {
            return EVAL_BODY_INCLUDE;
        }
        try {
            pageContext.getOut().write("Student nemá zapsaný žádný přemět");
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
            if(prubeh.getIdStudent() == st.getIdStudent()) {
                Predmet predmet = new Predmet(-1, "", -1, -1);
                Iterator<Predmet> pm = Data.predmet.iterator();
                Iterator<Rozvrh> ro = Data.rozvrh.iterator();
                while(pm.hasNext() && prubeh.getIdPredmet() != predmet.getIdPredmet()) {
                    predmet = pm.next();
                }
                Rozvrh rozvrh = new Rozvrh(-1, -1, "", "", "");

                while(ro.hasNext() && prubeh.getIdRozvrh() != rozvrh.getIdRozvrh()) {
                    rozvrh = ro.next();
                }
                pageContext.setAttribute("prubeh",
                    prubeh);
                pageContext.setAttribute("predmet",
                    predmet);
                pageContext.setAttribute("rozvrh",
                    rozvrh);
                return true;
            }
        }
        return false;
    }

}
