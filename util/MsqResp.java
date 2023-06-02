package util;

import java.io.Serializable;

public class MsqResp implements Serializable {
    

    private String resultado;


    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }
}