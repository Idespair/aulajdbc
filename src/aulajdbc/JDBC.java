/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stefano
 */
public class JDBC {
    
    private String enderecoBanco = "jdbc:sqlserver://localhost:1433;databaseName=aulaalpoo;trustServerCertificate=true";
    
    
    public Connection connection = null;
    public Statement smt;
    
    public JDBC()
    {
        // configurações do banco de dados
        
        String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String DATABASE_URL = "jdbc:sqlserver://localhost:1433;databaseName=aulaalpoo";

        try {
            Class.forName(DRIVER); // Carrega o Driver

            // Obtém a conexão com a base de dados
            connection = DriverManager.getConnection(enderecoBanco, "sa", "unip");
            smt = connection.createStatement();
            System.out.println("Conectou com o banco de dados");

        } catch (SQLException|ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }  
    }
    
    
    public void SalvarCliente(Pessoa c)
    {
        try{
        //Statement smt = connection.createStatement();
        smt.executeUpdate("insert into Pessoa (nome, CPF, ID) values ('" +  c.nome + "','" + c.CPF + "," + c.ID + "')");
        System.out.println("Inseriu uma pessoa");
        }
        catch(SQLException ex)
        {
          System.out.println(ex.getMessage());  
        }
    }
    
    public void ExcluirCliente(Pessoa c)
    {
        try{
        
        smt.executeUpdate("delete from Pessoa where nome = '" + c.nome + "'");
        System.out.println("Excluiu uma pessoa");
        }
        catch(SQLException ex)
        {
          System.out.println(ex.getMessage());  
        }
    }
    
    public List<Pessoa> ListarCliente()
    {
        List<Pessoa> resultado = new ArrayList<Pessoa>();
        
        try{
        //Statement smt = connection.createStatement();
        ResultSet resultSet = smt.executeQuery("select * from Pessoa");
        
        while (resultSet.next()) {
           // System.out.println(resultSet.getString("NOME"));
            
            Pessoa c = new Pessoa();
            c.nome = resultSet.getString("NOME");
            c.CPF = resultSet.getInt("CPF");
            c.ID = resultSet.getInt("ID");
            
            resultado.add(c);
        }

        return resultado;
        
        }
        catch(SQLException ex)
        {
          System.out.println(ex.getMessage());  
          return null;
        }
    }
    
}