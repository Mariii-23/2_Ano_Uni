package Fichas.src.Semana7.casainteligente;

import Fichas.src.Ficha4.EncEficiente;

import java.util.*;
import java.util.stream.Collectors;

public class CasaInteligente {
  private String morada;
  private Map<String,SmartDevice> devices;
  private Map<String,List <String>> perRoom;

  public CasaInteligente(String morada, Map<String, SmartDevice> devices, Map<String, List<String>> perRoom) {
    this.morada = morada;
    this.devices = devices;
    this.perRoom = perRoom;
  }

  public CasaInteligente(String morada) {
    this.morada = morada;
    this.devices = new HashMap<>();
    this.perRoom = new HashMap<>();
  }

  public CasaInteligente(){
    this.morada = "";
    this.devices = new HashMap<>();
    this.perRoom = new HashMap<>();
  }

  public String getMorada() {
    return morada;
  }

  public void setMorada(String morada) {
    this.morada = morada;
  }

  public boolean existsDevice(String ID){
    return this.devices.containsKey(ID);
  }

  public void addDevice(SmartDevice device){
    this.devices.put(device.getID(),device.clone());
  }

  public SmartDevice getDevice(String id){
   // return devices.values().stream()
   //     .filter(k->k.getID().equals(id))
   //     .findFirst().orElse(null);
    return devices.get(id);
  }

  public void setAllOn(boolean power){
    this.devices.values().forEach(device -> device.setOn(power));
  }

  public boolean hasRoom(String room){
    return perRoom.containsKey(room);
  }

  public void addRoom(String room){
    perRoom.put(room,new ArrayList<>());
  }

  public void addToRoom(String room,String id){
    List<String> ola = this.perRoom.get(room);
    if(ola==null) ola = new ArrayList<>();
    ola.add(id);
    this.perRoom.put(room, ola );
  }

  public boolean roomHasDevice(String room,String device){
    List<String> list = this.perRoom.get(room);

    return hasRoom(room) && list.contains(device) ;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CasaInteligente that = (CasaInteligente) o;
    return Objects.equals(morada, that.morada) && Objects.equals(devices, that.devices) && Objects.equals(perRoom, that.perRoom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(morada, devices, perRoom);
  }
}
