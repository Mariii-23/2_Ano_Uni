#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<ctype.h>
#include"../includes/Player.h"

struct player{
	char *player_name;
	char *player_position;
	int player_number;
};



PLAYER initPlayer(char* name, char* position, int number){
	PLAYER p = malloc(sizeof(struct player));
	p->player_name=strdup(name);
	p->player_position=strdup(position);
	p->player_number=number;
	return p;
}


PLAYER initPlayerFromFileLine(char* fileLine, char* fieldSeparator){
	char * name = strtok(fileLine,fieldSeparator);
	int number = atoi(strtok(NULL, fieldSeparator));
	char * position = strtok(NULL, fieldSeparator);
	return initPlayer(name,position,number);
}

char* getName(PLAYER p){
	return strdup(p->player_name);
}

char* getPosition(PLAYER p){
	return strdup(p->player_position);
}

int getNumber(PLAYER p){
	return p->player_number;
}

int isValid(PLAYER p){
	return p->player_number>0;
}


char* getPlayerInfo(PLAYER p){
	char info[256];
	sprintf(info, "Name: %s | Number: %d | Position: %s",p->player_name, p->player_number, p->player_position);
	return strdup(info);

}

PLAYER clonePlayer(PLAYER p){
	PLAYER new_p = malloc(sizeof(struct player*));
	new_p->player_name = strdup(p->player_name);
	new_p->player_number = p->player_number;
	new_p->player_position = strdup(p->player_position);
	return new_p; 
}


void destroyPlayer(PLAYER p){
	free(p->player_name);
	free(p->player_position);
	free(p);
}

