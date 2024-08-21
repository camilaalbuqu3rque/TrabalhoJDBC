package application;
import java.sql.Connection;
import java.sql.SQLException;

import jdbc.AlunoJDBC;

public class TesteConexao {
	public static void main(String[] args) {
        AlunoJDBC alunoJDBC = new AlunoJDBC();
        try (Connection conn = alunoJDBC.getConnection()) {
            if (conn != null) {
                System.out.println("Conexão estabelecida com sucesso!");
            } else {
                System.out.println("Falha na conexão.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}