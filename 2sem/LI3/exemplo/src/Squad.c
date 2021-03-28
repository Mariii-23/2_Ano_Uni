#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include"../includes/Squad.h"

#define BUFF_SIZE 64 

struct team{
	GTree *players;
};


/* funcao GCompareFunc */
gint comparePlayers(gconstpointer a, gconstpointer b){
    char *str_a = getName((PLAYER)a); // getname retrieves a copy of player name
    char *str_b =  getName((PLAYER)b);
    int result = strcmp(str_a,str_b);
    free(str_a);
    free(str_b);
    return result;
}

SQUAD initSquad(){
	SQUAD squad = malloc(sizeof(struct team));
	squad->players=g_tree_new_full((GCompareDataFunc)comparePlayers,NULL, NULL, (GDestroyNotify) destroyPlayer );
	return squad;
}

SQUAD loadSquadFromFile(SQUAD c, char* filename){
	char buffer[BUFF_SIZE];
	FILE* f = fopen(filename, "r");
	if (f==NULL){
		return NULL;
	}
	while(fgets(buffer, BUFF_SIZE, f)){
		char * playerLine = (strtok((buffer), "\r\n"));
		PLAYER player = initPlayerFromFileLine( playerLine ,":");
		g_tree_insert (c->players, player,player);
	}
	fclose(f);
	return c;
}

int playerExists(SQUAD c, char* name ){
	PLAYER p = initPlayer(name, "unknown", 99);
	// lookup retrieves key or null
	char* key = g_tree_lookup (c->players,p);
	destroyPlayer(p);
	int result = key!=NULL;
	free(key);
	return result;
}

static gboolean strikerCounter (gpointer key, gpointer value, gpointer data){
	int * striker_count = ((int*) data);
	PLAYER p = ((PLAYER) value);
	char* position = getPosition(p);
	if (strcmp(position,"Avancado")==0) {
		(*(striker_count))++;
	}
	free(position);
	return FALSE;
}

int getTotalStrikers(SQUAD c){
	int striker_count =0;
	g_tree_foreach(c->players, strikerCounter , &striker_count );
	return striker_count;
}


static int fillStrikerArray(gpointer key, gpointer value, gpointer data){
	PLAYER p = ((PLAYER) value);
	char* position = getPosition(p);
	if (!strcmp(position,"Avancado")) {
		addToStrArray(data, getPlayerInfo(p) );
	}
	free(position);
	return FALSE;
}

StrArray getStrikers(SQUAD c){
	StrArray array = initStrArray();
	g_tree_foreach(c->players, fillStrikerArray , array );
	return array;
}

int getSquadSize(SQUAD c){
	return g_tree_nnodes(c->players);
}

void addPlayerToSquad( SQUAD c , PLAYER p){
	PLAYER np = clonePlayer(p);
	g_tree_insert(c->players, np, np);
}

void destroySquad(SQUAD c){
	// visto que a gtree foi iniciada com 
	// g_tree_new_full especificando as funcoes de free
	// basta apenas:
	g_tree_destroy(c->players);
	free(c);
}


