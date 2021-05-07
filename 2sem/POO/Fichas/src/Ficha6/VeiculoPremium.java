package Fichas.src.Ficha6;

import java.util.ArrayList;

public class VeiculoPremium  extends Veiculo{


  public VeiculoPremium() {
    super();
  }

  public VeiculoPremium(String marca, String modelo, String matricula, int ano, double velociademedia, double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo) {
    super(marca, modelo, matricula, ano, velociademedia, precokm, classificacao, kms, kmsUltimo);
  }

  public VeiculoPremium(Veiculo v) {
    super(v);
  }

}
