
#include <malloc.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define N1 5

typedef struct edge {
  int dest;
  struct edge *prox;
} Edge;
typedef Edge *Graph[N1];

Graph *inicia(int m[][2], int N, int v) {
  Graph *g = calloc(1, v * sizeof(struct edge));
  Edge *p;
  for (int i = 0; i < N; i++) {
    for (p = g[m[i][0]]; p; p = p->prox)
      ;
    p = calloc(1, sizeof(struct edge));
    p->dest = m[i][1];
  }

  return g;
}

typedef struct btree {
  int node;
  struct btree *left, *right;
} * BTree;

int aux(BTree a, int alt) {
  int r = 0, l = 0, failed = -1;
  if (!a)
    return (0);
  if (alt == -1)
    return failed;

  l = aux(a->right, alt + 1);
  r = aux(a->left, alt + 1);

  if (r == -1 || l == -1)
    return failed;

  if (abs(l - r) <= 1)
    alt = l > r ? (l + 1) : (r + 1);
  else
    alt = failed;
  return alt;
}

int test(BTree a) {
  int r, l;
  if (!a)
    return 1;
  if (aux(a, 0) != -1)
    return 0; /* Não satisfaz a condição. */
  else
    return 1;
}
