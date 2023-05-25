//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import static java.lang.System.*;

public class BaseRunner
{
	public static void main ( String[] args )
	{
		BaseConversion bc=new BaseConversion("10",10);
		out.println(bc+" == "+bc.getNum(2));
		bc=new BaseConversion("AB",16);
		out.println(bc+" == "+bc.getNum(10));

		
		
		
		
						
	}
}