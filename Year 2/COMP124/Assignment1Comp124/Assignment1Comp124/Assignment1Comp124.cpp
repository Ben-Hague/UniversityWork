/***********************/
/* Comp124 Assignment1 */
/*      Ben Hague      */
/* SGBHAGUE@LIV.AC.UK  */
/*      201146260     */
/***********************/

#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	char Text1[] = "\n Enter the mark for module "; //declare the variables used for output Text
	char Text2[] = ": ";
	char PassText[] = "\n Number of Passes = ";
	char FailText[] = "\n Number of Fails = ";
	char InvalidInput[] = "\n Please Enter a Valid Input!";
	
	char IntFormat[] = "%d";
	

	
	int markArray[6];
	int passes = 6;
	int fails = 0;
	int counter = 1;


	_asm {
		
		mov ecx, 6
		mov ebx, 0
		
		getMarkLoop:
			push ecx
				jmp start; ignore the incorrect input commands
				
				redoInput:
					lea eax, InvalidInput ; print the invalid input command
					push eax
					call printf
					add esp,4
					
				start: ; start function
					lea eax, Text1; ask for module n
					push eax
					call printf
					add esp, 4
					
					mov eax, counter ; print the counter Number
					push eax
					lea eax, IntFormat
					push eax
					call printf
					add esp, 8

					lea eax, Text2 ; print the colon
					push eax
					call printf
					add esp, 4

					lea eax, markArray[ebx]; read the data in 
					push eax
					lea eax, IntFormat
					push eax
					call scanf
					add esp, 8
					
					
					cmp markArray[ebx], 100 ; if input is >100 send to redoinput
						JG redoInput
					cmp markArray[ebx], 0 ; if input is <0 send to redoinput
						JL redoInput
					
					inc counter ; increment Counter
					add ebx, 4 ; increment ebx(index)
					
			pop ecx 
		loop getMarkLoop; loop 
		
		mov ecx, 6
		mov ebx, 0 

		calculateLoop:; setup loop
			push ecx
						
				cmp markArray[ebx], 40 ; determine if value is more than 40
					jge Pass ; if it is then skip incrementing fails
				
				inc fails
				
				Pass:
			pop ecx
			add ebx, 4
		loop calculateLoop ; loop the loop
		
		mov eax, fails ; subtract the number of fails from the number of modules
		sub passes, eax
		
		lea eax, PassText ; outpyt the passed modules text
		push eax
		call printf
		add esp,4
		
		mov eax, passes ; output the pass number
		push eax
		lea eax, IntFormat
		push eax
		call printf
		add esp, 8
		
		lea eax, FailText ; output the failed modules text
		push eax
		call printf
		add esp,4
		
		mov eax, fails ; output the failed modules number 
		push eax
		lea eax, IntFormat
		push eax
		call printf
		add esp, 8
	}
	return 0;
}