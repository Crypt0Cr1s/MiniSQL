package codigo;
import java_cup.runtime.Symbol;
%%

%class Lexer
%type java_cup.runtime.Symbol
%line
%column
%cup

%{
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
     private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }

%}










Int = [0-9][0-9]*

String = ['][^'\n]*[']|[´][^´\n]*[´]
Float= [-+]?[0-9]+"."|[-+]?[0-9]+"."([0-9]+|("E"|"e")[-+]?[0-9]+|[0-9]+("E"|"e")[-+]?[0-9]+)
TC = "/*"  ~"*/" | "/*" "*"+ "/"
EC = "--" [^\r\n]* [\r|\n|\r\n]?
//Punt = "+"|"-"|"*"|"/"|"%"|"<"|"<="|">"|">="|"="|"=="|"!="|"&&"|"||"|"!"|";"|","|"."|"["|"]"|"("|")"|"{"|"}"|"[]"|"()"|"{}"|"@"|"#"|"##"
in = "/*" [^*\n]+

RETURNS = "RETURNS"
ADD = "ADD"
ALL = "ALL"
ALTER = "ALTER"
AND = "AND"
ANY = "ANY"
AS = "AS"
ASC = "ASC"
AUTHORIZATION = "AUTHORIZATION"
BACKUP = "BACKUP"
BEGIN = "BEGIN"
BETWEEN = "BETWEEN"
BREAK = "BREAK"
BROWSE ="BROWSE"
BULK ="BULK"
BY = "BY"
CASCADE = "CASCADE"
CASE = "CASE"
CHECK = "CHECK"
CHECKPOINT = "CHECKPOINT"
CLOSE = "CLOSE"
CLUSTERED = "CLUSTERED"
COALESCE = "COALESCE"
COLLATE = "COLLATE"
COLUMN = "COLUMN"
COMMIT = "COMMIT"
COMPUTE = "COMPUTE"
CONSTRAINT = "CONSTRAINT"
CONTAINS = "CONTAINS"
CONTAINSTABLE = "CONTAINSTABLE"
CONTINUE = "CONTINUE"/* ε */ ;
CONVERT = "CONVERT"
CREATE = "CREATE"
CROSS = "CROSS"
CURRENT = "CURRENT"
CURRENT_DATE = "CURRENT_DATE"
CURRENT_TIME = "CURRENT_TIME"
CURRENT_TIMESTAMP = "CURRENT_TIMESTAMP"
CURRENT_USER = "CURRENT_USER"
CURSOR = "CURSOR"
DATABASE = "DATABASE"
DBCC = "DBCC"
DEALLOCATE = "DEALLOCATE"
DECLARE = "DECLARE"
DEFAULT = "DEFAULT"
DELETE = "DELETE"
DENY = "DENY"
DESC = "DESC"
DISK = "DISK"
DISTINCT = "DISTINCT"
DISTRIBUTED = "DISTRIBUTED"
DOUBLE = "DOUBLE"
DROP = "DROP"
DUMP = "DUMP"
ELSE = "ELSE"
END = "END"
ERRLVL = "ERRLVL"
ESCAPE = "ESCAPE"
EXCEPT = "EXCEPT"
EXEC = "EXEC"
EXECUTE = "EXECUTE"
EXISTS = "EXISTS"
EXIT = "EXIT"
EXTERNAL = "EXTERNAL"
FETCH = "FETCH"
FILE = "FILE"
FILLFACTOR = "FILLFACTOR"
FOR = "FOR"
FOREIGN = "FOREIGN"
FREETEXT = "FREETEXT"
FREETEXTTABLE = "FREETEXTTABLE"
FROM = "FROM"
FULL = "FULL"
FUNCTION = "FUNCTION"
GOTO = "GOTO"
GRANT = "GRANT"
GROUP = "GROUP"
HAVING = "HAVING"
HOLDLOCK = "HOLDLOCK"
IDENTITY = "IDENTITY"
IDENTITY_INSERT = "IDENTITY_INSERT"
IDENTITYCOL = "IDENTITYCOL"
IF = "IF"
IN = "IN"
INDEX = "INDEX"
INNER = "INNER"
INSERT = "INSERT"
INTERSECT = "INTERSECT"
INTO = "INTO"
IS = "IS"
JOIN = "JOIN"
KEY = "KEY"
KILL = "KILL"
LEFT = "LEFT"
LIKE = "LIKE"
LINENO = "LINENO"
LOAD = "LOAD"
MERGE = "MERGE"
NATIONAL = "NATIONAL"
NOCHECK = "NOCHECK"
NONCLUSTERED = "NONCLUSTERED"
NOT = "NOT"
NULL = "NULL"
NULLIF = "NULLIF"
OF = "OF"
OFF = "OFF"
OFFSETS = "OFFSETS"
ON = "ON"
OPEN = "OPEN"
OPENDATASOURCE = "OPENDATASOURCE"
OPENQUERY = "OPENQUERY"
OPENROWSET = "OPENROWSET"
OPENXML = "OPENXML"
OPTION = "OPTION"
OR = "OR"
ORDER = "ORDER"
OUTER = "OUTER"
OVER = "OVER"
PERCENT = "PERCENT"
PIVOT = "PIVOT"
PLAN = "PLAN"
PRECISION = "PRECISION"
PRIMARY = "PRIMARY"
PRINT = "PRINT"
PROC = "PROC"
PROCEDURE = "PROCEDURE"
PUBLIC = "PUBLIC"
RAISERROR = "RAISERROR"
READ = "READ"
READTEXT = "READTEXT"
RECONFIGURE = "RECONFIGURE"
REFERENCES = "REFERENCES"
REPLICATION = "REPLICATION"
RESTORE = "RESTORE"
RESTRICT = "RESTRICT"
RETURN = "RETURN"
REVERT = "REVERT"
REVOKE = "REVOKE"
RIGHT = "RIGHT"
ROLLBACK = "ROLLBACK"
ROWCOUNT = "ROWCOUNT"
ROWGUIDCOL = "ROWGUIDCOL"
RULE = "RULE"
SAVE = "SAVE"
SCHEMA = "SCHEMA"
SECURITYAUDIT = "SECURITYAUDIT"
SELECT = "SELECT"
SEMANTICKEYPHRASETABLE = "SEMANTICKEYPHRASETABLE"
SEMANTICSIMILARITYDETAILSTABLE = "SEMANTICSIMILARITYDETAILSTABLE"
SEMANTICSIMILARITYTABLE = "SEMANTICSIMILARITYTABLE"
SESSION_USER = "SESSION_USER"
SET = "SET"
SETUSER = "SETUSER"
SHUTDOWN = "SHUTDOWN"
SOME = "SOME"
STATISTICS = "STATISTICS"
SYSTEM_USER = "SYSTEM_USER"
TABLE = "TABLE"
TABLESAMPLE = "TABLESAMPLE"
TEXTSIZE = "TEXTSIZE"
THEN = "THEN"
TO = "TO"
TOP = "TOP"
TRAN = "TRAN"
TRANSACTION = "TRANSACTION"
TRIGGER = "TRIGGER"
TRUNCATE = "TRUNCATE"
TRY_CONVERT = "TRY_CONVERT"
TSEQUAL = "TSEQUAL"
UNION = "UNION"
UNIQUE = "UNIQUE"
UNPIVOT = "UNPIVOT"
UPDATE = "UPDATE"
UPDATETEXT = "UPDATETEXT"
USE = "USE"
USER = "USER"
VALUES = "VALUES"
VARYING = "VARYING"
VIEW = "VIEW"
WAITFOR = "WAITFOR"
WHEN = "WHEN"
WHERE = "WHERE"
WHILE = "WHILE"
WITH = "WITH"
WITHIN_GROUP = "WITHIN GROUP"
WRITETEXT = "WRITETEXT"
DELAYED_DURABILITY = "DELAYED_DURABILITY"
ENCRYPTION = "ENCRYPTION"

/* Empiezan ODBC*/

ABSOLUTE = "ABSOLUTE"
ACTION = "ACTION"
ADA = "ADA"
ALLOCATE = "ALLOCATE"
ARE = "ARE"
ASSERTION = "ASSERTION"
AT = "AT"
AVG = "AVG"
BIT = "BIT"
BIT_LENGTH = "BIT_LENGTH"
BOTH = "BOTH"
CASCADED = "CASCADED"
CAST = "CAST"
CATALOG = "CATALOG"
CHAR = "CHAR"
CHAR_LENGTH = "CHAR_LENGTH"
CHARACTER = "CHARACTER"
CHARACTER_LENGTH = "CHARACTER_LENGTH"
COLLATION = "COLLATION"
CONNECT = "CONNECT"
CONNECTION = "CONNECTION"
CONSTRAINTS = "CONSTRAINTS"
CORRESPONDING = "CORRESPONDING"
COUNT = "COUNT"
DATE = "DATE"
DAY = "DAY"
DEC = "DEC"
DECIMAL = "DECIMAL"
DEFERRABLE = "DEFERRABLE"
DEFERRED = "DEFERRED"
DESCRIBE = "DESCRIBE"
DESCRIPTOR = "DESCRIPTOR"
DIAGNOSTICS = "DIAGNOSTICS"
DISCONNECT = "DISCONNECT"
DOMAIN = "DOMAIN"
END_EXEC = "END-EXEC"
EXCEPTION = "EXCEPTION"
EXTRACT = "EXTRACT"
FALSE = "FALSE"
FIRST = "FIRST"
FLOAT = "FLOAT"
FORTRAN = "FORTRAN"
FOUND = "FOUND"
GET = "GET"
GLOBAL = "GLOBAL"
GO = "GO"
HOUR = "HOUR"
IMMEDIATE = "IMMEDIATE"
INCLUDE = "INCLUDE"
INDICATOR = "INDICATOR"
INITIALLY = "INITIALLY"
INPUT = "INPUT"
INSENSITIVE = "INSENSITIVE"
INT = "INT"
INTEGER = "INTEGER"
INTERVAL = "INTERVAL"
ISOLATION = "ISOLATION"
LANGUAGE = "LANGUAGE"
LAST = "LAST"
LEADING = "LEADING"
LEVEL = "LEVEL"
LOCAL = "LOCAL"
LOWER = "LOWER"
MATCH = "MATCH"
MAX = "MAX"
MIN = "MIN"
MINUTE = "MINUTE"
MODULE = "MODULE"
MONTH = "MONTH"
NAMES = "NAMES"
NATURAL = "NATURAL"
NCHAR = "NCHAR"
NEXT = "NEXT"
NO = "NO"
NONE = "NONE"
NUMERIC = "NUMERIC"
OCTET_LENGTH = "OCTET_LENGTH"
ONLY = "ONLY"
OUTPUT = "OUTPUT"
OVERLAPS = "OVERLAPS"
PAD = "PAD"
PARTIAL = "PARTIAL"
PASCAL = "PASCAL"
POSITION = "POSITION"
PREPARE = "PREPARE"
PRESERVE = "PRESERVE"
PRIOR = "PRIOR"
PRIVILEGES = "PRIVILEGES"
REAL = "REAL"
RELATIVE = "RELATIVE"
ROWS = "ROWS"
SCROLL = "SCROLL"
SECOND = "SECOND"
SECTION = "SECTION"
SESSION = "SESSION"
SIZE = "SIZE"
SMALLINT = "SMALLINT"
SPACE = "SPACE"
SQL = "SQL"
SQLCA = "SQLCA"
SQLCODE = "SQLCODE"
SQLERROR = "SQLERROR"
SQLSTATE = "SQLSTATE"
SQLWARNING = "SQLWARNING"
SUBSTRING = "SUBSTRING"
SUM = "SUM"
TEMPORARY = "TEMPORARY"
TIME = "TIME"
TIMESTAMP = "TIMESTAMP"
TIMEZONE_HOUR = "TIMEZONE_HOUR"
TIMEZONE_MINUTE = "TIMEZONE_MINUTE"
TRAILING = "TRAILING"
TRANSLATE = "TRANSLATE"
TRANSLATION = "TRANSLATION"
TRIM = "TRIM"
TRUE = "TRUE"
UNKNOWN = "UNKNOWN"
UPPER = "UPPER"
USAGE = "USAGE"
USING = "USING"
VALUE = "VALUE"
VARCHAR = "VARCHAR"
WHENEVER = "WHENEVER"
WORK = "WORK"
WRITE = "WRITE"
YEAR = "YEAR"
ZONE = "ZONE"
LOGIN = "LOGIN"
FORWARD_ONLY = "FORWARD_ONLY"
STATIC = "STATIC"
KEYSET = "KEYSET"
DYNAMIC = "DYNAMIC"
FAST_FORWARD = "FAST_FORWARD"
READ_ONLY = "READ_ONLY"
SCROLL_LOCKS = "SCROLL_LOCKS"
OPTIMISTIC = "OPTIMISTIC"
TYPE_WARNING = "TYPE_WARNING"
RECOMPILE = "RECOMPILE"
OUT = "OUT"
MARK = "MARK"


%{
    public String lexeme;
    public String column1;
    public String column2;
    public String line;
%}

%%


//{Punt} {return new Symbol(sym.Int, yycolumn, yyline, yytext());}
{Int} {return new Symbol(sym.Entero, yycolumn, yyline, yytext());}
{String} {return new Symbol(sym.Cadena, yycolumn, yyline, yytext());}
{Float} {return new Symbol(sym.Float, yycolumn, yyline, yytext());}

{ADD} {return new Symbol(sym.ADD, yycolumn, yyline, yytext());}
{ALL} {return new Symbol(sym.ALL, yycolumn, yyline, yytext());}
{ALTER} {return new Symbol(sym.ALTER, yycolumn, yyline, yytext());}
{AND} {return new Symbol(sym.AND, yycolumn, yyline, yytext());}
{ANY} {return new Symbol(sym.ANY, yycolumn, yyline, yytext());}
{AS} {return new Symbol(sym.AS, yycolumn, yyline, yytext());}
{ASC} {return new Symbol(sym.ASC, yycolumn, yyline, yytext());}
{AUTHORIZATION} {return new Symbol(sym.AUTHORIZATION, yycolumn, yyline, yytext());}
{BACKUP} {return new Symbol(sym.BACKUP, yycolumn, yyline, yytext());}
{BEGIN} {return new Symbol(sym.BEGIN, yycolumn, yyline, yytext());}
{BETWEEN} {return new Symbol(sym.BETWEEN, yycolumn, yyline, yytext());}
{BREAK} {return new Symbol(sym.BREAK, yycolumn, yyline, yytext());}
{BROWSE} {return new Symbol(sym.BROWSE, yycolumn, yyline, yytext());}
{BULK} {return new Symbol(sym.BULK, yycolumn, yyline, yytext());}
{BY} {return new Symbol(sym.BY, yycolumn, yyline, yytext());}
{CASCADE} {return new Symbol(sym.CASCADE, yycolumn, yyline, yytext());}
{CASE} {return new Symbol(sym.CASE, yycolumn, yyline, yytext());}
{CHECK} {return new Symbol(sym.CHECK, yycolumn, yyline, yytext());}
{CHECKPOINT} {return new Symbol(sym.CHECKPOINT, yycolumn, yyline, yytext());}
{CLOSE} {return new Symbol(sym.CLOSE, yycolumn, yyline, yytext());}
{CLUSTERED} {return new Symbol(sym.CLUSTERED, yycolumn, yyline, yytext());}
{COALESCE} {return new Symbol(sym.COALESCE, yycolumn, yyline, yytext());}
{COLLATE} {return new Symbol(sym.COLLATE, yycolumn, yyline, yytext());}
{COLUMN} {return new Symbol(sym.COLUMN, yycolumn, yyline, yytext());}
{COMMIT} {return new Symbol(sym.COMMIT, yycolumn, yyline, yytext());}
{COMPUTE} {return new Symbol(sym.COMPUTE, yycolumn, yyline, yytext());}
{CONSTRAINT} {return new Symbol(sym.CONSTRAINT, yycolumn, yyline, yytext());}
{CONTAINS} {return new Symbol(sym.CONTAINS, yycolumn, yyline, yytext());}
{CONTAINSTABLE} {return new Symbol(sym.CONTAINSTABLE, yycolumn, yyline, yytext());}
{CONTINUE} {return new Symbol(sym.CONTINUE, yycolumn, yyline, yytext());}
{CONVERT} {return new Symbol(sym.CONVERT, yycolumn, yyline, yytext());}
{CREATE} {return new Symbol(sym.CREATE, yycolumn, yyline, yytext());}
{CROSS} {return new Symbol(sym.CROSS, yycolumn, yyline, yytext());}
{CURRENT} {return new Symbol(sym.CURRENT, yycolumn, yyline, yytext());}
{CURRENT_DATE} {return new Symbol(sym.CURRENT_DATE, yycolumn, yyline, yytext());}
{CURRENT_TIME} {return new Symbol(sym.CURRENT_TIME, yycolumn, yyline, yytext());}
{CURRENT_TIMESTAMP} {return new Symbol(sym.CURRENT_TIMESTAMP, yycolumn, yyline, yytext());}
{CURRENT_USER} {return new Symbol(sym.CURRENT_USER, yycolumn, yyline, yytext());}
{CURSOR} {return new Symbol(sym.CURSOR, yycolumn, yyline, yytext());}
{DATABASE} {return new Symbol(sym.DATABASE, yycolumn, yyline, yytext());}
{DBCC} {return new Symbol(sym.DBCC, yycolumn, yyline, yytext());}
{DEALLOCATE} {return new Symbol(sym.DEALLOCATE, yycolumn, yyline, yytext());}
{DECLARE} {return new Symbol(sym.DECLARE, yycolumn, yyline, yytext());}
{DEFAULT} {return new Symbol(sym.DEFAULT, yycolumn, yyline, yytext());}
{DELETE} {return new Symbol(sym.DELETE, yycolumn, yyline, yytext());}
{DENY} {return new Symbol(sym.DENY, yycolumn, yyline, yytext());}
{DESC} {return new Symbol(sym.DESC, yycolumn, yyline, yytext());}
{DISK} {return new Symbol(sym.DISK, yycolumn, yyline, yytext());}
{DISTINCT} {return new Symbol(sym.DISTINCT, yycolumn, yyline, yytext());}
{DISTRIBUTED} {return new Symbol(sym.DISTRIBUTED, yycolumn, yyline, yytext());}
{DOUBLE} {return new Symbol(sym.DOUBLE, yycolumn, yyline, yytext());}
{DROP} {return new Symbol(sym.DROP, yycolumn, yyline, yytext());}
{DUMP} {return new Symbol(sym.DUMP, yycolumn, yyline, yytext());}
{ELSE} {return new Symbol(sym.ELSE, yycolumn, yyline, yytext());}
{END} {return new Symbol(sym.END, yycolumn, yyline, yytext());}
{ERRLVL} {return new Symbol(sym.ERRLVL, yycolumn, yyline, yytext());}
{ESCAPE} {return new Symbol(sym.ESCAPE, yycolumn, yyline, yytext());}
{EXCEPT} {return new Symbol(sym.EXCEPT, yycolumn, yyline, yytext());}
{EXEC} {return new Symbol(sym.EXEC, yycolumn, yyline, yytext());}
{EXECUTE} {return new Symbol(sym.EXECUTE, yycolumn, yyline, yytext());}
{EXISTS} {return new Symbol(sym.EXISTS, yycolumn, yyline, yytext());}
{EXIT} {return new Symbol(sym.EXIT, yycolumn, yyline, yytext());}
{EXTERNAL} {return new Symbol(sym.EXTERNAL, yycolumn, yyline, yytext());}
{FETCH} {return new Symbol(sym.FETCH, yycolumn, yyline, yytext());}
{FILE} {return new Symbol(sym.FILE, yycolumn, yyline, yytext());}
{FILLFACTOR} {return new Symbol(sym.FILLFACTOR, yycolumn, yyline, yytext());}
{FOR} {return new Symbol(sym.FOR, yycolumn, yyline, yytext());}
{FOREIGN} {return new Symbol(sym.FOREIGN, yycolumn, yyline, yytext());}
{FREETEXT} {return new Symbol(sym.FREETEXT, yycolumn, yyline, yytext());}
{FREETEXTTABLE} {return new Symbol(sym.FREETEXTTABLE, yycolumn, yyline, yytext());}
{FROM} {return new Symbol(sym.FROM, yycolumn, yyline, yytext());}
{FULL} {return new Symbol(sym.FULL, yycolumn, yyline, yytext());}
{FUNCTION} {return new Symbol(sym.FUNCTION, yycolumn, yyline, yytext());}
{GOTO} {return new Symbol(sym.GOTO, yycolumn, yyline, yytext());}
{GRANT} {return new Symbol(sym.GRANT, yycolumn, yyline, yytext());}
{GROUP} {return new Symbol(sym.GROUP, yycolumn, yyline, yytext());}
{HAVING} {return new Symbol(sym.HAVING, yycolumn, yyline, yytext());}
{HOLDLOCK} {return new Symbol(sym.HOLDLOCK, yycolumn, yyline, yytext());}
{IDENTITY} {return new Symbol(sym.IDENTITY, yycolumn, yyline, yytext());}
{IDENTITY_INSERT} {return new Symbol(sym.IDENTITY_INSERT, yycolumn, yyline, yytext());}
{IDENTITYCOL} {return new Symbol(sym.IDENTITYCOL, yycolumn, yyline, yytext());}
{IF} {return new Symbol(sym.IF, yycolumn, yyline, yytext());}
{IN} {return new Symbol(sym.IN, yycolumn, yyline, yytext());}
{INDEX} {return new Symbol(sym.INDEX, yycolumn, yyline, yytext());}
{INNER} {return new Symbol(sym.INNER, yycolumn, yyline, yytext());}
{INSERT} {return new Symbol(sym.INSERT, yycolumn, yyline, yytext());}
{INTERSECT} {return new Symbol(sym.INTERSECT, yycolumn, yyline, yytext());}
{INTO} {return new Symbol(sym.INTO, yycolumn, yyline, yytext());}
{IS} {return new Symbol(sym.IS, yycolumn, yyline, yytext());}
{JOIN} {return new Symbol(sym.JOIN, yycolumn, yyline, yytext());}
{KEY} {return new Symbol(sym.KEY, yycolumn, yyline, yytext());}
{KILL} {return new Symbol(sym.KILL, yycolumn, yyline, yytext());}
{LEFT} {return new Symbol(sym.LEFT, yycolumn, yyline, yytext());}
{LIKE} {return new Symbol(sym.LIKE, yycolumn, yyline, yytext());}
{LINENO} {return new Symbol(sym.LINENO, yycolumn, yyline, yytext());}
{LOAD} {return new Symbol(sym.LOAD, yycolumn, yyline, yytext());}
{MERGE} {return new Symbol(sym.MERGE, yycolumn, yyline, yytext());}
{NATIONAL} {return new Symbol(sym.NATIONAL, yycolumn, yyline, yytext());}
{NOCHECK} {return new Symbol(sym.NOCHECK, yycolumn, yyline, yytext());}
{NONCLUSTERED} {return new Symbol(sym.NONCLUSTERED, yycolumn, yyline, yytext());}
{NOT} {return new Symbol(sym.NOT, yycolumn, yyline, yytext());}
{NULL} {return new Symbol(sym.NULL, yycolumn, yyline, yytext());}
{NULLIF} {return new Symbol(sym.NULLIF, yycolumn, yyline, yytext());}
{OF} {return new Symbol(sym.OF, yycolumn, yyline, yytext());}
{OFF} {return new Symbol(sym.OFF, yycolumn, yyline, yytext());}
{OFFSETS} {return new Symbol(sym.OFFSETS, yycolumn, yyline, yytext());}
{ON} {return new Symbol(sym.ON, yycolumn, yyline, yytext());}
{OPEN} {return new Symbol(sym.OPEN, yycolumn, yyline, yytext());}
{OPENDATASOURCE} {return new Symbol(sym.OPENDATASOURCE, yycolumn, yyline, yytext());}
{OPENQUERY} {return new Symbol(sym.OPENQUERY, yycolumn, yyline, yytext());}
{OPENROWSET} {return new Symbol(sym.OPENROWSET, yycolumn, yyline, yytext());}
{OPENXML} {return new Symbol(sym.OPENXML, yycolumn, yyline, yytext());}
{OPTION} {return new Symbol(sym.OPTION, yycolumn, yyline, yytext());}
{OR} {return new Symbol(sym.OR, yycolumn, yyline, yytext());}
{ORDER} {return new Symbol(sym.ORDER, yycolumn, yyline, yytext());}
{OUTER} {return new Symbol(sym.OUTER, yycolumn, yyline, yytext());}
{OVER} {return new Symbol(sym.OVER, yycolumn, yyline, yytext());}
{PERCENT} {return new Symbol(sym.PERCENT, yycolumn, yyline, yytext());}
{PIVOT} {return new Symbol(sym.PIVOT, yycolumn, yyline, yytext());}
{PLAN} {return new Symbol(sym.PLAN, yycolumn, yyline, yytext());}
{PRECISION} {return new Symbol(sym.PRECISION, yycolumn, yyline, yytext());}
{PRIMARY} {return new Symbol(sym.PRIMARY, yycolumn, yyline, yytext());}
{PRINT} {return new Symbol(sym.PRINT, yycolumn, yyline, yytext());}
{PROC} {return new Symbol(sym.PROC, yycolumn, yyline, yytext());}
{PROCEDURE} {return new Symbol(sym.PROCEDURE, yycolumn, yyline, yytext());}
{PUBLIC} {return new Symbol(sym.PUBLIC, yycolumn, yyline, yytext());}
{RAISERROR} {return new Symbol(sym.RAISERROR, yycolumn, yyline, yytext());}
{READ} {return new Symbol(sym.READ, yycolumn, yyline, yytext());}
{READTEXT} {return new Symbol(sym.READTEXT, yycolumn, yyline, yytext());}
{RECONFIGURE} {return new Symbol(sym.RECONFIGURE, yycolumn, yyline, yytext());}
{REFERENCES} {return new Symbol(sym.REFERENCES, yycolumn, yyline, yytext());}
{REPLICATION} {return new Symbol(sym.REPLICATION, yycolumn, yyline, yytext());}
{RESTORE} {return new Symbol(sym.RESTORE, yycolumn, yyline, yytext());}
{RESTRICT} {return new Symbol(sym.RESTRICT, yycolumn, yyline, yytext());}
{RETURN} {return new Symbol(sym.RETURN, yycolumn, yyline, yytext());}
{RETURNS} {return new Symbol(sym.RETURNS, yycolumn, yyline, yytext());}
{REVERT} {return new Symbol(sym.REVERT, yycolumn, yyline, yytext());}
{REVOKE} {return new Symbol(sym.REVOKE, yycolumn, yyline, yytext());}
{RIGHT} {return new Symbol(sym.RIGHT, yycolumn, yyline, yytext());}
{ROLLBACK} {return new Symbol(sym.ROLLBACK, yycolumn, yyline, yytext());}
{ROWCOUNT} {return new Symbol(sym.ROWCOUNT, yycolumn, yyline, yytext());}
{ROWGUIDCOL} {return new Symbol(sym.ROWGUIDCOL, yycolumn, yyline, yytext());}
{RULE} {return new Symbol(sym.RULE, yycolumn, yyline, yytext());}
{SAVE} {return new Symbol(sym.SAVE, yycolumn, yyline, yytext());}
{SCHEMA} {return new Symbol(sym.SCHEMA, yycolumn, yyline, yytext());}
{SECURITYAUDIT} {return new Symbol(sym.SECURITYAUDIT, yycolumn, yyline, yytext());}
{SELECT} {return new Symbol(sym.SELECT, yycolumn, yyline, yytext());}
{SEMANTICKEYPHRASETABLE} {return new Symbol(sym.SEMANTICKEYPHRASETABLE, yycolumn, yyline, yytext());}
{SEMANTICSIMILARITYDETAILSTABLE} {return new Symbol(sym.SEMANTICSIMILARITYDETAILSTABLE, yycolumn, yyline, yytext());}
{SEMANTICSIMILARITYTABLE} {return new Symbol(sym.SEMANTICSIMILARITYTABLE, yycolumn, yyline, yytext());}
{SESSION_USER} {return new Symbol(sym.SESSION_USER, yycolumn, yyline, yytext());}
{SET} {return new Symbol(sym.SET, yycolumn, yyline, yytext());}
{SETUSER} {return new Symbol(sym.SETUSER, yycolumn, yyline, yytext());}
{SHUTDOWN} {return new Symbol(sym.SHUTDOWN, yycolumn, yyline, yytext());}
{SOME} {return new Symbol(sym.SOME, yycolumn, yyline, yytext());}
{STATISTICS} {return new Symbol(sym.STATISTICS, yycolumn, yyline, yytext());}
{SYSTEM_USER} {return new Symbol(sym.SYSTEM_USER, yycolumn, yyline, yytext());}
{TABLE} {return new Symbol(sym.TABLE, yycolumn, yyline, yytext());}
{TABLESAMPLE} {return new Symbol(sym.TABLESAMPLE, yycolumn, yyline, yytext());}
{TEXTSIZE} {return new Symbol(sym.TEXTSIZE, yycolumn, yyline, yytext());}
{THEN} {return new Symbol(sym.THEN, yycolumn, yyline, yytext());}
{TO} {return new Symbol(sym.TO, yycolumn, yyline, yytext());}
{TOP} {return new Symbol(sym.TOP, yycolumn, yyline, yytext());}
{TRAN} {return new Symbol(sym.TRAN, yycolumn, yyline, yytext());}
{TRANSACTION} {return new Symbol(sym.TRANSACTION, yycolumn, yyline, yytext());}
{TRIGGER} {return new Symbol(sym.TRIGGER, yycolumn, yyline, yytext());}
{TRUNCATE} {return new Symbol(sym.TRUNCATE, yycolumn, yyline, yytext());}
{TRY_CONVERT} {return new Symbol(sym.TRY_CONVERT, yycolumn, yyline, yytext());}
{TSEQUAL} {return new Symbol(sym.TSEQUAL, yycolumn, yyline, yytext());}
{UNION} {return new Symbol(sym.UNION, yycolumn, yyline, yytext());}
{UNIQUE} {return new Symbol(sym.UNIQUE, yycolumn, yyline, yytext());}
{UNPIVOT} {return new Symbol(sym.UNPIVOT, yycolumn, yyline, yytext());}
{UPDATE} {return new Symbol(sym.UPDATE, yycolumn, yyline, yytext());}
{UPDATETEXT} {return new Symbol(sym.UPDATETEXT, yycolumn, yyline, yytext());}
{USE} {return new Symbol(sym.USE, yycolumn, yyline, yytext());}
{USER} {return new Symbol(sym.USER, yycolumn, yyline, yytext());}
{VALUES} {return new Symbol(sym.VALUES, yycolumn, yyline, yytext());}
{VARYING} {return new Symbol(sym.VARYING, yycolumn, yyline, yytext());}
{VIEW} {return new Symbol(sym.VIEW, yycolumn, yyline, yytext());}
{WAITFOR} {return new Symbol(sym.WAITFOR, yycolumn, yyline, yytext());}
{WHEN} {return new Symbol(sym.WHEN, yycolumn, yyline, yytext());}
{WHERE} {return new Symbol(sym.WHERE, yycolumn, yyline, yytext());}
{WHILE} {return new Symbol(sym.WHILE, yycolumn, yyline, yytext());}
{WITH} {return new Symbol(sym.WITH, yycolumn, yyline, yytext());}
{WITHIN_GROUP} {return new Symbol(sym.WITHIN_GROUP, yycolumn, yyline, yytext());}
{WRITETEXT} {return new Symbol(sym.WRITETEXT, yycolumn, yyline, yytext());}
{ABSOLUTE} {return new Symbol(sym.ABSOLUTE, yycolumn, yyline, yytext());}
{ACTION} {return new Symbol(sym.ACTION, yycolumn, yyline, yytext());}
{ADA} {return new Symbol(sym.ADA, yycolumn, yyline, yytext());}
{ALLOCATE} {return new Symbol(sym.ALLOCATE, yycolumn, yyline, yytext());}
{ARE} {return new Symbol(sym.ARE, yycolumn, yyline, yytext());}
{ASSERTION} {return new Symbol(sym.ASSERTION, yycolumn, yyline, yytext());}
{AT} {return new Symbol(sym.AT, yycolumn, yyline, yytext());}
{AVG} {return new Symbol(sym.AVG, yycolumn, yyline, yytext());}
{BIT} {return new Symbol(sym.BIT, yycolumn, yyline, yytext());}
{BIT_LENGTH} {return new Symbol(sym.BIT_LENGTH, yycolumn, yyline, yytext());}
{BOTH} {return new Symbol(sym.BOTH, yycolumn, yyline, yytext());}
{CASCADED} {return new Symbol(sym.CASCADED, yycolumn, yyline, yytext());}
{CAST} {return new Symbol(sym.CAST, yycolumn, yyline, yytext());}
{CATALOG} {return new Symbol(sym.CATALOG, yycolumn, yyline, yytext());}
{CHAR} {return new Symbol(sym.CHAR, yycolumn, yyline, yytext());}
{CHAR_LENGTH} {return new Symbol(sym.CHAR_LENGTH, yycolumn, yyline, yytext());}
{CHARACTER} {return new Symbol(sym.CHARACTER, yycolumn, yyline, yytext());}
{CHARACTER_LENGTH} {return new Symbol(sym.CHARACTER_LENGTH, yycolumn, yyline, yytext());}
{COLLATION} {return new Symbol(sym.COLLATION, yycolumn, yyline, yytext());}
{CONNECT} {return new Symbol(sym.CONNECT, yycolumn, yyline, yytext());}
{CONNECTION} {return new Symbol(sym.CONNECTION, yycolumn, yyline, yytext());}
{CONSTRAINTS} {return new Symbol(sym.CONSTRAINTS, yycolumn, yyline, yytext());}
{CORRESPONDING} {return new Symbol(sym.CORRESPONDING, yycolumn, yyline, yytext());}
{COUNT} {return new Symbol(sym.COUNT, yycolumn, yyline, yytext());}
{DATE} {return new Symbol(sym.DATE, yycolumn, yyline, yytext());}
{DAY} {return new Symbol(sym.DAY, yycolumn, yyline, yytext());}
{DEC} {return new Symbol(sym.DEC, yycolumn, yyline, yytext());}
{DECIMAL} {return new Symbol(sym.DECIMAL, yycolumn, yyline, yytext());}
{DEFERRABLE} {return new Symbol(sym.DEFERRABLE, yycolumn, yyline, yytext());}
{DEFERRED} {return new Symbol(sym.DEFERRED, yycolumn, yyline, yytext());}
{DESCRIBE} {return new Symbol(sym.DESCRIBE, yycolumn, yyline, yytext());}
{DESCRIPTOR} {return new Symbol(sym.DESCRIPTOR, yycolumn, yyline, yytext());}
{DIAGNOSTICS} {return new Symbol(sym.DIAGNOSTICS, yycolumn, yyline, yytext());}
{DISCONNECT} {return new Symbol(sym.DISCONNECT, yycolumn, yyline, yytext());}
{DOMAIN} {return new Symbol(sym.DOMAIN, yycolumn, yyline, yytext());}
{END_EXEC} {return new Symbol(sym.END_EXEC, yycolumn, yyline, yytext());}
{EXCEPTION} {return new Symbol(sym.EXCEPTION, yycolumn, yyline, yytext());}
{EXTRACT} {return new Symbol(sym.EXTRACT, yycolumn, yyline, yytext());}
{FALSE} {return new Symbol(sym.FALSE, yycolumn, yyline, yytext());}
{FIRST} {return new Symbol(sym.FIRST, yycolumn, yyline, yytext());}
{FLOAT} {return new Symbol(sym.FLOAT, yycolumn, yyline, yytext());}
{FORTRAN} {return new Symbol(sym.FORTRAN, yycolumn, yyline, yytext());}
{FOUND} {return new Symbol(sym.FOUND, yycolumn, yyline, yytext());}
{GET} {return new Symbol(sym.GET, yycolumn, yyline, yytext());}
{GLOBAL} {return new Symbol(sym.GLOBAL, yycolumn, yyline, yytext());}
{GO} {return new Symbol(sym.GO, yycolumn, yyline, yytext());}
{HOUR} {return new Symbol(sym.HOUR, yycolumn, yyline, yytext());}
{IMMEDIATE} {return new Symbol(sym.IMMEDIATE, yycolumn, yyline, yytext());}
{INCLUDE} {return new Symbol(sym.INCLUDE, yycolumn, yyline, yytext());}
{INDICATOR} {return new Symbol(sym.INDICATOR, yycolumn, yyline, yytext());}
{INITIALLY} {return new Symbol(sym.INITIALLY, yycolumn, yyline, yytext());}
{INPUT} {return new Symbol(sym.INPUT, yycolumn, yyline, yytext());}
{INSENSITIVE} {return new Symbol(sym.INSENSITIVE, yycolumn, yyline, yytext());}
{INT} {return new Symbol(sym.INT, yycolumn, yyline, yytext());}
{INTEGER} {return new Symbol(sym.INTEGER, yycolumn, yyline, yytext());}
{INTERVAL} {return new Symbol(sym.INTERVAL, yycolumn, yyline, yytext());}
{ISOLATION} {return new Symbol(sym.ISOLATION, yycolumn, yyline, yytext());}
{LANGUAGE} {return new Symbol(sym.LANGUAGE, yycolumn, yyline, yytext());}
{LAST} {return new Symbol(sym.LAST, yycolumn, yyline, yytext());}
{LEADING} {return new Symbol(sym.LEADING, yycolumn, yyline, yytext());}
{LEVEL} {return new Symbol(sym.LEVEL, yycolumn, yyline, yytext());}
{LOCAL} {return new Symbol(sym.LOCAL, yycolumn, yyline, yytext());}
{LOWER} {return new Symbol(sym.LOWER, yycolumn, yyline, yytext());}
{MATCH} {return new Symbol(sym.MATCH, yycolumn, yyline, yytext());}
{MAX} {return new Symbol(sym.MAX, yycolumn, yyline, yytext());}
{MIN} {return new Symbol(sym.MIN, yycolumn, yyline, yytext());}
{MINUTE} {return new Symbol(sym.MINUTE, yycolumn, yyline, yytext());}
{MODULE} {return new Symbol(sym.MODULE, yycolumn, yyline, yytext());}
{MONTH} {return new Symbol(sym.MONTH, yycolumn, yyline, yytext());}
{NAMES} {return new Symbol(sym.NAMES, yycolumn, yyline, yytext());}
{NATURAL} {return new Symbol(sym.NATURAL, yycolumn, yyline, yytext());}
{NCHAR} {return new Symbol(sym.NCHAR, yycolumn, yyline, yytext());}
{NEXT} {return new Symbol(sym.NEXT, yycolumn, yyline, yytext());}
{NO} {return new Symbol(sym.NO, yycolumn, yyline, yytext());}
{NONE} {return new Symbol(sym.NONE, yycolumn, yyline, yytext());}
{NUMERIC} {return new Symbol(sym.NUMERIC, yycolumn, yyline, yytext());}
{OCTET_LENGTH} {return new Symbol(sym.OCTET_LENGTH, yycolumn, yyline, yytext());}
{ONLY} {return new Symbol(sym.ONLY, yycolumn, yyline, yytext());}
{OUTPUT} {return new Symbol(sym.OUTPUT, yycolumn, yyline, yytext());}
{OVERLAPS} {return new Symbol(sym.OVERLAPS, yycolumn, yyline, yytext());}
{PAD} {return new Symbol(sym.PAD, yycolumn, yyline, yytext());}
{PARTIAL} {return new Symbol(sym.PARTIAL, yycolumn, yyline, yytext());}
{PASCAL} {return new Symbol(sym.PASCAL, yycolumn, yyline, yytext());}
{POSITION} {return new Symbol(sym.POSITION, yycolumn, yyline, yytext());}
{PREPARE} {return new Symbol(sym.PREPARE, yycolumn, yyline, yytext());}
{PRESERVE} {return new Symbol(sym.PRESERVE, yycolumn, yyline, yytext());}
{PRIOR} {return new Symbol(sym.PRIOR, yycolumn, yyline, yytext());}
{PRIVILEGES} {return new Symbol(sym.PRIVILEGES, yycolumn, yyline, yytext());}
{REAL} {return new Symbol(sym.REAL, yycolumn, yyline, yytext());}
{RELATIVE} {return new Symbol(sym.RELATIVE, yycolumn, yyline, yytext());}
{ROWS} {return new Symbol(sym.ROWS, yycolumn, yyline, yytext());}
{SCROLL} {return new Symbol(sym.SCROLL, yycolumn, yyline, yytext());}
{SECOND} {return new Symbol(sym.SECOND, yycolumn, yyline, yytext());}
{SECTION} {return new Symbol(sym.SECTION, yycolumn, yyline, yytext());}
{SESSION} {return new Symbol(sym.SESSION, yycolumn, yyline, yytext());}
{SIZE} {return new Symbol(sym.SIZE, yycolumn, yyline, yytext());}
{SMALLINT} {return new Symbol(sym.SMALLINT, yycolumn, yyline, yytext());}
{SPACE} {return new Symbol(sym.SPACE, yycolumn, yyline, yytext());}
{SQL} {return new Symbol(sym.SQL, yycolumn, yyline, yytext());}
{SQLCA} {return new Symbol(sym.SQLCA, yycolumn, yyline, yytext());}
{SQLCODE} {return new Symbol(sym.SQLCODE, yycolumn, yyline, yytext());}
{SQLERROR} {return new Symbol(sym.SQLERROR, yycolumn, yyline, yytext());}
{SQLSTATE} {return new Symbol(sym.SQLSTATE, yycolumn, yyline, yytext());}
{SQLWARNING} {return new Symbol(sym.SQLWARNING, yycolumn, yyline, yytext());}
{SUBSTRING} {return new Symbol(sym.SUBSTRING, yycolumn, yyline, yytext());}
{SUM} {return new Symbol(sym.SUM, yycolumn, yyline, yytext());}
{TEMPORARY} {return new Symbol(sym.TEMPORARY, yycolumn, yyline, yytext());}
{TIME} {return new Symbol(sym.TIME, yycolumn, yyline, yytext());}
{TIMESTAMP} {return new Symbol(sym.TIMESTAMP, yycolumn, yyline, yytext());}
{TIMEZONE_HOUR} {return new Symbol(sym.TIMEZONE_HOUR, yycolumn, yyline, yytext());}
{TIMEZONE_MINUTE} {return new Symbol(sym.TIMEZONE_MINUTE, yycolumn, yyline, yytext());}
{TRAILING} {return new Symbol(sym.TRAILING, yycolumn, yyline, yytext());}
{TRANSLATE} {return new Symbol(sym.TRANSLATE, yycolumn, yyline, yytext());}
{TRANSLATION} {return new Symbol(sym.TRANSLATION, yycolumn, yyline, yytext());}
{TRIM} {return new Symbol(sym.TRIM, yycolumn, yyline, yytext());}
{TRUE} {return new Symbol(sym.TRUE, yycolumn, yyline, yytext());}
{UNKNOWN} {return new Symbol(sym.UNKNOWN, yycolumn, yyline, yytext());}
{UPPER} {return new Symbol(sym.UPPER, yycolumn, yyline, yytext());}
{USAGE} {return new Symbol(sym.USAGE, yycolumn, yyline, yytext());}
{USING} {return new Symbol(sym.USING, yycolumn, yyline, yytext());}
{VALUE} {return new Symbol(sym.VALUE, yycolumn, yyline, yytext());}
{VARCHAR} {return new Symbol(sym.VARCHAR, yycolumn, yyline, yytext());}
{WHENEVER} {return new Symbol(sym.WHENEVER, yycolumn, yyline, yytext());}
{WORK} {return new Symbol(sym.WORK, yycolumn, yyline, yytext());}
{WRITE} {return new Symbol(sym.WRITE, yycolumn, yyline, yytext());}
{YEAR} {return new Symbol(sym.YEAR, yycolumn, yyline, yytext());}
{ZONE} {return new Symbol(sym.ZONE, yycolumn, yyline, yytext());}
{LOGIN} {return new Symbol(sym.LOGIN, yycolumn, yyline, yytext());}
{FORWARD_ONLY} {return new Symbol(sym.FORWARD_ONLY, yycolumn, yyline, yytext());}
{STATIC} {return new Symbol(sym.STATIC, yycolumn, yyline, yytext());}
{KEYSET}  {return new Symbol(sym.KEYSET, yycolumn, yyline, yytext());}
{DYNAMIC}  {return new Symbol(sym.DYNAMIC, yycolumn, yyline, yytext());}
{FAST_FORWARD} {return new Symbol(sym.FAST_FORWARD, yycolumn, yyline, yytext());}
{READ_ONLY} {return new Symbol(sym.READ_ONLY, yycolumn, yyline, yytext());}
{SCROLL_LOCKS} {return new Symbol(sym.SCROLL_LOCKS, yycolumn, yyline, yytext());}
{OPTIMISTIC} {return new Symbol(sym.OPTIMISTIC, yycolumn, yyline, yytext());}
{TYPE_WARNING} {return new Symbol(sym.TYPE_WARNING, yycolumn, yyline, yytext());}
{ENCRYPTION} {return new Symbol(sym.ENCRYPTION, yycolumn, yyline, yytext());}
{RECOMPILE} {return new Symbol(sym.RECOMPILE, yycolumn, yyline, yytext());}
{OUT} {return new Symbol(sym.OUT, yycolumn, yyline, yytext());}
{MARK} {return new Symbol(sym.MARK, yycolumn, yyline, yytext());}
    "+" {return new Symbol(sym.MAS, yycolumn, yyline, yytext());}
    "-" {return new Symbol(sym.MENOS, yycolumn, yyline, yytext());}
    "*" {return new Symbol(sym.ASTERISCO, yycolumn, yyline, yytext());}
    "/" {return new Symbol(sym.DIV, yycolumn, yyline, yytext());}
    "%" {return new Symbol(sym.PORCENTAJE, yycolumn, yyline, yytext());}
    "<" {return new Symbol(sym.MENOR, yycolumn, yyline, yytext());}
    "<=" {return new Symbol(sym.MENORIGUAL, yycolumn, yyline, yytext());}
    ">" {return new Symbol(sym.MAYOR, yycolumn, yyline, yytext());}
    ">=" {return new Symbol(sym.MAYORIGUAL, yycolumn, yyline, yytext());}
    "=" {return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());}
    "==" {return new Symbol(sym.IGUALIGUAL, yycolumn, yyline, yytext());}
    "!=" {return new Symbol(sym.NOIGUAL, yycolumn, yyline, yytext());}
    "&&" {return new Symbol(sym.And, yycolumn, yyline, yytext());}
    "||" {return new Symbol(sym.Or, yycolumn, yyline, yytext());}
    "!" {return new Symbol(sym.ADMIRACION, yycolumn, yyline, yytext());}
    ";" {return new Symbol(sym.PUNTOCOMA, yycolumn, yyline, yytext());}
    "," {return new Symbol(sym.COMMA, yycolumn, yyline, yytext());}
    "." {return new Symbol(sym.PUNTO, yycolumn, yyline, yytext());}
    "[" {return new Symbol(sym.CORCHETEOP, yycolumn, yyline, yytext());}
    "]" {return new Symbol(sym.CORCHETECLO, yycolumn, yyline, yytext());}
    "(" {return new Symbol(sym.PARENTESISOP, yycolumn, yyline, yytext());}
    ")" {return new Symbol(sym.PARENTESISCLO, yycolumn, yyline, yytext());}
    "{" {return new Symbol(sym.LLAVEOP, yycolumn, yyline, yytext());}
    "}" {return new Symbol(sym.LLAVECLO, yycolumn, yyline, yytext());}
    "[]" {return new Symbol(sym.CORCHETEDOBLE, yycolumn, yyline, yytext());}
    "()" {return new Symbol(sym.PARENTESISDOBLE, yycolumn, yyline, yytext());}
    "{}" {return new Symbol(sym.LLAVEDOBLE, yycolumn, yyline, yytext());}
    "@" {return new Symbol(sym.ARROBA, yycolumn, yyline, yytext());}
    "#" {return new Symbol(sym.NUMERAL, yycolumn, yyline, yytext());}
    "##" {return new Symbol(sym.NUMERALDOBLE, yycolumn, yyline, yytext());}

[a-zA-Z][a-zA-Z0-9_]* {return new Symbol(sym.Identificador, yycolumn, yyline, yytext());}

[ \t\r\n]+  { /*se ignoran los espacios*/}
{in} {  /*se ignoran los espacios*/}
{TC}|{EC} {/*se ignoran los comentario*/}

. { System.out.print("ERROR Caracter no valido " + yytext() + " en linea: "+(yyline+1)+ " columna: "+ (yycolumn + 1) + " - " + ((yycolumn+1) + yylength() -1) +"\n");}