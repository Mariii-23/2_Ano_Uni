#include "guiao.h"
#include <stdio.h>
#include <unistd.h>
//#include <stdlib.h>
//#include <sys/wait.h>
#include <fcntl.h>
#include <string.h>

/* exercicio 4 */
int ex4(char **argv, int argc) {
  if (argc < 0)
    return 1;
  int ret = execv("ex3", argv);
  return ret;
}

/* exercio 5 */
int ex5(char **argv, int argc) {
  int fork_ret, exec_ret, i;

  for (i = 0; i < argc; i++) {
    fork_ret = fork();
  }
}
