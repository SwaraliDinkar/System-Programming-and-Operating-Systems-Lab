#include<stdio.h>
#include "library.h"

int main()
{

float a,b;
char c,d;
printf("Enter the first number:-\n");
scanf("%d",&a);
printf("\nEnter the second number:-\n");
scanf("%d",&b);
scanf("%d",&d);
printf("\nEnter the opertion:-\n");
scanf("%c",&c);

switch(c)
{

case '+':
 printf("%f\n",add(a,b));
 break;

case '-':
 printf("%f\n",sub(a,b));
 break;

case '*':
 printf("%f\n",mul(a,b));
 break;

case '/':
if(b!=0)
{
 printf("%f\n",div(a,b));
 break;
}
else
{
printf("Denominator 0 is not allowed");
break;
}

}
return 0;
}



