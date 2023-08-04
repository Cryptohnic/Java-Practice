//(c) A+ Computer Science
//www.apluscompsci.com

public class HistogramListTwoRunner{
	public static void main(String[] args){
		HistoListTwo test = new HistoListTwo();
		String testString = "ABCDEFABCDEFFEDCBAAAAABBBBBCCCDAAAAAAAEEFFF";
		for(char c : testString.toCharArray()){
			test.add(c);
		}
		System.out.println(test);


		//add more test cases
		test = new HistoListTwo();
		testString = "11 22 33 44 55 66 33 44 22 11 11 11 11 22 11 11 11";
		for(String c : testString.split(" ")){
			test.add(Integer.parseInt(c));
		}
		System.out.println(test);

		test = new HistoListTwo();
		testString = "1.1 2.2 3.3 4.4 5.5 6.6 3.3 4.4 2.2 1.1 1.1 1.1 1.1 2.2 1.1";
		for(String c : testString.split(" ")){
			test.add(Double.parseDouble(c));
		}
		System.out.println(test);

		
		//demonstrate bad data check
		test = new HistoListTwo();
		test.add("dog");
		test.add(33);
		test.add(3.4);
		System.out.println(test);
	}
}