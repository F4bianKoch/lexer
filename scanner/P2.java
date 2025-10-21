import java.io.*;
import java_cup.runtime.*;

// ****************************************************************************
// Main program to test the simple scanner.
//
// The file to be scanned should be given as a command-line argument.
// The program opens the file and calls the scanner until the EOF token
// is returned.  For each token, the line and character numbers are printed
// (to System.out), followed by the token name.  If the token has a value
// (is a literal or an identifier), the value is printed, too.
// ****************************************************************************

public class P2 {
    public static void main(String[] args) {

	if (args.length != 1) {
	    System.err.println("Please supply name of file to be scanned!");
	    System.exit(-1);
	}

	FileReader inFile = null;
	try {
	    inFile = new FileReader(args[0]);

	} catch (FileNotFoundException ex) {
	    System.err.println("File " + args[0] + " not found!");
	    System.exit(-1);
	}

	Yylex scanner = new Yylex(inFile);
	
	try {
    Symbol token = scanner.next_token();

    while (token.sym != sym.EOF) {
      System.out.print(
        ((TokenVal)token.value).linenum + ":" + ((TokenVal)token.value).charnum
        + " "
      );
        
      switch (token.sym) {

        // Symbols
        //--------------------------------------------

        case sym.LCURLY:
          System.out.println("LCURLY");
          break;

        case sym.RCURLY:
          System.out.println("RCURLY");
          break;

        case sym.LPAREN:
          System.out.println("LPAREN");
          break;

        case sym.RPAREN:
          System.out.println("RPAREN");
          break;

        case sym.COMMA:
          System.out.println("COMMA");
          break;

        case sym.ASSIGN:
          System.out.println("ASSIGN");
          break;

        case sym.SEMICOLON:
          System.out.println("SEMICOLON");
          break;

        case sym.PLUS:
          System.out.println("PLUS");
          break;

        case sym.MINUS:
          System.out.println("MINUS");
          break;

        case sym.TIMES:
          System.out.println("TIMES");
          break;

        case sym.DIVIDE:
          System.out.println("DIVIDE");
          break;

        case sym.NOT:
          System.out.println("NOT");
          break;

        case sym.AND:
          System.out.println("AND");
          break;

        case sym.OR:
          System.out.println("OR");
          break;

        case sym.EQUALS:
          System.out.println("EQUALS");
          break;

        case sym.NOTEQUALS:
          System.out.println("NOTEQUALS");
          break;

        case sym.LESS:
          System.out.println("LESS");
          break;

        case sym.GREATER:
          System.out.println("GREATER");
          break;

        case sym.LESSEQ:
          System.out.println("LESSEQ");
          break;

        case sym.GREATEREQ:
          System.out.println("GREATEREQ");
          break;

        // Reserved words
        //--------------------------------------------

        case sym.STRING:
          System.out.println("STRING");
          break;

        case sym.SYSTEM_OUT:
          System.out.println("SYSTEM_OUT");
          break;

        case sym.BOOLEAN:
          System.out.println("BOOLEAN");
          break;

        case sym.CLASS:
          System.out.println("CLASS");
          break;

        case sym.DO:
          System.out.println("DO");
          break;

        case sym.ELSE:
          System.out.println("ELSE");
          break;

        case sym.FALSE:
          System.out.println("FALSE");
          break;

        case sym.IF:
          System.out.println("IF");
          break;

        case sym.INT:
          System.out.println("INT");
          break;

        case sym.PUBLIC:
          System.out.println("PUBLIC");
          break;

        case sym.RETURN:
          System.out.println("RETURN");
          break;

        case sym.STATIC:
          System.out.println("STATIC");
          break;

        case sym.TRUE:
          System.out.println("TRUE");
          break;

        case sym.VOID:
          System.out.println("VOID");
          break;

        case sym.WHILE:
          System.out.println("WHILE");
          break;

        case sym.CASE:
          System.out.println("CASE");
          break;

        case sym.SWITCH:
          System.out.println("SWITCH");
          break;

        case sym.DEFAULT:
          System.out.println("DEFAULT");
          break;

        case sym.INTLITERAL:
          System.out.println(
            "INTLITERAL (" + ((IntLitTokenVal)token.value).intVal + ")"
          );
          break;

        case sym.STRINGLITERAL:
          System.out.println(
            "STRINGLITERAL (" + ((StringTokenValue)token.value).strVal + ")"
          );
          break;

        case sym.ID:
          System.out.println(
            "ID (" + ((IdentifierTokenValue)token.value).idName + ")"
          );
          break;

        default:
          System.out.println("Error: unknown token! " + token.value);
          break;
      }

			token = scanner.next_token();
	  }

	} catch (IOException ex) {
	    System.err.println("Unexpected IOException thrown by the scanner.");
	    System.exit(-1);
	}
    }
}
