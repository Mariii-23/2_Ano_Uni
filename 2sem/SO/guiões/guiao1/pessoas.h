#ifndef __PESSOAS_H_
#define __PESSOAS_H_

#include <assert.h>
#include <stddef.h>
#include <stdint.h>
#include <stdlib.h>

#define FILE_PATH "data.txt"

typedef struct person {
  char *name;
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
#endif // __PESSOAS_H_
