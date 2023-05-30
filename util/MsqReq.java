package util;

import java.io.Serializable;

public class MsqReq implements Serializable {
   

 private double ValorEscolha;

 public MsqReq(double ValorEscolha){
  this.ValorEscolha = ValorEscolha;

 }

public double getValorEscolha() {
  return ValorEscolha;
}


}

