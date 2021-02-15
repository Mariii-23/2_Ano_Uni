#define N 6
typedef int GMat [N][N];

GMat g1 =
// 0  1  2  3  4  5
{{-1, 6, 7,-1, 3,-1},  // 0
 { 6,-1,-1, 5, 4, 2},  // 1
 { 7,-1,-1,-1, 8,-1},  // 2
 {-1, 5,-1,-1,-1, 2},  // 3
 { 3, 4, 8,-1,-1, 3},  // 4
 {-1, 2,-1, 2, 3,-1}}; // 5

int dijkstraSP(GMat g, int o, int d, int pesos[], int pais[]) {

}

/*
Valores iniciais:
pais =  [___,___,-1,___,___,___]
pesos = [inf,inf, 0,inf,inf,inf]

Iteração 0 - x = 2 (peso = 0):
pais =  [2,___,*-1*,___,2,___]
pesos = [7,inf, *0*,inf,8,inf]

Iteração 1 - x = 0 (peso = 7):
pais =  [*2*, 0,*-1*,___,2,inf]
pesos = [*7*,13, *0*,inf,8,inf]

Iteração 2 - x = 4 (peso = 8):
pais =  [*2*, 4,*-1*,___,*2*, 4]
pesos = [*7*,12, *0*,inf,*8*,11]

Iteração 3 - x = 5 (peso = 11):
pais =  [*2*, 4,*-1*, 5,*2*, *4*]
pesos = [*7*,12, *0*,13,*8*,*11*]

Iteração 4 - x = 1 (peso = 12):
pais =  [*2*, *4*,*-1*, 5,*2*, *4*]
pesos = [*7*,*12*, *0*,13,*8*,*11*]

Nº da iteração passa para 5, tornando falso que nº da iteração é menor que n - 1 (neste caso n é 6), logo o algoritmo terminou.

Caminho mais curto de 2 a 3:
2 -> 4 -> 5 -> 3
Distância = 13

(os valores com asteriscos à volta estão "trancados", isto é, os vértices correspondentes já entraram e saíram da orla, e esses valores são finais)
*/