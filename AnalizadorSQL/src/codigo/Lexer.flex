package codigo;
import static codigo.Tokens.*;
%%

%class Lexer
%type Tokens
%line
%column



Int = [0-9][0-9]*

String = ['][^'\n]*[']|[´][^´\n]*[´]
Float= [-+]?[0-9]+"."|[-+]?[0-9]+"."([0-9]+|("E"|"e")[-+]?[0-9]+|[0-9]+("E"|"e")[-+]?[0-9]+)
C = "ABSOLUTE"|"ACTION"|"ADA"|"ADD"|"ALL"|"ALLOCATE"|"ALTER"|"AND"|"ANY"|"ARE"|"AS"|"ASC"|"ASSERTION"|"AT"|"AUTHORIZATION"|"AVG"|"BACKUP"|"BEGIN"|"BETWEEN"|"BIT"|"BIT_LENGTH"|"BOTH"|"BREAK"|"BROWSE"|"BULK"|"BY"|"CASCADE"|"CASCADED"|"CASE"|"CAST"|"CATALOG"|"CHAR"|"CHAR_LENGTH"|"CHARACTER"|"CHARACTER_LENGTH"|"CHECK"|"CHECKPOINT"|"CLOSE"|"CLUSTERED"|"COALESCE"|"COLLATE"|"COLLATION"|"COLUMN"|"COMMIT"|"COMPUTE"|"CONNECT"|"CONNECTION"|"CONSTRAINT"|"CONSTRAINTS"|"CONTAINS"|"CONTAINSTABLE"|"CONTINUE"|"CONVERT"|"CORRESPONDING"|"COUNT"|"CREATE"|"CROSS"|"CURRENT"|"CURRENT_DATE"|"CURRENT_TIME"|"CURRENT_TIMESTAMP"|"CURRENT_USER"|"CURSOR"|"DATABASE"|"DATE"|"DAY"|"DBCC"|"DEALLOCATE"|"DEC"|"DECIMAL"|"DECLARE"|"DEFAULT"|"DEFERRABLE"|"DEFERRED"|"DELETE"|"DENY"|"DESC"|"DESCRIBE"|"DESCRIPTOR"|"DIAGNOSTICS"|"DISCONNECT"|"DISK"|"DISTINCT"|"DISTRIBUTED"|"DOMAIN"|"DOUBLE"|"DROP"|"DUMP"|"ELSE"|"END"|"END-EXEC"|"ERRLVL"|"ESCAPE"|"EXCEPT"|"EXCEPTION"|"EXEC"|"EXECUTE"|"EXISTS"|"EXIT"|"EXTERNAL"|"EXTRACT"|"FALSE"|"FETCH"|"FILE"|"FILLFACTOR"|"FIRST"|"FLOAT"|"FOR"|"FOREIGN"|"FORTRAN"|"FOUND"|"FREETEXT"|"FREETEXTTABLE"|"FROM"|"FULL"|"FUNCTION"|"GET"|"GLOBAL"|"GO"|"GOTO"|"GRANT"|"GROUP"|"HAVING"|"HOLDLOCK"|"HOUR"|"IDENTITY"|"IDENTITY_INSERT"|"IDENTITYCOL"|"IF"|"IMMEDIATE"|"IN"|"INCLUDE"|"INDEX"|"INDICATOR"|"INITIALLY"|"INNER"|"INPUT"|"INSENSITIVE"|"INSERT"|"INT"|"INTEGER"|"INTERSECT"|"INTERVAL"|"INTO"|"IS"|"ISOLATION"|"JOIN"|"KEY"|"KILL"|"LANGUAGE"|"LAST"|"LEADING"|"LEFT"|"LEVEL"|"LIKE"|"LINENO"|"LOAD"|"LOCAL"|"LOWER"|"MATCH"|"MAX"|"MERGE"|"MIN"|"MINUTE"|"MODULE"|"MONTH"|"NAMES"|"NATIONAL"|"NATURAL"|"NCHAR"|"NEXT"|"NO"|"NOCHECK"|"NONCLUSTERED"|"NONE"|"NOT"|"NULL"|"NULLIF"|"NUMERIC"|"OCTET_LENGTH"|"OF"|"OFF"|"OFFSETS"|"ON"|"ONLY"|"OPEN"|"OPENDATASOURCE"|"OPENQUERY"|"OPENROWSET"|"OPENXML"|"OPTION"|"OR"|"ORDER"|"OUTER"|"OUTPUT"|"OVER"|"OVERLAPS"|"PAD"|"PARTIAL"|"PASCAL"|"PERCENT"|"PIVOT"|"PLAN"|"POSITION"|"PRECISION"|"PREPARE"|"PRESERVE"|"PRIMARY"|"PRINT"|"PRIOR"|"PRIVILEGES"|"PROC"|"PROCEDURE"|"PUBLIC"|"RAISERROR"|"READ"|"READTEXT"|"REAL"|"RECONFIGURE"|"REFERENCES"|"RELATIVE"|"REPLICATION"|"RESTORE"|"RESTRICT"|"RETURN"|"REVERT"|"REVOKE"|"RIGHT"|"ROLLBACK"|"ROWCOUNT"|"ROWGUIDCOL"|"ROWS"|"RULE"|"SAVE"|"SCHEMA"|"SCROLL"|"SECOND"|"SECTION"|"SECURITYAUDIT"|"SELECT"|"SEMANTICKEYPHRASETABLE"|"SEMANTICSIMILARITYDETAILSTABLE"|"SEMANTICSIMILARITYTABLE"|"SESSION"|"SESSION_USER"|"SET"|"SETUSER"|"SHUTDOWN"|"SIZE"|"SMALLINT"|"SOME"|"SPACE"|"SQL"|"SQLCA"|"SQLCODE"|"SQLERROR"|"SQLSTATE"|"SQLWARNING"|"STATISTICS"|"SUBSTRING"|"SUM"|"SYSTEM_USER"|"TABLE"|"TABLESAMPLE"|"TEMPORARY"|"TEXTSIZE"|"THEN"|"TIME"|"TIMESTAMP"|"TIMEZONE_HOUR"|"TIMEZONE_MINUTE"|"TO"|"TOP"|"TRAILING"|"TRAN"|"TRANSACTION"|"TRANSLATE"|"TRANSLATION"|"TRIGGER"|"TRIM"|"TRUE"|"TRUNCATE"|"TRY_CONVERT"|"TSEQUAL"|"UNION"|"UNIQUE"|"UNKNOWN"|"UNPIVOT"|"UPDATE"|"UPDATETEXT"|"UPPER"|"USAGE"|"USE"|"USER"|"USING"|"VALUE"|"VALUES"|"VARCHAR"|"VARYING"|"VIEW"|"WAITFOR"|"WHEN"|"WHENEVER"|"WHERE"|"WHILE"|"WITH"|"WITHIN GROUP"|"WORK"|"WRITE"|"WRITETEXT"|"YEAR"|"ZONE"
TC = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EC = "--" [^\r\n]* [\r|\n|\r\n]?
Punt = "+"|"-"|"*"|"/"|"%"|"<"|"<="|">"|">="|"="|"=="|"!="|"&&"|"||"|"!"|";"|","|"."|"["|"]"|"("|")"|"{"|"}"|"[]"|"()"|"{}"|"@"|"#"|"##"
in = "/*" [^*]+
%{
    public String lexeme;
    public String column1;
    public String column2;
    public String line;
%}

%%


{Punt} {lexeme = yytext(); column1 = Integer.toString((yycolumn)); column2 = Integer.toString(yycolumn + yylength()-1); line = Integer.toString(yyline+1); return Puntuacion;}
{Int} { lexeme = yytext(); column1 = Integer.toString((yycolumn)); column2 = Integer.toString(yycolumn + yylength()-1);  line = Integer.toString(yyline+1); return Entero;}

{String} { lexeme = yytext(); column1 = Integer.toString((yycolumn)); column2 = Integer.toString(yycolumn + yylength()-1); line = Integer.toString(yyline+1); return Cadena;}
{Float} { lexeme = yytext(); column1 = Integer.toString((yycolumn)); column2 = Integer.toString(yycolumn + yylength()-1); line = Integer.toString(yyline+1); return Float;}
{C} {lexeme = yytext(); column1 = Integer.toString((yycolumn)); column2 = Integer.toString(yycolumn + yylength()-1); line = Integer.toString(yyline+1); return PalabraClave;}
[a-zA-Z][a-zA-Z0-9_]* { if(yytext().length()<=31){lexeme = yytext(); column1 = Integer.toString((yycolumn)); column2 = Integer.toString(yycolumn + yylength()-1); line = Integer.toString(yyline+1); return Identificador;} else{String cortador=yytext().substring(0,31); lexeme = cortador; column1 = Integer.toString((yycolumn)); column2 = Integer.toString(yycolumn + yylength()-30); line = Integer.toString(yyline+1); return IdentificadorTruncado;}}

[ \t\r\n]+  { /*se ignoran los espacios*/}
{in} { lexeme = yytext(); column1 = Integer.toString((yycolumn)); column2 = Integer.toString(yycolumn + yylength()-1); line = Integer.toString(yyline+1); return ComentarioE;}
{TC}|{EC} {/*se ignoran los comentario*/}

. { lexeme = yytext(); column1 = Integer.toString((yycolumn)); column2 = Integer.toString(yycolumn + yylength()-1); line = Integer.toString(yyline+1); return ERROR;}
