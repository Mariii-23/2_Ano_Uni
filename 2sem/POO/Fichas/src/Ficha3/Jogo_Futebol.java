package Ficha3;

import java.awt.geom.Point2D;
import java.util.Objects;

public class Jogo_Futebol {
  /**
   * 0 -> A iniciar
   * 1 -> A decorrer
   * 2 -> Terminado
   */
  int estado;
  String visitado;
  String visitante;
  Point2D placar;

  private Jogo_Futebol() {
    this(0,"" ,"" ,null );
  }

  private Jogo_Futebol(int estado, String visitado, String visitante, Point2D placar) {
    this.estado = estado;
    this.visitado = visitado;
    this.visitante = visitante;
    this.placar = placar;
  }

  public static Jogo_Futebol startGame(String visitado,String visitante){
    Point2D point = new Point2D.Double(0,0);
    return new Jogo_Futebol(0,visitado,visitante,point);
  }

  public static Jogo_Futebol decorrer(String visitado, String visitante, int x, int y){
    Point2D placar = new Point2D.Double(x,y);
    return new Jogo_Futebol(1,visitado,visitante,placar);
  }

  public static Jogo_Futebol terminado(String visitado, String visitante, Point2D placar){
    Point2D placar1 = new Point2D.Double(placar.getX(),placar.getY());
    String visitado1 = new String(visitado);
    String visitante1 = new String(visitante);
    return new Jogo_Futebol(2,visitado1,visitante1,placar1);
  }

  public static Jogo_Futebol jogo(Jogo_Futebol o){
    String visitado = new String(o.getVisitado());
    String visitante = new String(o.getVisitante());
    Point2D point = new Point2D.Double(o.getPlacar().getX(),o.getPlacar().getY());
    return new Jogo_Futebol(o.getEstado(), visitado , visitante, point );
  }

  public int getEstado() {
    return estado;
  }

  public void setEstado(int estado) {
    this.estado = estado%3;
  }

  public String getVisitado() {
    return visitado;
  }

  public void setVisitado(String visitado) {
    this.visitado = visitado;
  }

  public String getVisitante() {
    return visitante;
  }

  public void setVisitante(String visitante) {
    this.visitante = visitante;
  }

  public Point2D getPlacar() {
    return placar;
  }

  public void setPlacar(Point2D placar) {
    this.placar = placar;
  }

  public void setPlacar(int visitados, int visitante){
    Point2D point = new Point2D.Double(visitante,visitados);
     setPlacar(point);
  }

  public void goloVisitante(){
    this.placar.setLocation(getPlacar().getX(), this.getPlacar().getY() + 1 );
  }

  public void goloVisitado(){
    this.placar.setLocation(this.getPlacar().getX() + 1 ,getPlacar().getY());
  }

  public String resultadoActual(){
    StringBuilder s = new StringBuilder();
    s.append("---RESULTADO---\n");
    s.append(getVisitado());s.append(" : ");
    s.append(getVisitante());s.append("\n"+getPlacar().getX()+" : "+getPlacar().getY());
    s.append("\n");
    return s.toString();
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("JOGO DE_FUTEBOL{\n");

    s.append("Estado: ");
    switch(getEstado()){
      case 0:
        s.append("INICIADO\n");
        break;
      case 1:
        s.append("A DECORRER\n");
        break;
      case 2:
        s.append("TERMINADO\n");
        break;
    }
    s.append("Visitado: "+getVisitado()+"\n");
    s.append("Visitante: "+getVisitante()+"\n");
    s.append(resultadoActual());
    return s.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || this.getClass() != o.getClass() ) return false;
    Jogo_Futebol that = (Jogo_Futebol) o;
    return estado == that.estado && Objects.equals(visitado, that.visitado) && Objects.equals(visitante, that.visitante) && Objects.equals(placar, that.placar);
  }

  public Jogo_Futebol clone(){
    return Jogo_Futebol.jogo(this);
  }

  @Deprecated
  public void endGame(){
    setEstado(2);
  }
}
