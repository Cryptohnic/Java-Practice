import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Potholes{
    String destination;
    String shortestPath;
    int distance;
    Map<String,Map<String,Integer>> directDistance;
    Map<String,Map<String,Integer>> shortestDistance;

    public Potholes(String end){
        destination=end;
        shortestPath="";
        distance=Integer.MAX_VALUE;
        directDistance=new HashMap<>();
        shortestDistance=new HashMap<>();
    }

    public void add(String edge){
        String[] splitData=edge.split(" - ");
        String firstVertex=splitData[0].substring(0,1);
        String secondVertex=splitData[0].substring(2,3);
        int weight=Integer.parseInt(splitData[1]);
        if(directDistance.get(firstVertex)==null)
            directDistance.put(firstVertex,new HashMap<String,Integer>());
        if(directDistance.get(secondVertex)==null)
            directDistance.put(secondVertex,new HashMap<String,Integer>());
        directDistance.get(firstVertex).put(secondVertex,weight);
        directDistance.get(secondVertex).put(firstVertex,weight);
    }

    public void shortestPath(String end){
        shortestPath();

    }

    private void shortestPath(){
		for(String vertex : directDistance.keySet()){
            shortestDistance.put(vertex,new HashMap<>());
            shortestDistance.get(vertex).put("",Integer.MAX_VALUE);
        }
        calculate("");
	}

    private void calculate(String placesUsed){
        
	}

    public String toString(){
        return shortestPath;
    }
}