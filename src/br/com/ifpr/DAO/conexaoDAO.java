package br.com.ifpr.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexaoDAO {
     public Connection getConexao() {
         Connection conn = null;
         try {
             String url = "jdbc:mysql://localhost:3306/bd_patrimonio?useTimezone=true&serverTimezone=UTC";
             String username = "root";
             String password = "root";
             conn = DriverManager.getConnection(url,username,password);
          
         } catch (SQLException erro) {
             JOptionPane.showMessageDialog(null, "ConexaoDAO" + erro.getMessage());
         }
         return conn;
    }

}