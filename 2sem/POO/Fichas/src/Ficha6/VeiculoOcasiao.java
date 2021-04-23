package Fichas.src.Ficha6;

public class VeiculoOcasiao extends Veiculo{
  private boolean promocao;

  public VeiculoOcasiao(){
    super();
    this.promocao=false;
  }


  public VeiculoOcasiao(boolean promocao){
    super();
    this.promocao=promocao;
  }


   @Override
   public double custoRealKM(){
     double custo =  super.custoRealKM();
     if(this.promocao)
       custo = (1-0.25)*custo;
     return custo;
  }

  // fazer clone
}
