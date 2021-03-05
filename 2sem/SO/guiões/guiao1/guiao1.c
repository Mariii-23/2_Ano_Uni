#include "guiao1.h"
#include <sys/types.h>
/* chamadas ao sistema: defs e decls essenciais */
#include <unistd.h>
/* O_RDONLY, O_WRONLY, O_CREAT, O_* */
#include <fcntl.h>

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

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
  ssize_t i = 0;
  ssize_t bytes_read;
  while (i < size && (bytes_read = read(fd, &line[i], 1)) > 0 &&
         line[i] != '\n')
    i++;
  line[i++] = '\n';
  return i;
}

/* Mudar ????? */
ssize_t readln2(int fd, char *line, size_t size) {
  ssize_t bytes_read = read(fd, line, size);

  size_t line_len;
  for (line_len = 0; line[line_len] != '\n' && line_len < bytes_read;
       line_len++)
    ;
  line[line_len++] = '\n';

  lseek(fd, line_len - bytes_read, SEEK_CUR);
  /* lseek(fd, line_len, SEEK_CUR); */
  return line_len;
}

/* Prof */
ssize_t readl3(int fd_in, int fd_out) {
  ssize_t bytes_read;
  char *buffer = (char *)malloc(MAX_BUF * sizeof(char));
  int new_line = 1;
  char line_number[10];
  int line_counter = 0;

  while ((bytes_read = readln(fd_in, buffer, MAX_BUF)) > 0) {
    char line_number[10] = "";
    // nl skips empty lines
    if (new_line && buffer[0] != '\n') {
      snprintf(line_number, 10, "%d:", line_counter);
      write(fd_out, line_number, sizeof(line_number));
      line_counter++;
    }
    write(fd_out, buffer, bytes_read);

    // buffer was not big enougth to hold the whole line
    // continue reading the line
    if (buffer[bytes_read - 1] != '\n')
      new_line = 0;
    else
      new_line = 1;
  }
  return 0;
}

/* ssize_t readc(int fd, char *buffer) { */

/*   if (read_buffer_pos == read_buffer_end) { */
/*     read_buffer_end = read(fd, read_buffer, MAX_BUF); */
/*     switch (read_buffer_end) { */
/*     case -1: */
/*       perror("read:"); */
/*       return -1; */
/*       break; */
/*     case 0: */
/*       return 0; */
/*       break; */
/*     default: */
/*       read_buffer_pos = 0; */
/*     } */
/*   } */
/*   *buffer = read_buffer[read_buffer_pos]; */
/*   read_buffer_pos++; */

/*   return 1; */
/* } */

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
