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
public class StudentParrentTag extends BodyTagSupport {

    private Iterator<Student> st;
    private String garant;
    
    @Override
    public int doStartTag(){
        if(garant.equals("1")) {
            st = Data.garant.iterator();
        } else {
            st = Data.student.iterator();
        }
        if(iterate()) {
            return EVAL_BODY_INCLUDE;
        }
        try {
            if(garant.equals("1")) {
                pageContext.getOut().write("Seznam garantů neobsahuje žádný záznam");
            } else {
                pageContext.getOut().write("Seznam studentů neobsahuje žádný záznam");
            }
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

    public void setGarant(String garant) {
         this.garant = garant;
    }

    public boolean iterate(){
        if(st.hasNext()) {
            pageContext.setAttribute("student",
                    st.next());
            return true;
        }
        return false;
    }

}
