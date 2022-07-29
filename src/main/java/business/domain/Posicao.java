package business.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.io.Serializable;

@Getter
@AllArgsConstructor
public class Posicao implements Serializable {
    private int posicaoInicial;
    private int posicaoFinal;
}
