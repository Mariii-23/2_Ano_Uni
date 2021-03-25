#include "guiao2.h"

#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h> /* chamadas wait*() e macros relacionadas */
#include <unistd.h>   /* chamadas ao sistema: defs e decls essenciais */
#include <unistd.h>
/* Exercício 1 */
/**
 *Função que imprime o seu identificador
 *de processo e o do seu pai.
 **/
void ex1() { printf("[Pai] %d  [Filho] %d \n", getppid(), getpid()); }

void ex2() {
  pid_t child_pid = fork();
  ex1();
  if (child_pid != 0)
    printf("Child PID %d from Parent:\t%d\n", child_pid, getpid());
  else
    _exit(0);
  wait(NULL);
}

void ex3() {
  for (int i = 0; i < 10; ++i) {
    if (!fork()) {
      printf("[Pai] %d  [Filho] %d    [i] %d\n", getppid(), getpid(), i + 1);
      _exit(i + 1);
    }
    int exit_status;
    pid_t terminated_pid = wait(&exit_status);
    printf("[ID] %d , exit code: %d\n\n", terminated_pid,
           WEXITSTATUS(exit_status));
  }
}

void ex4() {
  int i;
  int status;
  for (i = 0; i < 10; i++) {
    if (fork() == 0) {
      printf("[Pai] %d  [Filho] %d    [i] %d\n", getppid(), getpid(), i + 1);
      _exit(i + 1);
    }
  }
  for (i = 0; i < 10; i++) {
    pid_t terminated_pid = wait(&status);
    printf("[Pai] %d , exit code: %d\n", terminated_pid, WEXITSTATUS(status));
  }
}

void ex5() {
  int i = 0;
  printf("[Pai] %d;  [Filho] %d    [i] %d\n", getppid(), getpid(), i);
  printf("Vamos la criar filhos:\n\n");
  for (i = 0; i < 10; i++) {
    if (fork() == 0) {
      printf("[Pai] %d;  [Filho] %d    [i] %d\n\n", getppid(), getpid(), i + 1);
    } else {
      printf("Morri %d [i] %d\n", getpid(), i + 1);
      exit(i + 1);
    }
  }
}

int findLinha(int matrix[COLUNA], int found) {
  int fail = 0;
  for (int i = 0; i < COLUNA; i++) {
    if (matrix[i] == found)
      fail++;
  }
  return fail;
}

int findMatrix(int matrix[LINHA][COLUNA], int found) {
  int status, count = 0;

  for (int i = 0; i < LINHA; i++) {
    if (fork() == 0) {
      int fail;
      fail = findLinha(matrix[i], found);
      printf("[Pai] %d;  [Filho] %d    [i] %d\nEncontrei %d\n\n", getppid(),
             getpid(), i, fail);
      _exit(fail);
    }
  }

  for (int i = 0; i < LINHA; i++) {
    pid_t terminated_pid = wait(&status);
    count += WEXITSTATUS(status);
    printf("[Pai] %d , exit code: %d   [i] %d\n", terminated_pid,
           WEXITSTATUS(status), i);
  }

  return count;
}

void ex7(int matrix[LINHA][COLUNA], int found) {
  int status;

  for (int i = 0; i < LINHA; i++) {
    if (fork() == 0) {
      int fail = findLinha(matrix[i], found);
      _exit(fail);
    }
  }

  for (int i = 0; i < LINHA; i++) {
    wait(&status);
    int encontrou = WEXITSTATUS(status);
    if (encontrou > 0)
      printf("Linha: %d -> Encontrou %d\n", i, encontrou);
  }
}
