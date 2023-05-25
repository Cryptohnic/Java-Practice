//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

public class Number implements Comparable<Number>
{

	//add in instance variables
	String number;
	Integer base10;
	String binary;
	//add in a constructor or two

	public Number(String num, int b){
		number=num;
		base10=Integer.parseInt(num,b);
		binary=Integer.toString(base10,2);
	}

	@Override
	public int compareTo(Number param)
	{
		int currOnes=binary.replaceAll("0","").length();
		int paramOnes=param.binary.replaceAll("0","").length();
		if(currOnes==paramOnes){ // compare num of ones first
			if(base10!=param.base10) // compare base10
				return base10.compareTo(param.base10);
			return number.compareTo(param.number); // compare the original values
		}
		else if(currOnes>paramOnes)
			return 1;
		else
			return -1;
	}
	
	@Override
	public String toString( )
	{
	  return number+" "+base10+" "+binary;
	}
}