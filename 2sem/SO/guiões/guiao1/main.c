/* #include "main.h" */
#include "guiao1.h"

#include <stdio.h>
#include <stdlib.h>

#define PATH "try.txt"
#define COPY "try2.txt"

int main() {
  /* Exercise 1  */
  printf("\n\n§§§§§§§§§§§§§§§§§\n\n     EXERCISE 1 \n\n");

  printf("Copy the file %s to %s\n", PATH, COPY);
  printf("\n%s :\n", PATH);
  my_print(PATH);
  int exer1 = my_cp(PATH, COPY);
  if (exer1) {
    printf("\n%s :\n", COPY);
    my_print(COPY);
  } else
    printf("Something went wrong.\n");

  /* Exercise 2  */
  printf("\n\n§§§§§§§§§§§§§§§§§\n\n     EXERCISE 2 \n\n");
  printf("We will print everything you write\n");
  printf("You can end the exercise by writing \"exit\" or \"Exit\" \n\n");
  my_cat();

  return 0;
}
