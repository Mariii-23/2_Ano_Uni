package Fichas.src;
import Ficha3.Ficha3;
import Ficha3.Jogo_Futebol;
import Fichas.src.Semana7.casainteligente.SmartBulb;
import Fichas.src.Semana7.casainteligente.SmartDevice;
import Fichas.src.Semana7.casainteligente.SmartSpeaker;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
  public static void main(String[] args) {
    SmartDevice ola = new SmartBulb();
    SmartDevice adeus = new SmartSpeaker();
    System.out.println(ola.getClass().getSimpleName());
    System.out.println(adeus.getClass().getSimpleName());

    List<Point2D> grh = new ArrayList<>();
    grh.add(new Point(1,1));
    grh.add(new Point(2,2));
    grh.add(new Point(3,3));
    grh.get(1).setLocation(10,10);
    System.out.println(grh.toString());
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