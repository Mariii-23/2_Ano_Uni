### 1
(a <- c(1:30))

b <- c(1:30, 29:1)
b

ec <- seq(1, 30, 2)
ec

d <- seq(29, 1, -2)
d

e <- rep(1:5, times = 1:5)
e

f <- rep(c(TRUE, FALSE, TRUE), times = c(2, 5, 1))
f

### 2
tmp <- c(4, 6, 3)
tmp
#### a
tmpa <- rep(tmp, 10)
tmpa
#### b
tmpb <- append((rep(tmp, 10)), tmp[1])
tmpb
#### c
tmpc <- rep(tmp, times = c(10, 20, 30))
tmpc

### 3
#### a
tmp3 <- c()
for (i in 0:31) {
  tmp3 <- append(tmp3, sum(3^i))
}
tmp3
# Or
tmp3 <- c(1, 3)
for (i in 3:31) {
  tmp3 <- append(tmp3, 3 * tmp3[i - 1])
}
tmp3

# GeometricSequence(4, .8, .6)

#### b
#### ???

#### c
tmp <- c(2)
for (i in 2:25) {
  tmp <- append(tmp, 2^i / i)
}
tmp

### 4
#### a
i <- 1:100
sum(i^3 + 4 * i^2)

#### b
i <- 1:25
sum(2^i / i + 3^i / i^2)

### 5
v5 <- c(1:30)
### 6
v6 <- paste("label", v5)
v6
### 7
v7 <- paste("fin", v5, sep = "")
v7

### 8
set.seed(50)
(xVec <- sample(0:999, 250, replace = T))
(yVec <- sample(0:999, 250, replace = T))
(con <- c(T, F, F))
####
#### a
Vec_a <- c()
for (i in 1:(length(xVec) - 1)) {
  Vec_a <- append(Vec_a, yVec[i + 1] - xVec[i])
}
Vec_a
####
#### b
Vec_b <- c()
for (i in 1:(length(xVec) - 1)) {
  Vec_b <- append(Vec_b, sin(yVec[i]) / cos(xVec[i + 1]))
}
Vec_b
####
#### c
tmp <- c()
for (i in 1:(length(xVec)) - 3) {
  aux <- xVec[i] + 2 * xVec[i + 1] - 3 * xVec[i + 3]
  tmp <- append(tmp, aux)
}
tmp
####
#### d ???
e <- 2
tmp <- c(1 / (xVec[1] + 10))
for (i in 2:(length(xVec))) {
  tmp <- append(tmp, tmp[i - 1] + e^(-1 * xVec[i + 1]) / (xVec[i] + 10))
}
tmp
sum(e^(-1 * xVec[i + 1]) / (xVec[i] + 10))

tmp <- (seq(yVec[2] - xVec[1]:yVec[length(yVec)] - xVec[length(xVec - 1)]))
tmp
### 9
#### a
subset(yVec, yVec > 600)
(1:length(yVec)) * (yVec < 600)
which(yVec < 600)
#### c
a <- (1:length(yVec)) * (yVec < 600)
a
b <- (1:length(xVec)) * (xVec < 600)
b
which(a == b)
#### d
(x_ <- mean(xVec))
(vector <- (abs(xVec - x_))^(1 / 2))
#### e
(e <- (yVec) * (yVec > 200))
e[e != 0] # Valores sem os 0
#### f
(f <- (yVec * (yVec %% 2)))
f[f != 0] # Valores sem os 0
#### g
#### ???
(a <- sort(xVec))
(b <- sort(yVec))
(resul <- ((a) * (a == b)))
resul[resul != 0]
#### h
yVec
# length(yVec)
(con <- append(rep(c(TRUE, FALSE, FALSE), length(yVec) / 3), TRUE))
# length(con)
(resul <- yVec * con)
resul[resul != 0]

### 10
