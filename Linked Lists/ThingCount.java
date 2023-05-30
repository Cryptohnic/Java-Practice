//(c) A+ Computer Science
//www.apluscompsci.com

public class ThingCount implements Comparable
{
	private int count;
	private Comparable thing;
	
	public ThingCount()
	{
		this(null,0);
	}
	
	public ThingCount(Comparable thang, int cnt)
	{	
		setCount(cnt);
		setThing(thang);
	}

	public void setThing(Comparable obj)
	{
		thing=obj;
	}
	
	public void setCount(int cnt)
	{
		count=cnt;
	}
	
	public Comparable getThing()
	{
		return thing;
	}

	public int getCount()
	{
		return count;
	}

	public boolean equals(Object obj)
	{
		ThingCount tc = (ThingCount)obj;
		return getThing().equals(tc.getThing()) && getCount()==tc.getCount(); // compare the things
	}

	public int compareTo(Object obj)
	{
		ThingCount tc=(ThingCount) obj;
		if(!getThing().getClass().equals(tc.getThing().getClass())) // make sure same type and comparable
			throw new RuntimeException("Both objects need to be of the same type");
		if(!(getThing() instanceof Comparable && tc.getThing() instanceof Comparable))
			throw new RuntimeException("Both objects need to be of type Comparable");
		return getThing().compareTo(tc.getThing()); // compare the things
	}
	
	public String toString()
	{
		return ""+thing + " - " + count;
	}
}