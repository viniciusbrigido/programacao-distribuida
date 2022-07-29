package business.domain;

import lombok.AllArgsConstructor;
import java.io.Serializable;

@AllArgsConstructor
public class Resultado implements Serializable {
    private int posicao;
    private double menor;

    @Override
    public String toString() {
        return posicao + "," + menor;
    }
}
