#include <stdlib.h>

typedef enum {FALSE, TRUE} Boolean;
typedef int Element;
#define NewVector(TYPE, SIZE) (TYPE*)malloc(sizeof(TYPE)*SIZE)
#define NewObject(TYPE) (TYPE*)malloc(sizeof(TYPE))

