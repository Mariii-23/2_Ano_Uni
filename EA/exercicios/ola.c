/* #include "ola.h" */

#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

float soma_quadrados(float const *array, int N) {
  float count = 0;
  for (int i = 0; i < N; i++)
    count += array[i] * array[i];
  return count;
}

/* float matriz_quadrados */

float media(float const *array, int N) {
  float count = 0;
  for (int i = 0; i < N; i++)
    count += array[i];
  count = count / 2;
  return count;
}

int ola(FILE const *fp) { return 1; }

void *read_array(float *array, int N) {
  for (int i = 0; i < N; i++)
    scanf("%f", &array[i]);
}

void print(float *array, int N) {
  for (int i = 0; i < N; i++)
    printf("%f, ", array[i]);
  printf("\n");
}

int main() {

  float array[6000];
  int N;

  printf("Valor do N:");
  scanf("%d", &N);
  read_array(array, N);
  print(array, N);

  return 0;
}
