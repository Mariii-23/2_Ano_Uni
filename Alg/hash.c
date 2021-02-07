/* Hash */

/* Closed Addressing */
typedef int ValueType;
#define MAXSTR 100
#define CAP 100

typedef struct node {
  char key[MAXSTR];
  ValueType info;
  struct node *next;
};
typedef struct node *Hashtable[CAP];
