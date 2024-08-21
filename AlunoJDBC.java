package jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import entities.Aluno;

public class AlunoJDBC {

	private Properties carregarPropriedades() {
        Properties props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                System.out.println("Desculpe, não foi possível encontrar o arquivo db.properties");
                return null;
            }
            // Carrega as propriedades do arquivo db.properties
            props.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return props;
    }

    public Connection getConnection() {
        Properties props = carregarPropriedades();
        if (props == null) {
            throw new RuntimeException("Erro ao carregar propriedades do banco de dados");
        }

        String url = props.getProperty("host");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
   	
    public static void main(String[] args) {
        try {
            int opcao = 0;
            Scanner console = new Scanner(System.in);
            AlunoJDBC acao = new AlunoJDBC();

            do {
                System.out.println("####### Menu #######"
                        + "\n1 - Cadastrar"
                        + "\n2 - Listar"
                        + "\n3 - Alterar"
                        + "\n4 - Excluir"
                        + "\n5 - Sair");
                System.out.println("\n\tOpção:");
                opcao = Integer.parseInt(console.nextLine());

                if (opcao == 1) {
                    Aluno a = new Aluno();
                    
                    System.out.println("\n ### Cadastrar Aluno ### \n");
                    
                    System.out.print("Nome: ");
                    a.setNome(console.nextLine());
                    
                    System.out.print("Sexo: ");
                    a.setSexo(console.nextLine());
                    
                    System.out.print("Data de Nascimento (dd/mm/aaaa): ");
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    a.setDt_nasc(LocalDate.parse(console.nextLine(), formato));
                    
                    acao.salvar(a);
                    System.out.println("\nAluno cadastrado com sucesso!\n");
                    
                } else if (opcao == 2) {
                    // Opção 2 - Listar Alunos
                    System.out.println("\n ### Listar Alunos ### \n");
                    List<Aluno> aluno = acao.listar();
                    for (Aluno aluno1 : aluno) {
                        System.out.println("ID: " + aluno1.getId() 
                                + ", Nome: " + aluno1.getNome() 
                                + ", Sexo: " + aluno1.getSexo() 
                                + ", Data de Nascimento: " + aluno1.getDt_nasc());
                    }
                    System.out.println();

                } else if (opcao == 3) {
                    // Opção 3 - Alterar Aluno
                    System.out.println("\n ### Alterar Aluno ### \n");
                    
                    System.out.print("ID do Aluno: ");
                    int id = Integer.parseInt(console.nextLine());
                    
                    Aluno alunoParaAlterar = new Aluno();
                    alunoParaAlterar.setId(id);
                    
                    System.out.print("Novo Nome: ");
                    alunoParaAlterar.setNome(console.nextLine());
                    
                    System.out.print("Novo Sexo: ");
                    alunoParaAlterar.setSexo(console.nextLine());
                    
                    System.out.print("Nova Data de Nascimento (dd/mm/aaaa): ");
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    alunoParaAlterar.setDt_nasc(LocalDate.parse(console.nextLine(), formato));
                    
                    acao.alterar(alunoParaAlterar);
                    System.out.println("\nAluno atualizado com sucesso!\n");

                } else if (opcao == 4) {
                    // Opção 4 - Excluir Aluno
                    System.out.println("\n ### Excluir Aluno ### \n");
                    
                    System.out.print("ID do Aluno: ");
                    int idParaExcluir = Integer.parseInt(console.nextLine());
                    
                    acao.apagar(idParaExcluir);
                    System.out.println("\nAluno excluído com sucesso!\n");
                }

            } while (opcao != 5);

            console.close();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

	private void apagar(int idParaExcluir) {
		// TODO Auto-generated method stub
		
	}

	private void alterar(Aluno alunoParaAlterar) {
		// TODO Auto-generated method stub
		
	}

	public List<Aluno> listar() {
        List<Aluno> aluno = new ArrayList<>();
		return aluno;
	}

	public void salvar(Aluno a) {
		// TODO Auto-generated method stub
		
	}
}