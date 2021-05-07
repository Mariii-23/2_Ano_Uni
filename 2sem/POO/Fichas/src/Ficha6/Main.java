package Fichas.src.Ficha6;

import java.io.IOException;
import java.io.PrintWriter;

public class Main {
  public static void main(String[] args) {
    ReadFile read = new ReadFile();

    Veiculo v1 = new Veiculo("Pagero","Nissa","AA-AA-AA",2020,120,10,null,100,0);
    Veiculo v2 = new Veiculo("ARroz","tarraa","AA-AA-AA",2020,120,10,null,100,0);

    DriveIt viaturas = new DriveIt();
    viaturas.adiciona(v1);
    viaturas.adiciona(v2);

    try{
      read.toCsv("Teste.csv",viaturas.getVeiculos());
      read.guardaEstado("Teste_drive.csv",viaturas);
    }
    catch (IOException e){
      System.out.printf("Algo de errado aconteceu");
    }
  }
}
