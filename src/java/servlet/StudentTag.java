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
public class StudentTag extends TagSupport{
    private String parameter;

    @Override
    public int doEndTag() {
        JspWriter writer = pageContext.getOut();
        Student student = (Student) pageContext.getAttribute("student");
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
        return EVAL_PAGE;
    }

    public void setParameter(String parameter) {
         this.parameter = parameter;
    }

}
