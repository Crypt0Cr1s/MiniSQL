package codigo;
import static codigo.Tokens.*;
%%

%class Lexer
%type Tokens
%line
%column



Int = [0-9][0-9]*
Bool ="true"|"false"|"NULL"
String = \" [^\r\n]+  \"
Float= [-+]?[0-9]+"."|[-+]?[0-9]+"."([0-9]+|("E"|"e")[-+]?[0-9]+|[0-9]+("E"|"e")[-+]?[0-9]+)
C = "void"|"int"|"double"|"bool"|"string"|"class"|"interface"|"null"|"this"|"extends"|"implements"|"for"|"while"|"if"|"else"|"return"|"break"|"New"|"NewArray"
TC = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EC = "//" [^\r\n]* [\r|\n|\r\n]?
Punt = "+"|"-"|"*"|"/"|"%"|"<"|"<="|">"|">="|"="|"=="|"!="|"&&"|"||"|"!"|";"|","|"."|"["|"]"|"("|")"|"{"|"}"|"[]"|"()"|"{}"
in = "/*" [^*]+ 
%{
    public String lexeme;
    public String column1;
    public String column2;
    public String line;
%}

%%



{Int} { lexeme = yytext(); column1 = Integer.toString((yycolumn+1) + yylength() - 1); line = Integer.toString(yyline+1); return Entero;}
{Bool} { lexeme = yytext(); column1 = Integer.toString((yycolumn+1) + yylength() - 1); line = Integer.toString(yyline+1); return Bit;}
{String} { lexeme = yytext(); column1 = Integer.toString((yycolumn+1) + yylength() - 1); line = Integer.toString(yyline+1); return Cadena;}
{Float} { lexeme = yytext(); column1 = Integer.toString((yycolumn+1) + yylength() - 1); line = Integer.toString(yyline+1); return Float;}
{C} {lexeme = yytext(); column1 = Integer.toString((yycolumn+1) + yylength() - 1); line = Integer.toString(yyline+1); return PalabraClave;}
[a-zA-Z][a-zA-Z0-9_]* { if(yytext().length()<=31){lexeme = yytext(); column1 = Integer.toString((yycolumn+1) + yylength() - 1); line = Integer.toString(yyline+1); return Identificador;} else{String cortador=yytext().substring(0,31); lexeme = cortador; column1 = Integer.toString((yycolumn+1) + yylength() - (yylength()-30)); line = Integer.toString(yyline+1); return IdentificadorTruncado;}}
[ ,\t,\r,\n]+  { /*se ignoran los espacios*/}
{in} { lexeme = yytext(); column1 = Integer.toString((yycolumn+1) + yylength() - 1); line = Integer.toString(yyline+1); return ComentarioE;}
{TC}|{EC} {/*se ignoran los comentario*/}
{Punt} {lexeme = yytext(); column1 = Integer.toString((yycolumn+1) + yylength() - 1); line = Integer.toString(yyline+1); return Puntuacion;}
. { lexeme = yytext(); column1 = Integer.toString((yycolumn+1) + yylength() - 1); line = Integer.toString(yyline+1); return ERROR;}





