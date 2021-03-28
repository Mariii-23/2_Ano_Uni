#ifndef AUX_STRUCTS_H
#define AUX_STRUCTS_H 

#include"glibWarningAvoid.h"


typedef GArray* StrArray;

StrArray initStrArray();

StrArray addToStrArray(StrArray st,  gpointer value );

void destroyStrArray(StrArray st);

int getLength(StrArray st);

char* getStrElement(StrArray st, int index);

#endif