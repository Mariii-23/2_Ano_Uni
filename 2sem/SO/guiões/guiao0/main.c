/* #include "main.h" */
#include "guiao0.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define N 10
#define SEARCH 8
#define SEARCH2 25
#define FILL 25
#define START (N / 2)
#define END N

int main() {
  int vector[N];
  int vetor2[N];

  /* §§§§§§§§§§§§§§§§§§ */
  /* §§ Fill  Arrays §§ */

  /* Array 1 */
  fill(vector, N, FILL);

  /* Array 2 */
  for (int i = 0; i < N; i++)
    vetor2[i] = i;

  /* §§§§§§§§§§§§§§§§§§ */
  /* §§ Print Arrays §§ */

  printf("Array 1:\n");
  print_array(vector, N);

  printf("\nArray 2:\n");
  print_array(vetor2, N);

  printf("\n");

  /* §§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§ */
  /* §§ Search for a number in Arrays §§ */
  printf("VECTOR1\n");

  int search_resul = find(vector, N, SEARCH);
  printf("Find %d in vector1 : %d \n", SEARCH, search_resul);

  search_resul = find(vector, N, SEARCH2);
  printf("Find %d in vector1 : %d \n", SEARCH2, search_resul);

  search_resul = find(vector + START, END - START, SEARCH);
  printf("Find %d in vector1 ,between %d and %d : %d \n", SEARCH, START, END,
         search_resul);

  search_resul = find(vector + START, END - START, SEARCH2);
  printf("Find %d in vector1 ,between %d and %d : %d \n", SEARCH2, START, END,
         search_resul);

  printf("\nVECTOR2\n");

  search_resul = find(vetor2, N, SEARCH);
  printf("Find %d in vector2 : %d \n", SEARCH, search_resul);

  search_resul = find(vetor2, N, SEARCH);
  printf("Find %d in vector2 : %d \n", SEARCH2, search_resul);

  search_resul = find(vetor2 + START, END - START, SEARCH);
  printf("Find %d in vector2 ,between %d and %d : %d \n", SEARCH, START, END,
         search_resul);

  search_resul = find(vetor2 + START, END - START, SEARCH2);
  printf("Find %d in vector2 ,between %d and %d : %d \n", SEARCH2, START, END,
         search_resul);

  return 1;
}
