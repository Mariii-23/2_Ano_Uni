# Wolfram Mathematica
> *NOTA:* Todos os comandos comecam com maiuscula

### Exemplo de uma funcao
**Funcao-------------------Dominio**

> Plot[2-Cos[2t]+5Sin[t] , (t, -Pi, 10) ]

### Dar nome a funcao
> grafA = Plot[2-Cos[2t]+5Sin[t] , (t, -Pi, 10) ] 

### Por o cenas a funcionar
> Shift + Enter

### Mostrar grafico de funcoes
> Show{ grafA, Plot[x² -x, {x, -PI,10}]}

##### Plot[ {x, f[x]}, {x, xi, xf}, PlotRange->{yi,yf}, Frame->True, AspectRatio -> Automatic, ImageSize -> 400]

> Definir os limites do y
```
PlotRange->{yi,yf}
```

> Definir os limites do x 
```
{x,  xi, xf} 
```

### Calcular a derivade em ordem a t
> D[ f[t], t]

> f'[t]

### Calcular integrais
> Integrate[f[t], t]

### Resolver
> Solve[ funcao[x] == algo ]

### Encontrar pontos
> Funcao == algo, Ponto{x,y}  substituir ou o x ou o y
```
FindRoot[f[x] ⩵ x, {x, -1}]
```

### Calcular varios resultados de uma vez
> Table[ *Funcao* , { x , valor_inicial, valor_final} ] 
```
**EXAMPLE**
ex1[k_] := 1 - 2 ex1[k - 1]
ex1[0] = 0.86;
Table[ex1[k], {k, 1, 5}]
```


### Exercicios
##### Encontrar solucoes de tipo constante e ciclos de periodo 2

```
f1[x_]= -1.982-2.306x-0.708x^2

Plot[ { x, f1[x]}, {x,- 7, 3}, PlotRange->{-10,2}, Frame->True]

Solve[f1[x]==x]

Plot[ {x, f1[x], f1[f1[x]]}, {x,- 7, 3}, PlotRange->{-8,2}, Frame->True]

Solve[f1[f1[x]]==x]
```
##### Pares de ciclo de periodo 2
Solve[f1[f1[x]]==x]
```
{{x → -2.20553 - 1.10543 ⅈ}, {x → -2.20553 + 1.10543 ⅈ},
{x → -2.12026}, {x → -1.64673 - 1.29175 ⅈ}, {x → -1.64673 + 1.29175 ⅈ},
{x → -0.98568}, {x → -0.405996}, {x → -0.104418}, {x → 0.2225
```
solucoes08 = x /. Solve[f1[f1[x]] ⩵ x]
```
{-2.20553 - 1.10543 ⅈ, -2.20553 + 1.10543 ⅈ, -2.12026, -1.64673 - 1.29175 ⅈ,
 -1.64673 + 1.29175 ⅈ, -0.98568, -0.405996, -0.104418, 0.222521}
```
f1[Part[solucoes08, 6]]
```
-0.104418
```
Assim sendo, um deles é dado por {-0.98568, -0.104418}
sendo o outro dado por {-2.12026, 0.222521}

##### Classificar os pontos fixos segundo a sua dinamica
```
f1[x_] = x^3
der[x_] = f1'[x]
Plot[ {x, f1[x]}, {x,- 2, 2}, PlotRange->{-3,3}, Frame->True ]
Solve[f1[x]==x]
solucoes = der[x]/.Solve[f1[x]==x]
```
