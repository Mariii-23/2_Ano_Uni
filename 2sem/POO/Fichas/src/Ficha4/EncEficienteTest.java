package Ficha4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EncEficienteTest {
  Random random = new Random();

  final int valorString = 1000;
  final int VALOR = 100;
  final int ValorMaxQuantidade = 100;
  final int ValorDesconto= 100;
  final int ValorImposto= 23;

  final String nome1 =String.valueOf(random.nextInt(valorString));
  final String nome2 = String.valueOf(random.nextInt(valorString));

  final String referencia1 = String.valueOf(random.nextInt(valorString));
  final String referencia2 = String.valueOf(random.nextInt(valorString));

  final String morada1 = String.valueOf(random.nextInt(valorString));
  final String morada2 =String.valueOf(random.nextInt(valorString));

  final String descricao1 = String.valueOf(random.nextInt(valorString));
  final String descricao2 = String.valueOf(random.nextInt(valorString));

  final LocalDate data1 = LocalDate.now();
  final LocalDate data2 = LocalDate.of(2020, 10, 5);

  final int preco1 = random.nextInt(VALOR);
  final int preco2 = random.nextInt(VALOR);

  final int quantidade1 = random.nextInt(ValorMaxQuantidade);
  final int quantidade2 = random.nextInt(ValorMaxQuantidade);

  final int imposto1 = random.nextInt(ValorImposto);
  final int imposto2 = random.nextInt(ValorImposto);

  final int desconto1 = random.nextInt(ValorDesconto);
  final int desconto2 = random.nextInt(ValorDesconto);

  final int numFiscal1 = random.nextInt(VALOR);
  final int numFiscal2 = random.nextInt(VALOR);

  @Test
  void getNome() {
    LinhaEncomenda e1 = new LinhaEncomenda(referencia1, descricao1, preco1, quantidade1, imposto1, desconto1);
    EncEficiente enc1 = new EncEficiente(nome1, morada1, numFiscal1, data1, e1);
    assertEquals(nome1, enc1.getNome());
  }

  @Test
  void setNome() {
    LinhaEncomenda e1 = new LinhaEncomenda(referencia1, descricao1, preco1, quantidade1, imposto1, desconto1);
    EncEficiente enc1 = new EncEficiente(nome1, morada1, numFiscal1, data1, e1);
    enc1.setNome(nome2);
    assertEquals(nome2, enc1.getNome());
  }

  @Test
  void getMorada() {
    LinhaEncomenda e1 = new LinhaEncomenda(referencia1, descricao1, preco1, quantidade1, imposto1, desconto1);
    EncEficiente enc1 = new EncEficiente(nome1, morada1, numFiscal1, data1, e1);
    assertEquals(morada1, enc1.getMorada());
  }

  @Test
  void setMorada() {
    LinhaEncomenda e1 = new LinhaEncomenda(referencia1, descricao1, preco1, quantidade1, imposto1, desconto1);
    EncEficiente enc1 = new EncEficiente(nome1, morada1, numFiscal1, data1, e1);
    enc1.setMorada(morada2);
    assertEquals(morada2, enc1.getMorada());
  }

  @Test
  void getNum_fiscal() {
    LinhaEncomenda e1 = new LinhaEncomenda(referencia1, descricao1, preco1, quantidade1, imposto1, desconto1);
    EncEficiente enc1 = new EncEficiente(nome1, morada1, numFiscal1, data1, e1);
    assertEquals(numFiscal1, enc1.getNumFiscal());
  }

  @Test
  void setNum_fiscal() {
    LinhaEncomenda e1 = new LinhaEncomenda(referencia1, descricao1, preco1, quantidade1, imposto1, desconto1);
    EncEficiente enc1 = new EncEficiente(nome1, morada1, numFiscal1, data1, e1);
    enc1.setNumFiscal(numFiscal2);
    assertEquals(numFiscal2, enc1.getNumFiscal());
  }

  @Test
  void getData() {
    LinhaEncomenda e1 = new LinhaEncomenda(referencia1, descricao1, preco1, quantidade1, imposto1, desconto1);
    EncEficiente enc1 = new EncEficiente(nome1, morada1, numFiscal1, data1, e1);
    assertEquals(data1, enc1.getData());
  }

  @Test
  void setData() {
    LinhaEncomenda e1 = new LinhaEncomenda(referencia1, descricao1, preco1, quantidade1, imposto1, desconto1);
    EncEficiente enc1 = new EncEficiente(nome1, morada1, numFiscal1, data1, e1);
    enc1.setData(data2);
    assertEquals(data2, enc1.getData());
  }

  @Test
  void getLista() {
    LinhaEncomenda e1 = new LinhaEncomenda(referencia1, descricao1, preco1, quantidade1, imposto1, desconto1);
    EncEficiente enc1 = new EncEficiente(nome1, morada1, numFiscal1, data1, e1);

    ArrayList<LinhaEncomenda> lista = new ArrayList<>();
    lista.add(e1);

    assertEquals(true, enc1.getLista().equals(lista));
  }

  @Test
  void setLista() {
    LinhaEncomenda e1 = new LinhaEncomenda(referencia1, descricao1, preco1, quantidade1, imposto1, desconto1);
    LinhaEncomenda e2 = new LinhaEncomenda(referencia2, descricao2, preco2, quantidade2, imposto2, desconto2);
    EncEficiente enc1 = new EncEficiente(nome1, morada1, numFiscal1, data1, e1);

    ArrayList<LinhaEncomenda> lista = new ArrayList<>();
    int N = random.nextInt(10);
    for (int i = 1; i < N; i++) {
      lista.add(new LinhaEncomenda(referencia1, descricao1, preco1*i, quantidade1*i,
          imposto1*i, desconto1*i));
    }
    enc1.setLista(lista);

    assertEquals(true, enc1.getLista().equals(lista));
  }

  @Test
  void calculaValorTotal() {
    int N = random.nextInt(10);
    int[] array = new int[N];
    int count = 0;

    for (int i = 0; i < N; i++) {
      int num = random.nextInt(10);
      double valor = quantidade1 * num;
      valor -= valor * desconto1;
      valor *= 1 + imposto1;
      count += valor;
      array[i] = num;
    }

    LinhaEncomenda e1 = new LinhaEncomenda(referencia1, descricao1, array[0], quantidade1, imposto1, desconto1);
    EncEficiente enc1 = new EncEficiente(nome1, morada1, numFiscal1, data1, e1);

    for (int i = 1; i < N; i++) {
      enc1.adicionaLinha(new LinhaEncomenda(referencia1, descricao1, array[i], quantidade1, imposto1, desconto1));
    }

    assertEquals(count, enc1.calculaValorTotal());
  }

  @Test
  void calculaValorDesconto() {
    int N = random.nextInt(10);
    int[] array = new int[N];
    int count = 0;
    double valor = quantidade1 * preco1;
    valor *= imposto1;

    for (int i = 0; i < N; i++) {
      int num = random.nextInt(10);

      double valorLinha = quantidade1 * preco1;
      valorLinha -= valorLinha * num;
      valorLinha *= 1 + imposto1;

      count += valorLinha - valor;
      array[i] = num;
    }

    LinhaEncomenda e1 = new LinhaEncomenda(referencia1, descricao1, preco1, quantidade1, imposto1, array[0]);
    EncEficiente enc1 = new EncEficiente(nome1, morada1, numFiscal1, data1, e1);

    for (int i = 1; i < N; i++) {
      enc1.adicionaLinha(new LinhaEncomenda(referencia1, descricao1, preco1, quantidade1, imposto1, array[i]));
    }

    assertEquals(count, enc1.calculaValorDesconto());
  }

  @Test
  void numeroTotalProdutos() {

    int N = random.nextInt(10);
    int[] array = new int[N];
    int count = 0;

    for (int i = 0; i < N; i++) {
      int num = random.nextInt(10);
      count += num;
      array[i] = num;
    }

    LinhaEncomenda e1 = new LinhaEncomenda(referencia1, descricao1,preco1, array[0], imposto1, desconto1);
    EncEficiente enc1 = new EncEficiente(nome1, morada1, numFiscal1, data1, e1);

    for (int i = 1; i < N; i++) {
      enc1.adicionaLinha(new LinhaEncomenda(referencia1, descricao1, preco1, array[i], imposto1, desconto1));
    }

    assertEquals(count, enc1.numeroTotalProdutos());
  }

  @Test
  void existeProdutoEncomenda() {
    String phrase = random.toString();

    LinhaEncomenda e1 = new LinhaEncomenda(referencia1, descricao1, preco1, quantidade1, imposto1, desconto1);
    LinhaEncomenda e2 = new LinhaEncomenda(referencia2, descricao2, preco2, quantidade2, imposto2, desconto2);
    LinhaEncomenda e3 = new LinhaEncomenda(phrase, descricao2, preco1, quantidade2, imposto1, desconto2);
    LinhaEncomenda e4 = new LinhaEncomenda(referencia2, descricao1, preco2, quantidade1, imposto2, desconto1);

    ArrayList<LinhaEncomenda> lista = new ArrayList<LinhaEncomenda>();
    lista.add(e1);
    lista.add(e3);
    lista.add(e2);
    lista.add(e4);

    EncEficiente enc1 = new EncEficiente(nome1, morada1, numFiscal1, data1, lista);
    assertEquals(true, enc1.existeProdutoEncomenda(phrase));
  }

  @Test
  void adicionaLinha() {
    LinhaEncomenda e1 = new LinhaEncomenda(referencia1, descricao1, preco1, quantidade1, imposto1, desconto1);
    LinhaEncomenda e2 = new LinhaEncomenda(referencia2, descricao2, preco2, quantidade2, imposto2, desconto2);
    EncEficiente enc1 = new EncEficiente(nome1, morada1, numFiscal1, data1, e1);

    ArrayList<LinhaEncomenda> lista = new ArrayList<>();
    lista.add(e1);
    lista.add(e2);

    enc1.adicionaLinha(e2);

    assertEquals(true, enc1.getLista().equals(lista));
  }

  @Test
  void removeProduto() {

    LinhaEncomenda e1 = new LinhaEncomenda(referencia1, descricao1, preco1, quantidade1, imposto1, desconto1);
    LinhaEncomenda e2 = new LinhaEncomenda(referencia2, descricao2, preco2, quantidade2, imposto2, desconto2);

    EncEficiente enc2 = new EncEficiente(nome2, morada2, numFiscal2, data2, e2);
    EncEficiente res = new EncEficiente(nome2, morada2, numFiscal2, data2, e2);
    enc2.adicionaLinha(e1);
    enc2.removeProduto(e1.getReferencia());

    assertEquals(true, enc2.equals(res));
  }
}