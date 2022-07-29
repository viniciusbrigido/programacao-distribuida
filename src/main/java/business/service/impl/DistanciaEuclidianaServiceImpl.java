package business.service.impl;

import business.domain.Posicao;
import business.service.DistanciaEuclidianaService;
import lombok.AllArgsConstructor;
import java.rmi.RemoteException;

@AllArgsConstructor
public class DistanciaEuclidianaServiceImpl implements DistanciaEuclidianaService {

    private int qtdRegistros;
    private int qtdMaquinas;

    @Override
    public Posicao getPosicao(int numMaquina) throws RemoteException {
        int posicaoInicial = (qtdRegistros / qtdMaquinas) * (numMaquina - 1);
        int posicaoFinal = numMaquina == qtdMaquinas ? qtdRegistros : (qtdRegistros / qtdMaquinas) * numMaquina;
        return new Posicao(posicaoInicial, posicaoFinal);
    }
}
