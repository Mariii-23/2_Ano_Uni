#include <stdio.h>
#include <stdlib.h>

#define N 20 
typedef struct edge {
    int dest, cost;
    struct edge *next;
} * Graph[N];

int simplePath(Graph g, int v[], int k) {
    int visited[k];
    for(int i = 0; i < k; i++) {
        visited[i] = 0;
    }
    for(int i = 0; i < k - 1; i++) {
        if(visited[v[i]] == 0) {
            struct edge *p = g[v[i]];
            int continues_path = 0;
            for(p;p;p = p->next) {
                if(p->dest == v[i+1]) {
                    continues_path = 1; 
                    break;
                }
            }
            if(!continues_path) return 0;
            visited[v[i]] = 1;
        }
        else return 0;
    }
    if(visited[v[k-1]] == 1) return 0;
    else return 1;
}

#define NE 0
typedef int GraphM[N][N];

void graphMtoL_sol(Graph gl, GraphM gm, int n) {
    int i, j;
    struct edge *head, *new;
    
    for (i = 0; i<n; i++) {
        head = NULL;
        for (j = n-1; j>=0; j--) 
            if (gm[i][j] != NE) {
                new = malloc(sizeof(struct edge));
                new -> dest = j;
                new -> cost = gm[i][j];
                new -> next = head;
                head = new;
            }
        gl[i] = head;
    }
}

int main() {
    GraphM gm1 = {
    {NE,  2, NE, NE, NE,  7,  3, NE, NE},
    { 2, NE,  4, NE, NE, NE,  6, NE, NE},
    {NE,  4, NE,  2, NE, NE, NE,  2, NE},
    {NE, NE,  2, NE,  1, NE, NE,  8, NE},
    {NE, NE, NE,  1, NE,  6, NE, NE,  2},
    { 7, NE, NE, NE,  6, NE, NE, NE,  5},
    { 3,  6, NE, NE, NE, NE, NE,  3,  1},
    {NE, NE,  2,  8, NE, NE,  3, NE,  4},
    {NE, NE, NE, NE,  2,  5,  1,  4, NE}
    }; 
    int n1 = 9; 

    Graph g1;
    graphMtoL_sol(g1,gm1,n1);

    int p1[5] = {0,1,2,3,4};
    int sp1 = simplePath(g1,p1,5);
    printf("Is 0->1->2->3->4 a simple path? %d\n",sp1);
    int p2[5] = {0,1,6,3,4};
    int sp2 = simplePath(g1,p2,5);
    printf("Is 0->1->6->3->4 a simple path? %d\n",sp2);
    int p3[5] = {0,1,2,3,2};
    int sp3 = simplePath(g1,p3,5);
    printf("Is 0->1->2->3->2 a simple path? %d\n",sp3);
    int p4[9] = {0,1,2,3,4,5,8,7,6};
    int sp4 = simplePath(g1,p4,9);
    printf("Is 0->1->2->3->4->5->8->7->6 a simple path? %d\n",sp4);
    int p5[3] = {0,1,5};
    int sp5 = simplePath(g1,p5,3);
    printf("Is 0->1->5 a simple path? %d\n",sp5);
    return 0;
}