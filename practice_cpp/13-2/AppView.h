#pragma once
#include <stdio.h>
#include <conio.h>
#include "Common.h"

void AppView_out_startProgram();

void AppView_out_newLine();

void AppView_out_label_Front();

void AppView_out_label_Rear();

char AppView_in_nextInputChar();

void AppView_out_endProgram();

void AppView_out_queueIsFull(char aChar);

void AppView_out_addedElementInQueue(char aChar);

void AppView_out_noElementInQueue();

void AppView_out_removedElementFromQueue(char removedChar);

void AppView_out_elementInQueue(Element element);

void AppView_out_queueSize(int numberOfSize);

void AppView_out_ignoredChar();

void AppView_out_frontElement(char anElement);

void AppView_out_endInput ();

void AppView_out_removedElementByEndInput(char anElement);

void AppView_out_numberOfInputChars (int numberOfChars);

void AppView_out_numberOfNormallyProcessedChars (int numberOfChars);

void AppView_out_numberOfIgnoredChars (int numberOfChars);

void AppView_out_numberOfAddedChars(int numberOfChars);
