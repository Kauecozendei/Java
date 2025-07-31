import java.util.Scanner;// Importa a classe Scanner para leitura de dados do usuário

public class Calculadora {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);// Cria o objeto Scanner para entrada de dados

            // Pede e armazena a quantidade de alunos
            System.out.println("Digite a quantidade de alunos: ");
            int qtdAluno = Integer.parseInt(input.nextLine());

            // Pede e armazena a quantidade de notas por aluno
            System.out.println("Digite a quantidade de notas por alunos: ");
            int qtdNotas = Integer.parseInt(input.nextLine());


            // Arrays para armazenar nomes e médias dos alunos
            String nomes[] = new String[qtdAluno];
            double medias[] = new double[qtdAluno];

            // Loop para ler o nome e as notas de cada aluno
            for (int i = 0; i < qtdAluno; i++) {
                System.out.println("Digite o nome do aluno " + (i+1));
                nomes[i] = input.nextLine(); // Armazena o nome do aluno atual

                medias[i] = lerNotasAluno(input, nomes[i], qtdNotas);
            }

            exibirBoletim(nomes, medias);
            input.close();
        }

    public static double lerNotasAluno(Scanner input, String nome, int qtdNotas) {
            int somaNotas = 0; // Acumula as notas do aluno atual

            // Loop para ler todas as notas de um aluno
            for (int j = 0; j < qtdNotas; j++){
                int nota;
                while(true){ // Valida a nota até ser entre 0 e 10
                    System.out.println("Digite a " + (j+1) + "ª nota do aluno(a) " + nome + " de 0 a 10:");
                    nota = Integer.parseInt(input.nextLine());
                    if(nota >= 0 && nota <= 10) break; // Sai do while se a nota for válida
                    System.out.println("Digite entre 0 a 10.");
                }
                somaNotas += nota; // Soma a nota válida
            }
            return (double) somaNotas / qtdNotas;
    }

    public static void exibirBoletim(String[] nomes, double[] medias) {
        System.out.println("\n================= BOLETIM FINAL =================");
        for (int g=0; g < nomes.length; g++){
            String status = medias[g] >= 6 ? "Aprovado" : "Reprovado";
            System.out.printf("Aluno: %-15s Média: %.2f - %s%n", nomes[g], medias[g] , status);
        }
        System.out.println("=================================================");

    }
}

