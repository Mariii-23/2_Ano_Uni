package Fichas.src.Ficha6;

import java.util.ArrayList;

public class VeiculoPremium extends Veiculo {
  private double taxaDeLuxo;

  public VeiculoPremium(String marca, String modelo, String matricula, int ano, double velociademedia, double precokm,
                        ArrayList<Integer> classificacao, int kms, int kmsUltimo, double taxaDeLuxo) {
    super(marca, modelo, matricula, ano, velociademedia, precokm, classificacao, kms, kmsUltimo);
    this.taxaDeLuxo = taxaDeLuxo;
  }

  public VeiculoPremium(VeiculoPremium that){
    super(that.getMarca(), that.getModelo(), that.getMatricula(), that.getAno(), that.getVelociademedia(),
        that.getPrecokm(), that.getClassificacao(), that.getKms(), that.getKmsUltimo());
    this.taxaDeLuxo=that.taxaDeLuxo;
  }


  public VeiculoPremium(Veiculo v) {
    super(v);
  }

  public double custoRealKM() {
    double custo = super.custoRealKM();
    custo = (1 + taxaDeLuxo % 100) * custo;
    return custo;
  }

  public VeiculoPremium clone(){
    return new VeiculoPremium(this);
  }

  @Override
  public String toString() {
    return "VeiculoPremium{" +
        "taxaDeLuxo=" + taxaDeLuxo +
        '}';
  }
}
