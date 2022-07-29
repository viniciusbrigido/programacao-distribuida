package util;

import business.domain.Resultado;
import java.util.ArrayList;
import java.util.List;

public class DistanciaEuclidiana {

    private static List<Integer> numeros;

    public static List<Resultado> calculaDistancia(int posicaoInicial, int posicaoFinal) {
        numeros = ManipuladorArquivo.getListaNumeros();

        List<Resultado> resultados  = new ArrayList<>();
        for (int i = posicaoInicial; i < posicaoFinal; i++) {
            double menor = Double.MAX_VALUE;
            int posicao = 0;
            for (int j = posicaoInicial; j < posicaoFinal; j++) {
                if (i == j) {
                    continue;
                }

                double raiz = getDistanciaEuclidiana(i, j);
                if (raiz < menor) {
                    menor = raiz;
                    posicao = j;
                }
            }
            resultados.add(new Resultado(posicao + 1, menor));
        }
        return resultados;
    }

    private static double getDistanciaEuclidiana(int i, int j) {
        int somatorio = 0;
        for (int k = 0; k < ManipuladorArquivo.QTD_CELULAS; k++) {
            int aux = numeros.get(i + k) - numeros.get(j + k);
            somatorio += aux * aux;
        }
        return Math.sqrt(somatorio);
    }
}
