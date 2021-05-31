### data.frame
### as colunas podem ter dados de tipo e classes diferentes
#### mas todas as colunas devem ter o mesmo comprimento

### os componentes da lista podem ser objetos de class e tipo diferentes e podem
### ter diferente número de elementos


df <- data.frame (A = c(-8, 7))
df$B <- list(matrix(1:6, nc=3), matrix(1:6))

str(df)

class(df[["B"]])

class(df["B"])


##### histogramas

#### representação gráfica de variáveis contínuas

library(MASS)

head(crabs)
dim(crabs)

str(crabs)
?crabs

library(ggplot2)

pl <- ggplot(crabs, aes(x = BD))
pl + geom_histogram(binwidth = 0.5, color="white", fill="green", alpha = 0.5)

pl1 <- ggplot(crabs, aes(x = BD, color = sex))
pl1 + geom_histogram(binwidth = 0.5, fill="white")

pl1 <- ggplot(crabs, aes(x = BD, fill = sex))
pl1 + geom_histogram(binwidth = 0.5, color="white")

pl1 + geom_histogram(binwidth = 0.5, color="white", alpha = 0.5, position = "dodge")



pl5 <- ggplot(crabs, aes(x = BD, y = ..density..))
pl5 + geom_histogram(binwidth = 0.5, color="white", fill="green", alpha = 0.5)+
  geom_density(fill = "red", alpha = 0.4)

pl5 + geom_histogram(binwidth = 0.5, color="white", fill="green", alpha = 0.5)+
  geom_density(color = "red")


pl1 <- ggplot(crabs, aes(x = BD, color = sex))
pl1 + geom_histogram(binwidth = 0.5, fill="white")


ggplot(crabs, aes(x = BD)) +
  geom_histogram(color="black", fill = "white") +
  facet_grid(sex~.)


ggplot(crabs, aes(x = BD)) +
  geom_histogram(binwidth = 0.5, color="white", fill = "red", alpha=0.4) +
  facet_grid(sp~.)


####### cálculo da média de cada grupo

med <- tapply(crabs$BD, crabs$sex, mean)

class(med)
dim(med)
med[1]
med[2]

names(med) <- NULL


medias <- data.frame (sexo = c("F", "M"), media.grupo = c(med[1], med[2]))


med <- tapply(crabs$BD, crabs$sp, mean)

names(med) <- NULL

mu <- data.frame(sp = c("B", "O"), med.grupo = c(med[1], med[2]))

p<-ggplot(crabs, aes(x=BD, color=sp)) +
  geom_histogram(fill="white", position="dodge")+
  geom_vline(data=mu, aes(xintercept=med.grupo, color=sp),
             linetype="dashed")+
  facet_grid(sp~.)
p






