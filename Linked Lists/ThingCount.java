//(c) A+ Computer Science
//www.apluscompsci.com

public class ThingCount<T> implements Comparable<T>
{
	private int count;
	private T thing;
	
	public ThingCount()
	{
		this(null,0);
	}
	
	public ThingCount(T thang, int cnt)
	{	
		setCount(cnt);
		setThing(thang);
	}

	public void setThing(T obj)
	{
		thing=obj;
	}
	
	public void setCount(int cnt)
	{
		count=cnt;
	}
	
	public T getThing()
	{
		return thing;
	}

	public int getCount()
	{
		return count;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj)
	{
		ThingCount<T> tc = (ThingCount<T>)obj;
		return getThing().equals(tc.getThing()) && getCount()==tc.getCount();
	}

	@SuppressWarnings("unchecked")
	public int compareTo(Object obj)
	{
		ThingCount<T> tc=(ThingCount<T>) obj;
		if(!getThing().getClass().equals(tc.getThing().getClass()))
			throw new RuntimeException("Both objects need to be of the same type");
		if(!(getThing() instanceof Comparable && tc.getThing() instanceof Comparable))
			throw new RuntimeException("Both objects need to be of type Comparable");
		return ((Comparable<T>)getThing()).compareTo(tc.getThing());
	}
	
	public String toString()
	{
		return ""+thing + " - " + count;
	}
}