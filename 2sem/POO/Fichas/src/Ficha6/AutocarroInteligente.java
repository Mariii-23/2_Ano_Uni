package Fichas.src.Ficha6;

import java.util.ArrayList;

public class AutocarroInteligente extends Veiculo {
  private int num_lugares;
  private int num_ocupados;

  public AutocarroInteligente(String marca, String modelo, String matricula, int ano, double velociademedia,
                              double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo,
                              int num_lugares, int num_ocupados) {
    super(marca, modelo, matricula, ano, velociademedia, precokm, classificacao, kms, kmsUltimo);
    this.num_lugares = num_lugares;
    this.num_ocupados = num_ocupados;
  }

  public AutocarroInteligente(String marca, String modelo, String matricula, int ano, double velociademedia,
                              double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo) {
    super(marca, modelo, matricula, ano, velociademedia, precokm, classificacao, kms, kmsUltimo);
    this.num_lugares = 0;
    this.num_ocupados = 0;
  }

  public AutocarroInteligente(String marca, String modelo, String matricula, int ano, double velociademedia,
                              double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo,
                              int num_lugares) {
    super(marca, modelo, matricula, ano, velociademedia, precokm, classificacao, kms, kmsUltimo);
    this.num_lugares = num_lugares;
    this.num_ocupados = 0;
  }

  public AutocarroInteligente(AutocarroInteligente that){
    super(that.getMarca(), that.getModelo(), that.getMatricula(), that.getAno(), that.getVelociademedia(),
        that.getPrecokm(), that.getClassificacao(), that.getKms(), that.getKmsUltimo());
    this.num_ocupados = that.num_ocupados;
    this.num_lugares= that.num_lugares;
  }

  public void add_passageiro() {
    this.num_ocupados++; // atencao q pode n ter lugares ???
  }

  public void sair_passageiro() {
    this.num_ocupados--;
    if (this.num_ocupados<0) this.num_ocupados=0;
  }

  public double custoRealKM() {
    double custo = super.custoRealKM();
    if (this.num_ocupados / this.num_lugares <= 0.6)
      custo = (1 + 0.5) * custo;
    else custo = (1 - 0.75) * custo;
    return custo;
  }

  public AutocarroInteligente clone(){
    return new AutocarroInteligente(this);
  }

  @Override
  public String toString() {
    return "AutocarroInteligente{" +
        "num_lugares=" + num_lugares +
        ", num_ocupados=" + num_ocupados +
        '}';
  }
}
