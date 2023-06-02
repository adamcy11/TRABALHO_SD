package util;

public class Status {
    private int vitorias;
    private int derrotas;

    public Status(int vitorias, int derrotas) {
        this.vitorias = vitorias;
        this.derrotas = derrotas;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }
}
