package Ficha1;

import java.util.Scanner;

/**
 * Main da Ficha1
 *
 * @author Mari
 * @version 0.0
 **/
public class main_Ficha1 {
  /**
   * Invoca o Exercício 1
   */
  private void main_exer1() {
    Scanner scanner = new Scanner(System.in);
    Parte2 parte2 = new Parte2();

    System.out.println("\nExercício 1");
    System.out.println("Converter graus Celsius em graus Farenheit");
    System.out.print("Introduza graus a converter: ");
    Double graus = scanner.nextDouble();
    parte2.celsiusParaFarenheit(graus);
    System.out.println();
  }

  /**
   * Invoca o Exercício 2
   */
  private void main_exer2() {
    Scanner scanner = new Scanner(System.in);
    Parte2 parte2 = new Parte2();

    System.out.println("\nExercício 2");
    System.out.println("Determinar o máximo entre dois números inteiros.");
    System.out.print("Introduza  o primeiro número: ");
    int a = scanner.nextInt();
    System.out.print("Introduza  o segundo número: ");
    int b = scanner.nextInt();
    parte2.maximoNumeros(a, b);
    System.out.println();
  }

  /**
   * Invoca o Exercício 3
   */
  private void main_exer3() {
    Scanner scanner = new Scanner(System.in);
    Parte2 parte2 = new Parte2();

    System.out.println("\nExercício 3");
    System.out.println("Criar descrição de uma conta.");
    System.out.print("Introduza o nome: ");
    String nome = scanner.next();
    System.out.print("Introduza o saldo correspondente: ");
    Double saldo = scanner.nextDouble();
    String result = parte2.criaDescricaoConta(nome, saldo);
    System.out.println(result);
    System.out.println();
  }

  /**
   * Invoca o Exercício 4
   */
  private void main_exer4() {
    Scanner scanner = new Scanner(System.in);
    Parte2 parte2 = new Parte2();

    System.out.println("\nExercício 4");
    System.out.println("Converter euros para libras através de uma taxa de conversão.");
    System.out.print("Introduza o valor a converter: ");
    double valor4 = scanner.nextDouble();
    System.out.print("Introduza a taxa de conversão: ");
    double taxa = scanner.nextDouble();
    parte2.eurosParaLibras(valor4, taxa);
    System.out.println();
  }

  /**
   * Invoca o Exercício 5
   */
  private void main_exer5() {
    Scanner scanner = new Scanner(System.in);
    Parte2 parte2 = new Parte2();

    System.out.println("\nExercício 5");
    System.out.println("Calcular a média de dois números inteiros.");
    parte2.read_media();
    System.out.println();
  }

  /**
   * Invoca o Exercício 6
   */
  private void main_exer6() {
    Scanner scanner = new Scanner(System.in);
    Parte2 parte2 = new Parte2();

    System.out.println("\nExercício 6");
    System.out.println("Fatorial de um número inteiro.");
    System.out.print("Introduza o valor que pretende fatorizar: ");
    int fact = scanner.nextInt();
    parte2.factorial(fact);
    System.out.println();
  }

  /**
   * Invoca o Exercício 7
   */
  private void main_exer7() {
    Scanner scanner = new Scanner(System.in);
    Parte2 parte2 = new Parte2();

    System.out.println("\nExercício 7");
    parte2.tempoGasto();
    System.out.println();
  }

  /**
   * Imprime o Menu da Ficha 1.
   */
  private void print_menu() {
    System.out.println("\nFicha1\nSelecione a opção que prentende efetuar:\n" +
        "0) Todos os exercícios\n" +
        "1) Exercício 1\n" +
        "2) Exercício 2\n" +
        "3) Exercício 3\n" +
        "4) Exercício 4\n" +
        "5) Exercício 5\n" +
        "6) Exercício 6\n" +
        "7) Exercício 7\n" +
        "8) Exit");
    System.out.print("Opção: ");
  }

  /**
   * Main da Ficha1
   */
  public void mainFicha1_Parte2() {
    boolean failed = false;
    int option = 0;
    Scanner scanner = new Scanner(System.in);

    while (!failed) {
      print_menu();
      option = scanner.nextInt();
      System.out.println();
      switch (option) {
        case 0:
          /* Exercício 1 */
          main_exer1();
          /* Exercício 2 */
          main_exer2();
          /* Exercício 3 */
          main_exer3();
          /* Exercício 4 */
          main_exer4();
          /* Exercício 5 */
          main_exer5();
          /* Exercício 6 */
          main_exer6();
          /* Exercício 7 */
          main_exer7();
          break;
        case 1:
          /* Exercício 1 */
          main_exer1();
          break;
        case 2:
          /* Exercício 2 */
          main_exer2();
          break;
        case 3:
          /* Exercício 3 */
          main_exer3();
          break;
        case 4:
          /* Exercício 4 */
          main_exer4();
          break;
        case 5:
          /* Exercício 5 */
          main_exer5();
          break;
        case 6:
          /* Exercício 6 */
          main_exer6();
          break;
        case 7:
          /* Exercício 7 */
          main_exer7();
          break;
        case 8:
          failed = true;
          break;
        default:
          System.out.println("Por favor selecione uma das opções válidas.");
      }
    }
  }
}
