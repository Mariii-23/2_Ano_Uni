### 1
#### a
(a <- c(1:30))
#### b
(b <- c(1:30, 29:1))
#### c
(c <- seq(1, 30, 2))
#### d
(d <- seq(29, 1, -2))
#### e
(e <- rep(1:5, times = 1:5))
#### f
(f <- rep(c(TRUE, FALSE, TRUE), times = c(2, 5, 1)))


### 2
(tmp <- c(4, 6, 3))

#### a
(tmpa <- rep(tmp, 10))
#### b
(tmpb <- append((rep(tmp, 10)), tmp[1]))
#### c
(tmpc <- rep(tmp, times = c(10, 20, 30)))


### 3
#### a
ia <- 0:31
(tres_a <- c(3^ia))

#### b
(i_first <- seq(from = 3, to = 36, by = 3))
(i_second <- seq(from = 1, to = 34, by = 3))
(tres_b <- c((0.1^i_first) * (0.2^i_second)))

#### c
ic <- 2:25
(tres_c <- c(2, (2^ic) / ic))


### 4
#### a
i <- 10:100
sum(i^3 + 4 * i^2)

#### b
i <- 1:25
sum(2^i / i + 3^i / i^2)

### 5
(v5 <- c(1:30))

### 6
(v6 <- paste("label", v5))

### 7
(v7 <- paste("fin", v5, sep = ""))


### 8
set.seed(50)
(xVec <- sample(0:999, 250, replace = T))
(yVec <- sample(0:999, 250, replace = T))

#### a
ia <- 1:(length(xVec) - 1)
(vector_a <- c(yVec[ia + 1] - xVec[ia]))
# OR
# arr[-n] -> Tirar o elemento na posição n
# arr[c(1,n)] -> arr[1..n]
# arr[-c(1,n)] -> arr sem os elementos dos indices 1..n
n <- length(xVec)
(vector_a1 <- yVec[-1] - xVec[-n])

#### b
ib <- 1:(length(xVec) - 1)
(vector_b <- c(sin(yVec[ib]) / cos(xVec[ib + 1])))
# OR
n <- length(xVec)
(vector_b1 <- sin(xVec[-n]) / cos(yVec[1]))
## OR
Vec_b <- c()
for (i in 1:(length(xVec) - 1)) {
  Vec_b <- append(Vec_b, sin(yVec[i]) / cos(xVec[i + 1]))
}
Vec_b

#### c
ic <- 1:(length(xVec) - 2)
(vector_c <- c(xVec[ic] + 2 * xVec[ic + 1] - xVec[ic + 2]))
# OR
(vector_c1 <- xVec[-c(n - 1, n)] + 2 * xVec[-c(1, n)] - xVec[-c(1, 2)])

#### d
id <- 1:length(xVec)
(vector_d <- sum(exp(-xVec[id] + 1) / (xVec[id] + 10)))
# OUTRA SOLUÇÃO
n <- length(xVec)
(d <- sum(exp(-xVec[-n] + 1) / (xVec[-n] + 10)))


### 9
#### a
subset(yVec, yVec > 600)
# OR
(vector9_a <- yVec[yVec > 600])

####
(subset((vector9_b <- (1:length(yVec)) * (yVec > 600)), vector9_b != 0))
# OR
which(yVec > 600)

#### c
x_c <- xVec > 600
y_c <- yVec > 600
which(x_c[x_c == y_c])

#### d
(x_d <- mean(xVec))
(vector9_d <- (abs(xVec - x_d))^(1 / 2))

#### e
(x_e <- (yVec) * (yVec > 200))
x_e[x_e != 0] # Valores sem os 0
# OR
(x_e <- yVec[yVec > 200])

# ??
aux1 <- yVec[yVec > 200]
aux2 <- yVec[yVec < 200]
length(c(aux1[aux1 < max(xVec)], aux2[aux2 > max(xVec)]))

#### f
(x_f <- (yVec * (yVec %% 2)))
x_f[x_f != 0] # Valores sem os 0

#### g
#### ???
(a <- sort(xVec))
(b <- sort(yVec))
(resul <- ((a) * (a == b)))
resul[resul != 0]

#### h
n <- length(yVec)
(ola <- yVec[seq(1, n, 3)])

### 10
(x <- c(1:100))
(vector_10 <- subset(x, x %% 2 != 0 & x %% 3 != 0 & x %% 7 != 0))

### 11
(queue <- c("Sara", "Rui", "Ana", "Luis"))

#### a
(queue <- append(queue, "Beatriz"))
#### b
(queue <- queue[-(which(queue == "Sara"))])
#### c
(queue <- append("Paulo", queue))
#### d
(queue <- queue[-(which(queue == "Beatriz"))])
#### e
(queue <- queue[-(which(queue == "Ana"))])
#### f
(which(queue == "Rui"))

### 12
## remove (almost) everything in the working environment.
## You will get no warning, so don't do this unless you are really sure.
(rm(list = ls()))
# x = 1
(x <- 1)
# Cria uma lista vazia
(y <- c())
# O elemento na posição 2 passa a ter o valor de 2
(y[2] <- 2)
y
# O elemento na posição 3 passa a ter o mesmo valor
# que o elemento na posicão 1
# Neste caso é Null porque ainda não atribuimos nada
# ao elemento na posição 1.
(y[3] <- y[1])
y

# O elemento na posição 2 passa a ter o mesmo valor
# que o elemento na posicão 4
(y[2] <- y[4])
y

# Z ainda nao foi declarado, logo da erro.
(z[1] <- 0)

### 13
(num <- seq(2, 38, 2))
(den <- seq(3, 39, 2))
cumprod(num[1:3] / den[1:3])
sum(cumprod(num / den))
