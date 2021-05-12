package Fichas.src.Ficha6;

import java.util.List;
import java.util.Scanner;

public class View {
  private Controller controller;
  private Scanner scanner = new Scanner(System.in);

  public View(Controller controller) {
    this.controller = controller;
  }

  public void run() {
    Menu m = new Menu(new String[]{
        "Adicionar um veiculo",
        "Verificar se existe Veiculo no sistema",
        "Guardar estafo num ficheiro binario",
        "Ler estado de um ficheiro binario",
        "Guardar estado num ficheiro .csv"
    });
    int op;
    do {
      m.executa();
      op = m.getOpcao();
      switch (op) {
        case 1:

          break;
        case 2:
          this.existeMatricula();
          break;
        case 3:
          break;
        case 4:
          break;
        case 5:
          this.toCsv();
          break;
        default:
          System.out.printf("Opcao invalida");
          break;
      }
    } while (op != 0);

  }

  private void addVeiculo(){


  }

  private void toCsv(){
    System.out.printf("Introduza um nome do ficheiro: ");
    String filename = scanner.next();
    filename = filename==null ? "Fichas/src/Ficha6/Veiculos.csv" : "Fichas/src/Ficha6/"+filename;
    List<Veiculo> imprimir = controller.getViaturas();
    try {
      ReadFile.toCsv( filename , imprimir);
      System.out.println("Operacao concluida com sucesso");
    } catch (Exception e){
      System.out.println("Operacao imcompleta\nNão foi possivel gerar o ficcehiro");
    }
  }

  private void existeMatricula() {
    System.out.printf("Matricula : ");
    String code = scanner.next();

    if (controller.existeMatricula(code))
      System.out.println("Matrícula encontrada");
    else
      System.out.println("Matrícula não existeno sistema");
  }
}
