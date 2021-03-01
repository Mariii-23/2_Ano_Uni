#ifndef __GUIAO1_H_
#define __GUIAO1_H_

#include <stdio.h>
#include <sys/types.h>

#define PATH "try.txt"
#define COPY "try2.txt"

#define MAX_BUF 1024

int my_cp(const char *source, const char *destiny);
void my_cat();
ssize_t readln(int fd, char *line, size_t size);
ssize_t readln2(int fd, char *line, size_t size);
int my_print(const char *source);

#endif // __GUIAO1_H_
