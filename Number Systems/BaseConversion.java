//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

public class BaseConversion
{
	private String number;
	private int base;

	public BaseConversion(String num, int b)
	{
		setNumBase(num,b);
	}

	public void setNumBase(String num, int b)
	{	
		number=num;	
		base=b;
	}

	private int convertToTen( )
	{
		int q=number.length();
		int base10=0;
		for(int i=0;i<q;i++){ // go through each character in given input
			int digit=number.charAt(q-i-1)-48; // ASCII of 0 is 48 so for all digits -48. For letters you need to subtract extra because A ASCII is 65 and we need A to equal 10: 65-48-x=10 x=7
			if(digit>9)
				digit-=7;
			base10+=digit*Math.pow(base,i); // add the digit times base^i
		}
		return base10;
		
	}

	public String getNum(int newBase)
	{
		int base10 = convertToTen();
		String newNum="";
		while(base10>0){
			String digit=String.valueOf(base10%newBase); // find the value of current digit
			if(Integer.parseInt(digit)>9) // if its a letter
				digit=""+(char)(Integer.parseInt(digit)+55); // add the char at ascii value of the num+55 ex: ASCII A is 10, (char)10+55=='A'
			newNum=digit+newNum; // add the digits in reverse order
			base10/=newBase;
		}
		return newNum+"-"+newBase;
	}

	public String toString()
	{
		return number+"-"+base;
	}
}