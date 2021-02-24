#include "guiao1.h"
#include <sys/types.h>
/* chamadas ao sistema: defs e decls essenciais */
#include <unistd.h>
/* O_RDONLY, O_WRONLY, O_CREAT, O_* */
#include <fcntl.h>

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_BUF 1024

int my_cp(const char *source, const char *destiny) {
  int failed = 0;

  /* buffer */
  void *buffer = malloc(MAX_BUF);

  /* Open files */
  int fd_source, fd_destiny;

  if ((fd_source = open(source, O_RDONLY)) == -1) {
    perror("open");
    return failed;
  }

  if ((fd_destiny = open(destiny, O_WRONLY | O_CREAT | O_TRUNC, 0640)) == -1) {
    perror("open");
    return failed;
  }

  int bytes_read;
  /* Write  */
  while ((bytes_read = read(fd_source, buffer, MAX_BUF)) > 0)
    write(fd_destiny, buffer, bytes_read);

  /* Close Files and free the buffer */
  close(fd_source);
  close(fd_destiny);
  free(buffer);

  return !failed;
}

void my_cat() {
  void *buffer = malloc(MAX_BUF);
  int bytes_read, failed = 0;

  while (!failed) {
    /* Save what you wrote in the buffer */
    bytes_read = read(STDIN_FILENO, buffer, MAX_BUF);
    /* Write in the prompt what was saved in the buffer */
    write(STDOUT_FILENO, buffer, bytes_read);
    /* Stop case */
    if ((strcmp(buffer, "exit\n") == 0) || (strcmp(buffer, "Exit\n") == 0))
      failed = 1;
  }

  free(buffer);
}

ssize_t readln(int fd, char *line, size_t size) {
  ssize_t failed = 0;
  char *line_aux = malloc(size * sizeof(char));

  return failed;
}

int my_print(const char *source) {
  int failed = 0;
  /* buffer */
  void *buffer = malloc(MAX_BUF);

  int fd_source;
  /* Open file */
  if ((fd_source = open(source, O_RDONLY)) == -1) {
    perror("open");
    return failed;
  }

  int bytes_read;
  /* Write in the prompt  */
  while ((bytes_read = read(fd_source, buffer, MAX_BUF)) > 0)
    write(STDOUT_FILENO, buffer, bytes_read);

  /* Close Files and free the buffer */
  close(fd_source);
  free(buffer);
  return !failed;
}
