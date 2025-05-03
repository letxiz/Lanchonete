/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.leticia.lanchonete;

import com.leticia.lanchonete.controller.Banco;
import com.leticia.lanchonete.model.Pedido;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author letno
 */
public class Lanchonete {

    public static void main(String[] args) {
        Banco b = new Banco();
        Connection conexao = b.conectar();
        
        Pedido pedido = new Pedido("Tapioca", 6.90);
        
        if(conexao != null){
            try{
                b.salvar(pedido, conexao);
                conexao.close();
            } catch(SQLException e){
                System.out.println("Erro ao fechar a conexão com o banco de dados");
            }
        }
    }
}
