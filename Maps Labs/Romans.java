//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.Map;
import java.util.HashMap;

public class Romans{
	private Map<String,Integer> m;
	
	public Romans(){
		m = new HashMap<String, Integer>();
		m.put("I",1);
		m.put("V", 5);
		m.put("X", 10);
		m.put("L", 50);
		m.put("C", 100);
		m.put("D", 500);
		m.put("M", 1000);					
	}
	
	public int getNumber(String s){
		return m.get(s);
	}

	public int getTotal(String s){
		int tot=0;
		for(String c:s.split(" "))
			tot+=m.get(c);
		return tot;
	}
}