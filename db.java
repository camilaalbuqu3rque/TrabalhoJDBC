package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class db {

	private static Connection conexao;
	private static Properties getPropriedades() throws IOException  { 
		
		Properties propriedades = new Properties();
		FileInputStream arquivo = new 
				FileInputStream ("./properties/db.properties");
				
	propriedades.load(arquivo);
	
	return propriedades;
	
	}
	
	public static Connection getConexao() throws SQLException, IOException {
		
		if (conexao == null) {
			Properties p = db.getPropriedades();
			conexao = DriverManager.getConnection(p.getProperty("host"), 
												p.getProperty("user"), 
												p.getProperty("password")
												);
		}		
		return conexao;
		
	}
		
		public static void fechaConexao () throws SQLException{
		if (conexao != null) {
			conexao.close();
			
		}
		
	}

		public static void closeConexao() {
			// TODO Auto-generated method stub
			
		}

		
}
	
