import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Mega-Seninha - Atividade 1 (Paradigmas de Linguagens de Programacao - FNR)
 * Equipe: Pedro Nascimento e Yago Barbosa
 */
public class MegaSeninha {

    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(new FileReader("APOSTAS.TXT"));
        FileWriter saida = new FileWriter("GANHADORES.TXT");

        int[] sorteados = lerNumeros(entrada.readLine());

        String cpf = entrada.readLine();
        while (cpf != null) {
            int[] aposta = lerNumeros(entrada.readLine());
            if (acertouTodos(sorteados, aposta)) {
                saida.write(formatarCpf(cpf) + "\n");
            }
            cpf = entrada.readLine();
        }

        entrada.close();
        saida.close();
    }

    // Converte "14 23 53 56 57 60" em um vetor com os 6 numeros
    public static int[] lerNumeros(String linha) {
        String[] partes = linha.split(" ");
        int[] numeros = new int[6];
        for (int i = 0; i < 6; i++) {
            numeros[i] = Integer.parseInt(partes[i]);
        }
        return numeros;
    }

    // Conta quantos numeros da aposta estao entre os sorteados
    public static boolean acertouTodos(int[] sorteados, int[] aposta) {
        int acertos = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (aposta[i] == sorteados[j]) {
                    acertos++;
                }
            }
        }
        return acertos == 6;
    }

    // Transforma "12345678909" em "123.456.789-09"
    public static String formatarCpf(String cpf) {
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "."
                + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }
}
