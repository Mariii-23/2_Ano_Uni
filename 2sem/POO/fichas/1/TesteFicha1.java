package Ficha1;
// import Ficha1.java;
import java.util.Scanner;

public class TesteFicha1 {
  private static Scanner ins;

  // Ficha1 f1 = new Ficha1();

  public static void main(String[] args) {
    Scanner ins = new Scanner(System.in);
    ins = new Scanner(System.in);

    exer1();
    ins.close();
  }

  private static void exer1() {
    System.out.println("Temperatura em graus Celsius: ");
    double tempC = ins.nextDouble();
    Ficha1 f1 = new Ficha1();
    double tempF = f1.celsiusParaFarenheit(tempC);
    System.out.println("Temperatura em Farnheit: " + tempF);
  }
}
