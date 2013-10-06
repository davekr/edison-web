/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Dave
 */
public class PredmetTag extends TagSupport{

    private String parameter;

    @Override
    public int doEndTag() {
        JspWriter writer = pageContext.getOut();
        Predmet predmet = (Predmet) pageContext.getAttribute("predmet");
        Student garant = (Student) pageContext.getAttribute("garant");
        if(parameter.equals("id")) {
                try {
                        writer.write(new Integer(predmet.getIdPredmet()).toString());
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
        else if(parameter.equals("name")){
                try {
                        writer.write(predmet.getNazev());
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
        else if(parameter.equals("credits")){
                try {
                        writer.write(new Integer(predmet.getKredity()).toString());
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
        else if(parameter.equals("garant")){
                try {
                        writer.write(garant.getJmeno());
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
        return EVAL_PAGE;
    }

    public void setParameter(String parameter) {
         this.parameter = parameter;
    }

}
