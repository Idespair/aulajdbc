/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulajdbc;

import java.util.List;

/**
 *
 * @author Stefano
 */
public class Aulajdbc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Cliente c1 = new Cliente();
        //c1.nome = "Stefano";
        //c1.contato = "12988888888";
        
        Pessoa c2 = new Pessoa();
        c2.nome = "Isabela";
        c2.CPF = 318297911;
        
        JDBC banco = new JDBC();
        banco.SalvarCliente(c2);    
        
        //banco.ExcluirCliente(c2);
        
         List<Pessoa> clientes = banco.ListarCliente();
         
         for (int i = 0; i <= clientes.size()-1; i++)
         {
             System.out.println(clientes.get(i).nome);
             System.out.println(clientes.get(i).CPF);
             System.out.println(clientes.get(i).ID);
         }
         
    }
    
}