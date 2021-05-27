/* #include "guiao.h" */
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h> /* chamadas wait*() e macros relacionadas */
#include <unistd.h>

#include <signal.h>
int palavra_found = 0;
int count_control_c = 0;
int seconds = 0;

void tratamento_ctrl_c(int signum) {
  count_control_c++;
  printf("Tempo passado %d\n", seconds);
}

void tratamento_alarme(int signum) {
  seconds++;
  alarm(1);
  printf("Alarme: %d\n", seconds);
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

int exec_grep(char *search, char *filename) {
  return execlp("grep", "grep", search, filename, NULL);
}

void test_exec_grep() {
  int status;
  if (fork() == 0) {
    exec_grep("ola", "guiao.c");
  } else {
    pid_t terminated_pid = wait(&status);
    exec_grep("if", "guiao.c");
  }
}

int ex2(char *search, char *filenames[], int N) {
  int filhos[20];

  printf("\n[PAI] %d\nPalavra a procurar: %s\n\n", getpid(), search);
  int i;
  for (i = 0; i < N; i++) {
    /* filhos[i] = getpid(); */
    if (fork() == 0) {
      printf("[Filho] %d  Iniciou a procura\nFile: %s \n\n", getpid(),
             filenames[i]);
      exec_grep(search, filenames[i]);
      sleep(i * 5);
      _exit(1);
    }
  }

  for (int i = 0; i < N; i++) {
    int exit_status;
    /* pause(); */
    pid_t terminated_pid = wait(&exit_status);
    printf("\n[Filho] %d , exit code: %d\n", terminated_pid,
           WEXITSTATUS(exit_status));

    if (WEXITSTATUS(exit_status) == 0) {
      printf("\n[Filho] %d Encoutrou\n", terminated_pid);
      kill(0, SIGKILL);
      /* for (int i = 0; i < N; i++) */
      /*   kill(0, SIGKILL); */
      /* return 1; */
    }
  }

  return 1;
}

int main(void) {
  /* printf("%d\n", ola); */
  ex1();
  /* char *filenames[] = {"guiao.c", "ola.txt", "nada_aqui.txt"}; */
  /* int N = 3; */

  /* int resul = ex2("if", filenames, N); */
  /* printf("\nEncountrou palavra em %d files\n", resul); */

  return 0;
}
