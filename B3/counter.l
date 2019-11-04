%{
	#include <stdio.h>
int ch=0;int bl=0;int ln=0;int wr=0;
%}
%%
[\n] {ln++;wr++;}
[\t] {bl++,wr++;}
[" "] {bl++,wr++;}
[^ \n\t] {ch++;}
%%
main()
{
yyin=fopen("counter.txt","r");
yylex();
printf("Characters %d\nWords %d\nLines %d\nBlanks %d\n",ch,wr,ln,bl);
}
	int yywrap(void)
	{
	return 1;
	}


