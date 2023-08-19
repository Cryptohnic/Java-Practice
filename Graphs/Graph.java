//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.Map;
import java.util.TreeMap;

public class Graph{
	private Map<String, String> map;
	private boolean found;

	public Graph(String line){
		map=new TreeMap<>();
		found=false;
		String[] connections=line.split(" ");
		for(String connection : connections){
			String firstVal=connection.substring(0,1);
			String secondVal=connection.substring(1);
			if(map.get(firstVal)==null)
				map.put(firstVal,"");
			if(map.get(secondVal)==null)
				map.put(secondVal,"");
			map.put(firstVal,map.get(firstVal)+secondVal);
			map.put(secondVal,map.get(secondVal)+firstVal);
		}
	}

	// public boolean contains(String letter){
	//    return map.get(letter)!=null;
	// }

	public void check(String first, String second, String placesUsed){
		if(map.get(first).contains(second)){
			found=true;
			return;
		}
		String currentConnections=map.get(first);
		for(String connection : currentConnections.split(""))
			if(!placesUsed.contains(connection))
				check(connection,second,placesUsed+connection);
	}

	public String toString(){
		return found ? "yes" : "no";
	}
}