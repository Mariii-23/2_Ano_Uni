/* #include "heaps.h" */

#include <stdio.h>
#include <stdlib.h>

void swap(int *array, int x, int y) {
  int aux = (array[x]);
  array[x] = array[y];
  array[y] = aux;
}

void bubble_up(int h[], int N) {
  int p = (N - 1) / 2;
  while (N > 0 && h[N] < h[p]) {
    swap(h, p, N);
    N = p;
    p = (N - 1) / 2;
  }
}

void bubble_down(int h[], int N) {
  int i = 0, f;
  while (2 * i + 2 < N) {
    if (h[2 * i + 1] < h[2 * i + 2]) {
      f = 2 * i + 1;
    } else
      f = 2 * i + 2;
    if (h[i] <= h[f])
      break;
    swap(h, i, f);
    i = f;
  }
  if (2 * i + 1 < N && h[i] > h[2 * i + 1])
    swap(h, i, i * 2 + 1);
}

typedef struct btree {
  int root;
  struct btree *left, *right;
} * Btree;

Btree add(Btree t, int x) {
  if (!t) {
    t = calloc(1, sizeof(struct btree));
    t->root = x;
  } else if (x > t->root) {
    t->left = add(t, x);
  } else if (x < t->root)
    t->right = add(t, x);
  return t;
}

Btree search(Btree t, int x) {
  while (t && x != t->root) {
    if (t->root > x)
      t = t->left;
    else
      t = t->right;
  }
  return t;
}

/* Arvores equilibrada */
/* |nº elemnetos da esquerda - nº elemnetos da direita|<=1 */

/* Arvores balanceadas */
/* |altura da esquerda - altura da direita|<=1 */

typedef struct btree_ {
  int root;
  int bal;
  struct btree_ *left, *right;
} * Btree_;

/* bal */
#define L (-1)
#define B (0)
#define R (+1)

Btree_ rotate_left(Btree_ t) {
  Btree_ b = t->left;
  t->right = b->left;
  b->left = t;
  return b;
}

Btree_ rotate_right(Btree_ t) {
  Btree_ b = t->right;
  t->left = b->right;
  b->right = t;
  return b;
}

typedef int TreeEntry;
typedef enum balancefactor { LH, EH, RH } BalanceFactor;

struct treenode {
  BalanceFactor bf;
  TreeEntry entry;
  struct treenode *left;
  struct treenode *right;
};

typedef struct treenode *Tree;

/* Adicionar um elemento a uma arvore, sem ter a certeza q ainda se */
/*   encontra equilibrada */
Tree insertTree_(Tree t, TreeEntry e) {
  if (t == NULL) {
    t = (Tree)malloc(sizeof(struct treenode));
    t->entry = e;
    t->right = t->left = NULL;
  } else if (e > t->entry)
    t->right = insertTree_(t->right, e);
  else
    t->left = insertTree_(t->left, e);
  return t;
}

// requires:
// (t != NULL) && (t->right != NULL)
//
/* Tree balanceRight(Tree t) { */
/*   if (t->right->bf == RH) { */
/*     // Rotacao simples, caso 3a */
/*     t = rotateLeft(t); */
/*     t->bf = EH; */
/*     t->left->bf = EH; */
/*   } else { */
/*     // Dupla rotação, caso 3b */
/*     t->right = rotateRight(t->right); */
/*     t = rotateLeft(t); */
/*     switch (t->bf) { */
/*     case EH: */
/*       t->left->bf = EH; */
/*       t->right->bf = EH; */
/*       break; */
/*     case LH: */
/*       t->left->bf = EH; */
/*       t->right->bf = RH; */
/*       break; */
/*     case RH: */
/*       t->left->bf = LH; */
/*       t->right->bf = EH; */
/*     } */
/*     t->bf = EH; */
/*   } */
/*   return t; */
/* } */

Tree balanceRight(Tree t) { return NULL; }
Tree balanceLeft(Tree t) { return NULL; }
int treeHeight(Tree t) { return 0; }

Tree insertTree(Tree t, TreeEntry e, int *cresceu) {

  if (t == NULL) {
    t = (Tree)malloc(sizeof(struct treenode));
    t->entry = e;
    t->right = t->left = NULL;
    t->bf = EH;
    *cresceu = 1;
  } else if (e > t->entry) {
    t->right = insertTree(t->right, e, cresceu);
    if (*cresceu) {
      switch (t->bf) {
      case LH:
        t->bf = EH;
        *cresceu = 0;
      case EH:
        t->bf = RH;
        *cresceu = 1;
      case RH:
        t = balanceLeft(t);
        *cresceu = 0;
      }
    }
  } else {
    t->left = insertTree(t->left, e, cresceu);
    if (*cresceu) {
      if (*cresceu) {
        switch (t->bf) {
        case LH:
          t = balanceRight(t);
          *cresceu = 0;
        case EH:
          t->bf = LH;
          *cresceu = 1;
        case RH:
          t->bf = EH;
          *cresceu = 0;
        }
      }
    }
  }
  return t;
}

/* Altura de uma arvore,em tempo $$\Theta(N)$$ */
int nonAVL_treeHeight(Tree t) {
  int l, r;
  if (t == NULL)
    return 0;
  l = nonAVL_treeHeight(t->left);
  r = nonAVL_treeHeight(t->right);
  if (l > r)
    return l + 1;
  else
    return r + 1;
}

/* Testar se uma árvore binária é ou não AVL */
/* Pior caso Θ(N) */
/* Melhor caso Θ(1) */
int isAVL(Tree t) {
  int l, r;
  if (t == NULL)
    return 1;

  l = treeHeight(t->left);
  r = treeHeight(t->right);

  return (abs(l - r) <= 1 && isAVL(t->left) && isAVL(t->right));
}

// altura da árvore será colocada em *p
int isAVL_aux(Tree t, int *p) {
  int r, l;
  if (t == NULL)
    return *p = 0;
  l = isAVL(t->left);
  r = isAVL(t->right);
  (l > r) ? (*p = l + 1) : (*p = r + 1);
  return *p;
}

int isAVL_opt(Tree a) {
  int p;
  return (isAVL_aux(a, &p));
}
