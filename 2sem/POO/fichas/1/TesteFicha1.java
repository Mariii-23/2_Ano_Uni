package Ficha1;
import java.util.Scanner;

public class TesteFicha1 {
  private static Scanner ins;
  private static Ficha1 f1;

  public static void main(String[] args) {
    f1 = new Ficha1();
    Scanner ins = new Scanner(System.in);
    ins = new Scanner(System.in);

    exer1();
    ins.close();
  }

  private static void exer1() {
    System.out.println("Temperatura em graus Celsius: ");
    double tempC = ins.nextDouble();
    double tempF = f1.celsiusParaFarnheit(tempC);
    System.out.println("Temperatura em Farnheit: " + tempF);
  }
}
