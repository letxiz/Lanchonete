package com.leticia.lanchonete.controller;

import com.leticia.lanchonete.model.Pedido;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author letno
 */
public class Banco {
    private String url;
    private String usuario;
    private String senha;
    
    
    public Banco(){
        url = "jdbc:mysql://localhost:3306/lanchonete";
        usuario = "root";
        senha= "driver";
    }
    
    public Connection conectar (){
        try{
            
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            
            System.out.println("A conexão com o banco de dados foi feita com sucesso!");
            return conexao;
                   
        } catch(SQLException e){
            
            System.out.println("Não foi possível conectar no banco de dados");
            return null;
            
        } 
    }
    public void salvar(Pedido pedido, Connection conexao){
        String sql = "INSERT INTO pedido(nome, preco) VALUES( ?, ?)";
        
        try{ 
            PreparedStatement stmt = conexao.prepareCall(sql);
        
            stmt.setString(1 ,pedido.getNome());
            stmt.setDouble(2 , pedido.getPreco()); 
            
            int linhasAfetadas = stmt.executeUpdate();
            
            if(linhasAfetadas > 0){
                System.out.println("O Pedido foi salvo com sucesso!");
            }
        } catch(SQLException e){
             System.out.println("O Pedido não foi salvo no Banco de dados");
        }
            
        
    }
}
