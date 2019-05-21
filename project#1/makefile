all:
	java -cp antlr-3.5.2-complete.jar org.antlr.Tool mylexer.g
	javac -cp ./antlr-3.5.2-complete.jar testLexer.java mylexer.java
	java -cp ./antlr-3.5.2-complete.jar:. testLexer input.c
	java -cp ./antlr-3.5.2-complete.jar:. testLexer input1.c
	java -cp ./antlr-3.5.2-complete.jar:. testLexer input2.c
clean:
	rm mylexer.java mylexer.tokens mylexer.class testLexer.class
