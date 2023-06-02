package util;

import java.io.Serializable;

public class MsgResp implements Serializable {
    private String resultado;
    private String placar;

    public MsgResp(String resultado, String placar) {
        this.resultado = resultado;
        this.placar = placar;
    }

    public String getResultado() {
        return resultado;
    }

    public String getPlacar() {
        return placar;
    }
}
