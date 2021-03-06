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
public class NavstevujeTag extends TagSupport{
    private String parameter;

    @Override
    public int doEndTag() {
        JspWriter writer = pageContext.getOut();
        Prubeh prubeh = (Prubeh) pageContext.getAttribute("prubeh");
        Student student = (Student) pageContext.getAttribute("student");
        Rozvrh rozvrh = (Rozvrh) pageContext.getAttribute("rozvrh");
        if(parameter.equals("id")) {
                try {
                        writer.write(new Integer(student.getIdStudent()).toString());
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
        else if(parameter.equals("name")){
                try {
                        writer.write(student.getJmeno());
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
        else if(parameter.equals("points")){
                try {
                        writer.write(new Integer(prubeh.getBody()).toString());
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
        else if(parameter.equals("register")){
                try {
                        writer.write(prubeh.getZapsan());
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
        else if(parameter.equals("date")){
                try {
                        writer.write(rozvrh.getDen() + ": " + rozvrh.getFrom()
                                + "-" + rozvrh.getTo());
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
