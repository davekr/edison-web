/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import beans.*;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Dave
 */
public class Controler extends HttpServlet{

    private Connect ct;
    private Connection con;
    private String msg;

    public void connect(){
        ct = new Connect();
        ConnectionObject co = ct.getConnection();
        con = co.getConnection();
        msg = co.getMessage();
    }

    public void close() {
        ct.closeConnection(con);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        new Connect().initialize();
    }

    @Override
    public void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException{
            execute(request, response);
	}

    @Override
    public void doPost(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException, IOException{
            execute(request, response);
    }

    public void execute(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
                connect();
                if(msg.equals("OK")) {
                    if(action == null) {
                            //
                    } else if(action.equals("student")) {
                        Data d = new Data();
                        d.setStudent(con);
                        d.setPredmet(con);
                        d.setPrubeh(con);
                        d.setRozvrh(con);
                    } else if(action.equals("predmet")) {
                        Data d = new Data();
                        d.setPredmet(con);
                        d.setGarant(con);
                        d.setPrubeh(con);
                        d.setRozvrh(con);
                        d.setStudent(con);
                    } else if(action.equals("garant")) {
                        Data d = new Data();
                        d.setGarant(con);
                        d.setPredmet(con);
                    }
                } else {
                    request.setAttribute("connection", 0);
                }
                close();
                getServletContext().getRequestDispatcher(
	            response.encodeRedirectURL("/index.jsp")).
	            forward(request, response);

    }

    private String encoding(String param) {
        try {
            return new String(param.getBytes("iso-8859-1"),
                "iso-8859-2");
        }
        catch(java.io.UnsupportedEncodingException e) {}
        return param;
    }

}
