//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.Map;
import java.util.HashMap;

public class Words{
	private Map<String,Integer> m;
	
	public Words(){
		m=new HashMap<>();
		m.put("one",1);
		m.put("two",2);
		m.put("three",3);
		m.put("four",4);
		m.put("five",5);
		m.put("six",6);
		m.put("seven",7);
		m.put("eight",8);
		m.put("nine",9);
		m.put("ten",10);
	}
	
	public int getNumber(String s){
		return m.get(s);
	}
}