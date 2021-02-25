##
# Project Guião1
#
# @file Guião1
# @version 0.1
OPT = -flto -Ofast -march=native -mtune=native
CFLAGS = -std=c17 -Wall -Wextra -Wdouble-promotion -Werror=pedantic -Werror=vla -pedantic-errors -Wfatal-errors $(OPT)
# CFLAGS = -g
CC = gcc
OBJS = pessoas.o guiao1.o main.o
NAME = pessoas

all: $(OBJS)
	$(CC) $(CFLAGS) -o $(NAME) $^

run: all
	./$(NAME)

clean:
	@rm -rf *.o $(NAME)
# end
