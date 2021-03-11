#include <assert.h>
#include <ctype.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>

#include "guiao1.h"

void print_file(char *name_in, int fd_out) {
  void *buffer = malloc(MAX_BUFFER);
  int fd_in;
  ssize_t bytes_read;

  if ((fd_in = open(name_in, O_RDONLY)) == -1) {
    perror("Open File source");
    return;
  }

  while ((bytes_read = read(fd_in, buffer, MAX_BUFFER)) > 0)
    write(fd_out, buffer, bytes_read);

  close(fd_in);
  close(fd_out);
  free(buffer);
}

// arroz.. nao da
char **to_buffer(char *name) {
  int fd, max = MAX_BUFFER;
  char *buffer = malloc(MAX_BUFFER);
  char **result = malloc(MAX_BUFFER * sizeof(char *));
  int N = 0;
  ssize_t bytes_read;

  if ((fd = open(name, O_RDONLY)) == -1) {
    perror("Open File source");
    return NULL;
  }

  while ((bytes_read = read(fd, buffer, MAX_BUFFER)) > 0) {

    if (N >= max) {
      max *= 2;
      result = realloc(result, max * sizeof(char *));
    }
    /* result[N++] = buffer; */
    write((*result[N++]), buffer, bytes_read);
    /* buffer = malloc(MAX_BUFFER); */
  }

  close(fd);
  free(buffer);

  return result;
}

REVIEW *to_review(int fd) {
  char buffer[MAX_BUFFER];
  REVIEW *self = (REVIEW *)malloc(sizeof(REVIEW));
  ssize_t bytes_reads;

  if ((bytes_reads = read(fd, &self, sizeof(REVIEW))) > 0) {
    char *buff2 = buffer;

    strcpy(self->review_id, strsep(&buff2, ";"));
    strcpy(self->user_id, strsep(&buff2, ";"));
    strcpy(self->business_id, strsep(&buff2, ";"));
    self->stars = atoi(strsep(&buff2, ";"));
    self->useful = atoi(strsep(&buff2, ";"));
    self->funny = atoi(strsep(&buff2, ";"));
    self->cool = atoi(strsep(&buff2, ";"));
  }
  free(buffer);

  return self;
}

CSVREVIEW *all_review(char *name) {
  int fd;
  if ((fd = open(name, O_RDWR)) == -1) {
    perror("open");
    return NULL;
  }

  CSVREVIEW *all, *ei = all;
  REVIEW *self;

  while ((self = to_review(fd)) != NULL) {
    ei = (CSVREVIEW *)malloc(sizeof(struct CSVReview));
    ei->self = self;
    ei = ei->next;
  }

  close(fd);

  return all;
}
