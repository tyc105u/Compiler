// $ANTLR 3.5.2 myC_new.g 2019-05-07 19:38:54

    // import packages here.


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class myC_newParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "FLOAT", "Floating_point_constant", 
		"IF", "INT", "Identifier", "Integer_constant", "MAIN", "PRINTF", "VOID", 
		"WHILE", "WS", "'%'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'/'", 
		"';'", "'='", "'{'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int COMMENT=4;
	public static final int FLOAT=5;
	public static final int Floating_point_constant=6;
	public static final int IF=7;
	public static final int INT=8;
	public static final int Identifier=9;
	public static final int Integer_constant=10;
	public static final int MAIN=11;
	public static final int PRINTF=12;
	public static final int VOID=13;
	public static final int WHILE=14;
	public static final int WS=15;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public myC_newParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public myC_newParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return myC_newParser.tokenNames; }
	@Override public String getGrammarFileName() { return "myC_new.g"; }


	    boolean TRACEON = true;



	// $ANTLR start "program"
	// myC_new.g:15:1: program : VOID MAIN '(' ')' '{' declarations statements '}' ;
	public final void program() throws RecognitionException {
		try {
			// myC_new.g:15:8: ( VOID MAIN '(' ')' '{' declarations statements '}' )
			// myC_new.g:15:9: VOID MAIN '(' ')' '{' declarations statements '}'
			{
			match(input,VOID,FOLLOW_VOID_in_program35); 
			match(input,MAIN,FOLLOW_MAIN_in_program37); 
			match(input,17,FOLLOW_17_in_program39); 
			match(input,18,FOLLOW_18_in_program41); 
			match(input,26,FOLLOW_26_in_program43); 
			pushFollow(FOLLOW_declarations_in_program45);
			declarations();
			state._fsp--;

			pushFollow(FOLLOW_statements_in_program47);
			statements();
			state._fsp--;

			match(input,27,FOLLOW_27_in_program48); 
			if (TRACEON) System.out.println("VOID MAIN () {declarations statements}");
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "program"



	// $ANTLR start "declarations"
	// myC_new.g:18:1: declarations : ( type Identifier ';' declarations |);
	public final void declarations() throws RecognitionException {
		try {
			// myC_new.g:18:13: ( type Identifier ';' declarations |)
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==FLOAT||LA1_0==INT) ) {
				alt1=1;
			}
			else if ( (LA1_0==IF||LA1_0==Identifier||LA1_0==PRINTF||LA1_0==WHILE||LA1_0==27) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// myC_new.g:18:14: type Identifier ';' declarations
					{
					pushFollow(FOLLOW_type_in_declarations64);
					type();
					state._fsp--;

					match(input,Identifier,FOLLOW_Identifier_in_declarations66); 
					match(input,24,FOLLOW_24_in_declarations68); 
					pushFollow(FOLLOW_declarations_in_declarations70);
					declarations();
					state._fsp--;

					 if (TRACEON) System.out.println("declarations: type Identifier : declarations"); 
					}
					break;
				case 2 :
					// myC_new.g:20:14: 
					{
					 if (TRACEON) System.out.println("declarations: ");
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "declarations"



	// $ANTLR start "type"
	// myC_new.g:22:1: type : ( INT | FLOAT );
	public final void type() throws RecognitionException {
		try {
			// myC_new.g:22:5: ( INT | FLOAT )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==INT) ) {
				alt2=1;
			}
			else if ( (LA2_0==FLOAT) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// myC_new.g:22:6: INT
					{
					match(input,INT,FOLLOW_INT_in_type107); 
					 if (TRACEON) System.out.println("type: INT"); 
					}
					break;
				case 2 :
					// myC_new.g:23:6: FLOAT
					{
					match(input,FLOAT,FOLLOW_FLOAT_in_type116); 
					if (TRACEON) System.out.println("type: FLOAT"); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "type"



	// $ANTLR start "statements"
	// myC_new.g:25:1: statements : ( statement statements |);
	public final void statements() throws RecognitionException {
		try {
			// myC_new.g:25:11: ( statement statements |)
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==IF||LA3_0==Identifier||LA3_0==PRINTF||LA3_0==WHILE) ) {
				alt3=1;
			}
			else if ( (LA3_0==27) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// myC_new.g:25:12: statement statements
					{
					pushFollow(FOLLOW_statement_in_statements124);
					statement();
					state._fsp--;

					pushFollow(FOLLOW_statements_in_statements126);
					statements();
					state._fsp--;

					}
					break;
				case 2 :
					// myC_new.g:26:10: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "statements"



	// $ANTLR start "arith_expression"
	// myC_new.g:28:1: arith_expression : multExpr ( '+' multExpr | '-' multExpr )* ;
	public final void arith_expression() throws RecognitionException {
		try {
			// myC_new.g:28:17: ( multExpr ( '+' multExpr | '-' multExpr )* )
			// myC_new.g:28:19: multExpr ( '+' multExpr | '-' multExpr )*
			{
			pushFollow(FOLLOW_multExpr_in_arith_expression143);
			multExpr();
			state._fsp--;

			// myC_new.g:29:19: ( '+' multExpr | '-' multExpr )*
			loop4:
			while (true) {
				int alt4=3;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==20) ) {
					alt4=1;
				}
				else if ( (LA4_0==22) ) {
					alt4=2;
				}

				switch (alt4) {
				case 1 :
					// myC_new.g:29:21: '+' multExpr
					{
					match(input,20,FOLLOW_20_in_arith_expression165); 
					pushFollow(FOLLOW_multExpr_in_arith_expression167);
					multExpr();
					state._fsp--;

					 if (TRACEON) System.out.println("add"); 
					}
					break;
				case 2 :
					// myC_new.g:30:9: '-' multExpr
					{
					match(input,22,FOLLOW_22_in_arith_expression179); 
					pushFollow(FOLLOW_multExpr_in_arith_expression181);
					multExpr();
					state._fsp--;

					 if (TRACEON) System.out.println("min"); 
					}
					break;

				default :
					break loop4;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "arith_expression"



	// $ANTLR start "multExpr"
	// myC_new.g:34:1: multExpr : signExpr ( '*' signExpr | '/' signExpr )* ;
	public final void multExpr() throws RecognitionException {
		try {
			// myC_new.g:34:9: ( signExpr ( '*' signExpr | '/' signExpr )* )
			// myC_new.g:34:11: signExpr ( '*' signExpr | '/' signExpr )*
			{
			pushFollow(FOLLOW_signExpr_in_multExpr218);
			signExpr();
			state._fsp--;

			// myC_new.g:35:11: ( '*' signExpr | '/' signExpr )*
			loop5:
			while (true) {
				int alt5=3;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==19) ) {
					alt5=1;
				}
				else if ( (LA5_0==23) ) {
					alt5=2;
				}

				switch (alt5) {
				case 1 :
					// myC_new.g:35:13: '*' signExpr
					{
					match(input,19,FOLLOW_19_in_multExpr232); 
					pushFollow(FOLLOW_signExpr_in_multExpr234);
					signExpr();
					state._fsp--;

					 if (TRACEON) System.out.println("mul"); 
					}
					break;
				case 2 :
					// myC_new.g:36:13: '/' signExpr
					{
					match(input,23,FOLLOW_23_in_multExpr250); 
					pushFollow(FOLLOW_signExpr_in_multExpr252);
					signExpr();
					state._fsp--;

					 if (TRACEON) System.out.println("div"); 
					}
					break;

				default :
					break loop5;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "multExpr"



	// $ANTLR start "signExpr"
	// myC_new.g:40:1: signExpr : ( primaryExpr | '-' primaryExpr );
	public final void signExpr() throws RecognitionException {
		try {
			// myC_new.g:40:9: ( primaryExpr | '-' primaryExpr )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==Floating_point_constant||(LA6_0 >= Identifier && LA6_0 <= Integer_constant)||LA6_0==17) ) {
				alt6=1;
			}
			else if ( (LA6_0==22) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// myC_new.g:40:11: primaryExpr
					{
					pushFollow(FOLLOW_primaryExpr_in_signExpr273);
					primaryExpr();
					state._fsp--;

					}
					break;
				case 2 :
					// myC_new.g:41:11: '-' primaryExpr
					{
					match(input,22,FOLLOW_22_in_signExpr285); 
					pushFollow(FOLLOW_primaryExpr_in_signExpr287);
					primaryExpr();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "signExpr"



	// $ANTLR start "primaryExpr"
	// myC_new.g:44:1: primaryExpr : ( Integer_constant | Floating_point_constant | Identifier | '(' arith_expression ')' );
	public final void primaryExpr() throws RecognitionException {
		try {
			// myC_new.g:44:12: ( Integer_constant | Floating_point_constant | Identifier | '(' arith_expression ')' )
			int alt7=4;
			switch ( input.LA(1) ) {
			case Integer_constant:
				{
				alt7=1;
				}
				break;
			case Floating_point_constant:
				{
				alt7=2;
				}
				break;
			case Identifier:
				{
				alt7=3;
				}
				break;
			case 17:
				{
				alt7=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// myC_new.g:44:14: Integer_constant
					{
					match(input,Integer_constant,FOLLOW_Integer_constant_in_primaryExpr301); 
					}
					break;
				case 2 :
					// myC_new.g:45:14: Floating_point_constant
					{
					match(input,Floating_point_constant,FOLLOW_Floating_point_constant_in_primaryExpr316); 
					}
					break;
				case 3 :
					// myC_new.g:46:14: Identifier
					{
					match(input,Identifier,FOLLOW_Identifier_in_primaryExpr331); 
					}
					break;
				case 4 :
					// myC_new.g:47:8: '(' arith_expression ')'
					{
					match(input,17,FOLLOW_17_in_primaryExpr340); 
					pushFollow(FOLLOW_arith_expression_in_primaryExpr342);
					arith_expression();
					state._fsp--;

					match(input,18,FOLLOW_18_in_primaryExpr344); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "primaryExpr"



	// $ANTLR start "statement"
	// myC_new.g:52:1: statement : ( Identifier '=' arith_expression ';' | IF '(' arith_expression ')' if_then_statements | PRINTF '(' Identifier ')' ';' | PRINTF '(' Identifier ',' '%' Identifier ')' ';' | WHILE '(' arith_expression ')' while_statements );
	public final void statement() throws RecognitionException {
		try {
			// myC_new.g:52:10: ( Identifier '=' arith_expression ';' | IF '(' arith_expression ')' if_then_statements | PRINTF '(' Identifier ')' ';' | PRINTF '(' Identifier ',' '%' Identifier ')' ';' | WHILE '(' arith_expression ')' while_statements )
			int alt8=5;
			switch ( input.LA(1) ) {
			case Identifier:
				{
				alt8=1;
				}
				break;
			case IF:
				{
				alt8=2;
				}
				break;
			case PRINTF:
				{
				int LA8_3 = input.LA(2);
				if ( (LA8_3==17) ) {
					int LA8_5 = input.LA(3);
					if ( (LA8_5==Identifier) ) {
						int LA8_6 = input.LA(4);
						if ( (LA8_6==18) ) {
							alt8=3;
						}
						else if ( (LA8_6==21) ) {
							alt8=4;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 8, 6, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 8, 5, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 8, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case WHILE:
				{
				alt8=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// myC_new.g:52:12: Identifier '=' arith_expression ';'
					{
					match(input,Identifier,FOLLOW_Identifier_in_statement365); 
					match(input,25,FOLLOW_25_in_statement367); 
					pushFollow(FOLLOW_arith_expression_in_statement369);
					arith_expression();
					state._fsp--;

					match(input,24,FOLLOW_24_in_statement371); 
					 if (TRACEON) System.out.println("assign"); 
					}
					break;
				case 2 :
					// myC_new.g:53:12: IF '(' arith_expression ')' if_then_statements
					{
					match(input,IF,FOLLOW_IF_in_statement386); 
					match(input,17,FOLLOW_17_in_statement388); 
					pushFollow(FOLLOW_arith_expression_in_statement390);
					arith_expression();
					state._fsp--;

					match(input,18,FOLLOW_18_in_statement392); 
					pushFollow(FOLLOW_if_then_statements_in_statement394);
					if_then_statements();
					state._fsp--;

					}
					break;
				case 3 :
					// myC_new.g:54:12: PRINTF '(' Identifier ')' ';'
					{
					match(input,PRINTF,FOLLOW_PRINTF_in_statement407); 
					match(input,17,FOLLOW_17_in_statement409); 
					match(input,Identifier,FOLLOW_Identifier_in_statement411); 
					match(input,18,FOLLOW_18_in_statement413); 
					match(input,24,FOLLOW_24_in_statement415); 
					 if (TRACEON) System.out.println("printf"); 
					}
					break;
				case 4 :
					// myC_new.g:55:12: PRINTF '(' Identifier ',' '%' Identifier ')' ';'
					{
					match(input,PRINTF,FOLLOW_PRINTF_in_statement429); 
					match(input,17,FOLLOW_17_in_statement431); 
					match(input,Identifier,FOLLOW_Identifier_in_statement433); 
					match(input,21,FOLLOW_21_in_statement435); 
					match(input,16,FOLLOW_16_in_statement437); 
					match(input,Identifier,FOLLOW_Identifier_in_statement439); 
					match(input,18,FOLLOW_18_in_statement441); 
					match(input,24,FOLLOW_24_in_statement443); 
					 if (TRACEON) System.out.println("printf with one parameter"); 
					}
					break;
				case 5 :
					// myC_new.g:57:12: WHILE '(' arith_expression ')' while_statements
					{
					match(input,WHILE,FOLLOW_WHILE_in_statement467); 
					match(input,17,FOLLOW_17_in_statement469); 
					pushFollow(FOLLOW_arith_expression_in_statement471);
					arith_expression();
					state._fsp--;

					match(input,18,FOLLOW_18_in_statement473); 
					pushFollow(FOLLOW_while_statements_in_statement475);
					while_statements();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "statement"



	// $ANTLR start "if_then_statements"
	// myC_new.g:60:1: if_then_statements : ( statement | '{' statements '}' );
	public final void if_then_statements() throws RecognitionException {
		try {
			// myC_new.g:60:19: ( statement | '{' statements '}' )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==IF||LA9_0==Identifier||LA9_0==PRINTF||LA9_0==WHILE) ) {
				alt9=1;
			}
			else if ( (LA9_0==26) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// myC_new.g:60:21: statement
					{
					pushFollow(FOLLOW_statement_in_if_then_statements486);
					statement();
					state._fsp--;

					}
					break;
				case 2 :
					// myC_new.g:61:21: '{' statements '}'
					{
					match(input,26,FOLLOW_26_in_if_then_statements508); 
					pushFollow(FOLLOW_statements_in_if_then_statements510);
					statements();
					state._fsp--;

					match(input,27,FOLLOW_27_in_if_then_statements512); 
					 if (TRACEON) System.out.println("if/else"); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "if_then_statements"



	// $ANTLR start "while_statements"
	// myC_new.g:64:1: while_statements : '{' statements '}' ;
	public final void while_statements() throws RecognitionException {
		try {
			// myC_new.g:64:17: ( '{' statements '}' )
			// myC_new.g:64:19: '{' statements '}'
			{
			match(input,26,FOLLOW_26_in_while_statements528); 
			pushFollow(FOLLOW_statements_in_while_statements530);
			statements();
			state._fsp--;

			match(input,27,FOLLOW_27_in_while_statements532); 
			 if (TRACEON) System.out.println("while-loop"); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "while_statements"

	// Delegated rules



	public static final BitSet FOLLOW_VOID_in_program35 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_MAIN_in_program37 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_program39 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_program41 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_program43 = new BitSet(new long[]{0x00000000080053A0L});
	public static final BitSet FOLLOW_declarations_in_program45 = new BitSet(new long[]{0x0000000008005280L});
	public static final BitSet FOLLOW_statements_in_program47 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_program48 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_declarations64 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Identifier_in_declarations66 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_declarations68 = new BitSet(new long[]{0x0000000000000120L});
	public static final BitSet FOLLOW_declarations_in_declarations70 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_type107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_type116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statements124 = new BitSet(new long[]{0x0000000000005280L});
	public static final BitSet FOLLOW_statements_in_statements126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_arith_expression143 = new BitSet(new long[]{0x0000000000500002L});
	public static final BitSet FOLLOW_20_in_arith_expression165 = new BitSet(new long[]{0x0000000000420640L});
	public static final BitSet FOLLOW_multExpr_in_arith_expression167 = new BitSet(new long[]{0x0000000000500002L});
	public static final BitSet FOLLOW_22_in_arith_expression179 = new BitSet(new long[]{0x0000000000420640L});
	public static final BitSet FOLLOW_multExpr_in_arith_expression181 = new BitSet(new long[]{0x0000000000500002L});
	public static final BitSet FOLLOW_signExpr_in_multExpr218 = new BitSet(new long[]{0x0000000000880002L});
	public static final BitSet FOLLOW_19_in_multExpr232 = new BitSet(new long[]{0x0000000000420640L});
	public static final BitSet FOLLOW_signExpr_in_multExpr234 = new BitSet(new long[]{0x0000000000880002L});
	public static final BitSet FOLLOW_23_in_multExpr250 = new BitSet(new long[]{0x0000000000420640L});
	public static final BitSet FOLLOW_signExpr_in_multExpr252 = new BitSet(new long[]{0x0000000000880002L});
	public static final BitSet FOLLOW_primaryExpr_in_signExpr273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_signExpr285 = new BitSet(new long[]{0x0000000000020640L});
	public static final BitSet FOLLOW_primaryExpr_in_signExpr287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Integer_constant_in_primaryExpr301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Floating_point_constant_in_primaryExpr316 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_primaryExpr331 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_primaryExpr340 = new BitSet(new long[]{0x0000000000420640L});
	public static final BitSet FOLLOW_arith_expression_in_primaryExpr342 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_primaryExpr344 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_statement365 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_statement367 = new BitSet(new long[]{0x0000000000420640L});
	public static final BitSet FOLLOW_arith_expression_in_statement369 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_statement371 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_statement386 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_statement388 = new BitSet(new long[]{0x0000000000420640L});
	public static final BitSet FOLLOW_arith_expression_in_statement390 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_statement392 = new BitSet(new long[]{0x0000000004005280L});
	public static final BitSet FOLLOW_if_then_statements_in_statement394 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINTF_in_statement407 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_statement409 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Identifier_in_statement411 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_statement413 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_statement415 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINTF_in_statement429 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_statement431 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Identifier_in_statement433 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_statement435 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_statement437 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Identifier_in_statement439 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_statement441 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_statement443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_in_statement467 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_statement469 = new BitSet(new long[]{0x0000000000420640L});
	public static final BitSet FOLLOW_arith_expression_in_statement471 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_statement473 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_while_statements_in_statement475 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_if_then_statements486 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_if_then_statements508 = new BitSet(new long[]{0x0000000008005280L});
	public static final BitSet FOLLOW_statements_in_if_then_statements510 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_if_then_statements512 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_while_statements528 = new BitSet(new long[]{0x0000000008005280L});
	public static final BitSet FOLLOW_statements_in_while_statements530 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_while_statements532 = new BitSet(new long[]{0x0000000000000002L});
}
