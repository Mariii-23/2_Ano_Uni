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
void ex1() {
    printf("[Pai] %d  [Filho] %d \n", getppid(), getpid());
}

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
            printf(
                "[Pai] %d  [Filho] %d    [i] %d\n", getppid(), getpid(), i + 1);
            _exit(i + 1);
        }
        int exit_status;
        pid_t terminated_pid = wait(&exit_status);
        printf(
            "[ID] %d , exit code: %d\n\n",
            terminated_pid,
            WEXITSTATUS(exit_status));
    }
}

void ex4() {
    int i;
    int status;
    for (i = 0; i < 10; i++) {
        if (fork() == 0) {
            printf(
                "[Pai] %d  [Filho] %d    [i] %d\n", getppid(), getpid(), i + 1);
            _exit(i + 1);
        }
    }
    for (i = 0; i < 10; i++) {
        pid_t terminated_pid = wait(&status);
        printf(
            "[Pai] %d , exit code: %d\n", terminated_pid, WEXITSTATUS(status));
    }
}

// tem erros
void ex5() {
    int i = 0;
    int status;
    printf("[Pai] %d;  [Filho] %d    [i] %d\n", getppid(), getpid(), i);
    printf("Vamos la criar filhos:\n");
    for (i = 0; i < 10; i++) {
        if (fork() == 0) {
            printf(
                "[Pai] %d;  [Filho] %d    [i] %d\n",
                getppid(),
                getpid(),
                i + 1);
        }
        else {
            pid_t terminated_pid = wait(&status);
            printf(
                "[Pai] %d , exit code: %d   [i] %d\n",
                terminated_pid,
                WEXITSTATUS(status),
                i + 1);
            exit(0);
        }
    }
    wait(NULL);
}
