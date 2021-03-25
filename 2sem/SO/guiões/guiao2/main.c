#include <stdio.h>
#include <stdlib.h>

#include "guiao2.h"

int main() {
  printf("\n\n$$$$$$$$ EXERCICIO 1 $$$$$$$$$\n");
  ex1();
  printf("\n\n$$$$$$$$ EXERCICIO 2 $$$$$$$$$\n");
  ex2();
  printf("\n\n$$$$$$$$ EXERCICIO 3 $$$$$$$$$\n");
  ex3();
  printf("\n\n$$$$$$$$ EXERCICIO 4 $$$$$$$$$\n");
  ex4();
  printf("\n\n$$$$$$$$ EXERCICIO 5 $$$$$$$$$\n");
  ex5();

  printf("\n\n$$$$$$$$ FIND MATRIX $$$$$$$$$\n");
  int matrix[LINHA][COLUNA];
  for (size_t i = 0; i < LINHA; i++) {
    for (size_t j = 0; j < COLUNA; j++)
      matrix[i][j] = j;
  }

  matrix[0][1] = 25;
  matrix[0][20] = 25;
  matrix[9][9] = 25;
  matrix[2][15] = 25;

  int count = findMatrix(matrix, 25);
  printf("\nForam encontrados %d\n\n", count);

  printf("\n\n$$$$$$$$ EXERCICIO 7 $$$$$$$$$\n");
  ex7(matrix, 25);

  return 0;
}
