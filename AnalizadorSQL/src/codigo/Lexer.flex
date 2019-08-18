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
C = "ADD"|"ALL"|"ALTER"|"AND"|"ANY"|"AS"|"ASC"|"AUTHORIZATION"|"BACKUP"|"BEGIN"|"BETWEEN"|"BREAK"|"BROWSE"|"BULK"|"BY"|"CASCADE"|"CASE"|"CHECKPOINT"|"CLOSE"|"CLUSTERED"|"CLOSE"|"CLUSTERED"|"COALESCE"|"COLLATE"|"COLUMN"|"COMMIT"|"COMPUTE"|"CONSTRAINT"|"CONTAINS"|"CONTAINSTABLE"|"CONTINUE"|"CONVERT"|"CREATE"|"CROSS"|"CURRENT"|"CURRENT_DATE"|"CURRENT_TIME"|"CURRENT_TIMESTAMP"|"CURRENT_USER"|"CURSOR"|"DATABASE"|"DBCC"|"DEALLOCATE"|"DECLARE"|"DEFAULT"|"DELETE"|"DENY"|"DESC"|"DISK"|"DISTINCT"|"DISTRIBUTE"|"DOUBLE"|"DROP"|"DUMP"|"ELSE"|"END"|"ERRLVL"|"ESCAPE"|"EXCEPT"|"EXEC"|"EXECUTE"|"EXISTS"|"EXIT"|"EXTERNAL"|"FETCH"|"FILE"|"FILLFACTOR"|"FOR"|"FOREIGN"|"FREETEXT"|"FREETEXTTABLE"|"FROM"|"NULL"|"FUNCTION"|"GOTO"|"GRANT"|"GROUP"|"HAVING"|"HOLDLOCK"|"IDENTITY"|"IDENTITY_INSERT"|"IDENTITYCOL"|"IF"|"IN"|"INDEX"|"INNER"|"INSERT"|"INTERSECT"|"INTO"|"IS"|"JOIN"|"KEY"|"KILL"|"LEFT"|"LIKE"|"LINENO"|"LOAD"|"MERGE"|"NATIONAL"|"NOCHECK"|"NONCLUSTERED"|"NOT"|"NULL"|"NULLIF"|"OF"|"OFF"|"OFFSETS"|"ON"|"OPEN"|"OPENDATASOURCE"|"OPENQUERY"|"OPENROWSET"|"OPENXML"|"OPTION"|"OR"|"ORDER"|"OUTER"|"OVER"|"PERCENT"|"PIVOT"|"PLAN"|"PRECISION"|"PRIMARY"|"PRINT"|"PROC"|"PROCEDURE"|"PUBLIC"|"RAISERROR"|"READ"|"READTEXT"|"RECONFIGURE"|"REFERENCES"|"REPLICATION"|"RESTORE"|"RESTRICT"|"RETURN"|"REVERT"|"REVOKE"|"RIGHT"|"ROLLBACK"|"ROWCOUNT"|"ROWGUIDCOL"|"RULE"|"SAVE"|"SCHEMA"|"SECURITYAUDIT"|"SELECT"|"SEMANTICKEYPHRASETABLE"|"SEMANTICSIMILARITYDETAILSTABLE"|"SEMANTICSIMILARITYTABLE"|"SESSION_USER"|"SET"|"SETUSER"|"SHUTDOWN"|"SOME"|"STATISTICS"|"SYSTEM_USER"|"TABLE"|"TABLESAMPLE"|"TEXTSIZE"|"THEN"|"TO"|"TOP"|"TRAN"|"TRANSACTION"|"TRIGGER"|"TRUNCATE"|"TRY_CONVERT"|"TSEQUAL"|"UNION"|"UNIQUE"|"UNPIVOT"|"UPDATE"|"UPDATETEXT"|"USE"|"USER"|"VALUES"|"VARYING"|"VIEW"|"WAITFOR"|"WHEN"|"WHERE"|"WHILE"|"WITH"|"WITHIN GROUP"|"WRITETEXT"
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



{Int} { lexeme = yytext(); column1 = Integer.toString((yycolumn)); column2 = Integer.toString(yycolumn + yylength()-1);  line = Integer.toString(yyline+1); return Entero;}
{Bool} { lexeme = yytext(); column1 = Integer.toString((yycolumn)); column2 = Integer.toString(yycolumn + yylength()-1); line = Integer.toString(yyline+1); return Bit;}
{String} { lexeme = yytext(); column1 = Integer.toString((yycolumn)); column2 = Integer.toString(yycolumn + yylength()-1); line = Integer.toString(yyline+1); return Cadena;}
{Float} { lexeme = yytext(); column1 = Integer.toString((yycolumn)); column2 = Integer.toString(yycolumn + yylength()-1); line = Integer.toString(yyline+1); return Float;}
{C} {lexeme = yytext(); column1 = Integer.toString((yycolumn)); column2 = Integer.toString(yycolumn + yylength()-1); line = Integer.toString(yyline+1); return PalabraClave;}
[a-zA-Z][a-zA-Z0-9_]* { if(yytext().length()<=31){lexeme = yytext(); column1 = Integer.toString((yycolumn)); column2 = Integer.toString(yycolumn + yylength()-1); line = Integer.toString(yyline+1); return Identificador;} else{String cortador=yytext().substring(0,31); lexeme = cortador; column1 = Integer.toString((yycolumn)); column2 = Integer.toString(yycolumn + yylength()-30); line = Integer.toString(yyline+1); return IdentificadorTruncado;}}
[ ,\t,\r,\n]+  { /*se ignoran los espacios*/}
{in} { lexeme = yytext(); column1 = Integer.toString((yycolumn)); column2 = Integer.toString(yycolumn + yylength()-1); line = Integer.toString(yyline+1); return ComentarioE;}
{TC}|{EC} {/*se ignoran los comentario*/}
{Punt} {lexeme = yytext(); column1 = Integer.toString((yycolumn)); column2 = Integer.toString(yycolumn + yylength()-1); line = Integer.toString(yyline+1); return Puntuacion;}
. { lexeme = yytext(); column1 = Integer.toString((yycolumn)); column2 = Integer.toString(yycolumn + yylength()-1); line = Integer.toString(yyline+1); return ERROR;}
