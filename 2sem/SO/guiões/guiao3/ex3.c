/* #include "ex3.h" */
#include <stdio.h>
#include <unistd.h>
//#include <stdlib.h>
//#include <sys/wait.h>
#include <fcntl.h>
#include <string.h>
int main(int argc, char **argv) {
  for (int i = 0; i < argc; i++) {
    write(1, argv[i], strlen(argv[i]));
    write(1, "\n", 1);
    // printf("argumento &d: %s\n",i,argv[i]);
  }

  // para mostrar com ps...
  // sleep(10);

  return 0;
}
