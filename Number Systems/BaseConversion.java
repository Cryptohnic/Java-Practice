//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import static java.lang.System.*;

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
		for(int i=0;i<q;i++){
			int num=number.charAt(q-i-1)-48;
			base10=base10+num*Math.pow(base,i);
		}
		return base10;
	}

	public String getNum(int newBase)
	{
		int base10 = convertToTen();
		String newNum="";
		while(base10>0){
			newNum=base10%newBase+newNum;
			base10/=newBase;
		}
		return newNum+"-"+newBase;
	}

	public String toString()
	{
		return number+"-"+base;
	}
}