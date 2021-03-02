#!/usr/bin/env Rscript
## install.packages("remotes")
## install.packages("styler")
## library("styler")
## remotes::install_github("r-lib/styler")

# Simple hello world code in R

f <- function() {
  ## some
  print("Hello World!")
  print("LinuxHint")
  print(5 + 6)
}

f()


x <- 4
y <- 10
class(y)
z <- 5L
typeof(z)

plot(2:8) # vetor

table(c(4, 4, 4, 5, 6, 7, 7, 7, 7, 7, 7, 5))

plot(table(c(4, 4, 4, 5, 6, 7, 7, 7, 7, 7, 7, 5)))

class(NA)
typeof(NA)

v <- c(8, 9, 7, 45, 7, 8, 9, 2)
print(v)
length(v)
mean(v)

seq(0, 1, 0.05)

## 02-03-2021 #

### Observacoes em falta(missing values)
### Ondservacoes NA (not available)

class(NA)
typeof(NA)

idades <- c(3L, 20L, NA, 33L, 44L, NA, 100L)
sqrt(idades)

sum(is.na(idades))

mean(idades)

mean(idades, na.rm = T)

### desvio padrao
sd(idades, na.rm = T)

### substituir as observacoes Na pela media das observacoes
(idades2 <- replace(idades, is.na(idades), mean(idades, na.rm = T)))

### formatar subconjunto das idades

### indexacao -> parenteses retos
idades[id < 40]

subset(idades, idades < 40)

### índices que correspondem a idades < 40

### shorhand

1:20

1:length(idades)

(1:length(idades)) * (idades < 40)

which(idades < 40)

### remover (free)
(rm(idades, idades2))

### definicao de um vetor vazio
v <- c()

v[6] <- 7

### Print | Cat
print("olaa")

cat("olaaa ", v, "tcheee")

paste("ollaaa", v)

### readline() | scan()

cat("Introduza um vetor de valores numericos:\n")

x <- scan()

cat("o vetor é ", x, "\n")

cat("Introduza um vetor de nomes\n")
y <- scan(what = "")
y


(vvv <- seq(10, 40, along.with = x))

rep(4:8, each = 2)

rep(4:8, times = 1:5)

### aleatorios
sample(1:10, 2)

sample(1:10, 20, replace = TRUE)

set.seed(564)
sample(1:10, 20, replace = TRUE)

sample(1:10, 20)

sample(1:10, 20, replace = TRUE)
