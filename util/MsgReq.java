package util;

import java.io.Serializable;

public class MsgReq implements Serializable {
    private double value1;
    private int value2;
    private char escolha;

    public MsgReq(double value1, int value2, char escolha) {
        this.value1 = value1;
        this.value2 = value2;
        this.escolha = escolha;
    }

    public double getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    public char getEscolha() {
        return escolha;
    }
}
