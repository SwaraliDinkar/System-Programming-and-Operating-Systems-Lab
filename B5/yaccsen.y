%{
#include<stdio.h>
int num=1;
FILE* yyin;
%}
%token WORD CONJUNCTION
%%
paragraph:  vsentence| vsentence' 'paragraph;

vsentence:  ssentence {printf("%d : Simple Sentence\n",num++);} | csentence {printf("%d : Compound Sentence\n",num++);};

ssentence:  sclause'.' ;

csentence:  cclause'.' ;

sclause:    sclause' 'WORD | WORD ;
cclause:    sclause' 'CONJUNCTION' 'sclause| sclause' 'CONJUNCTION' 'cclause ;

%%
main()
{
yyin=fopen("input.txt","r");
yyparse();
fclose(yyin);
}
yyerror(const char* s)
{
fprintf(stderr, "ERROR:%s\n",s);
}

