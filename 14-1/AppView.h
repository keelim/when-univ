#pragma once
#include <stdio.h>
#include <conio.h>
#include "Common.h"

void AppView_out_startProgram();

void AppView_out_newLine();

char AppView_in_nextInputChar();

void AppView_out_endProgram();

void AppView_out_dictionaryIsFull(char aChar);

void AppView_out_addedElementInDictionary(char aChar);

void AppView_out_noElementInDictionary();

void AppView_out_removedElementFromQueue(char removedChar);

void AppView_out_elementInDictionary(Element element);

void AppView_out_dictionarySize(int numberOfSize);

void AppView_out_ignoredChar();

void AppView_out_endInput ();

void AppView_out_doesExist(Boolean flag);


