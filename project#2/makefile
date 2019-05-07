all:
	java -cp antlr-3.5.2-complete.jar org.antlr.Tool myC_new.g
	javac -cp antlr-3.5.2-complete.jar:. myC_new_test.java
	java -cp antlr-3.5.2-complete.jar:. myC_new_test test.c
	java -cp antlr-3.5.2-complete.jar:. myC_new_test test2.c
	java -cp antlr-3.5.2-complete.jar:. myC_new_test test3.c
clean:
	rm myC_new_test.class myC_newParser.class myC_newLexer.class myC_newParser.java myC_newLexer.java
