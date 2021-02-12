/* #include "exercicios.h" */
#include <malloc.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define COUNT 10

#define LEFT 1
#define BAL 0
#define RIGHT -1

#define Livre 0
#define Ocupado 1
#define Apagado 2

/* 1. */
#define SIZE 1009
typedef struct no {
  char matricula[6];
  struct no *next;
} No;
typedef No *Tabela[SIZE];

int hash_(char matricula[6]) {
  int sum;
  for (int i = 0; matricula[i] != '\0' && i < 6; sum += matricula[i++])
    ;
  return sum % SIZE;
}

int insert_(Tabela t, char matricula[6]) {
  int sucess = 0, key;
  key = hash_(matricula);

  if (!t)
    t = calloc(1, SIZE * sizeof(struct no));
  No *ola = t[key];
  while (!sucess && ola) {
    sucess = !strcmp(ola->matricula, matricula);
    ola = ola->next;
  }
  if (!sucess && ola == NULL) {
    ola = malloc(sizeof(No));
    strcpy(ola->matricula, matricula);
    ola->next = NULL;
    sucess = 1;
  }
  return sucess;
}

/* 29.
 * feito na 39 */

/* 30 */
typedef struct nodo {
  int valor;
  int altura;
  struct nodo *esq, *dir;
} Node, *AVL30;

AVL30 rotateLeft(AVL30 a) {
  AVL30 aux = a->esq;
  a->esq = aux->dir;
  aux->dir = a;
  a->altura = (a->altura == RIGHT) ? BAL : LEFT;
  aux->altura = (aux->altura == RIGHT) ? BAL : LEFT;
  return aux;
}

/* 31. */
typedef struct key *Key;
struct celula {
  Key k;
  void *info;
  int estado; // Livre/Ocupado/Apagado
};

typedef struct shash {
  int tamanho, ocupados, apagados;
  struct celula *Tabela;
} * THash;

/* faz algo */
int hash31(Key key, int n) { return n; }

void remApagados(THash h) {
  int key, tamanho = h->tamanho;
  int i = 0, j, k, cont, failed;

  for (i = 0; i < h->tamanho; i++) {
    if (h->Tabela[i].estado == Apagado) {
      key = hash31(h->Tabela[i].k, tamanho);
      cont = 0;
      for (j = i, k = i, failed = 0;
           failed < tamanho && (h->Tabela[k + 1].estado != Livre);
           k = (k + 1) % tamanho) {
        if (hash31(h->Tabela[k + 1].k, tamanho) == key) {
          h->Tabela[j] = h->Tabela[k + 1];
          j += cont;
          cont = 0;
        } else {
          cont++;
          j = (j + 1) % tamanho;
        }
      }
      h->Tabela[j].estado = Livre;
    }
  }
  h->apagados = 0;
}

/* 32.
 *
 * procura(12)-> hash:1 :
 *   * posicoes percorridas: 1, 2
 *   * return -1
 *
 * procura(37)-> hash:4 :
 *   * posicoes percorridas: 4, 5, 6, 7, 8, 9, 10
 *   * return -1
 *
 * */

/* 38. */
/* a) final:
**             2
**          /     \
**         13     12
**        /  \    / \
**       50  20  42 36
*/

/* b) ??? */

/* 39. */
typedef struct avlnode {
  int value;
  int bal; // Left/Bal/Right
  struct avlnode *left, *right;
} * AVLTree;

/* a.
 *
 * Melhor caso -> Quando a arvore se encontra em equilibrio
 * T(N) = N
 * Pior caso -> A arvore apresenta um lado maior que o outro
 * T(N) = N
 * Caso Medios: sum i=1 to N , 2^i * k
 * */

/*b) */
int deepest(AVLTree arv) {
  AVLTree l = arv;
  if (!l)
    return 0;
  int count = 1;
  while (l && ((l->bal == BAL && l->right) || l->bal != BAL)) {
    l = l->bal == LEFT ? l->left : l->right;
    count++;
  }
  return count;
}
/*
 * Melhor caso -> Quando a arvore se encontra em equilibrio
 * T(N) = log_2(N)
 * Pior caso -> A arvore apresenta um lado maior que o outro
 * T(N) = log_2(N) + 1
 * Caso Medio -> sum i=0 to log_2(N), i + k
 * */

/* 40. */
#define HSIZE40 1000

/* fazer algo */
int hash40(int chave, int size) { return 0; }

typedef struct lista {
  int valor;
  struct lista *prox;
} * HashChain40[HSIZE40];

typedef struct celula40 {
  int estado; // 0 - Livre
  // 1 - Ocupado
  // 2 - Removido
  int valor;
} HashOpen40[HSIZE40];

int linear_probing(HashOpen40 h, int key) {
  int p = hash40(key, HSIZE40);
  int i;
  for (i = 0; i < HSIZE40 && h[p].estado == 1; i++, p = (p + 1) % HSIZE40)
    ;
  if (i == HSIZE40)
    p = -1;
  return p;
}

int fromChain(HashChain40 h1, HashOpen40 h2) {
  int sucess = 1, i, j;

  for (i = 0; i < HSIZE40; i++)
    h2[i].estado = 0;

  for (i = 0; sucess && i < HSIZE40; i++) {
    for (struct lista *l = h1[i]; sucess && l; l = l->prox) {
      j = linear_probing(h2, l->valor);
      if (j == -1)
        sucess = 0;
      else {
        h2[i].estado = 1;
        h2[i].valor = l->valor;
      }
    }
  }

  return sucess;
}

/* 41 */
#define Hsize41 13
#define FREE41 0
#define USED41 1
#define DELETED41 2
typedef struct entry41 {
  int key;
  int probec;
  int status;
} Entry41;
typedef Entry41 Thash41[Hsize41];

int hash41(int t) { return (t % Hsize41); }

/* TABELA
**   |-------------------------|
**   | Key  | Probec | STATUS  |
**   |-------------------------|
**  0| 260  |  0     | USED    |
**  1| 40   |  0     | USED    |
**  2| 80   |  0     | USED    |
**  3| 54   |  1     | USED    |
**  4| 65   |  4     | USED    |
**  5|      |        | FREE    |
**  6|      |        | FREE    |
**  7|      |        | FREE    |
**  8| 60   |  0     | USED    |
**  9|      |        | FREE    |
** 10| 140  |  0     | USED    |
** 11|      |        | FREE    |
** 12|      |        | FREE    |
** 13|      |        | FREE    |
**   |-------------------------|
*/

/* 42. */

#define LEFT 1
#define BAL 0
#define RIGHT -1
typedef struct avl42 {
  int value;
  int bal;
  struct avl42 *left, *right;
} * AVL42;

AVL42 maisProfundo(AVL42 l) {
  if (!l)
    return NULL;
  else if (l && !l->right && !l->left)
    return l;
  else {
    switch (l->bal) {
    case LEFT:
      maisProfundo(l->left);
      break;
    case BAL:
      maisProfundo(l->right);
      break;
    case RIGHT:
      maisProfundo(l->right);
      break;
    }
  }
}

AVL42 maisProfundo_(AVL42 l) {
  while (l && ((l->bal == BAL && l->right) || l->bal != BAL))
    l = l->bal == LEFT ? l->left : l->right;
  return l;
}

/* b. R: 29 Sendo q so inserimos os valores e nao a balanceamos */

/* 43. ja fiz algures nas folhas */

/* 44. */
typedef struct llint {
  int value;
  struct llint *next;
} * LInt;

typedef enum balancefactor { LH, EH, RH } BalanceFactor;

typedef struct avl {
  int value;
  int deleted;
  BalanceFactor bal;
  struct avl *esq, *dir;
} * AVL1;

AVL1 insert(LInt *l) {
  AVL1 t;
  if (l) {
    t = (AVL1)malloc(sizeof(struct avl));
    t->value = (*l)->value;
    t->bal = EH;
    t->deleted = 0;
    t->esq = t->dir = NULL;
  }
  return t;
}

/* AVL1 fromlist_aux(LInt *l,int N){ */
/*     AVL1 r=NULL; */
/*     if (*l && N>0){ */
/*         if(N==1 ){ */
/*             r = insert(l); */
/*             *l=(*l)->next; */
/*          }else{ */
/*             AVL1 esq = fromlist_aux(l, N/2); */
/*             AVL1 meio = l ? insert(l) : NULL; */
/*             *l=(*l)->next; */
/*             AVL1 dir = l ? fromlist_aux(l, N - N/2 - 1) : NULL; */
/*             if (meio){ */
/*                 r = meio; */
/*                 r->esq = esq; */
/*                 r->dir = dir; */
/*                 if(!r->dir) r->bal=LH; */
/*             } else r= esq; */
/*          } */
/*     } */
/*     return r; */
/* } */
AVL1 fromlist_aux(LInt *l, int N) {
  AVL1 r = NULL;
  if (*l && N > 0) {
    r = malloc(sizeof(struct avl));
    r->esq = fromlist_aux(l, N / 2);
    r->value = (*l)->value;
    r->bal = EH;
    *l = (*l)->next;
    r->dir = fromlist_aux(l, N - N / 2 - 1);
    if (!r->dir)
      r->bal = LH;
  }
  return r;
}

AVL1 fromlist(LInt l, int N) { return fromlist_aux(&l, N); }
/* ----------------------------- */
/* MUITO MAU */
AVL1 rotateRight_(AVL1 a) {
  AVL1 aux = a->esq;
  a->esq = aux->dir;
  aux->dir = a;
  return aux;
}
AVL1 rotateLeft__(AVL1 a) {
  AVL1 aux = a->dir;
  a->dir = aux->esq;
  aux->esq = a;
  return aux;
}

AVL1 aux_44(AVL1 t, LInt l, int *cresceu) {
  if (l == NULL) {
    AVL1 t;
    t = (AVL1)malloc(sizeof(struct avl));
    t->value = l->value;
    t->bal = EH;
    t->deleted = 0;
    t->esq = t->dir = NULL;
    *cresceu = 1;
  } else if (l->value > t->value) {
    t->dir = aux_44(t->dir, l, cresceu);
    if (*cresceu) {
      switch (t->bal) {
      case LH:
        t->bal = EH;
        *cresceu = 0;
        break;
      case EH:
        t->bal = RH;
        *cresceu = 1;
        break;
      case RH:
        t = rotateLeft__(t);
        *cresceu = 0;
        break;
      }
    }
  } else {
    t->esq = aux_44(t->esq, l, cresceu);
    if (*cresceu) {
      switch (t->bal) {
      case LH:
        t->bal = EH;
        t = rotateRight_(t);
        *cresceu = 0;
        break;
      case EH:
        t->bal = LH;
        *cresceu = 1;
        break;
      case RH:
        t->bal = EH;
        *cresceu = 0;
        break;
      }
    }
  }
  return t;
}

AVL1 fromList(LInt l, int n) {
  int cresceu = 0;
  AVL1 a = NULL;
  while (l) {
    a = aux_44(a, l, &cresceu);
    l = l->next;
  }
  return a;
}

/* 45. */
/*
**  -----------
** 0|   10    |
**  -----------
** 1|   8     |
**  -----------
** 2|         |
**  -----------
** 3|   3     |
**  -----------
** 4|         |
**  -----------
** 5|         |
**  -----------
** 6|         |
**  -----------
** 7|         |
**  -----------
** 8|   8     |
**  -----------
** 9|         |
**   ---------|
*/

/* 46. */
#define LIVRE 0
#define APAGADO 1
#define OCUPADO 2

struct entry {
  int value, status;
};

typedef struct thash {
  int ocupados, tamanho;
  struct entry *tabela;
} * THash46;

void inicia_tabela(struct entry *a, int tamanho) {
  a = malloc(tamanho * (sizeof(int)));
}

void add_hash(THash46 h, int value) {
  if (h) {
    int x = value % h->tamanho;
    while (h->tabela[x].status != OCUPADO && x < h->tamanho)
      x++;
    /* criar o caso em q o x passa h e entao volta a 0 */
    h->tabela[x].status = OCUPADO;
    h->tabela[x].value = value;
  } else {
    h = malloc(sizeof(struct thash));
    h->tamanho = 3;
    h->ocupados = 1;
    inicia_tabela(h->tabela, 3);
    add_hash(h, value);
  }
}

int verifica_hash(THash46 h) {
  int r = 0;
  if (h->ocupados / h->tamanho < 0.33) {
    struct entry *aux = h->tabela;
    h->tamanho = 2 * h->tamanho / 3;
    // realloc do espaco
    // inserir again os elementos
  }

  return r;
}

int removed_hash(THash46 h, int x) {
  int r = 0;
  int key = x % h->tamanho;

  while (h->tabela[x].status == 1)
    x++;
  if (h->tabela[x].status == LIVRE)
    return r;

  h->tabela[x].status = APAGADO;
  h->ocupados--;

  r = verifica_hash(h);
  return r;
}

/* 47. */
typedef struct nodo47 {
  int valor;
  struct nodo47 *esq, *dir;
} * AVL;

AVL rotateRight(AVL a) {
  AVL aux = a->esq;
  a->esq = aux->dir;
  aux->dir = a;
  return aux;
}

AVL spine(AVL a) {
  if (a != NULL) {
    while (a->esq != NULL)
      a = rotateRight(a);
    a->dir = spine(a->dir);
  }
  return (a);
}

/*
** C1 = custo de chamar a função spine
** T_rotate = custo de chamar a funcao rotate_rigth
**
** T( AVL ) | AVL is empty ;   0
**          | otherwise        T_spine + T( AVL->dir )
**
** Considerando q o custo de C1 é 1 e h é a altura da arvore
**
** T( AVL,h ) =  C1 + T( AVL->dir, h-1 )
**            = sum k=1 to h-1, 1
**            = h-1 = O(N)
*/
LInt ins(int value, LInt l) {
  LInt new = NULL;

  new = malloc(sizeof(struct llint));
  new->value = value;
  new->next = l;
  return new;
}

LInt inserLint(int *a, int n) {
  LInt new = NULL;
  if (n > 0) {
    new = malloc(sizeof(struct llint));
    new->value = a[0];
    new->next = inserLint(a + 1, n - 1);
  }
  return new;
}

/* exame 2016/2017 */
#define HSIZE 23
#define FREE -1
typedef struct entry1 {
  int probeC; // -1: free
  int key;
  int value;
} HTable[HSIZE];

int hash(int key, int size) {
  /* faz qualquer coisa */
  return 1;
}

/*Matilde bravo*/
int update(HTable t, int key, int value) {
  int p = hash(key, HSIZE);
  int probe = 0;
  for (int i = p; probe < HSIZE; probe++, i = (i + 1) % HSIZE) {
    if (t[i].key == key || t[i].probeC == FREE) {
      t[i] = (struct entry1){
          .probeC = probe,
          .key = key,
          .value = value,
      };
      break;
    }
  }
  return probe == HSIZE;
}
/****/
/* 4. */
typedef struct aresta {
  int destino, peso;
  struct aresta *prox;
} * LAdj;
#define N1 10
typedef LAdj Grafo[N1];

int dijkstraSP(Grafo g, int v, int pesos[], int pais[]) { return 1; }
int aproxMeio(Grafo g, int o, int d) {
  if (d - o < 0)
    return -1;
  int sucess = 0;
  int soma = 0, i;
  int pesos[N1], pais[N1];
  int r = dijkstraSP(g, o, pesos, pais);

  if (r == 0)
    return sucess;

  for (i = 0; i < N1 && pais[i] != d; i++)
    soma += pesos[i];
  soma = soma / 2;
  int aux;
  for (i = 0, aux = 0; i < N1 && aux < soma; i++)
    aux += pesos[i];

  if (abs(aux - pesos[i]) > aux)
    sucess = abs(aux - pesos[i]);
  else
    sucess = aux;
  return sucess;
}

/*  */
int aux_con(AVL1 a) {
  int l, r, x = 0;
  if (!a)
    return x;
  r = aux_con(a->esq);
  l = aux_con(a->dir);
  if (r != l)
    x = r > l ? RIGHT : LEFT;
  a->bal = x;
  return x;
}

void convert(AVL1 a) { int r = aux_con(a); }

/*-----------*/

// Function to print binary tree in 2D
// It does reverse inorder traversal
void print2DUtil(AVL1 root, int space) {
  // Base case
  if (root == NULL)
    return;
  // Increase distance between levels
  space += COUNT;
  // Process right child first
  print2DUtil(root->dir, space);
  // Print current node after space
  // count
  printf("\n");
  for (int i = COUNT; i < space; i++)
    printf(" ");
  printf("%d\n", root->value);
  // Process left child
  print2DUtil(root->esq, space);
}

void main44() {
  printf("Excercicio 44: \n\n");
  int N = 20;
  int array[50];
  for (int i = N - 1; i >= 0; i--)
    array[i] = i + 1;

  LInt ola = NULL;
  for (int i = N; i > 0; i--)
    ola = ins(array[i - 1], ola);

  AVL1 resul = fromlist(ola, N);
  print2DUtil(resul, 0);
}

int main() {
  main44();
  return 0;
}
