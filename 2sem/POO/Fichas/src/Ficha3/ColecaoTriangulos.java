package Fichas.src.Ficha3;

import java.util.ArrayList;
import java.util.Iterator;
import Ficha3.Triangulo;

public class ColecaoTriangulos {
  private ArrayList<Ficha3.Triangulo> triangulos;

  public ColecaoTriangulos() {
    this.triangulos = new ArrayList<Triangulo>();
  }

  public ColecaoTriangulos(ArrayList<Triangulo> triangulos) {
    this.triangulos = new ArrayList<Triangulo>();
    for (Triangulo tri : triangulos) {
      this.triangulos.add(tri.clone());
    }
  }

  public ColecaoTriangulos(ColecaoTriangulos o) {
    triangulos = o.getTriangulos();
  }

  public ArrayList<Triangulo> getTriangulos() {
    ArrayList<Triangulo> r = new ArrayList<>(); //diamond notation
    for (Triangulo tri : this.triangulos) {
      r.add(tri.clone());
    }
    return r;
  }

  public void setTriangulos(ArrayList<Triangulo> novosTriangulos) {
    this.triangulos = new ArrayList<>(); //diamond notation
    for (
        Triangulo tri : novosTriangulos) {
      this.triangulos.add(tri.clone());
    }
  }

  public boolean triangulosPertence(Triangulo t){
   /*
   boolean found = false;
    Iterator<Triangulo> it = triangulos.iterator();
    while(!found && it.hasNext()){
      Triangulo este = it.next();
      if(este.equals(t)) found = true;
    }
    */
   boolean found = triangulos.contains(t);
   return found;
  }

  public Triangulo maiorArea(){
    Triangulo r = triangulos.get(0);
    for(Triangulo t :triangulos){
      if(t.calculaArea() > r.calculaArea()) r = t;
    }
    return r.clone();
  }
}
