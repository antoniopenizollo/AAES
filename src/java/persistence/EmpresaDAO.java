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
import model.Empresa;

/**
 *
 * @author anton
 */
public class EmpresaDAO {
    
    private static EmpresaDAO instance = new EmpresaDAO();
    
    private EmpresaDAO(){}
    public static EmpresaDAO getInstance(){
        return instance;
    }
    
    public void save(Empresa empresa) throws ClassNotFoundException, SQLException{
            Connection conn = null;
            Statement st = null;
            try{
                conn = DatabaseLocator.getInstance().getConnection();
                st = conn.createStatement();
                st.execute("insert into empresa_tb (nome)" +
                        " values ('"+ empresa.getNome() + "');");
            } catch (SQLException e){
                throw e;
            } finally {
                closeResources(conn,st);
            }
    }
    
    public void delete(String id_empresa) throws ClassNotFoundException, SQLException{
            Connection conn = null;
            Statement st = null;
            PreparedStatement stmt = null;
            String sql = "delete from empresa_tb where id_empresa = " + id_empresa;
            try{
                stmt = DatabaseLocator.getInstance().getConnection().prepareStatement(sql);
                stmt.executeUpdate();
            } catch (SQLException e){
                throw e;
            } finally {
                closeResources(conn,st);
            }
    }

    public Empresa search(String id_empresa) throws ClassNotFoundException, SQLException {
        Empresa empresa = null;
        PreparedStatement stmt = null;
        String sql = "select * from empresa_tb where id_empresa = " + id_empresa;
        stmt = DatabaseLocator.getInstance().getConnection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            empresa = new Empresa();
            empresa.setId(rs.getInt("id_empresa"));
            empresa.setNome(rs.getString("nome"));
        }
        
        rs.close();
        stmt.close();
        return empresa;
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
