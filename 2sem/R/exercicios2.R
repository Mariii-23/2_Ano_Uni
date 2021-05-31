## 6.4 Exercicios
##

## 1.

ex1<-data.frame()

## 2.
## a)
summary(iris)

## b)
## Subset
vers2<-subset(iris,iris$Species == "versicolor")
vers2[,-5]

## Indexação
vers<-iris[iris$Species == "versicolor",-5]

## c
## for
forVersao<-function(){
    v1<-c()
    for(linhas in 1:nrow(vers)){
       v1<-append(v1,0)
       for(colunas in 1:ncol(vers)){
             (v1[linhas] <- v1[linhas] + vers[linhas,colunas])
       }
    }
    v1
}
v2<-forVersao()

## Soma todas as linhas
v<-apply(vers,1,sum)

## d
## Devolve a media de cada coluna
d<-apply(vers,2,mean)

d1<-colMeans(vers, na.rm = FALSE, dims = 1)

## e
d<-apply(vers[,-5],2,function(x) sum(x>5))

## 6.6.1

## 1
myLst <- function(n) {
  x <- rnorm(n)
  medx <- median(x)
  if (medx >= 0) {
    y <- rexp(n, rate = 1/medx)
  } else {
    y <- -rexp(n, rate = 1/-medx)
  }
  k <-sum(abs(y) > abs(x))
  list(vetx = x, vety = y, conta = k)
}

myLst(10)

lapply(rep(10, 4), myLst)
sapply(rep(10, 4), myLst)
replicate(4, myLst(10), simplify = T)
replicate(4, myLst(10), simplify = F)


negativos<-function(x){
  which(ola<0,arr.ind=T)
  sum(apply(ola,1,function(x) sum(x<0)))
}
