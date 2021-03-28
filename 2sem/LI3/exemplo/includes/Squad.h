#ifndef SQUAD_H
#define SQUAD_H 

#include"Player.h"
#include"AuxStructs.h"
#include"glibWarningAvoid.h"

typedef struct team* SQUAD;


SQUAD initSquad();

SQUAD loadSquadFromFile(SQUAD p,char* fileName);

int playerExists(SQUAD c, char* playerName );

int getTotalStrikers(SQUAD c);

void addPlayerToSquad( SQUAD c , PLAYER p);

int getSquadSize(SQUAD c);

StrArray getStrikers(SQUAD c);

void destroySquad(SQUAD c);

#endif

