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
    
    public void delete(String email) throws ClassNotFoundException, SQLException{
            Connection conn = null;
            Statement st = null;
            PreparedStatement stmt = null;
            String sql = "delete from contato where email = ? ";
            try{
                stmt = DatabaseLocator.getInstance().getConnection().prepareStatement(sql);
                stmt.setString(1, email);
                stmt.executeUpdate();
            } catch (SQLException e){
                throw e;
            } finally {
                closeResources(conn,st);
            }
    }

    public Contato search(String email) throws ClassNotFoundException, SQLException {
        Contato contato = null;
        PreparedStatement stmt = null;
        String sql = "select * from contato where email = ? ";
        stmt = DatabaseLocator.getInstance().getConnection().prepareStatement(sql);
        stmt.setString(1, "email");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            contato = new Contato();
            contato.setNome(rs.getString("nome"));
            contato.setEmail(rs.getString("email"));
        }
        
        rs.close();
        stmt.close();
        return contato;
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
