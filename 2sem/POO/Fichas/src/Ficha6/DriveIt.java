package Fichas.src.Ficha6;

import java.util.*;
import java.util.stream.Collectors;

public class DriveIt {
  private Map<String,Veiculo> list;

  public DriveIt() {
    this.list = new HashMap<>();
  }
  public DriveIt(Map<String, Veiculo> list) {
    this.list = new HashMap<>();
    for(Map.Entry<String,Veiculo> e : list.entrySet() ){
      list.put(e.getKey(),e.getValue().clone());
    }
  }

  // verificar
  public DriveIt(DriveIt self){
    this.list = new HashMap<>();
    for(Map.Entry<String,Veiculo> e : self.list.entrySet() ){
      list.put(e.getKey(),e.getValue().clone());
    }
  }

  public boolean existeVeiculo(String cod){
    return list.containsKey(cod);
  }

  public int quantos(){
    return list.size();
  }

  public int quantos(String marca){
    //int quantos = 0;
    //for(Map.Entry<String,Veiculo> e : list.entrySet() ){
    //  if(e.getValue().getMarca().equals(marca))
    //    quantos++;
    //}
    //return quantos;
    return (int) this.list.values().stream().filter(elem->elem.getMarca().equals(marca)).count();
  }

  public Veiculo getVeiculo(String cod){
    return this.list.containsKey(cod) ? this.getVeiculo(cod).clone() : null;
  }

  public void adiciona(Veiculo v){
    this.list.put(v.getMatricula(),v.clone());
  }

  public List<Veiculo> getVeiculos(){
    return this.list.values().stream().map(Veiculo::clone).collect(Collectors.toList());
  }

  public void adiciona(Set<Veiculo> vs){
    for( Veiculo elem : vs){
      this.list.put(elem.getMatricula(),elem.clone()); // faltava-te aqui um clone
    }
  }

  public void registarAluguer(String codVeiculo, int numKms){
    if(this.list.containsKey(codVeiculo))
    this.list.get(codVeiculo).addViagem(numKms);
  }

  public void classificarVeiculo(String cod, int classificacao){
    if(this.list.containsKey(cod))
      this.list.get(cod).addClassificacao(classificacao);
  }

  public int custoRealKm(String cod){
    int custo =-1;
    if(this.list.containsKey(cod))
      custo = (int) this.list.get(cod).custoRealKM();
    return custo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DriveIt driveIt = (DriveIt) o;
    return Objects.equals(list, driveIt.list);
  }

  @Override
  public int hashCode() {
    return Objects.hash(list);
  }

  @Override
  public Object clone( ) throws CloneNotSupportedException {
    return new DriveIt(this);
  }
}