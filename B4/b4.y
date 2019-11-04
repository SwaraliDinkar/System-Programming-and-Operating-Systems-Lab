%{
	#include <stdio.h>

	FILE* yyin;
%}

%token INT FLOAT CHAR BOOLEAN INTEGER_VALUE BOOLEAN_VALUE CHAR_VALUE FLOAT_VALUE VARIABLE COMMA SEMICOLON ASSIGN NEW_LINE

%%
statement: IntDeclaration statement|FloatDeclaration statement|CharDeclaration statement|BooleanDeclaration statement|
; 
IntDeclaration: INT IntSyntax SEMICOLON NEW_LINE { printf("Valid Int Declaration\n"); }
;
FloatDeclaration: FLOAT FloatSyntax SEMICOLON NEW_LINE { printf("Valid Float Declaration\n"); }
;
CharDeclaration: CHAR CharSyntax SEMICOLON NEW_LINE { printf("Valid Char Declaration\n"); }
;
BooleanDeclaration: BOOLEAN BooleanSyntax SEMICOLON NEW_LINE { printf("Valid Boolean Declaration\n"); }
;
IntSyntax: VARIABLE | VARIABLE COMMA IntSyntax | VARIABLE ASSIGN INTEGER_VALUE | VARIABLE ASSIGN INTEGER_VALUE COMMA IntSyntax
;
FloatSyntax: VARIABLE | VARIABLE COMMA FloatSyntax | VARIABLE ASSIGN FLOAT_VALUE | VARIABLE ASSIGN FLOAT_VALUE COMMA FloatSyntax
;
CharSyntax: VARIABLE | VARIABLE COMMA CharSyntax | VARIABLE ASSIGN CHAR_VALUE | VARIABLE ASSIGN CHAR_VALUE COMMA CharSyntax
;
BooleanSyntax: VARIABLE | VARIABLE COMMA BooleanSyntax | VARIABLE ASSIGN BOOLEAN_VALUE | VARIABLE ASSIGN BOOLEAN_VALUE COMMA BooleanSyntax
;

%%

int yywrap() { return 1; }

void yyerror(const char *s ) { fprintf(stderr, "ERROR: %s\n",s); }

int main(){
	yyin=fopen("input.txt","r");
	yyparse();
	fclose(yyin);
	return 0;
}
