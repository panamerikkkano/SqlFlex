package sqlex;
import static sqlex.Token.*;
%%
%class Lexer
%type Token
letra=[A-Za-z]
letras=letra+
digito=[0-9]
digitos=digito+
ws=[ ,\r,\t,\n]
select = (S|s)(E|e)(L|l)(E|e)(C|c)(T|t)
from = (F|f)(R|r)(O|o)(M|m)
where = (W|w)(H|h)(E|e)(R|r)(E|e)
id = letra(letras|digitos)*
%{
    public String lexeme;
%}
%%
{ws} {/*Ignore*/}
"//".* {/*Ignore*/}
"=" {return igual;}

{select} {lexeme=yytext(); return select;}
{from} {lexeme=yytext(); return from;}
{where} {lexeme=yytext(); return where;}
{id} {lexeme=yytext(); return id;}
. {return ERROR;}