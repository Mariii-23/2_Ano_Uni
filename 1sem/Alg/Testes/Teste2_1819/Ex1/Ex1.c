#include <stdio.h>
#include <stdlib.h>

#define PARENT(i) (i-1)/2
#define LEFT(i) 2*i + 1
#define RIGHT(i) 2*i + 2

typedef int Elem;

typedef struct {
 int   size;
 int   used;
 Elem  *values;
} Heap;

void initHeap(Heap *h, int size) {
    h->size = size;
    h->used = 0;
    h->values = calloc(size,sizeof(Elem));   
}

void bubbleUp(Elem *a, int i) {
    if(i > 0 && a[PARENT(i)] > a[i]) {
        int temp = a[i];
        a[i] = a[PARENT(i)];
        a[PARENT(i)] = temp;
        bubbleUp(a, PARENT(i));
    }
}

int insertHeap(Heap *h, Elem x) {
    if(h->size == h->used) {
        h->size *= 2;
        h->values = realloc(h->values, h->size * sizeof(Elem));
    }
    h->values[h->used] = x;
    bubbleUp(h->values, h->used);
    (h->used)++;
    return 1;
}

void bubbleDown(Elem *a, int n) {
    int i = 0;
    while(LEFT(i) < n) {
        int min = a[i] < a[LEFT(i)] ? i : LEFT(i);
        if(RIGHT(i) < n) min = a[min] < a[RIGHT(i)] ? min : RIGHT(i);
        if(min != i) {
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
            i = min;
        }
        else break;
    }
}

int extractMin(Heap *h, Elem *x) {
    if(h->used == 0) return 0;
    *x = h->values[0];
    h->values[0] = h->values[--h->used];
    bubbleDown(h->values, h->used);
    return 1;
}

int kmaior(int v[], int N, int k) {
    int h[k];
    int h_used = 0;
    for(int i = 0; i < N; i++) {
        if(h_used == k) {
            if(v[i] > h[0]) {
                h[0] = v[i];
                bubbleDown(h, k);
            }
        }
        else {
            h[h_used] = v[i];
            bubbleUp(h, h_used++);
        }
    }
    return h[0];
}

int main() {
    int random_list[10] = {30,60,40,10,100,20,90,50,80,70};
    for(int k = 1; k < 11; k++) {
        int km = kmaior(random_list, 10, k);
        printf("O %dº maior elemento da lista é %d\n",k, km);
    }
    return 0;
}

// O pior caso ocorre quando o array está ordenado. Nesse caso, a complexidade é O(N * k), pois a função terá que percorrer o array todo uma vez,
// e por cada vez que o percorre terá sempre que efetuar um bubbleUp/bubbleDown, que tem pior caso de O(k).