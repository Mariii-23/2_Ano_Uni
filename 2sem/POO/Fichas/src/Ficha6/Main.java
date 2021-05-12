package Fichas.src.Ficha6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

  //  ReadFile read = new ReadFile();

    Veiculo v1 = new VeiculoPremium ("Pagero","Nissa","AA-AA-AA",2020,120,10,null,100,0,100);
    Veiculo v2 = new VeiculoOcasiao("ARroz","tarraa","AB-AB-AB",2020,120,10,null,100,0,false);
    Veiculo v3 = new VeiculoOcasiao("ARroz","tarraa","2B-AB-AB",2020,120,10,null,100,0,false);

    DriveIt viaturas = new DriveIt();
    viaturas.adiciona(v1);
    viaturas.adiciona(v2);
    viaturas.adiciona(v3);

    Controller controller = new Controller(viaturas);
    View view = new View(controller);

    view.run();
  //  List<Veiculo> ola = new ArrayList<>();
  //  ola.add(v1);
  //  ola.add(v2);

  //  try{
  //    ReadFile.toCsv("Fichas/src/Ficha6/Teste.csv",viaturas.getVeiculos());
  //    ReadFile.toCsv("Fichas/src/Ficha6/Teste1.csv",ola);
  //    System.out.println("Supostamente deu\n");
  //    //read.guardaEstado("Teste_drive.csv",viaturas);
  //  }
  //  catch (IOException e){
  //    System.out.printf("Algo de errado aconteceu");
  //  }
  }
}
