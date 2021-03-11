package Ficha3;

public class Circulo {

  private double x;
  private double y;
  private double raio;

  public Circulo() {
    this.x = 0;
    this.y = 0;
    this.raio = 0;
  }

  public Circulo(double x, double y, double raio) {
    this.x = x;
    this.y = y;
    this.raio = raio;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double getRaio() {
    return raio;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public void setRaio(double raio) {
    this.raio = raio;
  }

  public void alteraCentro(double x, double y) {
    this.setX(x);
    this.setY(y);
  }

  public double calculaArea() {
    return Math.PI * Math.pow(raio,2);
  }

   public double calculoPeriodo(){
      return Math.PI * this.getRaio()*2;
   }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || this.getClass() != o.getClass()) return false;
    Circulo circulo = (Circulo) o;
    return Double.compare(circulo.x, x) == 0 && Double.compare(circulo.y, y) == 0 && Double.compare(circulo.raio, raio) == 0;
  }

  public String toString(){
    StringBuilder s= new StringBuilder();
    s.append("---Circulo---\nraio:");s.append(getRaio());
    s.append("Ponto: x->\n"); s.append(getX()); s.append(" y->");s.append(getY());
    s.append("\n");
    return s.toString();
  }
}
