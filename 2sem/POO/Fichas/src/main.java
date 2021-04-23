package Fichas.src;
import Ficha3.Ficha3;
import Ficha3.Jogo_Futebol;
import Fichas.src.Semana7.casainteligente.SmartBulb;
import Fichas.src.Semana7.casainteligente.SmartDevice;
import Fichas.src.Semana7.casainteligente.SmartSpeaker;

import java.util.Arrays;

public class main {
  public static void main(String[] args) {
    SmartDevice ola = new SmartBulb();
    SmartDevice adeus = new SmartSpeaker();
    System.out.println(ola.getClass().getSimpleName());
    System.out.println(adeus.getClass().getSimpleName());
  }
  //public static void main(String[] args) {
  //  Ficha2.ficha2 ficha2 = new Ficha2.ficha2();
  //  int[] a = {1,2,4,4,4,4,2,3,2,2,2};
  //  int[] b = {5,1,2,1,4,2,3};

  //  System.out.println(Arrays.toString(ficha2.array_comum(a, b)));

  //  Ficha1.main_Ficha1 ficha1 = new Ficha1.main_Ficha1();
  //  ficha1.mainFicha1_Parte2();
  //}
}