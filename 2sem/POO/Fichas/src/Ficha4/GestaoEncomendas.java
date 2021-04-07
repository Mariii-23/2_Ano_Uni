package Fichas.src.Ficha4;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class GestaoEncomendas {

  private Map<Integer, EncEficiente> encomendas;

  public GestaoEncomendas() {
    this.encomendas = new TreeMap<>();
  }

  public GestaoEncomendas(Map<Integer, EncEficiente> encomendas) {
    this.encomendas = new TreeMap<>();

    for (EncEficiente enc : encomendas.values())
      this.encomendas.put(enc.getNumFiscal(), enc.clone());
  }

  public GestaoEncomendas(GestaoEncomendas e) {
    this.encomendas = new TreeMap<>();
    for (Map.Entry<Integer, EncEficiente> enc : e.getEncomendas().entrySet()) {
      encomendas.put(enc.getKey(), enc.getValue().clone());
    }
  }

  public Map<Integer, EncEficiente> getEncomendas() {
    return encomendas
        .values()
        .stream()
        .collect(Collectors.toMap(EncEficiente::getNumFiscal, e -> e.clone()));
  }

  public void setEncomendas(Map<Integer, EncEficiente> encomendas) {
    this.encomendas = new TreeMap<>();

    for (EncEficiente enc : encomendas.values())
      this.encomendas.put(enc.getNumFiscal(), enc.clone());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || this.getClass() != o.getClass()) return false;
    GestaoEncomendas that = (GestaoEncomendas) o;
    return this.encomendas.equals(that.encomendas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(encomendas);
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return new GestaoEncomendas(this);
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("GestaoEncomendas: ");
    for (EncEficiente e : encomendas.values()) {
      s.append("-----------------------\n");
      s.append(e.toString());
      s.append("-----------------------\n");
    }
    return s.toString();
  }

  public Set<Integer> todosCodigos() {
    Set<Integer> chaves = encomendas.keySet();
    return new TreeSet<Integer>(chaves);
  }

  public void addEncomenda(EncEficiente enc) {
    encomendas.put(enc.getNumFiscal(), enc.clone());
  }

  public EncEficiente getEncomeda(int codEnc) {
    Boolean encontrou = encomendas.containsKey(codEnc);
    if (encontrou)
      return encomendas.get(codEnc).clone();
    else return null;
    //ou
    /*
     * EncEficiente r = encomendas.get(codEnc);
     * if(r!=null) r=r.clone();
     * return r;
     * */
  }

  public void removeEncomenda(int cod) {
    encomendas.remove(cod);
  }

  public int encomendaComMaisProdutos() {
    Comparator<EncEficiente> comparator = (e1, e2) -> e1.numeroTotalProdutos() - e2.numeroTotalProdutos();
    TreeSet<EncEficiente> ordena = new TreeSet<EncEficiente>(comparator);

    for (EncEficiente e : this.encomendas.values())
      ordena.add(e); //clone é desnecessario

    int r = -1;
    if (ordena != null) r = ordena.last().getNumFiscal();
    return r;
  }

  public Set<Integer> encomendasComProduto(String cod) {
    return this.encomendas
        .values()
        .stream()
        .filter(e -> e.existeProdutoEncomenda(cod))
        //.map(e->e.getNumFiscal())
        .map(EncEficiente::getNumFiscal)
        //.collect(Collectors.toSet());
        .collect(Collectors.toCollection(TreeSet::new));
  }

  public Set<Integer> encomendasAposData(LocalDate date) {
    return this.encomendas
        .values()
        .stream()
        .filter(e -> e.getData().isAfter(date))
        //.map(e->e.getNumFiscal())
        .map(EncEficiente::getNumFiscal)
        //.collect(Collectors.toSet());
        .collect(Collectors.toCollection(TreeSet::new));
  }

  public Set<EncEficiente> encomendasVaorDecrescente(){
    Comparator<EncEficiente> comparator = (e1,e2) -> (int) (100 * (e2.calculaValorTotal() - e1.calculaValorTotal()));
    TreeSet<EncEficiente> ordena = new TreeSet<EncEficiente>(comparator);

    for (EncEficiente e : this.encomendas.values())
      ordena.add(e); //clone é desnecessario

    return ordena;
  }
}



