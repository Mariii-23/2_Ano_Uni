# 1
fun1<-function(x)
  x^(1:length(x))

fun2<-function(x)
  x^(1:length(x))/(1:length(x))

fun1(seq(-4,1,0.5))
fun2(seq(-4,1,0.5))

# 2.
f<-function(x,y){
  if(length(x)!=length(y))
    print("Warnig, os objetos não apresentam o mesmo comprimento")
   y[-1] - x[-length(x)]
}

(x<-1:20)
(y<-20:1)

f(x,y)

f2<-function(x,y){
  if(length(x)!=length(y))
    print("Warnig, os objetos não apresentam o mesmo comprimento")
 exp(y[-length(y)])*cos(x[-1])
}

f2(1:20,20:1)
f2(1:20,20:5)

# 3
f3a<-function(x){
  n<-length(x)
  if(n<3){
    print("O comprimento tem q ser maior que 2")
    NULL
  }else{
    x[-c((n-1),n)] + 2*x[-c(1,n)] - x[-c(1,2)]
  }
}

f3a(1:20)
f3a(1:2)

f3b<-function(x){
  n<-length(x)
  if(n<3){
    print("O comprimento tem q ser superior a 2")
    NULL
  }else{
    exp(-x[-1])/(x[-n]+10)
  }
}

f3b(1:20)
f3b(1:2)

# 4
is_natural<-function(x){
  x%%1 == 0
}

is_natural(2)
is_natural(0.5)

## a
is_all_divisor<-function(k,n){
  if (!all(is_natural(k)) || !all(is_natural(n)) || all(k>n)) {
    print("K deverá ser superior a N, ambos números naturais")
    return(FALSE)
  }
  all(n%%k==0)
}

is_divisor<-function(k,n){
  if (!all(is_natural(k)) || !all(is_natural(n)) || all(k>n)) {
    print("K deverá ser superior a N, ambos números naturais")
    return(FALSE)
  }
  n%%k==0
}

is_divisor(2,10)
is_divisor(3,10)

is_divisor(0.5,10)
is_divisor(20,10)

is_divisor(2,seq(2,20,by=2))
is_all_divisor(2,seq(2,20,by=2))

is_divisor(2,1:20)
is_all_divisor(2,1:20)

is_divisor(30,seq(2,20,by=2))
is_divisor(30,seq(2,20,by=0.5))

is_all_divisor(10,seq(2,20,by=0.5))
is_divisor(10,seq(2,20,by=0.5))

is_divisor(0.8,seq(2,20,by=2))

## b
todos_divisores<-function(n){
  vector<-c()
  if(n>0 && is_natural(n)){
    vector<-subset(a<-(1:n)*is_divisor(1:n,n),a!=0)
  }else{
    print("N tem que ser um número natural maior que 0")
  }
  vector
}

todos_divisores(10)
todos_divisores(1000)
todos_divisores(1.5)
todos_divisores(-1)

## c
is_primo<-function(x){
  if(x<0 || !is_natural(x) || length(a<-todos_divisores(x))>2){
    return(FALSE)
  }
  all(a==c(1,x))
}

is_primo(-1)
is_primo(2)
is_primo(7)
is_primo(4)
is_primo(4.5)

## d
all_primos<-function(x){
  if(x<0 || !is_natural(x)){
    print("N tem que ser um número positivo")
    return(NULL)
  }
  v<-c()
  for(i in 1:x){
    if(is_primo(i)==TRUE)
      v<-append(v,i)
  }
  v
}

all_primos(1)
all_primos(10)
all_primos(200)
all_primos(-5)
all_primos(2.5)

entre_primos<-function(x,n){
  if(x<0 || n<0 || !is_natural(x) || !is_natural(n)){
    print("N tem que ser mair que x, sendo ambos números positivos")
    return(NULL)
  }
  v<-c()
  for(i in x:n){
    if(is_primo(i)==TRUE)
      v<-append(v,i)
  }
  v
}

entre_primos(1,2)
entre_primos(10,20)
entre_primos(1,1)
entre_primos(20,10)
entre_primos(-4,10)
entre_primos(2,1.5)

## 5
f5<-function(x)
  ifelse(x<0,-x,x^2)
  
f5(0)
f5(5)
f5(-5)

f5(-2:2)
f5(-20:20)

## 6
stat<-function(x){
  v<-c(mean(x,na.rm=T),sd(x))
  names(v)<-c("média","desvio-padrão")
  v
}

rivers
(stat(rivers))
(stat(rivers[1:20]))

#(rm(list = ls()))
