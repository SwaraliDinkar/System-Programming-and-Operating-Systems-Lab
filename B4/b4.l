%{
	#include <stdio.h>
	#include "y.tab.h"
%}

%%
int { printf("%s --> Datatype\n", yytext); return INT; }
float { printf("%s --> Datatype\n", yytext); return FLOAT; }
char { printf("%s --> Datatype\n", yytext); return CHAR; }
boolean { printf("%s --> Datatype\n", yytext); return BOOLEAN; }
true|false { printf("%s --> Boolean Value\n", yytext); return BOOLEAN_VALUE; }
['][^\t\n]['] { printf("%s --> Character\n", yytext); return CHAR_VALUE; }
[0-9]+ { printf("%s --> Integer\n", yytext); return INTEGER_VALUE; }
[0-9]+.[0-9]+ { printf("%s --> Float Value\n", yytext); return FLOAT_VALUE; }
[a-zA-z_][a-zA-z0-9_]* { printf("%s --> Variable\n", yytext); return VARIABLE; }
"," { return COMMA; }
";" { return SEMICOLON; }
"=" { return ASSIGN; }
\n { return NEW_LINE; }
. ;

%%

