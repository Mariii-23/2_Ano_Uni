/* #include "main.h" */
#include <stdio.h>
#include <unistd.h>
//#include <stdlib.h>
//#include <sys/wait.h>
#include "guiao.h"
#include <fcntl.h>
#include <string.h>
int main(int argc, char **argv) {
  printf("Exercicio 4\n");
  ex4(argv + 1, argc--);
  return 0;
}
