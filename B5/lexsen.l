%{
#include<stdio.h>
#include "y.tab.h"
extern int yylval;
%}
%%
"and"|"or"|"but"|"though"|"because"   {return(CONJUNCTION);}
[^ \t\n\.]+                           {return(WORD);}
\n                                    {return 0;}
.                                     {return(yytext[0]);}
%%
int yywrap()
{
return (1);
}

//Give input as :
//sentence 1(dot)(space)sentence 2(dot)(space)...
