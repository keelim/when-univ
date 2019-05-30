#include <stdlib.h>
typedef enum {FALSE, TRUE} Boolean;
#define NewObject(TYPE) (TYPE*)malloc(sizeof(TYPE))
