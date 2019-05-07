grammar myC_new;

options {
   language = Java;
}

@header {
    // import packages here.
}

@members {
    boolean TRACEON = true;
}

program:VOID MAIN '(' ')' '{' declarations statements'}'
        {if (TRACEON) System.out.println("VOID MAIN () {declarations statements}");};

declarations:type Identifier ';' declarations
             { if (TRACEON) System.out.println("declarations: type Identifier : declarations"); }
           | { if (TRACEON) System.out.println("declarations: ");} ;

type:INT { if (TRACEON) System.out.println("type: INT"); }
   | FLOAT {if (TRACEON) System.out.println("type: FLOAT"); };

statements:statement statements
        |;

arith_expression: multExpr
                  ( '+' multExpr { if (TRACEON) System.out.println("add"); }
				  | '-' multExpr { if (TRACEON) System.out.println("min"); }
				  )*
                  ;

multExpr: signExpr
          ( '*' signExpr { if (TRACEON) System.out.println("mul"); }
          | '/' signExpr { if (TRACEON) System.out.println("div"); }
		  )*
		  ;

signExpr: primaryExpr
        | '-' primaryExpr
		;
		  
primaryExpr: Integer_constant
           | Floating_point_constant
           | Identifier
		   | '(' arith_expression ')'
           ;



statement: Identifier '=' arith_expression ';' { if (TRACEON) System.out.println("assign"); }
         | IF '(' arith_expression ')' if_then_statements
         | PRINTF '(' Identifier ')' ';'{ if (TRACEON) System.out.println("printf"); }
         | PRINTF '(' Identifier ',' '%' Identifier ')' ';'
         { if (TRACEON) System.out.println("printf with one parameter"); }
         | WHILE '(' arith_expression ')' while_statements
		 ;

if_then_statements: statement
                  | '{' statements '}' { if (TRACEON) System.out.println("if/else"); }
				  ;

while_statements: '{' statements '}' { if (TRACEON) System.out.println("while-loop"); };

		   
/* description of the tokens */
FLOAT:'float';
INT:'int';
MAIN: 'main';
VOID: 'void';
IF: 'if';
PRINTF: 'printf';
WHILE: 'while';

Identifier:('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
Integer_constant:'0'..'9'+;
Floating_point_constant:'0'..'9'+ '.' '0'..'9'+;


WS:( ' ' | '\t' | '\r' | '\n' | '"' | ',' | '(' | ')') {$channel=HIDDEN;};
COMMENT:'/*' .* '*/' {$channel=HIDDEN;};
