package Ficha4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EncEficiente {
  private String nome;
  private String morada;
  private int num_fiscal;
  private LocalDate data;
  //private List<LinhaEncomenda> lista;
  private ArrayList<LinhaEncomenda> lista;

  public EncEficiente(String nome, String morada, int num_fiscal, LocalDate data, LinhaEncomenda encomenda) {
    this.nome = nome;
    this.morada = morada;
    this.num_fiscal = num_fiscal;
    this.data = data;
    this.lista = new ArrayList<>();
    lista.add(encomenda.clone());
  }

  public EncEficiente(String nome, String morada, int num_fiscal, LocalDate data, List<LinhaEncomenda> lista) {
    this.nome = nome;
    this.morada = morada;
    this.num_fiscal = num_fiscal;
    this.data = data;
    this.lista = lista.stream()
        .map(LinhaEncomenda::clone)
        //.collect(Collectors.toList());
        .collect(Collectors.toCollection(ArrayList::new));
  }

  public EncEficiente(EncEficiente that) {
    this.nome = that.nome;
    this.morada = that.morada;
    this.num_fiscal = that.num_fiscal;
    this.data = that.data;
    this.lista = that.lista.stream()
        .map(LinhaEncomenda::clone)
        //.collect(Collectors.toList());
        .collect(Collectors.toCollection(ArrayList::new));
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

  public int getNumFiscal() {
    return num_fiscal;
  }

  public void setNumFiscal(int num_fiscal) {
    this.num_fiscal = num_fiscal;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public ArrayList<LinhaEncomenda> getLista() {
    return this.lista.stream()
        .map(LinhaEncomenda::clone)
        //.collect(Collectors.toList());
        .collect(Collectors.toCollection(ArrayList::new));
  }

  public void setLista(ArrayList<LinhaEncomenda> lista) {
    this.lista = lista.stream()
        .map(LinhaEncomenda::clone)
        //.collect(Collectors.toList());
        .collect(Collectors.toCollection(ArrayList::new));
  }

  public double calculaValorTotal() {
    return this.lista.stream()
        .mapToDouble(LinhaEncomenda::calculaValorLinhaEnc)
        .sum();
  }

  public double calculaValorDesconto() {
    return this.lista.stream()
        .mapToDouble(LinhaEncomenda::calculaValorDesconto)
        .sum();
  }

  public int numeroTotalProdutos() {
    return this.lista.stream()
        .mapToInt(LinhaEncomenda::getQuantidade)
        .sum();
  }

  public boolean existeProdutoEncomenda(String refProduto) {
    return this.lista.stream()
        .anyMatch(L -> L.getReferencia().equals(refProduto));

  }

  public void adicionaLinha(LinhaEncomenda linha) {
    this.lista.add(linha.clone());
  }

  public void removeProduto(String codProd) {
    this.lista
        .removeIf(L -> L.getReferencia().equals(codProd));
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("EncEficiente");
    s.append("\nnome\t->\t");
    s.append(nome);
    s.append("\nmorada\t->\t");
    s.append(morada);
    s.append("\nnum_fiscal\t->\t");
    s.append(num_fiscal);
    s.append("\ndata\t->\t");
    s.append(data);
    s.append("\nlista\t->\n");
    for (LinhaEncomenda e : lista) {
      s.append("\t-----------------------------------------------------------\n");
      s.append(e.toString());
      s.append("\t-----------------------------------------------------------\n");
    }
    return s.toString();
  }

  public EncEficiente clone() {
    return new EncEficiente(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || (o.getClass() != this.getClass())) return false;
    EncEficiente that = (EncEficiente) o;
    return
        this.num_fiscal == that.getNumFiscal() &&
            this.nome.equals(that.getNome()) &&
            this.morada.equals(that.getMorada()) &&
            this.data.equals(that.getData()) &&
            this.lista.equals(that.getLista());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getNome(), getMorada(), getNumFiscal(), getData(), getLista());
  }
}
