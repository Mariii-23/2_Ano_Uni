/* #include "main.h" */
#include "guiao0.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define N 10

int main() {
  int vector[N];

  fill(vector, N, 25);

  int search = find(vector, N, 7);
  printf("Find 7 : %d \n", search);

  search = find(vector, N, 25);
  printf("Find 25 : %d \n", search);

  return 1;
}
