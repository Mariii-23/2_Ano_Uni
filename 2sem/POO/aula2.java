public
class aula2 {

    public static void main(String[] args) {
        System.out.print("success");
    }

public
  static void main() {
    String[] array = {"Sandes de Atum", "Chocolate", "Arroz"};

    int array_[][] = {{1, 1, 1}, {2, 2, 2}};

    for (int i = 0; i < array.length; i++)
      System.out.print(array[i] + " ");

    for (String elem : array)
      System.out.print(elem + " ");

    int sfinal = 0;

    // Somar todos os elementos da matriz
    for (int[] l_elem : array_)
      for (int elem : l_elem)
        sfinal += elem;
    System.out.print(sfinal);
  }
}