##
# Project Title
#
# @file Guião0
# @version 0.1
OPT = -flto -Ofast -march=native -mtune=native
CFLAGS = -std=c17 -Wall -Wextra -Wdouble-promotion -Werror=pedantic -Werror=vla -pedantic-errors -Wfatal-errors $(OPT)
# CFLAGS = -g
CC = gcc

all: guiao0.o main.o
	$(CC) $(CFLAGS) -o guiao0 $^

clean:
	@rm -rf *.o guiao0


# end
