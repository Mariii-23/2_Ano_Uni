##
# Project Guião1
#
# @file Guião1
# @version 0.1
OPT = -flto -Ofast -march=native -mtune=native
CFLAGS = -std=c17 -Wall -Wextra -Wdouble-promotion -Werror=pedantic -Werror=vla -pedantic-errors -Wfatal-errors -g $(OPT)
# CFLAGS = -g
CC = gcc
OBJS = guiao.o main.o ex3.o
EX3 = ex3.c
NAME = guiao
GUIAO = guiao.c main.c
NAME1 = ex3

all: $(OBJS)
	$(CC) $(CFLAGS) -o $(NAME1) ex3.o
	$(CC) $(CFLAGS) -o $(NAME) $(GUIAO)

run: all
	./$(NAME)

clean:
	@rm -rf *.o $(NAME)
# end
