/* #include "guiao.h" */
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

int count_control_c = 0;
int seconds = 0;

void tratamento_ctrl_c(int signum) {
  count_control_c++;
  printf("Tempo passado %d\n", seconds);
}
void tratamento_alarme(int signum) {
  seconds++;
  alarm(1);
  printf("Alarme\n");
}

void tratamento_ctrl_barra(int singum) {
  printf("Carregou %d vezes no control c\n", count_control_c);
  _exit(0);
}

void ex1() {
  printf("Pid: %d\n", getpid());

  if (signal(SIGINT, tratamento_ctrl_c) == SIG_ERR) {
    /* error("algo errado aconteceu"); */
    _exit(1);
  }

  if (signal(SIGQUIT, tratamento_ctrl_barra) == SIG_ERR) {
    /* error("algo errado aconteceu"); */
    _exit(1);
  }

  if (signal(SIGALRM, tratamento_alarme) == SIG_ERR) {
    perror("algo errado aconteceu");
    _exit(1);
  }

  alarm(1);
  while (1) {
    pause();
  }
}

int main(void) {
  ex1();
  return 0;
}
