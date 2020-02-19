package br.com.projectoACAP.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Factory {
	private static final String URL = "jdbc:mysql://localhost:3306/gestaodesportiva_db";
	private static final String USUARIO = "root";
	private static final String SENHA = "";

	public static Connection conectar() throws SQLException {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
                
                
                return conexao;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
            }
return null;
	}

}
