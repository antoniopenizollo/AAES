/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;
import persistence.ContatoDAO;

/**
 *
 * @author anton
 */
public class GravarContatoAction implements Action {
    
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        
        String nome = request.getParameter("textNome");
        String email = request.getParameter("textEmail");

        if (nome.equals("") || email.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                Contato contato = new Contato(nome, email);
                ContatoDAO.getInstance().save(contato);
                response.sendRedirect("contatoSucesso.jsp");
            } catch (SQLException ex) {
                response.sendRedirect("contatoErro.jsp");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GravarContatoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
