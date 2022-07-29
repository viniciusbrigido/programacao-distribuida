package util;

import business.domain.Resultado;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManipuladorArquivo {

    private static final String ENTRADA = "leitura.txt";
    private static final String SAIDA = "resultado.csv";
    public static final Integer QTD_CELULAS = 4;

    public static List<Integer> getListaNumeros() {
        List<Integer> numeros = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(ENTRADA))) {
            while (true) {
                try {
                    numeros.add(Integer.valueOf(bufferedReader.readLine()));
                } catch (NumberFormatException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numeros;
    }

    public static void gravaResultados(List<Resultado> resultados) throws IOException {
        try (FileWriter fileWriter = new FileWriter(SAIDA)) {
            PrintWriter arquivoGravacao = new PrintWriter(fileWriter);

            resultados.forEach(resultado -> arquivoGravacao.println(resultado.toString()));
        }
    }
}
