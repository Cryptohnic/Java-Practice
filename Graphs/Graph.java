//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.Map;
import java.util.HashMap;

public class Graph{
	private Map<String, String> map;
	private boolean found;

	public Graph(String line){
		map=new HashMap<>();
		found=false;
		String[] connections=line.split(" ");
		for(String connection : connections){
			String firstVal=connection.substring(0,1);
			String secondVal=connection.substring(1);
			if(map.get(firstVal)==null)
				map.put(firstVal,"");
			if(map.get(secondVal)==null)
				map.put(secondVal,"");
			map.put(firstVal,map.get(firstVal)+secondVal); // add on the secondVal to the list of current connections
			map.put(secondVal,map.get(secondVal)+firstVal); // add on the firstVal to the list of current connections
		}
	}

	// public boolean contains(String letter){
	//    return map.get(letter)!=null;
	// }

	public void check(String first, String second, String placesUsed){
		if(map.get(first).contains(second)){ // if we found a connection
			found=true;
			return;
		}
		String currentConnections=map.get(first);
		for(String connection : currentConnections.split(""))
			if(!placesUsed.contains(connection)) // if we haven't checked this connection yet
				check(connection,second,placesUsed+connection); // check it and add it as a checked position
	}

	public String toString(){
		return found ? "yes" : "no";
	}
}