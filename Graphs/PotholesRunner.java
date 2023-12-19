import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.lang.System.*;

public class PotholesRunner {
    public static void main(String[] args)throws IOException{
        Scanner sc=new Scanner(new File("potholes.dat"));
        String destination=sc.next();
        sc.nextLine();
        Potholes ph=new Potholes(destination);
        while(sc.hasNextLine()){
            String line=sc.nextLine();
            if(line.length()<2){
                //ph.shortestPath("A",destination,"",0,0);
                System.out.println(ph);
                ph=new Potholes(line);
            }else
                ph.add(line);
        }
    }
}
