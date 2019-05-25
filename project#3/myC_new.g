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
;

declarations: type Identifier ';' declarations
           | ;

type returns [int flag]
:INT {flag = 1;}
| FLOAT {flag = 2;};

statements:statement statements
        |;

arith_expression returns  [float f_value]
: a=multExpr { 
        $f_value = $a.f_value;
        }
( '+' b=multExpr {
        $f_value = $f_value + $b.f_value;
        }
| '-' c=multExpr {
        $f_value = $f_value - $c.f_value; 
        }
)*
;

multExpr returns  [float f_value]
: a=signExpr {
        $f_value = $a.f_value;
        }
( '*' b=signExpr {
        $f_value = $f_value * $b.f_value;
        }
| '/' c=signExpr {
        $f_value = $f_value / $c.f_value;
        }
)*
;

signExpr returns [float f_value]
: a=primaryExpr {
        $f_value = $a.f_value;
        }
| '-' b=primaryExpr {
        $f_value = $b.f_value * -1;
        }
;
		  
primaryExpr returns [float f_value]
: a=Integer_constant {
        $f_value = (float)Integer.parseInt($Integer_constant.text);
        }
| b=Floating_point_constant {
        $f_value = Float.parseFloat($Floating_point_constant.text);
        }
| c=Identifier {
        Float v = (Float)memory.get($Identifier.text);
        if (v != null)
                $f_value = v.floatValue();
        else
                System.err.println("undefined var: "+$Identifier.text);
}
| '(' arith_expression ')' { 
        $f_value = $arith_expression.f_value; 
        }
;


statement
: Identifier '=' arith_expression ';'{
        memory.put($Identifier.text, new Float($arith_expression.f_value));
        if (TRACEON) 
                System.out.println("final value: " + $arith_expression.f_value);

}
| if_statements[1] 
| print_stmt[1] ';'
| SCANF '(' '%'  Identifier ',' '&' Identifier ')' ';'{
        if (TRACEON)
                System.out.println("scanf with integer");
        }
;

if_statements[int flag]:
	IF '(' condition[flag] ')' if_then_statements[$condition.flag] 
;

if_then_statements[int flag]:
if_then_statement[flag]
|'{' if_then_statement[flag] if_then_statements[flag] '}'
|
;

if_then_statement[int flag]: 
Identifier '=' arith_expression ';'{
        if (flag == 1) 
                memory.put($Identifier.text, new Float($arith_expression.f_value));
}
| if_statements[flag]
| print_stmt[flag] ';'
;

condition[int x] returns [int flag]:
a=arith_expression
(
        RelationOP b=arith_expression{
        if(x == 1)
                switch($RelationOP.text){
                        case ">=":
                                if($a.f_value >= $b.f_value)
                                        flag = 1;
                                else
                                        flag = 0;
                                break;
                        case ">":
                                if($a.f_value > $b.f_value)
                                        flag = 1;
                                else
                                        flag = 0;
                                break;
                        case "<=":
                                if($a.f_value <= $b.f_value)
                                        flag = 1;
                                else
                                        flag = 0;
                                break;
                        case "<":
                                if($a.f_value < $b.f_value)
                                        flag = 1;
                                else
                                        flag = 0;
                                break;
                        case "==":
                                if($a.f_value == $b.f_value)
                                        flag = 1;
                                else
                                        flag = 0;
                                break;
                        case "!=":
                                if($a.f_value != $b.f_value)
                                        flag = 1;
                                else
                                        flag = 0;
                                break;
        }
        
}
)*
;
RelationOP:
'>' 
|'>=' 
| '<' 
| '<=' 
| '==' 
| '!='
;

print_stmt [int flag]: PRINTF '(' argument (',' arith_expression)?  ')'{
        if(flag == 1){
                String tmp = $argument.s;
                String num = Integer.toString((int)$arith_expression.f_value);
                if(tmp.contains("\%d") == true)
                        tmp = tmp.replace("\%d", num);
                String f_num = Float.toString($arith_expression.f_value);
                if(tmp.contains("\%f") == true)
                        tmp = tmp.replace("\%f", f_num);
                System.out.println(tmp);
        }
}
;


argument returns[String s]
: c=arg (',' arg)* {
        s = $c.text;
        s = s.substring(1, s.length()-1);
        //System.out.println(s.contains("\%d"));
        if(s.contains("\\n") == true)
                s = s.replace("\\n", "\n");
        if(s.contains("\\r") == true)
                s = s.replace("\\r", "\r");
}
;

arg :
| STRING_LITERAL
;

STRING_LITERAL
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    ;

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
DD:'%d';
FF:'%f';

Identifier:('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
Integer_constant:'0'..'9'+;
Floating_point_constant :'0'..'9'+ '.' '0'..'9'+;


WS:( ' ' | '\t' | '\r' | '\n' | '"' | ',' | '(' | ')') {$channel=HIDDEN;};
COMMENT:'/*' .* '*/' {$channel=HIDDEN;};
