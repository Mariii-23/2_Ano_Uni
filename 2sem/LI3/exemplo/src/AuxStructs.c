#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include"../includes/AuxStructs.h"




StrArray initStrArray(){
	// Inicializa garray para ser utilizado com strings
	StrArray st = g_array_new(FALSE,FALSE, sizeof(char*));
	return st;
}

StrArray addToStrArray(StrArray st,  gpointer value ){
	g_array_append_val(st,value);
	return st;
}


void destroyStrArray(StrArray st){
	for (int i = 0; i < getLength(st); ++i){
		free(getStrElement( st, i));
	}
	g_array_free (st,TRUE);
}

int getLength(StrArray st){
	return st->len;
}

char* getStrElement(StrArray st, int index){
	return g_array_index( st, char*, index );

}


