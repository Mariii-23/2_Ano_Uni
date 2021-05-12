package Fichas.src.Ficha6;

import java.util.ArrayList;

public class VeiculoOcasiao extends Veiculo{
  private boolean promocao;

  public VeiculoOcasiao(String marca, String modelo, String matricula, int ano, double velociademedia,
                        double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo){
    super(marca, modelo, matricula, ano, velociademedia, precokm, classificacao, kms, kmsUltimo);
    this.promocao=false;
  }

  public VeiculoOcasiao(String marca, String modelo, String matricula, int ano, double velociademedia,
                        double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo,boolean promocao){
    super(marca, modelo, matricula, ano, velociademedia, precokm, classificacao, kms, kmsUltimo);
    this.promocao=promocao;
  }

  public VeiculoOcasiao(VeiculoOcasiao that){
    super(that.getMarca(), that.getModelo(), that.getMatricula(), that.getAno(), that.getVelociademedia(),
        that.getPrecokm(), that.getClassificacao(), that.getKms(), that.getKmsUltimo());
    this.promocao= that.promocao;
  }

  public boolean isPromocao() {
    return promocao;
  }

  public void setPromocao(boolean promocao) {
    this.promocao = promocao;
  }

  @Override
   public double custoRealKM(){
     double custo =  super.custoRealKM();
     if(this.promocao)
       custo = (1-0.25)*custo;
     return custo;
  }

  public VeiculoOcasiao clone(){
    return new VeiculoOcasiao(this);
  }

  @Override
  public String toString() {
    return "VeiculoOcasiao{" +
        "promocao=" + promocao +
        '}';
  }
}
