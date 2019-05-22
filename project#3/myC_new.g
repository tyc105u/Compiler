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

program:VOID MAIN '(' ')' '{' declarations statements'}'
        {if (TRACEON) System.out.println("VOID MAIN () {declarations statements}");};

declarations: type Identifier ';' declarations
             { if (TRACEON) System.out.println("declarations: type Identifier : declarations"); }
           | { if (TRACEON) System.out.println("declarations: ");} ;

type:INT { if (TRACEON) System.out.println("type: INT"); }
   | FLOAT {if (TRACEON) System.out.println("type: FLOAT"); };

statements:statement statements
        |;

arith_expression returns  [int value, float f_value]
: a=multExpr {$value = $a.value; $f_value = $a.f_value; $f_value = $a.f_value; if (TRACEON) System.out.println("arith_a: " + $a.value);}
( '+' b=multExpr { $value = $value + $b.value; $f_value = $f_value + $b.f_value; if (TRACEON) System.out.println("arith_b: " + $b.value);}
| '-' c=multExpr { $value = $value - $c.value; $f_value = $f_value - $c.f_value; if (TRACEON) System.out.println("arith_c: " + $c.value);}
)*
                  ;

multExpr returns  [int value, float f_value]
: a=signExpr {$value = $a.value; $f_value = $a.f_value; if (TRACEON) System.out.println("mult_a: " + $a.value);}
          ( '*' b=signExpr { $value = $value * $b.value;  $f_value = $f_value * $b.f_value; if (TRACEON) System.out.println("mult_b: " + $b.value);}
          | '/' c=signExpr { $value = $value / $c.value;  $f_value = $f_value / $c.f_value; if (TRACEON) System.out.println("mult_c: " + $c.value);}
		  )*
		  ;

signExpr returns [int value, float f_value]
: a=primaryExpr {$value = $a.value;$f_value = $a.f_value;if (TRACEON) System.out.println("sign_a: " + $a.value);}
        | '-' b=primaryExpr {$value = $b.value * -1; $f_value = $b.f_value; if (TRACEON) System.out.println("sign_b: " + $b.value);}
		;
		  
primaryExpr returns [int value, float f_value]
: a=Integer_constant {$value = Integer.parseInt($Integer_constant.text);}
           | b=Floating_point_constant {$f_value = Float.parseFloat($Floating_point_constant.text);}
           | c=Identifier 
           | '(' arith_expression ')' { $value = $arith_expression.value; $f_value = $arith_expression.f_value; }
           ;


statement: Identifier '=' arith_expression ';'
 { memory.put($Identifier.text, new Float($arith_expression.value)); if (TRACEON) System.out.println("final value: " +$arith_expression.value +","+$arith_expression.f_value); }
         | if_statements else_statements*
         | PRINTF '(' Identifier ')' ';'{ if (TRACEON) System.out.println("printf"); }
         | PRINTF '(' '%' Identifier ',' Identifier ')' ';'
         {if (TRACEON) if (TRACEON) System.out.println("printf with one parameter"); }
         | SCANF '(' '%'  Identifier ',' '&' Identifier ')' ';'
         {if (TRACEON) if (TRACEON) System.out.println("scanf with integer"); }
         | WHILE '(' arith_expression ')' while_statements {if (TRACEON) System.out.println("while value: " + $arith_expression.value + "," + $arith_expression.f_value); }
		 ;

if_then_statements: statement
                  | '{' statements '}' { if (TRACEON) System.out.println("if/else"); }
				  ;
else_statements:
	ELSE if_then_statements;

if_statements:
	IF '(' condition ')' if_then_statements ;

condition : arith_expression 
        (RelationOP arith_expression)*
        ;
RelationOP: '>' |'>=' | '<' | '<=' | '==' | '!=';

while_statements: '{' statements '}' { if (TRACEON) System.out.println("while-loop"); };

		   
/* description of the tokens */
FLOAT:'float';
INT:'int';
MAIN: 'main';
VOID: 'void';
IF: 'if';
PRINTF: 'printf';
WHILE: 'while';
SCANF: 'scanf';
ELSE: 'else';

Identifier:('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
Integer_constant:'0'..'9'+;
Floating_point_constant:'0'..'9'+ '.' '0'..'9'+;


WS:( ' ' | '\t' | '\r' | '\n' | '"' | ',' | '(' | ')') {$channel=HIDDEN;};
COMMENT:'/*' .* '*/' {$channel=HIDDEN;};
