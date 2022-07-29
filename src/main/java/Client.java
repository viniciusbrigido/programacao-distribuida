import business.domain.Posicao;
import business.domain.Resultado;
import business.service.DistanciaEuclidianaService;
import util.DistanciaEuclidiana;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import static util.ManipuladorArquivo.*;

public class Client {

    public static void main(String[] args) throws IOException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry();
        DistanciaEuclidianaService server = (DistanciaEuclidianaService) registry.lookup("DistanciaEuclidianaService");
        Posicao posicao = server.getPosicao(1);
        List<Resultado> resultados =  DistanciaEuclidiana.calculaDistancia(posicao.getPosicaoInicial(), posicao.getPosicaoFinal());
        gravaResultados(resultados);
    }
}
