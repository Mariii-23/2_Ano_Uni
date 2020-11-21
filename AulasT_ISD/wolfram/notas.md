# Wolfram Mathematica
> *NOTA:* Todos os comandos comecam com maiuscula

### Exemplo de uma funcao

> **Funcao                   Dominio**

> Plot[2-cos[2t]+5sin[t] , (t, -Pi, 10) ]

### Dar nome a funcao
> grafA = Plot[2-cos(2t)+5sin(t) , (t, -Pi, 10) ] 

### Por o cenas a funcionar
> Shift + Enter

### Mostrar grafico de funcoes
> Show( grafA, Plot[x² -x, (x, -PI,10)])

### Definir "limites"
> Plot[x² -6x, (x, -PI,10)], PlotRange -> (-10,10) 

### Calcular a derivade em ordem a t
> D[ f[t], t]
> f'[t]

### Calcular integrais
> Integrate[f[t], t]

### Resolver
> Solve[ xx+3 == 4 ]

### Calcular varios resultados de uma vez
> Table[ *Funcao* , { x , valor_inicial, valor_final} ] 
````
**EXAMPLE**
ex1[k_] := 1 - 2 ex1[k - 1]
ex1[0] = 0.86;
Table[ex1[k], {k, 1, 5}]
````


