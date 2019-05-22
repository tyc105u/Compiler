grammar myC_new;

options {
	language = Java;
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
	VOID MAIN '(' ')' '{' declarations statements '}' {if (TRACEON) System.out.println("VOID MAIN () {declarations statements}");
		};

declarations:
	type Identifier ';' declarations { if (TRACEON) System.out.println("declarations: type Identifier : declarations"); 
		}
	| { if (TRACEON) System.out.println("declarations: ");};

type:
	INT { if (TRACEON) System.out.println("type: INT"); }
	| FLOAT {if (TRACEON) System.out.println("type: FLOAT"); };

statements: statement statements |;

arith_expression:
	a = multExpr('+' b = multExpr | '-' c = multExpr)*;

multExpr:
	a = signExpr ('*' b = signExpr | '/' c = signExpr)*;

signExpr:
	a = primaryExpr | '-' b = primaryExpr ;

primaryExpr:
	a = Integer_constant 
	| b = Floating_point_constant 
	| c = Identifier
	| '(' arith_expression ')' //grouping expressions so you can make a prior calculation
	; 

statement:
	assignment ';' { memory.put($Identifier.text, new Integer($arith_expression.value)); if (TRACEON) System.out.println("final value: " + $arith_expression.value); 
		}
	| if_then_else
	| printf_statement ';'
	| scanf_statement ';'
	| while_statements
	;

assignment: Identifier '=' arith_expression
           ;

if_then_else:
	if_statements else_statements[$if_statements.flag]
;


if_statements returns [int flag]:
	IF '(' condition ')' stmt {$flag = $condition.result;}
;

else_statements [int flag]:
	ELSE stmt {
                  if (flag > 0) { System.out.println("Here\n"); }
                  System.out.println(flag);}
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

condition returns [int result]
               : a=arith_expression { $result = $a.result; }
                 (RelationOP b=arith_expression { $result=$b.result; } )*
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