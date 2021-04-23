#define PARENT(i) ((i - 1) / 2)
#define LEFT(i) (2 * i + 1)
#define RIGHT(i) (2 * i + 2)

// min heaº
typedef struct heap {
  int size;
  int *values;
  int used;
} * Heap;

Heap init(int size);
int insertHeap(Heap h, int x);
int extractMin(Heap h, int *x);
void bubbleUP(int h[], int i);
void bubbleDown(int h[], int N);
int minHeapOk(Heap h);
void printHeap(Heap h);
