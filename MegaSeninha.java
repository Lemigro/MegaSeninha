//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//
///**
// * Mega-Seninha — Atividade 1 (Paradigmas)
// * Grupo: Pedro Nascimento e Yago Barbosa
// * Professor: Lin Tse-Min
// */
//public class MegaSeninha {
//
//    public static void main(String[] args) {
//        String arquivoEntrada = "APOSTAS.TXT";
//        String arquivoSaida = "GANHADORES.TXT";
//
//        if (args.length >= 1) {
//            arquivoEntrada = args[0];
//        }
//        if (args.length >= 2) {
//            arquivoSaida = args[1];
//        }
//
//        processarApostas(arquivoEntrada, arquivoSaida);
//        System.out.println("Processamento concluido. Ganhadores em: " + arquivoSaida);
//    }
//
//    /**
//     * Procedimento principal: le o arquivo de apostas e grava os ganhadores.
//     */
//    public static void processarApostas(String arquivoEntrada, String arquivoSaida) {
//        try {
//            BufferedReader leitor = new BufferedReader(new FileReader(arquivoEntrada));
//            BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSaida));
//
//            String Sorteio = leitor.readLine();
//            int[] numerosSorteados = converterLinhaEmNumeros(Sorteio);
//
//            String linhaCpf;
//            while ((linhaCpf = leitor.readLine()) != null) {
//                String linhaNumeros = leitor.readLine();
//                int[] numerosAposta = converterLinhaEmNumeros(linhaNumeros);
//
//                if (acertouTodos(numerosSorteados, numerosAposta)) {
//                    String cpfFormatado = formatarCpf(linhaCpf.trim());
//                    escritor.write(cpfFormatado);
//                    escritor.newLine();
//                }
//            }
//
//            leitor.close();
//            escritor.close();
//        } catch (IOException erro) {
//            System.out.println("Erro ao processar arquivos: " + erro.getMessage());
//        }
//    }
//
//    /**
//     * Converte uma linha com numeros separados por espaco em um vetor de int.
//     */
//    public static int[] converterLinhaEmNumeros(String linha) {
//        String[] partes = linha.trim().split(" ");
//        int[] numeros = new int[partes.length];
//
//        for (int i = 0; i < partes.length; i++) {
//            numeros[i] = Integer.parseInt(partes[i]);
//        }
//
//        return numeros;
//    }
//
//    /**
//     * Verifica se a aposta acertou os 6 numeros sorteados.
//     */
//    public static boolean acertouTodos(int[] sorteados, int[] escolhidos) {
//        int acertos = 0;
//
//        for (int i = 0; i < escolhidos.length; i++) {
//            if (contemNumero(sorteados, escolhidos[i])) {
//                acertos = acertos + 1;
//            }
//        }
//
//        return acertos == 6;
//    }
//
//    /**
//     * Verifica se um numero existe no vetor.
//     */
//    public static boolean contemNumero(int[] vetor, int numero) {
//        for (int i = 0; i < vetor.length; i++) {
//            if (vetor[i] == numero) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * Formata CPF de 11 digitos para 123.456.789-10.
//     */
//    public static String formatarCpf(String cpf) {
//        return cpf.substring(0, 3) + "."
//                + cpf.substring(3, 6) + "."
//                + cpf.substring(6, 9) + "-"
//                + cpf.substring(9, 11);
//    }
//}



import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class MegaSeninha {

    public static void main(String[] args) {
        String entrada = args.length > 0 ? args[0] : "APOSTAS.TXT";
        String saida = args.length > 1 ? args[1] : "GANHADORES.TXT";

        processarApostas(entrada, saida);
        System.out.println("Processamento concluido. Ganhadores em: " + saida);
    }

    public static void processarApostas(String entrada, String saida) {
        try (BufferedReader leitor = Files.newBufferedReader(Path.of(entrada));
             BufferedWriter escritor = Files.newBufferedWriter(Path.of(saida))) {

            Set<Integer> sorteados = parseNumeros(leitor.readLine());

            String cpf;
            while ((cpf = leitor.readLine()) != null) {
                Set<Integer> aposta = parseNumeros(leitor.readLine());

                if (aposta.stream().filter(sorteados::contains).count() == 6) {
                    escritor.write(formatarCpf(cpf.trim()));
                    escritor.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao processar arquivos: " + e.getMessage());
        }
    }

    private static Set<Integer> parseNumeros(String linha) {
        return Arrays.stream(linha.trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    private static String formatarCpf(String cpf) {
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }
}
