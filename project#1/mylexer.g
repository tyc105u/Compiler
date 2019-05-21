lexer grammar mylexer;

options {
  language = Java;
}

/*----------------------*/
/*  Compound Operators  */
/*----------------------*/

ADD_OP : '+';
SUB_OP : '-';
PR_OP : '*';
D_OP : '/';
PP_OP : '++';
MM_OP : '--'; 
ASSIGN_OP : '=';

EQ_OP : '==';
LS_OP : '<';
LE_OP : '<=';
GR_OP : '>';
GE_OP : '>=';
NE_OP : '!=';

RSHIFT_OP : '<<';
LSHIFT_OP : '>>';
AND_OP : '&&';
OR_OP : '||';

NUMBER : (DIGIT)+;

FLOAT_NUM: FLOAT_NUM1 | FLOAT_NUM2;
fragment FLOAT_NUM1: (DIGIT)+'.'(DIGIT)*;
fragment FLOAT_NUM2: '.'(DIGIT)+;

/* Comments */
COMMENT1 : '//'(.)*'\n';
COMMENT2 : '/*' (options{greedy=false;}: .)* '*/';


IF : 'if';
WHILE : 'while';

VOID : 'void';
INT : 'int';
CHAR : 'char';
FLOAT : 'float';

INCLUDE : '#include';
DEFINE : '#define';
STDIO : '<stdio.h>';
STDLIB : '<stdlib.h>';
SCANF : 'scanf';
PRINTF : 'printf';
RETURN : 'return';

ID : (LETTER)(LETTER | DIGIT)*;

fragment LETTER : 'a'..'z' | 'A'..'Z' | '_';
fragment DIGIT : '0'..'9';


WS  : (' '|'\\n'|'\n'|'\\r'|'\r'|'\\t'|'\t'|'?'|':'|'['|']'|'{'|'}'|'%'|'&'|'('|')'|'#'|'"'|','|';')+ {skip();};

