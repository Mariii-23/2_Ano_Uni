## Teste 1
##

library(carData)
library(MASS)

## pergunta 1
## subset(Arrests,(Arrests$age <= 15) & (Arrests$checks == 5))
Arrests[(Arrests$checks == 5 & Arrests$age <= 15), ]

## pergunta 2
subset(Arrests,(Arrests$age >=18 ) & (Arrests$checks >= 4))$sex
quantos<- length( subset(Arrests,(Arrests$age >=18 ) & (Arrests$checks >= 4))$sex)

## pergunta 3
subset(Arrests,(Arrests$sex=="Female" ) & (Arrests$released =="Yes"))$age
length(subset(Arrests,(Arrests$sex=="Female" ) & (Arrests$released =="Yes"))$age)
## Têm 380.﻿

## pergunta 4
subset(crabs,(crabs$sex == "F") & (crabs$sp == "B"))

## pergunta 5
crabs$sex <- as.numeric(crabs$sex == "F")

## pergunta 6
aux<-matrix( rep(sample(iris$Petal.Length,10,replace=F),5), nrow=5)
apply(aux, nrow=5),1,mean)

## pergunta 7
summary(Arrests)

## pergunta 8 ??
## list(1:3) -> contem 1 elemento ﻿﻿﻿﻿﻿apenas, com 1 array de 3 elementos (numeros)﻿
## as.list(1:3)﻿﻿﻿﻿﻿﻿﻿-> contem 3 elementos, com cada 1 um elemento (numero)﻿﻿﻿﻿﻿﻿﻿﻿﻿

## pergunta 9
df <- data.frame (x = 1:3, y = letters[1:3])
df$newCol<-matrix(c(1:3))

## pergunta 10
aggregate(crabs$FL,list(crabs$sp),function(x)c(mediana = median(x),media = mean(x)))

## pergunta 11
aggregate(crabs[,c(4,5)],list(crabs$sp,crabs$sex),function(x)c(mediana = median(x),media = mean(x)))
