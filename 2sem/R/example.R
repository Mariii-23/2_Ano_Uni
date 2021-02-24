#!/usr/bin/env Rscript
## install.packages("remotes")
## install.packages("styler")
## library("styler")
## remotes::install_github("r-lib/styler")

# Simple hello world code in R

f <- function() {
  ##some
  print("Hello World!")
  print("LinuxHint")
  print(5+6)
 }

f()


x<-4
y<-10
class(y)
z<-5L
typeof(z)

plot(2:8) # vetor

table(c(4,4,4,5,6,7,7,7,7,7,7,5))

plot(table(c(4,4,4,5,6,7,7,7,7,7,7,5)))

class(NA)
typeof(NA)

v<-c(8,9,7,45,7,8,9,2)
print(v)
length(v)
mean(v)

seq(0,1,0.05)


