all:
	java -cp antlr-3.5.2-complete.jar org.antlr.Tool myC_new.g
	javac -cp antlr-3.5.2-complete.jar:. myC_new_test.java
	java -cp antlr-3.5.2-complete.jar:. myC_new_test test.c
clean:
	rm myC_new_test.class myC_newLexer* myC_newParser* myC_new.tokens
