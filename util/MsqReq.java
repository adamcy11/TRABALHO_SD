package util;

import java.io.Serializable;

public class MsqReq implements Serializable {
   
 private String verRegra, nome1, aposta, numero;
 private char operacao;


public String getVerRegra() {
  return verRegra;
}

public String getNome1() {
  return nome1;
}

public String getAposta() {
  return aposta;
}

public String getNumero() {
  return numero;

  }

public char getOperacao() {
  return operacao;

  }
}
  