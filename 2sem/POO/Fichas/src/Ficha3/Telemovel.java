package Ficha3;

import java.awt.geom.Point2D;

public class Telemovel {
  private String marca;
  private String modelo;
  private Point2D  resolucao;
  private int dim_msg;
  private int dim_fotos;
  private int dim_app;
  private int num_fotos;
  private int num_app;
  private int tamanha_fotos;
  private int tamanha_apps;

  public Telemovel(String marca, String modelo, Point2D resolucao, int dim_msg, int dim_fotos, int dim_app, int num_fotos, int num_app, int tamanha_fotos, int tamanha_apps) {
    this.marca = marca;
    this.modelo = modelo;
    this.resolucao = resolucao;
    this.dim_msg = dim_msg;
    this.dim_fotos = dim_fotos;
    this.dim_app = dim_app;
    this.num_fotos = num_fotos;
    this.num_app = num_app;
    this.tamanha_fotos = tamanha_fotos;
    this.tamanha_apps = tamanha_apps;
  }

  public Telemovel(){
    this.marca = marca;
    Point2D point = new Point2D.Double();
    this.modelo = "";
    this.resolucao = point;
    this.dim_msg =0;
    this.dim_fotos =0;
    this.dim_app = 0;
    this.num_fotos =0;
    this.num_app = 0;
    this.tamanha_fotos =0;
    this.tamanha_apps = 0;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public Point2D getResolucao() {
    return resolucao;
  }

  public void setResolucao(Point2D resolucao) {
    this.resolucao = resolucao;
  }

  public int getDim_msg() {
    return dim_msg;
  }

  public void setDim_msg(int dim_msg) {
    this.dim_msg = dim_msg;
  }

  public int getDim_fotos() {
    return dim_fotos;
  }

  public void setDim_fotos(int dim_fotos) {
    this.dim_fotos = dim_fotos;
  }

  public int getDim_app() {
    return dim_app;
  }

  public void setDim_app(int dim_app) {
    this.dim_app = dim_app;
  }

  public int getNum_fotos() {
    return num_fotos;
  }

  public void setNum_fotos(int num_fotos) {
    this.num_fotos = num_fotos;
  }

  public int getNum_app() {
    return num_app;
  }

  public void setNum_app(int num_app) {
    this.num_app = num_app;
  }

  public int getTamanha_fotos() {
    return tamanha_fotos;
  }

  public void setTamanha_fotos(int tamanha_fotos) {
    this.tamanha_fotos = tamanha_fotos;
  }

  public int getTamanha_apps() {
    return tamanha_apps;
  }

  public void setTamanha_apps(int tamanha_apps) {
    this.tamanha_apps = tamanha_apps;
  }

  @Override
  public String toString() {
    return "Telemovel{" +
        "marca='" + marca + '\'' +
        ", modelo='" + modelo + '\'' +
        ", resolucao=" + resolucao +
        ", dim_msg=" + dim_msg +
        ", dim_fotos=" + dim_fotos +
        ", dim_app=" + dim_app +
        ", num_fotos=" + num_fotos +
        ", num_app=" + num_app +
        ", tamanha_fotos=" + tamanha_fotos +
        ", tamanha_apps=" + tamanha_apps +
        '}';
  }
}
