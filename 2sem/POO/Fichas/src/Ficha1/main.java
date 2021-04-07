package Fichas.src.Ficha1;


/**
 * Parte 2 -> exercício 7 com a main
 */
public class main {
  String[] args = {"20", "30", "40", "50"};

  public static void main(String[] args) {
    for (int i = 0; i < args.length; i++) {
      int n = Integer.parseInt(args[i]);
      Parte2 ficha1 = new Parte2();
      ficha1.factorial(n);
    }
  }
}

