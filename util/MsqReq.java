package util;

import java.io.Serializable;

public class MsqReq implements Serializable {
   
 private String EscolhaImpOuPar;
 private double value1;
 private Double ValorEscolha;

public MsqReq(String escolhaImpOuPar, double value1, double ValorEscolh) {
  EscolhaImpOuPar = escolhaImpOuPar;
  this.value1 = value1;
  this.ValorEscolha = ValorEscolha;

}



public String getEscolhaImpOuPar() {
  return EscolhaImpOuPar;
}


public double getValue1() {
  return value1;
}


public Double getValorEscolha() {
  return ValorEscolha;
}



}

