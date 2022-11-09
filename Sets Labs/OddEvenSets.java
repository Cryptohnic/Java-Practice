//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

public class OddEvenSets{
	private Set<Integer> odds;
	private Set<Integer> evens;
	private Set<Integer> perfects;

	public OddEvenSets(){
		odds=new TreeSet<>();
		evens=new TreeSet<>();
		perfects=new TreeSet<>();
	}

	public OddEvenSets(String line){
		this();
		Scanner s=new Scanner(line);
		while(s.hasNext()){
			int num=s.nextInt();
			if(num%2!=0)
				odds.add(num);
			else
				evens.add(num);
		}
		s.close();
		PerfectSet(line);
	}

	private void PerfectSet(String line){
		Scanner s=new Scanner(line);
		while(s.hasNext()){
			int num=s.nextInt();
			if(num>1){
				int totDivisors=1;
				for(int i=2;i<=Math.sqrt(num);i++)
					if(num%i==0){
						totDivisors+=i;
						if(Math.pow(i,2)!=num)
							totDivisors+=num/i;
					}
				if(totDivisors==num)
					perfects.add(num);
			}
		}
		s.close();
	}

	public String toString(){
		return "ODDS : "+odds+"\nEVENS : "+evens+"\nPERFECTS : "+perfects+"\n\n";
	}
}