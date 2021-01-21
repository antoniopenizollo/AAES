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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Empresa;
import persistence.EmpresaDAO;

/**
 *
 * @author anton
 */
public class LerEmpresaAction implements Action{
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        String idEmpresa = request.getParameter("textId");
        Empresa empresa = null;
        if (idEmpresa.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                empresa = EmpresaDAO.getInstance().search(idEmpresa);
                //response.sendRedirect("contatoSucesso.jsp");
                request.getRequestDispatcher("contatoSucesso.jsp").forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("contatoErro.jsp");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GravarContatoAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ServletException ex) {
                Logger.getLogger(LerContatoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
