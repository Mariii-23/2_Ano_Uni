#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h> /* chamadas wait*() e macros relacionadas */
#include <unistd.h>

#include <signal.h>

int ex2() {
  char *commands = "ls";
  int pipeP[2];
  int status;
  status = pipe(pipeP);
  if (status < 0)
    perror("Nope1\n");

  size_t pii, pi;
  if ((pi = fork()) == 0) {
    close(pipeP[0]);
    dup2(pipeP[1], 1);
    execlp("ls", "ls", NULL);
    close(pipeP[1]);
    exit(0);
  }
  if ((pii = fork()) == 0) {
    // Processo filho 2
    // Lê do pipe e faz wc
    close(pipeP[1]);
    dup2(pipeP[0], 0);
    execlp("wc", "wc", "-l", NULL);
    close(pipeP[0]);
    exit(0);
  }
  return 0;
}

/* Parte 2 */
int exec_mail(char *name) {
  char *mail = "@alunos.uminho.pt";
  /* strcat(name, mail); */
  char *enviar = malloc(sizeof(char) * 320);
  sprintf(enviar, "%s%s\n", name, mail);
  execl("mail", "mail", "Sistemas_Operativos", enviar);
  return 1;
}

ssize_t readln(int fd, char *line, size_t size) {
  ssize_t i = 0;
  ssize_t bytes_read;
  while (i < size && (bytes_read = read(fd, &line[i], 1)) > 0 &&
         line[i] != '\n')
    i++;
  line[i++] = '\n';
  return i;
}

#define MAX 10

int parte2(char *filename) {
  int pip[2];
  int fd_in = open("alunos.txt", O_RDONLY);
  if (fd_in == -1) {
    perror("erro");
  }
  if (pipe(pip) < 0) {
    perror("erro");
  }
  char buffer[MAX];

  for (int i = 0; i < 10; i++) {
    lseek(fd_in, i * 10, SEEK_CUR);
    switch (fork()) {
    case (-1):
      perror("erro");
      break;

    case 0:
      while (readln(fd_in, buffer, MAX) > 0) {
        char *name = strndup(buffer, 6);
        char *nota = strndup(buffer + 7, 3);
        int pid;
        if ((pid = fork()) == 0) {
          close(pip[1]);
          dup2(pip[0], 0);
          execlp("./mail", "./mail", "SistemasOperatiovs", name, NULL);
          close(pip[0]);
          exit(0);
        }
        close(pip[0]);

        dup2(pip[1], 1);
        close(pip[1]);
        sleep(2);
        char *enviar = strcat(name, strcat(nota, " "));
        write(pip[1], enviar, sizeof(char) * strlen(enviar));
        // mandar kill
        sleep(2);
        kill(pid, SIGINT);
        wait(NULL);
        lseek(fd_in, 90, SEEK_CUR);
      }
      exit(0);
      break;

    case 1:
      wait(NULL);
      break;
    default:
      break;
    }
  }
  return 0;
}

// parte 3
int counter(char *padrao) {
  int counter = 0;
  int pip[2];

  if (pipe(pip) < 0) {
    perror("erro");
    return -1;
  }

  while (1) {
    for (int i = 0; i < 8; i++) {
      if (fork() == 0) {
        dup2(pip[1], 1);
        close(pip[0]);
        execlp("patgrep", "patgrep", padrao, NULL);
        close(pip[1]);
        exit(-1);
      }
    }
    close(pip[1]);
    dup2(pip[0], 0);

    char buff[128];
    int bytes_read;
    while ((bytes_read = read(pip[0], buff, 128)) > 0) {
      for (int j = 0; j < bytes_read; j++) {
        if (buff[j] == 'X')
          counter++;
      }
    }
    close(pip[0]);

    for (int i = 0; i < 8; i++) {
      wait(NULL);
    }
  }

  /* write(STDIN_FILENO, atoi(counter), sizeof(atoi(counter))); */

  return counter;
}

#define MAXX 1024
// fuck this
int paginas(char *args, int N) {
  /* char *comandos[N]; */
  char *comandos[] = {"ls", "find", "df", "ls", "find"};
  N = 5;

  int pip[N][2];
  for (int l = 0; l < N; l++)
    if (pipe(pip[l]) < 0)
      perror("erro");

  for (int i = 0; i < N; i++) {
    if (fork() == 0) {
      close(pip[i][0]);
      dup2(pip[i][1], 1);
      close(pip[i][1]);
      execlp(comandos[i], comandos[i], NULL);
      exit(0);
    }

    close(pip[i][1]);
    int bytes_read;
    int count = 0;
    char buff[MAXX];
    int j;
    while (count < 10) {
      j = 0;
      while (count < 10 && (bytes_read = read(pip[i][0], &buff[j], 1)) > 0 &&
             buff[j] != '\n')
        j++;
      buff[j++] = '\n';
      if (bytes_read == 0)
        break;
      write(STDOUT_FILENO, buff, j);
      /* write(STDIN_FILENO, buff, j); */
      count++;
    }

    while ((bytes_read = read(pip[i][0], &buff[j], 1)) > 0 && buff[j] != EOF)
      j++;
    close(pip[i][0]);
  }
  while (wait(NULL) != -1)
    ;
  return 1;
}

// filtro e pesquisa
/* int filtroEexiste(int n){} */

int main(void) {
  /* parte2("alunos.txt"); */
  paginas("fuck this", 2);
  return 1;
}
