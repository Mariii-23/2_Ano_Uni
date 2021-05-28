set.seed(12234)

v1<-sample(1:24,10)
v2<-sample(-8:8,10,replace=T)
v3<-sample(c(NA,0,1),10,replace=T)

## linha1->v1
## linha2->v2
## linha3->v3
mat1<-rbind(v1,v2,v3)

## coluna1->v1
## coluna2->v2
## coluna3->v3
mat2<-cbind(v1,v2,v3)
