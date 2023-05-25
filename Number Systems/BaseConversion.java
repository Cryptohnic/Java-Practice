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
		for(int i=0;i<q;i++){
			int digit=number.charAt(q-i-1)-48;
			if(digit>9)
				digit-=7;
			base10+=digit*Math.pow(base,i);
		}
		return base10;
		
	}

	public String getNum(int newBase)
	{
		int base10 = convertToTen();
		String newNum="";
		while(base10>0){
			String digit=String.valueOf(base10%newBase);
			if(Integer.parseInt(digit)>9)
				digit=""+(char)(Integer.parseInt(digit)+55);
			newNum=digit+newNum;
			base10/=newBase;
		}
		return newNum+"-"+newBase;
	}

	public String toString()
	{
		return number+"-"+base;
	}
}