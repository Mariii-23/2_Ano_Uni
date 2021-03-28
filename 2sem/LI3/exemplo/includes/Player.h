#ifndef PLAYER_H
#define PLAYER_H 

typedef struct player* PLAYER;

PLAYER initPlayer(char* name, char* position, int number);

PLAYER initPlayerFromFileLine(char* fileLine, char* fieldSeparator);

PLAYER clonePlayer(PLAYER p);

char* getName(PLAYER p);

char* getPosition(PLAYER p);

int getNumber(PLAYER p);

int isValid(PLAYER p);

char* getPlayerInfo(PLAYER p);

void destroyPlayer(PLAYER p);

#endif

