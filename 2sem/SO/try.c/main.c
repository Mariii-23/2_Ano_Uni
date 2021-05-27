#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
int main(int argc, char **argv) {

  /* char ola[30]; */
  /* sprintf(ola, "Mail enviado: %s %s\n", argv[1], argv[2]); */
  /* write(STDIN_FILENO, ola, sizeof(ola)); */
  char ola2[10];
  /* scanf(ola2, 11 * sizeof(char)); */
  fgets(ola2, 11 * sizeof(char), stdin);
  write(STDIN_FILENO, ola2, 10);
  return 1;
}

// for ()
// crias n forks -> processo
//
// acaba
//
// tens q criar outro
//
/* Nproc = 0; */
/* while (true) { */

/*   while (Nprocs < N_dado) { */
/*   FORK: */
/*     cria fork; */
/*     sinal++->nProc++; */
/*     execlp; */

/*     wait(NULL); */
/*     sinal--->nProc--; */
/*     exit(0); */

/*   PAI: */
/*     segue */
/*   } */
/* } */

/* waits->5 */
