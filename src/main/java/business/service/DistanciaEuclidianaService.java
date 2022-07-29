package business.service;

import business.domain.Posicao;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DistanciaEuclidianaService extends Remote {
    Posicao getPosicao(int numMaquina) throws RemoteException;
}
