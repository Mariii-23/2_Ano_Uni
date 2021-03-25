package Ficha4;

import java.time.LocalDate;
import java.util.ArrayList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class jess {

  private String nome;
  private String morada;
  private int num_fiscal;
  private LocalDate data;
  private ArrayList<LinhaEncomenda> lista;

  public jess(String nome, String morada,
              int num_fiscal, LocalDate data,
              ArrayList<LinhaEncomenda> lista) {
    this.nome = nome;
    this.morada = morada;
    this.num_fiscal = num_fiscal;
    this.data = data;
    this.lista = lista;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getMorada() {
    return morada;
  }

  public void setMorada(String morada) {
    this.morada = morada;
  }

  public int getNum_fiscal() {
    return num_fiscal;
  }

  public void setNum_fiscal(int num_fiscal) {
    this.num_fiscal = num_fiscal;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public ArrayList<LinhaEncomenda> getLista() {
    return lista;
  }

  public void setLista(ArrayList<LinhaEncomenda> lista) {
    this.lista = lista;
  }

  @Override
  public String toString() {
    return "jess{" +
        "nome='" + nome + '\'' +
        ", morada='" + morada + '\'' +
        ", num_fiscal=" + num_fiscal +
        ", data=" + data +
        ", lista=" + lista +
        '}';
  }

  public double calculaValorTotal(){
    double count = 0;
    for(LinhaEncomenda enc: lista){
      count = count + enc.calculaValorLinhaEnc();
    }
    return count;
    //return this.lista.stream().mapToDouble(LinhaEncomenda::calculaValorLinhaEnc).sum();
  }

  public double calculaDesconto(){
    double count = 0;
    for(LinhaEncomenda enc: lista){
      count = count + enc.calculaValorDesconto();
    }
    return count;
    //return this.lista.stream().mapToDouble(LinhaEncomenda::calculaValorLinhaEnc).sum();
  }

  public int numeroTotalProdutos(){
    int count = 0;
    for(LinhaEncomenda enc: lista){
      count = count + enc.getQuantidade();
    }
    return count;
  }

  public boolean exist(String refProduto){
    for(LinhaEncomenda enc: lista){
      if(enc.getReferencia().equals(refProduto)){
        return true;
      }
    }
    return false;

    //return lista.stream().anyMatch(L -> L.getReferencia().equals(refProduto));
  }

  public void adicionaLinha(LinhaEncomenda linha) {
    this.lista.add(linha);
  }

  public void removeProduto(String codProd) {
    lista.removeIf(L -> L.getReferencia().equals(codProd));
  }
}
