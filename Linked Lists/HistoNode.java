//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

public class HistoNode<T>
{
	private Comparable<T> data;
	private int dataCount;
	private HistoNode<T> left;
	private HistoNode<T> right;

	public HistoNode(Comparable<T> d, int cnt, HistoNode<T> lft, HistoNode<T> rt)
	{
		data=d;
		dataCount=cnt;
		left=lft;
		right=rt;
	}

	public Comparable<T> getData()
	{
		return data;
	}

	public int getDataCount()
	{
		return dataCount;
	}

	public HistoNode<T> getLeft()
	{
	   return left;
	}

	public HistoNode<T> getRight()
	{
	   return right;
	}

	public void setData(Comparable<T> d)
	{
		data=d;
	}

	public void setDataCount(int cnt)
	{
		dataCount=cnt;
	}

	public void setLeft(HistoNode<T> lft)
	{
		left=lft;
	}

	public void setRight(HistoNode<T> rt)
	{
		right=rt;
	}
}


