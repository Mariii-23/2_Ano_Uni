/* #include "guiao.h" */

#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <unistd.h>

void ex1() {
  int res = 0, i = 0;
  char buffer;
  char line[1024];

  int ifd = open("/etc/passwd", O_RDONLY);
  int ofd = open("saida.txt", O_CREAT | O_TRUNC | O_WRONLY, 0666);
  int efd = open("erros.txt", O_CREAT | O_TRUNC | O_WRONLY, 0666);

  res = dup2(ifd, 0);
  res = dup2(ofd, 1);
  res = dup2(efd, 2);
  /**/
  close(ifd);
  close(ofd);
  close(efd);

  int read_res;
  // setbus();

  while ((read_res = read(0, &buffer, 1)) != 0) {
    line[i] = buffer;
    i++;
    if (buffer == '\n') {
      write(1, line, i);
      write(2, line, i);
      printf("after write line \n");
      fflush(stdout);
      i = 0;
    }
  }
}

int ex2() {
  int res = 0;
  int input_fd = open("/etc/passwd", O_RDONLY);
  int output_fd = open("saida.txt", O_CREAT | O_TRUNC | O_WRONLY, 0666);
  int output_error = open("erros.txt", O_CREAT | O_TRUNC | O_WRONLY, 0666);

  res = dup2(input_fd, 0);
  // printf ("Input fd (old, new) = %d, %d \n", input_fd, res);
  res = dup2(output_fd, 1);
  res = dup2(output_error, 2);

  close(input_fd);
  close(output_error);
  close(output_fd);
  pid_t pid;
  int status;
  if ((pid = fork()) == 0) {
    int read_res;
    char buffer;
    char line[1024];
    int i = 0;
    while ((read_res = read(0, &buffer, 1)) != 0) {
      line[i] = buffer;
      i++;

      if (buffer != '\n') {
        write(1, line, i);
        write(2, line, i);
        // printf ("Hello world... \n");
        fflush(stdout);
        i = 0;
      }
    }
  } else {
    pid_t terminated_pid = wait(&status);
    if (WIFEXITED(status)) {
      printf("\n\nO filho retornou %d\n", WEXITSTATUS(status));
    } else {
      printf("\n\nO filho não retornou\n");
    }
  }
  return 0;
}

int ex3() {
  int res = 0;
  int input_fd = open("/etc/passwd", O_RDONLY);
  int output_fd = open("saida3.txt", O_CREAT | O_TRUNC | O_WRONLY, 0666);
  int output_error = open("erros3.txt", O_CREAT | O_TRUNC | O_WRONLY, 0666);

  res = dup2(input_fd, 0);
  // printf ("Input fd (old, new) = %d, %d \n", input_fd, res);
  res = dup2(output_fd, 1);
  res = dup2(output_error, 2);

  close(input_fd);
  close(output_error);
  close(output_fd);

  res = execlp("wc", "/bin/wc", NULL);
  return 0;
}

int ex4() {
  int res = 0;
  int input_fd = open("/etc", O_RDONLY);
  int output_fd = open("saida4.txt", O_CREAT | O_TRUNC | O_WRONLY, 0666);
  int output_error = open("erros4.txt", O_CREAT | O_TRUNC | O_WRONLY, 0666);

  res = dup2(input_fd, 0);
  res = dup2(output_fd, 1);
  res = dup2(output_error, 2);

  close(input_fd);
  close(output_error);
  close(output_fd);

  res = execlp("wc", "/bin/wc", NULL);
  return 0;
}

int main(void) {
  ex1();
  ex2();
  ex3();
  ex4();
  return 0;
}
