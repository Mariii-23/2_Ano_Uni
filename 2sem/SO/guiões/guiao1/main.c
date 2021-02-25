/* #include "main.h" */
#include "guiao1.h"
#include "pessoas.h"
#include <fcntl.h>
#include <sys/types.h>
#include <unistd.h>

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main_exer() {
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

  /* Exercise 3  */
  printf("\n\n§§§§§§§§§§§§§§§§§\n\n     EXERCISE 3 \n\n");

  int fd_source;
  if ((fd_source = open(PATH, O_RDONLY)) == -1) {
    perror("open");
    return 1;
  }
  char buffer3[MAX_BUF];
  ssize_t exer3 = readln(fd_source, buffer3, MAX_BUF);
  if (exer3 != 0)
    printf("%s\n", buffer3);
  else
    printf("Something went wrong\n");
  close(fd_source);

  return 0;
}

void help() {
  printf("To run exercises:\n./pessoas -e\n");
  printf("\nWorking on updates.....\n");
}

int main(int argc, char *argv[]) {
  int faile = 0;
  if (argc < 2 || argc > 4) {
    help();
    faile = 1;
  } else if (argc == 2 && argv[1][1] == 'e')
    main_exer();
  else {
    /* unsigned char option = argv[1][1]; */
    argv = argc > 2 ? argv + 2 : NULL;
    main_pessoas(argc - 2, argv);
  }
  return faile;
}
