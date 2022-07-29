import business.service.DistanciaEuclidianaService;
import business.service.impl.DistanciaEuclidianaServiceImpl;
import util.ManipuladorArquivo;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public static void main(String[] args) throws IOException {
        Integer qtdRegistros = ManipuladorArquivo.getListaNumeros().size() - (ManipuladorArquivo.QTD_CELULAS - 1);
        DistanciaEuclidianaService server = new DistanciaEuclidianaServiceImpl(qtdRegistros, 1);
        DistanciaEuclidianaService stub = (DistanciaEuclidianaService) UnicastRemoteObject.exportObject(server, 0);

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("DistanciaEuclidianaService", stub);
    }
}
