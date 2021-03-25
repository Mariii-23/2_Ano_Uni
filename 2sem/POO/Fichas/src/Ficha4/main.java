package Ficha4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class main {
  public static void main(String[] args) {
    Random random = new Random();
    final int valorString = 1000;
    final int VALOR = 10;
    final int ValorMaxQuantidade = 100;
    final int N = random.nextInt(20);

    final String nome1 = String.valueOf(random.nextInt(valorString));
    final String nome2 = String.valueOf(random.nextInt(valorString));

    final String referencia1 = String.valueOf(random.nextInt(valorString));
    final String referencia2 = String.valueOf(random.nextInt(valorString));

    final String morada1 = String.valueOf(random.nextInt(valorString));
    final String morada2 = String.valueOf(random.nextInt(valorString));

    final String descricao1 = String.valueOf(random.nextInt(valorString));
    final String descricao2 = String.valueOf(random.nextInt(valorString));

    final LocalDate data1 = LocalDate.now();
    final LocalDate data2 = LocalDate.of(2020, 10, 5);

    final int preco1 = random.nextInt(VALOR);
    final int preco2 = random.nextInt(VALOR);

    final int quantidade1 = random.nextInt(ValorMaxQuantidade);
    final int quantidade2 = random.nextInt(ValorMaxQuantidade);

    final double imposto1 = Math.random() * 100 % 1;
    final double imposto2 = Math.random() * 100 % 1;

    final double desconto1 = Math.random() * 100 % 1;
    final double desconto2 = Math.random() * 100 % 1;

    final int numFiscal1 = random.nextInt(VALOR);
    final int numFiscal2 = random.nextInt(VALOR);


    /* Criar EncEficiente */

    LinhaEncomenda e0 = new LinhaEncomenda(referencia1, descricao1, preco1, quantidade1, imposto1, desconto1);
    EncEficiente enc0 = new EncEficiente(nome1, morada1, numFiscal1, data1, e0);

    ArrayList<LinhaEncomenda> lista = new ArrayList<>();
    for (int i = 0; i < N - 1; i++) {
      lista.add(new LinhaEncomenda(String.valueOf(random.nextInt(valorString)),
          String.valueOf(random.nextInt(valorString)),
          random.nextInt(VALOR), random.nextInt(VALOR),
          Math.random() * 23 % 1, Math.random() * 50 % 1));
    }
    lista.add(e0);
    enc0.setLista(lista);

    System.out.println("Iremos criar um EncEficiente com " + N + " LinhasEncomenda\n");
    System.out.println(enc0.toString());

    System.out.println("O número total de produtos é de " + enc0.numeroTotalProdutos() + "\n");
    System.out.println("O valor total da encomenda é de " + enc0.calculaValorTotal() + "\n");
    System.out.println("O valor total dos descontos é de " + enc0.calculaValorDesconto() + "\n");
    System.out.println("Vamos verificar se existe a LinhaEcomenda: "
        + String.valueOf(enc0.existeProdutoEncomenda(e0.getReferencia()))
        + "\n" + e0.toString() + "\n");

    /* Remover e adicionar */

    LinhaEncomenda e1 = new LinhaEncomenda(referencia1, descricao1, preco1, quantidade1, imposto1, desconto1);
    LinhaEncomenda e2 = new LinhaEncomenda(referencia2, descricao2, preco2, quantidade2, imposto2, desconto2);

    EncEficiente enc1 = new EncEficiente(nome1, morada1, numFiscal1, data1, e1);
    EncEficiente enc2 = new EncEficiente(nome2, morada2, numFiscal2, data2, e2);
    enc2.adicionaLinha(e1);

    System.out.println("1º Encomenda -> Random");
    System.out.println(enc1.toString());

    System.out.println("2º Encomenda -> Random");
    System.out.println(enc2.toString());

    enc2.removeProduto(e1.getReferencia());
    System.out.println("Vamos eliminar o 1 elemento da 2º Encomenda:\n");
    System.out.println(enc2.toString());
  }
}
