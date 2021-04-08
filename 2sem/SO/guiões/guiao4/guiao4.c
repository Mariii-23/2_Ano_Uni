/* #include "guiao4.h" */
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <unistd.h>

int mysystem(char *comando) {
  int fork_ret, exec_ret, wait_ret, status, res;

  char *exec_args[20];
  //???
  char *string = (char *)malloc(sizeof(char) * 100);
  /* char *string; */
  int i = 0;

  string = strtok(comando, " ");

  while (string != NULL) {
    strcpy(exec_args[i], string);
    /* exec_args[i] = string; */
    string = strtok(NULL, " ");
    i++;
  }

  exec_args[i] = NULL;

  fork_ret = fork();

  if (fork_ret == 0) {
    exec_ret = execvp(exec_args[0], exec_args);
    _exit(exec_ret);

  } else {
    if (fork_ret != -1) {
      wait_ret = waitpid(fork_ret, &status, 0);

      if (WIFEXITED(status))
        res = WEXITSTATUS(status);
      else
        res = -1;

    } else
      res = -1;
  }
  free(string);
  return res;
}

int main(int argc, char **argv) {
  char *comando1 = "ls -l -a -h";
  char *comando2 = "sleep 10";
  char *comando3 = "ps";

  int ret = -1;
  printf("a executar mysystem para %s\n", comando1);
  ret = mysystem(comando1);
  printf("ret: %d\n", ret);

  printf("a executar mysystem para %s\n", comando2);
  /* ret = mysystem(comando2); */
  printf("ret: %d\n", ret);

  printf("a executar mysystem para %s\n", comando3);
  /* ret = mysystem(comando3); */
  printf("ret: %d\n", ret);

  return 0;
}
