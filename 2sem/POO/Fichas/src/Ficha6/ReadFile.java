package Fichas.src.Ficha6;

import java.io.*;
import java.util.List;

// fase 4
public class ReadFile {

  public static void toCsv(String filename, List<Veiculo> viaturas) throws IOException {
    PrintWriter fich = new PrintWriter(new File(filename));
    for (Veiculo v : viaturas) {
      fich.println(v.toString());
    }
    fich.flush();
    fich.close();
  }

  public void guardaEstado(String filename, DriveIt self) throws IOException {
    FileOutputStream fos = new FileOutputStream(filename);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(self);
    oos.flush();
    oos.close();
  }

  public DriveIt carregaEstado(String filename) throws IOException, Exception {
    DriveIt self = new DriveIt();
    FileInputStream fos = new FileInputStream(filename);
    ObjectInputStream oos = new ObjectInputStream(fos);
    self = (DriveIt) oos.readObject();
    oos.close();
    return self;
  }
}
