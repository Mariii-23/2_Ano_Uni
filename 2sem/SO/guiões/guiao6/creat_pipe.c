#include <stdio.h>
#include <sys/stat.h>
#include <sys/types.h>

#define NAME "fifo"

int creates_fifo() {
  if (mkfifo(NAME, 0664) < 0) {
    perror("Algo errado aconteceu");
    return -1;
  }
  printf("FiFo created\n");
  return 1;
}

int main(void) { return creates_fifo(); }
