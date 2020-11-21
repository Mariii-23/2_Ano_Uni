# Wolfram Mathematica
> *NOTA:* Todos os comandos comecam com maiuscula

### Exemplo de uma funcao

> *Funcao                   Dominio*
> Plot[2-Cos[2t]+5Sin[t] , {t, -Pi, 10} ]

### Dar nome a funcao
> grafA = Plot[2-Cos{2t}+ 5 Sin{t} , {t, -Pi, 10} ]

### Por o cenas a funcionar
> Shift + Enter

### Mostrar grafico de funcoes
> Show{ grafA, Plot[x² -x, {x, -PI,10}]}

### Definir "limites"
> Plot[x² -6x, {x, -PI,10}], PlotRange -> {-10,10}

### Calcular a derivade em ordem a t
> D[ f[t], t]
> f'[t]

### Calcular integrais
> Integrate[f[t], t]

### Resolver
> Solve[ xx+3 == 4 ]
