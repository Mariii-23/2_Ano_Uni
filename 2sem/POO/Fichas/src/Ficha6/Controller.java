package Fichas.src.Ficha6;

import java.util.List;

public class Controller {
  DriveIt driveIt;

  public Controller(DriveIt driveIt) {
    this.driveIt = driveIt;
  }

  public boolean existeMatricula(String cod){
    return driveIt.existeVeiculo(cod);
  }

  public List<Veiculo> getViaturas(){
    return driveIt.getVeiculos();
  }

  public String toCsv(){
    StringBuilder s = new StringBuilder();
    for (Veiculo e : driveIt.getVeiculos())
      s.append( e.toString() );
    return s.toString();
  }
}
