/* #include "exercicios.h" */
#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#define COUNT 10
/* 44. */
typedef struct llint {
    int value;
    struct llint *next;
} *LInt;

typedef enum balancefactor { LH, EH, RH } BalanceFactor;

typedef struct avl {
    int value;
    int deleted;
    BalanceFactor bal;
    struct avl *esq, *dir;
} *AVL1;

AVL1 insert(LInt *l){
    AVL1 t;
    if(l){
       t = (AVL1)malloc(sizeof(struct avl));
       t->value=(*l)->value;
       t->bal=EH;
       t->deleted=0;
       t->esq=t->dir=NULL;
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
AVL1 fromlist_aux(LInt *l,int N){
    AVL1 r = NULL;
    if (*l && N>0){
       r = malloc(sizeof(struct avl));
       r->esq = fromlist_aux(l, N/2);
       r->value = (*l)->value;
       *l=(*l)->next;
       r->dir = fromlist_aux(l, N - N/2 - 1);
       if(!r->dir) r->bal=LH;
    }
    return r;
}

AVL1 fromlist(LInt l,int N){
    return fromlist_aux(&l, N);
}
/* ----------------------------- */
/* MUITO MAU */
AVL1 rotateRight_ (AVL1 a){
    AVL1 aux = a->esq;
    a->esq = aux->dir;
    aux->dir=a;
    return aux;
}
AVL1 rotateLeft__ (AVL1 a){
    AVL1 aux = a->dir;
    a->dir = aux->esq;
    aux->esq=a;
    return aux;
}

AVL1 aux_44(AVL1 t, LInt l, int *cresceu){
    if(l==NULL){
        AVL1 t;
        t = (AVL1)malloc(sizeof(struct avl));
        t->value=l->value;
        t->bal=EH;
        t->deleted=0;
        t->esq=t->dir=NULL;
        *cresceu=1;
    }else if (l->value > t->value){
        t->dir =aux_44(t->dir, l, cresceu);
        if (*cresceu){
            switch (t->bal){
                case LH:
                    t->bal=EH;
                    *cresceu=0;
                    break;
                case EH:
                    t->bal=RH;
                    *cresceu=1;
                    break;
                case RH:
                    t = rotateLeft__(t);
                    *cresceu =0;
                    break;
            }
        }
    }else{
        t->esq =aux_44(t->esq, l, cresceu);
        if (*cresceu){
            switch (t->bal){
                case LH:
                    t->bal=EH;
                    t = rotateRight_(t);
                    *cresceu=0;
                    break;
                case EH:
                    t->bal=LH;
                    *cresceu=1;
                    break;
                case RH:
                    t->bal = EH;
                    *cresceu =0;
                    break;
            }
        }
    }
    return t;
}

AVL1 fromList (LInt l,int n){
    int cresceu=0;
    AVL1 a=NULL;
    while(l)
    { a= aux_44(a,l,&cresceu); l=l->next;}
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
} *THash;

void inicia_tabela(struct entry *a, int tamanho){
    a= malloc(tamanho*(sizeof(int)));
}

void add_hash(THash h, int value){
    if(h){
        int x = value % h->tamanho;
        while( h->tabela[x].status != OCUPADO && x<h->tamanho) x++;
        /* criar o caso em q o x passa h e entao volta a 0 */
        h->tabela[x].status=OCUPADO;
        h->tabela[x].value=value;
    }else{
        h = malloc(sizeof(struct thash));
        h->tamanho=3;
        h->ocupados=1;
        inicia_tabela(h->tabela,3);
        add_hash(h, value);
    }
}

int verifica_hash(THash h){
    int r=0;
    if ( h->ocupados/h->tamanho < 0.33 ){
        struct entry *aux = h->tabela;
        h->tamanho= 2*h->tamanho/3;
        // realloc do espaco
        // inserir again os elementos
    }

    return r;
}

int removed_hash(THash h, int x){
    int r=0;
    int key= x % h->tamanho;

    while ( h->tabela[x].status == 1 ) x++;
    if (h->tabela[x].status == LIVRE) return r;

    h->tabela[x].status = APAGADO;
    h->ocupados--;

    r = verifica_hash(h);
    return r;
}


/* 47. */
typedef struct nodo {
    int valor;
    struct nodo *esq, *dir;
} *AVL;

AVL rotateRight (AVL a){
    AVL aux = a->esq;
    a->esq = aux->dir;
    aux->dir=a;
    return aux;
}

AVL spine (AVL a){
    if (a!=NULL) {
        while (a->esq != NULL)
            a=rotateRight (a);
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
LInt ins(int value, LInt l){
    LInt new = NULL;

    new = malloc(sizeof(struct llint));
    new->value = value;
    new->next = l;
    return new;

}

LInt inserLint(int *a,int n){
    LInt new = NULL;
    if (n>0){
        new = malloc(sizeof(struct llint));
        new->value = a[0];
        new->next = inserLint(a+1,n-1);
    }
    return new;
}

// Function to print binary tree in 2D
// It does reverse inorder traversal
void print2DUtil( AVL1 root, int space)
{
    // Base case
    if (root == NULL) return;
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


void main44(){
    printf("Excercicio 44: \n\n");
    int N=5;
    int array[50];
    for (int i=N-1; i>=0;i--){ array[i]=i+1;}

    LInt ola = NULL;
    for (int i=N; i>0;i--) ola = ins(array[i-1],ola);

    AVL1 resul = fromlist(ola, N);
    print2DUtil(resul, 0);
}

int main (){
    main44();
    return 0;

}
