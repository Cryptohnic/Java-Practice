//(c) A+ Computer Science
//www.apluscompsci.com

public class ThingCount implements Comparable
{
	private int count;
	private Object thing;
	
	public ThingCount()
	{
		this(null,0);
	}
	
	public ThingCount(Object thang, int cnt)
	{	
		setCount(cnt);
		setThing(thang);
	}

	public void setThing(Object obj)
	{
		thing=obj;
	}
	
	public void setCount(int cnt)
	{
		count=cnt;
	}
	
	public Object getThing()
	{
		return thing;
	}

	public int getCount()
	{
		return count;
	}


	// check if they are the same count and object
	public boolean equals(Object obj)
	{
		ThingCount tc = (ThingCount)obj;
		return getThing().equals(tc.getThing()) && getCount()==tc.getCount(); // compare the things
	}


	// compare the objects stored if of same type and implement Comparable
	public int compareTo(Object obj)
	{
		ThingCount tc=(ThingCount) obj;
		if(!getThing().getClass().equals(tc.getThing().getClass())) // make sure same type and comparable
			throw new RuntimeException("Both objects need to be of the same type");
		if(!(getThing() instanceof Comparable && tc.getThing() instanceof Comparable))
			throw new RuntimeException("Both objects need to be of type Comparable");
		return ((Comparable)getThing()).compareTo(tc.getThing()); // compare the things
	}
	
	public String toString()
	{
		return ""+thing + " - " + count;
	}
}