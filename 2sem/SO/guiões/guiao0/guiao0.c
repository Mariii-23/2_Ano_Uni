#include "guiao0.h"
#include <stdlib.h>

void fill(int *vector, int size, int value) {
  for (int i = 0; i < size; i++)
    vector[i] = value;
}

int find(int *vector, int size, int value) {
  int failed = -1, i;
  for (int i = 0; failed == -1 && i < size; i++) {
    if (*(vector + i) == value)
      failed = i;
  }
  return failed;
}
