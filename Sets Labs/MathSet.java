//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.Set;
import java.util.TreeSet;

public class MathSet{
	private Set<Integer> one;
	private Set<Integer> two;

	public MathSet(){
		one=new TreeSet<Integer>();
		two=new TreeSet<Integer>();
	}

	public MathSet(String o,String t){
		this();
		for(String s : o.split(" "))
			one.add(Integer.valueOf(s));
		for(String s : t.split(" "))
			two.add(Integer.valueOf(s));
	}

	public Set<Integer> union(){
		TreeSet<Integer> union=new TreeSet<>();
		union.addAll(one);
		union.addAll(two);
		return union;
	}

	public Set<Integer> intersection(){
		TreeSet<Integer> intersection=new TreeSet<>();
		intersection.addAll(one);
		intersection.retainAll(two);
		return intersection;
	}

	public Set<Integer> differenceAMinusB(){
		TreeSet<Integer> AMinusB=new TreeSet<>();
		AMinusB.addAll(one);
		AMinusB.removeAll(two);
		return AMinusB;
	}

	public Set<Integer> differenceBMinusA(){
		TreeSet<Integer> BMinusA=new TreeSet<>();
		BMinusA.addAll(two);
		BMinusA.removeAll(one);
		return BMinusA;
	}
	
	public Set<Integer> symmetricDifference(){		
		TreeSet<Integer> symmetricDifference=new TreeSet<>(union());
		symmetricDifference.removeAll(intersection());
		return symmetricDifference;
	}	
	
	public String toString(){
		return "Set one "+one+"\n"+"Set two "+two+"\n\n"+"union - "+union()+"\nintersection - "+intersection()+"\ndifference A-B - "+differenceAMinusB()+"\ndifference B-A - "+differenceBMinusA()+"\nsymmetric difference - "+symmetricDifference()+"\n\n";
	}
}