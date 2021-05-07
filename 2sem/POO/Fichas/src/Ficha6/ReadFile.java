package Fichas.src.Ficha6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;

// fase 4
public class ReadFile {

  public static void toCsv(String filename, List<Veiculo> viaturas) throws IOException {
    PrintWriter fich = new PrintWriter(filename);
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

  public DriveIt carregaEstado(String filename) throws IOException {
    DriveIt self = new DriveIt();
    FileOutputStream fos = new FileOutputStream(filename);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    // coisas
    oos.flush();
    oos.close();
    return self;
  }
}
