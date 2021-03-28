FLAGS= -std=c99 -Wextra -O2 -D_GNU_SOURCE
PKG = `pkg-config --cflags --libs glib-2.0`
COMPILER=gcc
INCLUDES=includes
SRC=src
OBJ=obj

all: auxStruct player squad prog allprog
	
auxStruct: $(SRC)/AuxStructs.c $(INCLUDES)/AuxStructs.h
	$(COMPILER) $(FLAGS) -o $(OBJ)/auxStruct.o $(PKG) -c $(SRC)/AuxStructs.c
player: $(SRC)/Player.c $(INCLUDES)/Player.h
	$(COMPILER) $(FLAGS) -o $(OBJ)/player.o -c $(SRC)/Player.c

squad: $(SRC)/Squad.c $(INCLUDES)/Squad.h
	$(COMPILER) $(FLAGS) -o $(OBJ)/squad.o $(PKG) -c $(SRC)/Squad.c

prog: $(SRC)/prog.c $(OBJ)/squad.o
	$(COMPILER) $(FLAGS) -o $(OBJ)/prog.o $(PKG) -c $(SRC)/prog.c	


allprog: $(SRC)/prog.c $(OBJ)/prog.o $(OBJ)/player.o $(OBJ)/squad.o
	$(COMPILER) $(FLAGS) $(OBJ)/auxStruct.o $(OBJ)/player.o $(OBJ)/squad.o $(OBJ)/prog.o  $(PKG) -o program


memcheck:
	valgrind --leak-check=yes ./program

clean:
	rm -rf $(OBJ)/*.o program
