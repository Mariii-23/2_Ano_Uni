#ifndef TRY_H
#define TRY_H 

#include <stdint.h>  /* for uint8_t */
#define BUFFER_SIZE 1024

/* FILE */

/* Block Values */
typedef struct Array_Block {
    uint8_t value;
    struct Array_Block *prox; 
} *ARRAY_BLOCK ;

/* struct for blocks */
typedef struct Block {
    // uint8_t buffer[ BUFFER_SIZE ];
    ARRAY_BLOCK *buffer;
    int block_size;
    struct Block *prox;
} *BLOCKS;

/* struct to put on file on blocks */
typedef struct {
    char what; /* R == compression with RLE ||  N == no compression */
    int num_blocks;
//    int *blocks_size;
    BLOCKS *Blocks;
} *Block_file;


/* FREQUENCY */

/* Struct for the blocks' frequency */
typedef struct freq_block {
    int freq[256];
    struct freq_block *prox;
} *Freq_blocks ;

#endif /* TRY_H */
