#include <stdio.h>
#include <stdint.h>  /* for uint8_t */
#include "data.h"


/// functions related to files

// Open file
FILE *openFile( const char *file, const char *mode)
{
    FILE *new_file = NULL;
    new_file = fopen( file, mode);
    return new_file;
}

// Close file
void closeFile(FILE **file)
{
    if( !file || !(*file))
        return;

    fclose(*file);
    *file = NULL;
}



/* allocar memoria para as frequencias */
void initializeFreq( Freq_blocks *e ){
    // *e = malloc .....
    *e = NULL; /* para ja fica a null, mas o objetivo é alocar o espaco correto */
}

/* verifica se um determinado valor se encontra num dado array */
int verifica_valor( uint8_t value, uint8_t *list, int n)
{
    int result; result = 0;
    int i; i=0;
    
    while ( i<n && !result ){
        if( value == list[i] ) result = 1;
        i=i+1;
    }

    return result; /* Return 0 se n pertence ao array e 1 no caso contrario */
}

/* calcular as frequencias  de um bloco e organiza las */
/* isto so funciona para os blocos sem a compressao RL isto so funciona para os blocos sem a compressao RLE */
void calculateFreqOneBlock( BLOCK_LIST *e_block ,Freq_blocks *e_Freq , int block_size){
    BLOCK_LIST *e = e_block;

    int i; i=0;               
    int count1 /* contar as vezes q aparece o valor 1 */ , verificar1 /* serve para sabermos se o valor1 contem o valor atual ou se é o valor do ciclo anterior */;   
    int count2 /* contar as vezes q aparece o valor 2 */ , verificar2 /* serve para sabermos se o valor2 contem o valor atual ou se é o valor do ciclo anterior */;   
    int count3 /* contar as vezes q aparece o valor 3 */ , verificar3 /* serve para sabermos se o valor3 contem o valor atual ou se é o valor do ciclo anterior */;   
    int count4 /* contar as vezes q aparece o valor 4 */ , verificar4 /* serve para sabermos se o valor4 contem o valor atual ou se é o valor do ciclo anterior */;   
    
    uint8_t values[256];  /* array q guarda os valores ja analisados */
    uint8_t value1; /* valor 1 */     
    uint8_t value2; /* valor 2 */
    uint8_t value3; /* valor 3 */
    uint8_t value4; /* valor 4 */

    
    while ( e ){         
        count1 = 1;  verificar1 = 0;
        count2 = 1;  verificar2 = 0;
        count3 = 1;  verificar3 = 0;
        count4 = 1;  verificar4 = 0;
        
        value1 = (*e)->value;  
        /* vamos determinar o value1 */ 
        while ( e && verifica_valor( value1, values, i)){
            e = &((*e)->prox);
            if ( e ) value1 = (*e)->value;  /* o tipo de dados pode ser incompativel.. melhor criar funcao q nos dei a um valor em uint8_t em funcao do (*e_)->value */
        }
        /* atualizar as variaveis */
        if ( e ){ /* se falhar esta condicao, significa q o valor1 n foi alterado e portanto, n ha nada a atualizar */  
            values[i] = value1;
            i = i + 1;
            verificar1 = 1; /* verificar1 passa para 1(true) pois o valor1 foi alterado / alterado */
            e = &((*e)->prox);
            if ( e ) value2 = (*e)->value; /* o tipo de dados pode ser incompativel.. melhor criar funcao q nos deia um valor em uint8_t em funcao do (*e_)->value */

        }
        /* vamos determinar o valor 2... valor2 tem q ser diferente do valor 1 e dos outros valores ja calculados(valores q se encontram no array) */
        while ( e && value2 == value1 && verifica_valor( value2, values ,i )){
            if( value2==value1) count1 = count1 + 1;
            e = &((*e)->prox);
            if ( e ) value2 = (*e)->value; /* o tipo de dados pode ser incompativel.. melhor criar funcao q nos deia um valor em uint8_t em funcao do (*e_)->value */

        }
        if( e ) { 
            values[i] = value2; i = i+1;
            verificar2=1;
            e = &((*e)->prox);
            if ( e ) value3 = (*e)->value; /* o tipo de dados pode ser incompativel.. melhor criar funcao q nos deia um valor em uint8_t em funcao do (*e_)->value */

        }
        /* determinar valor3... tem q ser diferente dos analisados(array) e tanto do valor 1 e 2 */
        while ( e && (value3 == value1 || value3==value2) && verifica_valor( value3, values, i )) {
            if (value3 == value1) count1 = count1 + 1;
            if( value3 == value2) count2 = count2 + 1;
            e = &((*e)->prox);
            if ( e ) value3 = (*e)->value; /* o tipo de dados pode ser incompativel.. melhor criar funcao q nos deia um valor em uint8_t em funcao do (*e_)->value */

        }
        if( e ) { 
            values[i] = value3;  i = i+1; 
            verificar3 = 1;
            e = &((*e)->prox);
            if ( e ) value4 = (*e)->value;
        }
        /* determinar o valor 4 */
        while ( e && (value4 == value1 || value4==value2 || value4==value1) && verifica_valor( value4, values, i )) {
            if (value4 == value1) count1 = count1 + 1;
            if (value4 == value2) count2 = count2 + 1;
            if (value4 == value3) count3 = count3 + 1;
            e = &((*e)->prox);
            if ( e ) value4 = (*e)->value; /* o tipo de dados pode ser incompativel.. melhor criar funcao q nos deia um valor em uint8_t em funcao do (*e_)->value */

        }
        if( e ) { 
            values[i] = value4;  i = i+1; 
            verificar4 = 1;
            e = &((*e)->prox);
        }

        /* So vamos analisar os casos em q encontramos valores */
        if ( e ){ /* se o array encontra se vazio, significa q ja analisamos todos os valores. Falta nos apenas atualizar a tabela das frequencias */
            BLOCK_LIST *e_ = e;
            uint8_t valor_analisar; 
            
            /* vamos comparar as 4 variaveis obtidas com os restantes elementos do bloco */
            while( e_ ){
                valor_analisar = (*e_)->value; /* o tipo de dados pode ser incompativel.. melhor criar funcao q nos deia um valor em uint8_t em funcao do (*e_)->value */
                
                /* comparar o valor_analisar com as 4 variaveis */
                if( valor_analisar == value1 ) count1 = count1 +1;
                else{
                    if( valor_analisar == value2 ) count2 = count2 +1;
                    else{
                        if( valor_analisar == value3 ) count3 = count3 +1;
                        else if( valor_analisar == value4 ) count4 = count4 +1;
                    }
                }
                e_ = &((*e_)->prox);
            }
        }

        /* Atualizar as frequencias... temos q ter atencao q alguns dos valores encontrados podem ja ter sido analizados em ciclos anteriores */
        if (verificar1) { (*e_Freq)->freq[ value1 ] = count1;} 
        else if (verificar2) { (*e_Freq)->freq[ value2 ] = count2;} 
            else if (verificar3) { (*e_Freq)->freq[ value3 ] = count3;} 
                else if (verificar4) { (*e_Freq)->freq[ value4 ] = count4;}  
                /* sabemos q se o valor 3 n tiver sido atualizado o 4 tambem n tera sido, logo ao verificarmos se o 3 nao foi atualizado n precisamos de analisar o 4 
                ... se o valor2 n tiver sido atualizado, o 3 e 4 tambem n terao sido analisados ...por isso é q estao ifs dentro de ifs... basta um falhar para "parar" */
    }
}

/* Escrever as frequencias num file */
int write_freq( Freq_blocks *frequencies, int num_blocks, char *name_file ){
    
    FILE *file = openFile( name_file, "wb" ); 

    return 1;
}

/* Function to calculate frequencies */
int frequency( Block_file *file , Freq_blocks *frequencies , char *name_file){
    
    BLOCKS *e; /* Pointer to the address of the blocks */
    int num_blocks; /* Number of blocks */
    int block_size; /* Block size */
    int rle = (*file)->type; /* rle==1 -> ha compressao rle, 0 caso contrario */

    //Freq_blocks *freq = NULL; /* Initialize frequencies */
    Freq_blocks *e_Freq; e_Freq = frequencies; /* Pointer to the address of the frequencies */

    if ( file ){
        
        num_blocks = (*file)->num_blocks;
        
        e = ((*file)->Blocks); /* algo me diz q isto n é assim */
        
        while ( e )
        {
            block_size = (*e)->block_size; 

            initializeFreq( e_Freq ); /* reservar espaco na memoria */
            /* Calcular as frequencias so de um bloco */
            if (rle); /* falta criar funcao pra o calculo das frequencias de um file com compressao rle */
            else
                /* esta funcao so funciona se os blocos nao utilizarem a compressao rle */
                calculateFreqOneBlock( (*e)->blocklist , e_Freq , block_size );

            e = &((*e)->prox);
            e_Freq = &((*e_Freq)->prox);
        }

        write_freq( frequencies, num_blocks, name_file);

        return 1;
    }
    else return 0;
}


int main()
{
    uint8_t a =4;
    //uint8_t b = 300;
    uint8_t b = 120;

    printf("%d   %d   \n",a,b);

    return  0;
}
