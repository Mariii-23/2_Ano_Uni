package Fichas.src.Ficha3;

import Ficha3.Circulo;
import Ficha3.Jogo_Futebol;


public class main {
  public static void main(String[] args) {

    System.out.println("$$$$$$$$ EXERCICIO 1 $$$$$$$$$$$$$\n");
    main_circulo();

    System.out.println("\n$$$$$$$$ EXERCICIO 5 $$$$$$$$$$$$$\n");
    main_futebol();

  }

  private static void main_circulo(){
    Circulo circulo = new Circulo();
    circulo.toString();
    circulo.setRaio(4);
    System.out.println("O Perimetro do circulo: \nraio: "+circulo.getRaio());
    System.out.println(" e centro:"+ circulo.getX()+"  "+ circulo.getY()+" é "+ circulo.calculoPeriodo());
    System.out.println("A sua area -> "+ circulo.calculaArea());

    Circulo circulo1 = new Circulo(2,2,20);
    circulo1.toString();
    System.out.println("\nO Perimetro do circulo: \nraio: "+circulo1.getRaio());
    System.out.println(" e centro:"+ circulo1.getX()+"  "+ circulo1.getY()+" é "+ circulo1.calculoPeriodo());
    System.out.println("A sua area -> "+ circulo1.calculaArea());

    System.out.println("\nOs 2 circulos anteriores eram iguais -> "+circulo1.equals(circulo));
  }

  /**
   * Exercicio 5
   */
  private static void main_futebol() {
    Jogo_Futebol jogo = Jogo_Futebol.startGame("EQUIPA1", "EQUIPA2");
    Jogo_Futebol jogo1 = Jogo_Futebol.decorrer("ARROZ_1", "ARROZ_2", 10, 5);

    System.out.println(jogo.toString());
    jogo.goloVisitado();
    System.out.println(jogo.getVisitado() + " marcou GOLOOOOO. RESULTADO: " + jogo.getPlacar().toString()+"\n");
    jogo.goloVisitado();
    System.out.println(jogo.getVisitado() + " marcou GOLOOOOO. RESULTADO: " + jogo.getPlacar().toString()+"\n");
    jogo.goloVisitado();
    System.out.println(jogo.getVisitado() + " marcou GOLOOOOO. RESULTADO: " + jogo.getPlacar().toString()+"\n");

    Jogo_Futebol clone = jogo1.clone();
    clone.setVisitante("BATATA2");
    clone.setVisitado("BATATA3");
    System.out.println(clone.toString());
    clone.goloVisitante();
    System.out.println(clone.getVisitante() + " marcou GOLOOOOO. RESULTADO: " + clone.getPlacar().toString()+"\n");
    clone.goloVisitante();
    System.out.println(clone.getVisitante() + " marcou GOLOOOOO. RESULTADO: " + clone.getPlacar().toString()+"\n");

    System.out.println(   jogo1.toString());
    jogo1.goloVisitado();
    jogo1.goloVisitado();
    jogo1.goloVisitado();
    jogo1.goloVisitado();
    jogo1.goloVisitado();
    System.out.println(jogo1.getVisitado()+" MARCOU GOLOOOO. Resultado: "+ jogo1.getPlacar().toString()+"\n");

    jogo1.endGame();
    jogo.endGame();
    clone.endGame();

    System.out.println(jogo.toString());
    System.out.println(jogo1.toString());
    System.out.println(clone.toString());
  }

}
