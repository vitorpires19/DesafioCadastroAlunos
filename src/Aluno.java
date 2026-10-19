
import java.util.Arrays;

public class Aluno {

    private String nome;
    private double[] notas;

    public Aluno(String nome, double[] notas) {
        this.setNome(nome);
        this.setNotas(notas);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double[] getNotas() {
        return Arrays.copyOf(notas, notas.length);
    }

    public void setNotas(double[] notas) {
        if (notas == null || notas.length == 0) {
            throw new IllegalArgumentException(
                    "O aluno deve possuir pelo menos uma nota."
            );
        }

        for (double nota : notas) {
            if (!Double.isFinite(nota) || nota < 0 || nota > 10) {
                throw new IllegalArgumentException(
                        "As notas devem estar entre 0 e 10."
                );
            }
        }

        this.notas = Arrays.copyOf(notas, notas.length);
    }

    public double calcularMedia() {
        double soma = 0;

        for (double nota : notas) {
            soma += nota;
        }

        return soma / notas.length;
    }
}
