library(ggplot2)

movies <- read.csv("MovieRatings.csv")

str(movies)

names(movies) <- c("Film", "Genre", "CriticRatings", "AudienceRatings", "BudgetMillion", "Year")

class(movies$Genre)
typeof(movies$Genre)

movies$Genre <- factor(movies$Genre)
class(movies$Genre)
typeof(movies$Genre)

str(movies)

movies$Year <- factor(movies$Year)

summary(movies)
tail(movies)

##movies[which(movies$BudgetMillion == max(movies$BudgetMillion)), ]
movies[which(movies$Budget..million... == max(movies$Budget..million...)), ]

movies[which(movies$Budget..million... == min(movies$Budget..million...)), ]



###### plots

################# ggplot() ? a main para constru??ao de gr?ficos

##### constiu?da por layers (camadas)

##### primeira camada: dados
### segunda camada: aes() eixos, cor, fill, size,.... (things we see)
#### terceira camada: geometria


##### grafico de barras para vari?veis categ?ricas

ggplot(movies, aes(x = Genre, fill = Year.of.release)) + 
  geom_bar(position = "stack")

ggplot(movies, aes(x = Genre, fill = Year.of.release)) +
  geom_bar(position = "dodge")

#### gr?fico cruzamento de vari?veis quantitativas e um fator

ggplot(movies, aes(x = Audience.Ratings.., y = Rotten.Tomatoes.Ratings.., color = Genre, size = Budget..million...)) +
  geom_point()



movies[which(movies$Audience.Ratings.. == min(movies$Audience.Ratings..) & movies$Rotten.Tomatoes.Ratings.. == min(movies$Rotten.Tomatoes.Ratings..) ), ]

movies[which(movies$Audience.Ratings.. == max(movies$Audience.Ratings..) & movies$Genre == "Thriller" ), ]

ggplot(movies) +
  geom_point(aes(x = Audience.Ratings.., y = Audience.Ratings.., color = Genre, size = Budget..million...))

p <- ggplot(movies)

p + geom_point(aes(x = Audience.Ratings.., y =  Audience.Ratings..)) + geom_smooth()


q <- ggplot(movies, aes(x = Audience.Ratings.., y = Budget..million...))

q + geom_point() + geom_smooth()

q + geom_point() + geom_smooth(fill=NA)




#### overriding aes
ggplot(movies, aes(x = Audience.Ratings.., y = Rotten.Tomatoes.Ratings.., color = Genre, size = Budget..million...)) +
  geom_point()


ggplot(movies, aes(x = Audience.Ratings.., y = Rotten.Tomatoes.Ratings.., color = Genre, size = Budget..million...)) +
  geom_point(aes(size=Rotten.Tomatoes.Ratings..))

##ggplot(movies, aes(x = AudienceRatings, y = CriticRatings, color = Genre, size = BudgetMillion)) +
#  geom_point(aes(size = CriticRatings))



ggplot(movies, aes(x = Audience.Ratings.., y = Rotten.Tomatoes.Ratings.., color = Genre, size = Rotten.Tomatoes.Ratings..)) +
  geom_point()




ggplot(movies, aes(x = Audience.Ratings.., y = Rotten.Tomatoes.Ratings..)) +
  geom_point(size = 5, color = "DarkGreen")


#### GRAFICO DE BOLINHAS

# so bolinhas
ggplot(movies, aes(x = Audience.Ratings.., y = Rotten.Tomatoes.Ratings..,color= "DarkGreen")) +
  geom_point(size = 5)


# bolinhas avaliadas por genero (separado) (horizontal)
ggplot(movies, aes(x = Audience.Ratings.., y = Rotten.Tomatoes.Ratings..,color= Genre)) +
  geom_point(size = 3) +
  facet_grid(Genre ~ .)


# bolinhas avaliadas por genreo (separado) (vertical)
ggplot(movies, aes(x = Audience.Ratings.., y = Rotten.Tomatoes.Ratings.., color = Genre)) +
  geom_point(size = 3) +
  facet_grid(. ~ Genre)


# bolinhas avaliadas por cada geneero e por cada ano
# escala igual pra todos
ggplot(movies, aes(x = Audience.Ratings.., y = Rotten.Tomatoes.Ratings.., color = Genre)) +
  geom_point(size = 3) +
  facet_grid(Genre ~ Year.of.release)


# bolinhas avaliadas por cada geneero e por cada ano
# escala depende do q avalia
ggplot(movies, aes(x = Audience.Ratings.., y = Rotten.Tomatoes.Ratings.., color = Genre)) +
  geom_point(size = 3) +
  facet_grid(Genre ~ Year.of.release, scales = "free")


# bolinhas avaliadas por cada geneero e por cada ano
# escala depende do q avalia
# tenta desenhar uma reta
ggplot(movies, aes(x = Audience.Ratings.., y = Rotten.Tomatoes.Ratings.., color = Genre)) +
  geom_point(size = 3) +
  geom_smooth() +
  facet_grid(Genre ~ Year.of.release, scales = "free")


# bolinhas avaliadas por cada geneero e por cada ano
# escala depende do q avalia
# tenta desenhar uma reta 
# Mais limpa sem os NA
ggplot(movies, aes(x = Audience.Ratings.., y = Rotten.Tomatoes.Ratings.., color = Genre)) +
  geom_point(size = 3) +
  geom_smooth(fill=NA) +
  facet_grid(Genre ~ Year.of.release, scales = "free")



######################### histograma

ggplot(movies, aes(x = Audience.Ratings.. )) +
  geom_histogram(binwidth = 5) +
  xlab("classes de audiencia") + ylab("numero de efetivos") +
  ggtitle("histograma")





