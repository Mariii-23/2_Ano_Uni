#include "pessoas.h"
#include "guiao1.h"
#include <sys/types.h>
/* chamadas ao sistema: defs e decls essenciais */
#include <unistd.h>
/* O_RDONLY, O_WRONLY, O_CREAT, O_* */
#include <assert.h>
#include <ctype.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>

#define PATH_FILE "pessoas.txt"

/* Dynamic Arrays */
size_t dynamic_size(Dynamic const *self) { return self->size; }

size_t dynamic_used(Dynamic const *self) { return self->used; }
Person *dynamic_people(Dynamic const *self) { return self->people; }

size_t change_size(Dynamic *self, size_t size) { return (self->size = size); }

Person dynamic_index(Dynamic const *self, size_t index) {
  assert(index < dynamic_used(self));
  return self->people[index];
}

size_t dynamic_pop(Dynamic *self) {
  assert(dynamic_used(self) > 0);
  return --self->used;
}

void dynamic_push(Dynamic *self, Person pessoa) {
  if (dynamic_used(self) == dynamic_size(self)) {
    change_size(self, dynamic_size(self) == 0 ? 1 : dynamic_size(self) * 2);
    self->people = realloc(dynamic_people(self), self->size * sizeof(Person));
  }
  self->people[dynamic_used(self)] = pessoa;
  self->used++;
}

void dynamic_free(Dynamic *self) {
  free(self->people);
  free(self);
}

void added_person(Person self) {
  int fd;
  if ((fd = open(PATH_FILE, O_WRONLY | O_CREAT | O_TRUNC, 0640)) == -1) {
    perror("open");
    return;
  }

  char buffer[MAX_BUF];
  snprintf(buffer, sizeof(buffer), "%s;%d\n", self.name, self.age);
  /* asprintf(&buffer, "%s %d", self.name, self.age); */
}

Person *initialize_person(int age, char *name) {
  Person *self = (Person *)malloc(sizeof(struct person));
  /* algo */
  strcpy(self->name, name);
  self->age = age;

  return self;
}

void added_name_age(char *age, char *name) {
  int fd;
  if ((fd = open(PATH_FILE, O_WRONLY | O_CREAT | O_APPEND, 0640)) == -1) {
    perror("open");
    return;
  }

  Person *self = initialize_person(atoi(age), name);

  /* size -> tamanho do buffer da idade e do nome - 2( \n desses buffer )
   *          + char ";" + \n */
  /* char buffer[sizeof(age) + sizeof(name) - 2 + sizeof(char) + 1]; */
  /* char buffer[MAX_BUF]; */
  /* snprintf(buffer, sizeof(buffer), "%s;%s\n", name, age); */
  if (write(fd, self, sizeof(*self)) < 1) {
    puts("ERROR: Não foi possivel adicionar1n.");
    close(fd);
    return;
  }

  struct stat st;
  fstat(fd, &st);
  off_t filesize = st.st_size;
  int pos = (int)filesize / sizeof(struct person);
  printf("Pessoa adicionada. Registo: %d\n", pos);
  close(fd);
  /* asprintf(&buffer, "%s %d", self.name, self.age); */
}

void change_age(char *age, char *name) {
  int fd, end = 0;
  if ((fd = open(PATH_FILE, O_RDWR)) == -1) {
    perror("open");
    return;
  }
  char buffer[MAX_BUF];
  Person self;
  ssize_t bytes_reads;
  while (!end && (bytes_reads = read(fd, &self, sizeof(Person))) > 0) {
    /* char *buff2 = buffer; */
    /* char *name_ = strsep(&buff2, ";"); */
    /* char *age_ = strsep(&buff2, ";"); */
    if (strcmp(self.name, name) == 0) {
      /* char buffer[sizeof(age) + sizeof(name) - 2 + sizeof(char) + 1]; */
      /* char buffer[MAX_BUF]; */
      /* snprintf(buffer, sizeof(buffer), "%s;%s\n", name, age); */
      self.age = atoi(age);
      lseek(fd, -bytes_reads, SEEK_CUR);
      write(fd, &self, sizeof(self));
      end = 1;
    }
  }
  close(fd);
}

void print_pessoas() {
  int fd;
  if ((fd = open(PATH_FILE, O_RDWR)) == -1) {
    perror("open");
    return;
  }
  char buffer[MAX_BUF];
  Person self;
  ssize_t bytes_reads;
  while ((bytes_reads = read(fd, &self, sizeof(Person))) > 0) {
    printf("%s;%d\n", self.name, self.age);
  }
  close(fd);
}

/* funcoes feitas pelo stor */

/* Program */
void main_pessoas(int N, char *argv[]) {

  switch (argv[0][1]) {
  case 'i':
    /* acrscentar pessoa */
    break;
  case 'u':
    /* atualizar idade */
    break;
  default:
    printf("Something went wrong");
    break;
  }
}
