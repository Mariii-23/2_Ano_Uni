##
# Project Guião1
#
# @file Guião1
# @version 0.1
OPT = -flto -Ofast -march=native -mtune=native
CFLAGS = -std=c99 -Wall -Wextra -Wdouble-promotion -Werror=pedantic -Werror=vla -Wfatal-errors -g $(OPT)
#CFLAGS = -std=c99 -Wall -Wextra -Wdouble-promotion -Werror=pedantic -Werror=vla -pedantic-errors -Wfatal-errors -g $(OPT)
# CFLAGS = -g
CC = gcc
OBJS = guiao.o 
NAME = guiao
GUIAO = guiao.c 

all: $(OBJS)
	$(CC) $(CFLAGS) -o $(NAME) $(GUIAO)

run: all
	./$(NAME)

clean:
	@rm -rf *.o $(NAME)
# end
