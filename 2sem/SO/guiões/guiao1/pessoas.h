#ifndef __PESSOAS_H_
#define __PESSOAS_H_
#define _BSD_SOURCE
#include "guiao1.h"
#include <sys/types.h>
/* chamadas ao sistema: defs e decls essenciais */
#include <unistd.h>
/* O_RDONLY, O_WRONLY, O_CREAT, O_* */
#include <assert.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define FILE_PATH "data.txt"

typedef struct person {
  char name[100];
  int age;
} Person;

typedef struct dynamic {
  Person *people;
  size_t used;
  size_t size;
} Dynamic;

size_t dynamic_size(Dynamic const *self);

size_t dynamic_used(Dynamic const *self);

Person *dynamic_people(Dynamic const *self);

size_t change_size(Dynamic *self, size_t size);

Person dynamic_index(Dynamic const *self, size_t index);
size_t dynamic_pop(Dynamic *self);
void dynamic_push(Dynamic *self, Person pessoa);

void dynamic_free(Dynamic *self);
void main_pessoas(int N, char *argv[]);

void added_name_age(char *age, char *name);
void change_age(char *age, char *name);
void print_pessoas();
#endif // __PESSOAS_H_
