package Fichas.src.Semana7.casainteligente;

public class SmartDevice {
  private String ID;
  private boolean estado;

  public SmartDevice(String ID, boolean  estado) {
    this.ID = ID;
    this.estado = estado;
  }
  public SmartDevice(){
    this.ID = "";
    this.estado = false;
  }
  public SmartDevice(String ID) {
    this.ID = ID;
    this.estado = false;
  }

  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public boolean isEstado() {
    return estado;
  }

  public void setEstado(boolean estado) {
    this.estado = estado;
  }

  public void setOn(boolean estado){
    this.estado=estado;
  }

  public boolean getOn(){
    return true == this.estado;
  }
}
