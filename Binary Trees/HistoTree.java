//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

public class HistoTree
{
	private HistoNode root;

	public HistoTree( )
	{
		root=null;
	}

	public void addData(Comparable data)
	{
		HistoNode thisDataNode=search(data);
		if(thisDataNode==null)
			root=add(data,root);
		else
			thisDataNode.setDataCount(thisDataNode.getDataCount()+1);
	}

	private HistoNode add(Comparable data, HistoNode tree)
	{
		if(tree==null)
			return new HistoNode(data,1,null,null);
		int dirTest=data.compareTo(tree.getData());
		if(dirTest<0)
			tree.setLeft(add(data,tree.getLeft()));
		else
			tree.setRight(add(data,tree.getRight()));
		return tree;
	}

	private HistoNode search(Comparable data)
	{
		return search(data,root);
	}

	private HistoNode search(Comparable data, HistoNode tree)
	{
		if(tree==null)
			return null;
		int dirTest=data.compareTo(tree.getData());
		if(dirTest==0)
			return tree;
		else if(dirTest<0)
			return search(data,tree.getLeft());
		return search(data,tree.getRight());
	}

	public String toString()
	{
		return toString(root);
	}

	private String toString(HistoNode tree)
	{
		if(tree==null)
			return "";
		return toString(tree.getLeft())+" "+tree.getData()+" - "+tree.getDataCount()+" "+toString(tree.getRight());
	}
}