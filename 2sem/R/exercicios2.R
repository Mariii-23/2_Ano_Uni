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
