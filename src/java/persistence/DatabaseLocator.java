/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author anton
 */
public class DatabaseLocator {
    
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/designpatterndb";
    private static final String USER = "postgres";
    private static final String PASS = "admin";
    
    //Padrão Singleton
    private static DatabaseLocator instance = new DatabaseLocator();
    public static DatabaseLocator getInstance(){
        return instance;
    }
    private DatabaseLocator(){}
    //End Padrão
    
    public Connection getConnection() throws ClassNotFoundException{
        Connection con= null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexao com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro - conexão" + ex);
        }
        
        return con;
    }   
}
