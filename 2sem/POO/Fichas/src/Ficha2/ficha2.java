package Fichas.src.Ficha2;

import java.util.Arrays;
import java.util.Scanner;

public class ficha2 {
  /**
   * Método que lê um array.
   *
   * @return Array lido.
   */
  public int[] read_array() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Indique o número de elementos a ler: ");
    int N = scanner.nextInt();
    int[] array = new int[N];
    for (int i = 0; i < N; i++) {
      System.out.print("Insira um valor: ");
      array[i] = scanner.nextInt();
    }
    return array;
  }

  /**
   * Método que determina o valor mínimo de um dado array.
   *
   * @param a Array a ser analisado.
   * @return Valor mínimo.
   */
  public int min_array(int[] a) {
    int min = a[0];
    for (int elem : a) {
      if (elem < min)
        min = elem;
    }
    return min;
  }
  //public int min_array(int[] a){
  //    int min = a[0];
  //    for(int i=1; i<a.length;i++) {
  //        if(a[i]< min)
  //            min = a[i];
  //    }
  //    return min;
  //}

  /**
   * Método que determina o valor máximo de um dado array.
   *
   * @param a Array a ser analisado.
   * @return Valor máximo.
   */
  public int max_array(int[] a) {
    int max = a[0];
    for (int elem : a) {
      if (elem > max)
        max = elem;
    }
    return max;
  }

  /**
   * Método que copia um dado array entre certos índices.
   *
   * @param a      Array a ser analisado.
   * @param inicio Comeco do novo array.
   * @param fim    Fim do novo array.
   * @return Array copia.
   */
  public int[] array_entre(int[] a, int inicio, int fim) {
    int[] res = new int[fim - inicio + 1];
    System.arraycopy(a, inicio, res, 0, fim - inicio + 1);
    return res;
  }

  /**
   * Método que determina o array com os elementos comuns aos dois arrays dados.
   *
   * @param a Array a.
   * @param b Array b.
   * @return Array resultante.
   */
  public int[] array_comum(int[] a, int[] b) {
    int[] resul = new int[Math.min(a.length, b.length)];

    int[] min = a.length > b.length ? b : a;
    int[] max = a.length > b.length ? a : b;

    Arrays.sort(min);
    Arrays.sort(max);

    int i = 0, y = 0, j = 0;

    while (i < min.length && j < max.length && y < min.length) {
      if (min[i] == max[j]) {
        resul[y] = min[i];
        i++;
        j++;
        y++;
      } else {
        while (i < min.length && j < max.length && max[j] != min[i]) {
          if (max[j] < min[i]) j++;
          else i++;
        }
      }
    }

    int[] r_final = new int[y];
    System.arraycopy(resul, 0, r_final, 0, y);
    return r_final;
  }
}

