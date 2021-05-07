/* #include "servidor.h" */
#include <fcntl.h>
#include <stdio.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

#define SERVIDOR "servidor"
#define NAME "log.txt"
#define MAX 1024

int creates_fifo() {
  if (mkfifo(SERVIDOR, 0664) < 0) {
    perror("Algo errado aconteceu");
    return -1;
  }
  printf("FiFo created\n");
  return 1;
}

void write_fifo() {
  int fifo_fd = open(SERVIDOR, O_WRONLY);
  /* int file_fd = open(NAME, O_WRONLY); */

  printf("Fifo is open\n");

  int bytes_read;
  char buff[MAX];

  while ((bytes_read = read(0, buff, MAX)) > 0) {
    /* write(file_fd, buff, bytes_read); */
    write(fifo_fd, buff, bytes_read);
  }
}

void read_fifo() {
  int fifo_fd = open(SERVIDOR, O_RDONLY);

  printf("Fifo is open\n");

  int bytes_read;
  char buff[MAX];

  while ((bytes_read = read(0, buff, MAX)) > 0) {
    write(0, buff, bytes_read);
  }
}

int main(void) {}
