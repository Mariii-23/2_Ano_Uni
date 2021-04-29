/* #include "guiao.h" */
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <unistd.h>

/* int ex() { */

/*   /\* isto nao funciona *\/ */

/*   int p[2]; */
/*   pipe(p); // sempre antes do fork */

/*   if (!fork) { */
/*     // redir stdin */
/*     close(p[1], dup2(p[0], 0)); */
/*     close(p[0]); */

/*     execlp("wc", "wc", "-l", NULL); */
/*     perror(); */
/*     exit(); */
/*   } else { */

/*     close(p[0], dup2(p[1], 1)); */
/*     close(p[1]); */
/*     execlp("lc", "lc", "/etc", NULL); */
/*   } */
/*   return 0; */
/* } */

int ex1() {
  int fildes[2];
  int res = pipe(fildes);
  if (res == -1)
    return res;
  return 0;
}

int ex4() {
  int p[2];
  int status[2];

  if (pipe(p) != 0) {
    /* 77algo */
  }

  switch (fork()) {
  case -1:
    perror("Fork\n");
    break;
  case 0:
    close(p[0]);
    dup2(p[1], 1);
    close(p[1]);
    execlp("ls", "ls", "/etc", NULL);
    exit(0);
    break;
  default:
    close(p[1]);
    break;
  }
  switch (fork()) {
  case -1:
    perror("Fork\n");
    break;
  case 0:
    dup2(p[0], 0);
    close(p[0]);
    execlp("wc", "wc -l", NULL);
    exit(0);
    break;
  default:
    close(p[0]);
    break;
  }

  for (int w = 0; w < 2; w++)
    wait(&status[w]);

  return 0;
}

int main(void) {
  printf("Ola\n");
  printf("\nExercicio 4\n");
  ex4();
  return 0;
}
