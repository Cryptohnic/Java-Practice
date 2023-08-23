import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Potholes{
    String shortestPath;
    Map<String,Map<String,Integer>> connections;
    Map<String,Map<String,Integer>> shortestDistance;

    public Potholes(){
        shortestPath="";
        connections=new HashMap<>();
        shortestDistance=new HashMap<>();
    }

    public void add(String edge){
        String[] splitData=edge.split(" - ");
        String firstVertex=splitData[0].substring(0,1);
        String secondVertex=splitData[0].substring(2,3);
        int weight=Integer.parseInt(splitData[1]);
        if(connections.get(firstVertex)==null)
            connections.put(firstVertex,new HashMap<String,Integer>());
        if(connections.get(secondVertex)==null)
            connections.put(secondVertex,new HashMap<String,Integer>());
        connections.get(firstVertex).put(secondVertex,weight);
        connections.get(secondVertex).put(firstVertex,weight);
    }

    private void shortestPath(String start, String end){ // implements Djikstra's algorithm
		for(String vertex : connections.keySet()){
            shortestDistance.put(vertex,new HashMap<>());
            shortestDistance.get(vertex).put("",Integer.MAX_VALUE);
        }
        shortestDistance.get(start).put("",0);
        List<String> unvisited=new ArrayList<>(shortestDistance.keySet());
        unvisited.remove(start);
        String previousNode=start;  
        while(unvisited.size()>0){
            int closestDistance=Integer.MAX_VALUE;
            String closestNode="";
            for(Map.Entry<String,Integer> weightedNode : connections.get(previousNode).entrySet()){ // find the closest node to visit first
                int checkingDistance=weightedNode.getValue();
                String checkingNode=weightedNode.getKey();
                if(!unvisited.contains(checkingNode) && checkingDistance<closestDistance)
                    closestDistance=checkingDistance;
            }
            if(closestNode=="")
                closestNode=unvisited.remove(0);
            
            // shortestDistance.get(closestNode).put(previousNode,);



            unvisited.remove(closestNode);
            previousNode=closestNode;
        }
	}

    public String toString(){
        return shortestPath;
    }
}