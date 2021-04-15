package Fichas.src.Semana7.casainteligente;

import java.util.Objects;

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

  public SmartDevice clone() {
    return new SmartDevice(this.getID(),this.estado);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SmartDevice that = (SmartDevice) o;
    return estado == that.estado && Objects.equals(ID, that.ID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, estado);
  }
}
