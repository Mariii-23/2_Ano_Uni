package Fichas.src.Ficha6;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class DriveIt implements Serializable {
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

  public int quantosT(String marca){
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
      this.list.put(elem.getMatricula(),elem.clone());
    }
  }

  public List<Veiculo> veiculosOrdenadosCusto(){
    List<Veiculo> newlist = getVeiculos();
    Collections.sort(newlist, (e1,e2)->((int)(e2.custoRealKM()-e1.custoRealKM())) );
    return newlist;
  }

  public Veiculo veiculoMaisBarato(){
    List<Veiculo> newlist = getVeiculos();
    if(newlist.isEmpty())
      return null;
    return newlist.get(0);
  }

  public Veiculo veiculoMenosUtilizado(){
    List<Veiculo> newlist = getVeiculos();
    Collections.sort(newlist, (e1,e2)-> (e2.getKms()-e1.getKms()) );
    return newlist.isEmpty() ? null : newlist.get(0);
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

  public void registarAluguer(String codVeiculo, int numKms){
   this.list.get(codVeiculo).addViagem(numKms);
  }

  public void alteraPromocao(boolean estado){
    this.list.values().stream().filter(e -> e.getClass() == VeiculoOcasiao.class).forEach(e -> ((VeiculoOcasiao) e).setPromocao(estado));
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

  @Override
  public String toString() {
    return "DriveIt{" +
        "list=" + list +
        '}';
  }
}