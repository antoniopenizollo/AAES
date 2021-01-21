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
import model.Empresa;
import persistence.EmpresaDAO;

/**
 *
 * @author anton
 */
public class GravarEmpresaAction implements Action {
    
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        
        String nomeEmpresa = request.getParameter("textNome");

        if (nomeEmpresa.equals("") || nomeEmpresa.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                Empresa empresa = new Empresa(nomeEmpresa);
                EmpresaDAO.getInstance().save(empresa);
                response.sendRedirect("contatoSucesso.jsp");
            } catch (SQLException ex) {
                response.sendRedirect("contatoErro.jsp");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GravarContatoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}