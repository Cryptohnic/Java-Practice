//(c) A+ Computer Science
//www.apluscompsci.com

import static java.lang.System.*;

public class SyntaxCheckRunner
{
	public static void main ( String[] args )
	{
		SyntaxChecker sc=new SyntaxChecker("(abc(*def)");
		out.println(sc);
		sc=new SyntaxChecker("[{}]");
		out.println(sc);
		sc=new SyntaxChecker("[");
		out.println(sc);
		sc=new SyntaxChecker("[{<()>}]");
		out.println(sc);
		sc=new SyntaxChecker("{<html[value=4]*(12)>{$x}}");
		out.println(sc);
		sc=new SyntaxChecker("[one]<two>{three}(four)");
		out.println(sc);
		sc=new SyntaxChecker("car(cdr(a)(b)))");
		out.println(sc);
		sc=new SyntaxChecker("car(cdr(a)(b))");
		out.println(sc);
	}
}