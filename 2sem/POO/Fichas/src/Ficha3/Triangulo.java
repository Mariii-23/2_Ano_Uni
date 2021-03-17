package Ficha3;

import java.awt.*;
import java.util.Objects;

public class Triangulo {
  Ponto ponto1;
  Ponto ponto2;
  Ponto ponto3;

  public Triangulo(Ponto ponto1, Ponto ponto2, Ponto ponto3) {
    this.ponto1 = ponto1.clone();
    this.ponto2 = ponto2.clone();
    this.ponto3 = ponto3.clone();
  }

  public Triangulo() {
    this.ponto1 = new Ponto();
    this.ponto2 = new Ponto();
    this.ponto3 = new Ponto();
  }

  public Triangulo(Triangulo ola) {
    this.ponto1 = ola.ponto1.clone();
    this.ponto2 = ola.ponto2.clone();
    this.ponto3 = ola.ponto3.clone();
  }

  public Ponto getPonto1() {
    return ponto1.clone();
  }

  public void setPonto1(Ponto ponto1) {
    this.ponto1 = ponto1.clone();
  }

  public Ponto getPonto2() {
    return ponto2.clone();
  }

  public void setPonto2(Ponto ponto2) {
    this.ponto2 = ponto2.clone();
  }

  public Ponto getPonto3() {
    return ponto3.clone();
  }

  public void setPonto3(Ponto ponto3) {
    this.ponto3 = ponto3.clone();
  }

  public Triangulo clone() {
    return new Triangulo(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o != null || this.getClass() != o.getClass()) return false;
    Triangulo triangulo = (Triangulo) o;
    return this.ponto1.equals(triangulo.ponto1) &&
        this.ponto2.equals(triangulo.ponto2) &&
        this.ponto3.equals(triangulo.ponto3);
  }

  @Override
  public String toString() {
    return "Triangulo{" +
        "ponto1=" + ponto1.toString() +
        ", ponto2=" + ponto2.toString() +
        ", ponto3=" + ponto3.toString() +
        '}';
  }

  public double calculaPerimetro() {
    double a = getPonto1().distancia(getPonto2());
    double b = getPonto2().distancia(getPonto3());
    double c = getPonto3().distancia(getPonto1());
    return a + b + c;
  }

  public double calculaArea() { // herons formula
    double a = getPonto1().distancia(getPonto2());
    double b = getPonto2().distancia(getPonto3());
    double c = getPonto3().distancia(getPonto1());
    double perimetro = calculaPerimetro() / 2;
    return Math.sqrt(perimetro * (perimetro - a) * (perimetro - b) * (perimetro - c));
  }

  public double altura() {
    int miny = Math.min(ponto1.getY(), Math.min(ponto2.getY(), ponto3.getY()));
    int maxy = Math.max(ponto1.getY(), Math.max(ponto2.getY(), ponto3.getY()));
    return maxy - miny;
  }
}
