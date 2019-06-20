all:
		java  -cp antlr-3.5.2-complete.jar org.antlr.Tool myCompiler.g
		javac -cp antlr-3.5.2-complete.jar:. myCompiler_test.java
		java  -cp antlr-3.5.2-complete.jar:. myCompiler_test test1.c > test1.j
		java -jar jasmin.jar test1.j
		java myResult
		rm myResult.class

		java  -cp antlr-3.5.2-complete.jar org.antlr.Tool myCompiler.g
		javac -cp antlr-3.5.2-complete.jar:. myCompiler_test.java
		java  -cp antlr-3.5.2-complete.jar:. myCompiler_test test2.c > test2.j
		java -jar jasmin.jar test2.j
		java myResult
		rm myResult.class

		java  -cp antlr-3.5.2-complete.jar org.antlr.Tool myCompiler.g
		javac -cp antlr-3.5.2-complete.jar:. myCompiler_test.java
		java  -cp antlr-3.5.2-complete.jar:. myCompiler_test test10.c > test10.j
		java -jar jasmin.jar test10.j
		java myResult
		rm myResult.class

clean:
	rm myCompilerLexer.java myCompiler.tokens *.class myCompilerParser.java 
	
	


