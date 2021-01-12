/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contato;

/**
 *
 * @author anton
 */
public class ContatoDAO {
    private static ContatoDAO instance = new ContatoDAO();
    
    private ContatoDAO(){}
    public static ContatoDAO getInstance(){
        return instance;
    }
    
    public void save(Contato contato) throws ClassNotFoundException, SQLException{
            Connection conn = null;
            Statement st = null;
            try{
                conn = DatabaseLocator.getInstance().getConnection();
                st = conn.createStatement();
                st.execute("insert into contato (nome,email)" +
                        " values ('"+ contato.getNome() + "','" + contato.getEmail() + "');");
            } catch (SQLException e){
                throw e;
            } finally {
                closeResources(conn,st);
            }
    }
    
    public void closeResources(Connection conn, Statement st){
        try {
            if(st!=null) st.close();
            if(conn!=null) conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }
}
