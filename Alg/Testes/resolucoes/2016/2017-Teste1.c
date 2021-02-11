/* #include "2017-Teste1.h" */

/* 1. */
void partition (int v[], int N,int *ep, int *eq){
    int i, p, q, t;
    // PRE: N > 0
    i=p=q=0;
    // ...
    while (i<N-1) {
    // ...
       if (v[i] < v[N-1]) {
           t = v[i]; v[i] = v[q];
           v[q] = v[p]; v[p] = t;
           p++; q++;}
       else if (v[i] == v[N-1]) {
           t = v[i]; v[i] = v[q];
           v[q] = t; q++;
       }
       i++;
    }
    t=v[i]; v[i] = v[q];
    v[q] = t; q++;
    // POS: p < q
    *ep = p; *eq = q;
}

/* 2.
 *(a)
 * variante é i<N-1
 * Analisando sabemos q i inicializa a 0
 * em cada iteracao do ciclo while ou o i é incrementado
 * ou o N é decrementando.
 * Sabendo q a condicao de paragem é i>N-1 ou i==N-1,
 * podemos assegurar q o ciclo irá terminar
 *
 *(b)
 *
 *Melhor caso:
 *    Todo 0<=i<N-1  a[i]!=a[i+1]
 *    T(N)=0;
 *
 * Pior caso:
 *    Todo 0<=i<N-1  a[i]==a[i+1]
 *
 *    T(N)= sum k=1 to N-1, k
 *        = 1/2*(N-1)N
 *        =O(N²)
 *
 * */

/* 3.
 *
 * numero medio = Sum probs * custos da swap
 *
 * */
