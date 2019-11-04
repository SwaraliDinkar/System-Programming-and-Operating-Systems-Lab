%{
#include <stdio.h>
%}
keyword  import|class|int|float|double|char|boolean|String|new|static|void|if|else|for|while|do
access private|public|protected
identifier [a-zA-Z]+[a-zA-Z0-9]*
number [0-9]+.\?[0-9]*
whitespaces [ \t]
newline \n
lit \".*\"
assignment =
relational <|>|<=|>=
operator \+|\*|\-|\/
increment \++|\--

%%
{keyword}      {ECHO; printf("\tkeyword\n");}
{access}       {ECHO; printf("\tAccess specifier\n");}
{identifier}    {ECHO; printf("\tIdentifier\n");}
{number}       {ECHO; printf("\tNumber\n");}
{lit}          {ECHO; printf("\tLiteral\n");}
{assignment}   {ECHO; printf("\tAssignment operators\n");}
{relational}   {ECHO; printf("\trelational operators\n");}
{operator}     {ECHO; printf("\toperators\n");}
{increment}    {ECHO; printf("\tIncrement operators\n");}
{whitespaces}   {;}
{newline}       {;}
.               {;}

%%

int main(int arc,char* argv[])
{
yyin=fopen(argv[1],"r");
yylex();
fclose(yyin);
}

int yywrap(void)
{
return 1;
}
