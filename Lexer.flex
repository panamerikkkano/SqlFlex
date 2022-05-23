package sqlex;
import static sqlex.Token.*;
%%
%class Lexer
%type Token
letra=[a-zA-Z]
digito=[0-9]
digitos={digito}+
ws=[ ,\n]
select = (S|s)(E|e)(L|l)(E|e)(C|c)(T|t)
from = (F|f)(R|r)(O|o)(M|m)
where = (W|w)(H|h)(E|e)(R|r)(E|e)
id = {letra}({letra}|{digito})*
%{
    public String lexeme;
%}
%%
{ws} {/*Ignore*/}
"//".* {/*Ignore*/}
{select} {lexeme=yytext(); return PC;}
{from} {lexeme=yytext(); return PC;}
{where} {lexeme=yytext(); return PC;}
{id} {lexeme=yytext(); return ID;}
{digitos} {lexeme=yytext(); return NUM;}
"+" {return SUM;}
"-" {return RES;}
"*" {return MULT;}
"/" {return DIV;}
"=" {return EQ;}
"<" {return LT;}
">" {return GT;}
"<=" {return LE;}
">=" {return GE;}
. {return ERROR;}