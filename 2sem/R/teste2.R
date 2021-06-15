## TESTE 2

## pergunta 1
outer(1:20, 1:12, function(i, j){(i + 1)*j/(j^2 - (1/2))})

## pergunta 2
sum (M[ c(M[upper.tri(M)])])

## pergunta 3
matA<-outer(1:200, 1:100,function(i,j){ mat[i,j]<-i/j})

## pergunta 4

Fibonacci <- numeric(12)
Fibonacci[1] <- Fibonacci[2] <- 1
for (i in 3:12) Fibonacci[i] <- Fibonacci[i - 2] + Fibonacci[i - 1]

fibonacci<-function(n){
  Fibonacci <- numeric(n)
  Fibonacci[1] <- Fibonacci[2] <- 1
  if(n==1)
    return(1)
  else if (n==2)
    return(c(1,1))
  for (i in 3:n) Fibonacci[i] <- Fibonacci[i - 2] + Fibonacci[i - 1]
  Fibonacci
}

## pergunta 5
summary(crabs)


## pergunta 6
iris[sample(1:150, 10),]

## pergunta 7
set.seed(1789)
(matM <- matrix(sample(c(0, 1, NA), 30, prob = c(0.4, 0.4, 0.2), replace = T), nc = 5))#

## linhas<-apply(matM,1,function(x) sum(which(x==1)*0+1))
linhas<-rowSums(matM==1,na.rm=T)
## colunas<-apply(matM,2,function(x) sum(which(x==1)*0+1))
colunas<-colSums(matM==1,na.rm=T)

linhas;colunas

## pergunta 8
mtcars[ mtcars$cyl==6 & mtcars$mpg>=18 & mtcars$gear<5, -c(3:11) ]

## pergunta 9
for(i in 1:10) list[[i]]<-(sample(1:10,i,replace=T)); list

## pergunta 10
outer(1:10,1:8,function(i,j){(i*i*i+1)/(2-i*j*j)})

## pergunta 11
sum(outer(1:10,2:50,function(i,j){(sqrt(i*j))/(i+j)}))

## pergunta 12
negativos<-function(n){
  print(which(n<0,arr.ind=T))
  ## sum(apply(n,1,function(x) sum(x<0)))
  sum(n<0)
}

## pergunta 13
mtcars==4

## pergunta 14
mtcars[mtcars$mpg> mean(mtcars$mpg),]
linhas<-nrow( mtcars[mtcars$mpg> mean(mtcars$mpg),])
## número: 14﻿
##

## pergunta 15
f<-function(){
  aux<-0
  for( i in 1:5){ (for(j in (i+1):50){ aux<- aux + 2/(1+i*j) })}
  aux
}
f()

## pergunta 16
linhas<-apply(matM,1,function(x) sum(which(x==1)*0+1))
colunas<-apply(matM,2,function(x) sum(which(x==1)*0+1))

linhas;colunas

## pergunta 17
M <- matrix(0, nc = 5, nr = 5)
outer(1:nrow(M),1:ncol(M),function(i,j){j-i})

## pergunta 18
str(mtcars)

## pergunta 19
v<-c(-6,7,8,5,4,-9)
u<-c(0,NA,8,7,5,NA)
outer(v,na.omit(u),function(i,j) i<j)


## pergunta 20
matB <- matrix(seq(0,1,length.out = 200), nc=10)
matB[ 18:20 ,4:7 ]

## pergunta 21
M2<-outer(1:20,1:6,function(i,j){i+j})

## pergunta 22
P<-cbind(coluna1=c(0.1,0.4,0.3,0.2), coluna2=c(0.2,0.1,0.4,0.3),coluna3=c(0.3,0.2,0.1,0.4),coluna4=c(0.4,0.3,0.2,0.1))
apply(P,1,function(x){sum(x)==1})

## pergunta 23
outer(1:20, 1:10, function(i,j) {(i-1) + ((j-1)/9)})

## pergunta 24
apenas_diagonal<-function(m){
  m[ -c(diag(m)) ]<-0
  m
}

## antes:
(m<-matrix(1:25,nrow=5))
## depois
(m<-apenas_diagonal(m))


## pergunta 25
ID <- sample(101:110)
before <-c(200.1, 190.9, 192.7, 213, 241.4, 196.9, 172.2, 185.5, 205.2, 193.7)
after <-c(392.9, 393.2, 345.1, 393, 434, 427.9, 422, 383.9, 392.3, 352.2)

(mat<-cbind(ID,before,after))
tail(mat,n=2)

## pergunta 26
media_maior50<-function(x){
  apply(x,1,function(i){mean(i)>50} )
}

(matrix<-rbind(sample(0:100,10),sample(0:100,10),sample(0:100,10),sample(0:100,10),sample(0:100,10),sample(0:100,10),sample(0:100,10),sample(0:100,10),sample(0:100,10),sample(0:100,10)))
media_maior50(matrix)

## podemos comprovar fazendo:
apply(matrix,1,function(i){mean(i)} )

## pergunta 27
crabs[crabs$RW >12.5,]

## pergunta 28
media_colunas<-function(m){
  apply(m,2,mean)
}

## pergunta 29
m<-outer(1:20,1:10,function(i,j){NA*i})
