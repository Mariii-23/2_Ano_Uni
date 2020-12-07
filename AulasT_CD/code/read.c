#include <stdio.h>
void main(){
	unsigned char buffer[4096] = {0};
	int i = 0;
	FILE *ptr;
	ptr = fopen("aaa.txt","rb");  // r for read, b for binary
	fread(buffer,sizeof(buffer),1,ptr); // read 10 bytes to our buffer
	for(i; buffer[i] != 0 /*i < 4096*/; i++)
    		printf("%u ", buffer[i]); // prints a series of bytes
	printf("\n");
	printf("%d\n",(i));
}


typedef struct bloco_{
    unsigned char buffer[ 1024 ];
    struct bloco_ *prox;
} *BLOCO;


typedef struct {
    int blocos;
    BLOCO *bloco; 
} file;
