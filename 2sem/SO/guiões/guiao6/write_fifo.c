#include <fcntl.h>
#include <stdio.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
/* #include < */

#define MAX 1024

void write_fifo() {
  int fifo_fd = open("fifo", O_WRONLY);

  printf("Fifo is open\n");

  int bytes_read;
  char buff[MAX];

  while ((bytes_read = read(0, buff, MAX)) > 0) {
    write(fifo_fd, buff, bytes_read);
  }
}

int main(void) {
  write_fifo();
  return 1;
}
