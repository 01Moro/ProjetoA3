/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connectionfactory; // Make sure this package name is correct based on your project structure

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoDB {
    //Variáveis para a conexão
    private static String host = "localhost";
    private static String porta = "3306";
    private static String db = "tulioa3";
    private static String usuario = "root";
    private static String senha = "12345";

    public static Connection obtemConexao() {
        Connection c = null;
        try {
            //URL de conexão
            String jdbcUrl = "jdbc:mysql://" + host + ":" + porta + "/" + db + "?useTimezone=true&serverTimezone=UTC";
            
            //Mostrar onde tentou conectar para debugging
            //System.out.println("Attempting to connect to: " + jdbcUrl);
            //System.out.println("User: " + usuario); 
            
            
            c = DriverManager.getConnection(jdbcUrl, usuario, senha);
            //System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            return c;

        } 
        //Caso dê erro mostrar o erro
        catch (SQLException e) {
            System.err.println("Erro ao tentar conectar ao banco de dados!");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
            e.printStackTrace();
            return null; 
        }
    }
}
