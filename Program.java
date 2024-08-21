package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import entities.Aluno;
import jdbc.AlunoJDBC;

public class Program {

    public static void main(String[] args) {
        try {
            int opcao = 0;
            try (Scanner console = new Scanner(System.in)) {
                do {
                    System.out.println("####### Menu #######"
                            + "\n1 - Cadastrar"
                            + "\n2 - Listar"
                            + "\n3 - Alterar"
                            + "\n4 - Excluir"
                            + "\n5 - Sair");
                    System.out.println("\n\tOpção:");
                    opcao = Integer.parseInt(console.nextLine());

                    AlunoJDBC acao = new AlunoJDBC();

                    if (opcao == 1) {
                        Aluno a = new Aluno();

                        System.out.println("\n ### Cadastrar Aluno ### \n\r");

                        System.out.print("Nome: ");
                        a.setNome(console.nextLine());

                        System.out.print("Sexo: ");
                        a.setSexo(console.nextLine());

                        System.out.print("Data de Nascimento (dd-mm-aaaa): ");
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        a.setDt_nasc(LocalDate.parse(console.nextLine(), formato));

                        acao.salvar(a);
                        console.nextLine();
                        System.out.println("\n\n\n\n");
                    } else if (opcao == 2) {
                        // Listar aluno
                        System.out.println("\n ### Lista de Alunos ### \n");
                        List<Aluno> aluno = acao.listar(); // Chama o método listar
                        if (aluno.isEmpty()) {
                            System.out.println("Nenhum aluno encontrado.");
                        } else {
                            for (Aluno alunos : aluno) {
                                System.out.println("ID: " + alunos.getId());
                                System.out.println("Nome: " + alunos.getNome());
                                System.out.println("Sexo: " + alunos.getSexo());
                                System.out.println("Data de Nascimento: " + alunos.getDt_nasc());
                                System.out.println("-----------------------------");
                            }
                        }
                        System.out.println("\n\n\n\n");
                    } else if (opcao == 3) {
                        // Alterar aluno
                        // Implemente a lógica de alteração aqui
                    } else if (opcao == 4) {
                        // Excluir aluno
                        // Implemente a lógica de exclusão aqui
                    }

                } while (opcao != 5);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
}