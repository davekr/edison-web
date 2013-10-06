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
public class VyucujeParrentTag extends BodyTagSupport{
    private Iterator<Predmet> pr;

    @Override
    public int doStartTag(){
        pr = Data.predmet.iterator();
        if(iterate()) {
            return EVAL_BODY_INCLUDE;
        }
        try {
            pageContext.getOut().write("Učitel nevyučuje žádný přemět");
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
            Student student = (Student) pageContext.getAttribute("student");
            Predmet predmet = pr.next();
            if(predmet.getGarant() == student.getIdStudent()) {
                pageContext.setAttribute("predmet",
                    predmet);
                return true;
            }
        }
        return false;
    }

}
