#include <fcntl.h>
#include <stdio.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
/* #include < */

#define MAX 1024
// nao é suposto ser isto
void read_fifo() {
  int fifo_fd = open("fifo", O_RDONLY);
  int file_fd = open("file.txt", O_WRONLY);

  printf("Fifo is open\n");

  int bytes_read;
  char buff[MAX];

  while ((bytes_read = read(fifo_fd, buff, MAX)) > 0) {
    write(file_fd, buff, bytes_read);
  }
}

int main(void) {
  read_fifo();
  return 1;
}
