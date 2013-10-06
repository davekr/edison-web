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
public class PredmetParrentTag extends BodyTagSupport{

    private Iterator<Predmet> pr;

    @Override
    public int doStartTag(){
        pr = Data.predmet.iterator();
        if(iterate()) {
            return EVAL_BODY_INCLUDE;
        }
        try {
            pageContext.getOut().write("Seznam předmětů neobsahuje žádný záznam");
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
        if(pr.hasNext()) {
            Predmet predmet = pr.next();
            Student student = new Student(-1, "", "");
            Iterator<Student> gr = Data.garant.iterator();
            while(gr.hasNext() && student.getIdStudent() != predmet.getGarant()) {
                student = gr.next();
            }
            pageContext.setAttribute("predmet",
                    predmet);
            pageContext.setAttribute("garant",
                    student);
            return true;
        }
        return false;
    }

}
