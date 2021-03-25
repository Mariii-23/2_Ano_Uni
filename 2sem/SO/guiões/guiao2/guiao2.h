#ifndef __GUIAO2_H_
#define __GUIAO2_H_

/* pid_t getpid(void); */
/* pid_t getppid(void); */
/* pid_t fork(void); */
/* void _exit(int status); */
/* pid_t wait(int *status); */
/* pid_t waitPID(pid_t pid, int *status, int options); */
/* int WIFEXITED(int status); /\* macro *\/ */
/* int WEXITSTATUS(int status); /\* macro *\/ */

#define COLUNA 100000
#define LINHA 10

void ex1();
void ex2();
void ex3();
void ex4();
void ex5();
int findMatrix(int matrix[LINHA][COLUNA], int found);
void ex7(int matrix[LINHA][COLUNA], int found);

#endif // __GUIAO2_H_
