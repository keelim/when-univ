#pragma once
#include <stdio.h>
#include <conio.h>
#include "Common.h"
#include "Key.h"

void AppView_out_startProgram();

void AppView_out_newLine();

char AppView_in_nextInputChar();

void AppView_out_endProgram();

void AppView_out_dictionaryIsFull(char aChar);

void AppView_out_addedElementInDictionary(char aChar, int aInt);

void AppView_out_noElementInDictionary();

void AppView_out_removedElementFromDictionary(char removedChar, int removedInt);

void AppView_out_dictionarySize(int numberOfSize);

void AppView_out_ignoredChar();

void AppView_out_endInput ();

void AppView_out_doesExist(Boolean flag, Key *aKey);

char AppView_int_removeKey ();

char AppView_in_searchKey();

void AppView_out_noKeyInDictionary();

void AppView_out_replace(char keyValue, int objectValue);


