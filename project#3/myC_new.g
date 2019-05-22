grammar myC_new;

options {
	language = Java;
	backtrack = true;
}

@header {
    // import packages here.
    import java.util.HashMap;
}

@members {
    boolean TRACEON = true;
    HashMap memory = new HashMap();
}

program:
	VOID MAIN '(' ')' '{' declarations statements '}';

declarations:
	type Identifier ';' declarations 
	| ;

type:
	INT | FLOAT ;

statements: statement statements |;

arith_expression:
	multExpr ('+' multExpr | '-' multExpr)*;

multExpr:
	signExpr ('*' signExpr | '/' signExpr)*;

signExpr:
	primaryExpr | '-' primaryExpr ;

/* primaryExpr:
	Integer_constant 
	| Floating_point_constant 
	| Identifier
	| '(' arith_expression ')' 
	; */

primaryExpr: 
	Integer_constant 
	| Floating_point_constant
	| Identifier
	| '&' Identifier
	| '%' Identifier
	| '(' arith_expression ')'  //grouping expressions so you can make a prior calculation
	;

statement:
	assignment ';' 
	| if_then_else
	| printf_statement ';'
	| scanf_statement ';'
	| while_statements
	;

assignment: Identifier '=' arith_expression
           ;

if_then_else:
	if_statements else_statements
;


if_statements:
	IF '(' condition ')' stmt 
;

else_statements:
	ELSE stmt 
			  |;

while_statements:
	WHILE '(' condition ')' stmt
;

stmt:
	statement
	| '{' statements '}' ;

printf_statement:
	PRINTF '(' argument ')'	
;

scanf_statement:
	SCANF '(' argument ')'
;

argument: arg (',' arg)? argument
		|
        ;

arg: arith_expression
   | STRING_LITERAL
   ;

condition 
               : arith_expression 
                 (RelationOP arith_expression)*
               ;

/* description of the tokens */
FLOAT: 'float';
INT: 'int';
MAIN: 'main';
VOID: 'void';
IF: 'if';
PRINTF: 'printf';
WHILE: 'while';
SCANF: 'scanf';
ELSE: 'else';

Identifier: ('a' ..'z' | 'A' ..'Z' | '_') (
		'a' ..'z'
		| 'A' ..'Z'
		| '0' ..'9'
		| '_'
	)*;
Integer_constant: '0' ..'9'+;
Floating_point_constant: '0' ..'9'+ '.' '0' ..'9'+;
RelationOP: '>' |'>=' | '<' | '<=' | '==' | '!=';

WS: (' ' | '\t' | '\r' | '\n' | '"' | ',' | '(' | ')'){$channel=HIDDEN;};
COMMENT: '/*' .* '*/' {$channel=HIDDEN;};

STRING_LITERAL
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;//may not occur '\\' and '"' at the current place

fragment
EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    ;//like '\n', '\\\', '\r', etc.