//(c) A+ Computer Science
//www.apluscompsci.com

public class HistoTreeTwo{
   private TreeNode root;

	public HistoTreeTwo(){
		root=null;
	}	

	public void addData(Comparable data){
		TreeNode currNode=search(data);
		if(currNode==null) // if we arent in the tree
			root=add(data,root); // call the add method
		else // update the count by one
			((ThingCount)currNode.getValue()).setCount(((ThingCount)currNode.getValue()).getCount()+1);
	}

	private TreeNode add(Comparable data, TreeNode tree){
		if(tree==null) // once we have reached the end
			return new TreeNode(new ThingCount(data,1),null,null);
		int dirTest=data.compareTo(((ThingCount)tree.getValue()).getThing());
		if(dirTest<0) 
			tree.setLeft(add(data,tree.getLeft())); // set the left to the new node/old node if not at the end
		else
			tree.setRight(add(data,tree.getRight())); // set the right to the new node/old node if not at the end
		return tree; // keep updating back up the tree
	}

	private TreeNode search(Comparable data){
		return search(data,root);
	}

	private TreeNode search(Comparable data, TreeNode tree){
		if(tree==null)
			return null;
		int dirTest=data.compareTo(((ThingCount)tree.getValue()).getThing());
		if(dirTest==0) // if we are here
			return tree;
		else if(dirTest<0) // search left
			return search(data,tree.getLeft());
		else // search right
			return search(data,tree.getRight());
	}

	public String toString(){
		return toString(root);
	}

	private String toString(TreeNode tree){ // inOrder approach
		if(tree==null)
			return "";
		return ""+toString(tree.getLeft())+" "+tree.getValue()+" "+toString(tree.getRight());
	}
}