
import java.util.Scanner;

public class CadastroAlunos {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CADASTRO DE ALUNOS - EBAC ===");

        int quantidadeAlunos = lerInteiroPositivo(
                scanner, "Quantos alunos deseja cadastrar? "
        );

        Aluno[] alunos = new Aluno[quantidadeAlunos];

        for (int i = 0; i < alunos.length; i++) {

            System.out.println("\n--- Aluno " + (i + 1) + " ---");

            String nome;

            do {
                System.out.print("Nome do aluno: ");
                nome = scanner.nextLine().trim();

                if (nome.isEmpty()) {
                    System.out.println("O nome nao pode ficar vazio.");
                }
            } while (nome.isEmpty());

            int quantidadeNotas = lerInteiroPositivo(
                    scanner, "Quantidade de notas do ano: "
            );

            double[] notas = new double[quantidadeNotas];

            for (int j = 0; j < notas.length; j++) {
                notas[j] = lerNota(
                        scanner, "Digite a nota " + (j + 1) + ": "
                );
            }

            alunos[i] = new Aluno(nome, notas);
        }

        System.out.println("\n=== RESUMO DOS ALUNOS ===");

        for (Aluno aluno : alunos) {
            System.out.println("\nAluno: " + aluno.getNome());
            System.out.print("Notas: ");

            double[] notas = aluno.getNotas();

            for (int i = 0; i < notas.length; i++) {
                System.out.printf("%.2f", notas[i]);

                if (i < notas.length - 1) {
                    System.out.print(" | ");
                }
            }

            System.out.printf(
                    "%nMedia final: %.2f%n",
                    aluno.calcularMedia()
            );
        }

        System.out.println(
                "\nTotal de alunos cadastrados: " + alunos.length
        );

        scanner.close();
    }

    private static int lerInteiroPositivo(
            Scanner scanner, String mensagem) {

        while (true) {
            System.out.print(mensagem);

            String entrada = scanner.nextLine().trim();

            try {
                int numero = Integer.parseInt(entrada);

                if (numero > 0) {
                    return numero;
                }
            } catch (NumberFormatException e) {
                // Solicita uma nova entrada.
            }

            System.out.println(
                    "Valor invalido! Digite um inteiro maior que zero."
            );
        }
    }

    private static double lerNota(
            Scanner scanner, String mensagem) {

        while (true) {
            System.out.print(mensagem);

            String entrada = scanner.nextLine()
                    .trim()
                    .replace(',', '.');

            try {
                double nota = Double.parseDouble(entrada);

                if (Double.isFinite(nota) && nota >= 0 && nota <= 10) {
                    return nota;
                }
            } catch (NumberFormatException e) {
                // Solicita uma nova entrada.
            }

            System.out.println(
                    "Nota invalida! Informe um valor entre 0 e 10."
            );
        }
    }
}
