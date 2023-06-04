//(c) A+ Computer Science
//www.apluscompsci.com

import static java.lang.System.out;
import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree
{
	private TreeNode root;

	public BinarySearchTree()
	{
		root=null;
	}

	public void add(Comparable val)
	{
		root=add(val,root);
	}

	private TreeNode add(Comparable val, TreeNode tree)
	{
		if(tree==null)
			tree=new TreeNode(val);
		else{
			Comparable treeValue=tree.getValue();
			int dirTest=val.compareTo(treeValue);
			if(dirTest<0)
				tree.setLeft(add(val, tree.getLeft()));
			else if(dirTest>=0)
				tree.setRight(add(val, tree.getRight()));
		}
		return tree;
	}

   	public void inOrder()
	{
		inOrder(root);
		out.println("\n\n");
	}

	private void inOrder(TreeNode tree) // all left values first then all right values
	{
		if (tree!=null){
			inOrder(tree.getLeft());
			out.print(tree.getValue()+" ");
			inOrder(tree.getRight());
		}
	}

	public void preOrder()
	{
		preOrder(root);
		out.println("\n\n");
	}
	
	private void preOrder(TreeNode tree) // returns the values in a possible arrangement of how they were added
	{
		if(tree!=null){
			out.print(tree.getValue()+" ");
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}

	public void postOrder()
	{
		postOrder(root);
		out.println("\n\n");
	}
	
	private void postOrder(TreeNode tree) // go to the left and then start going to the right until you have to go up
	{
		if(tree!=null){
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			out.print(tree.getValue()+" ");
		}
	}

	public void levelOrder()
	{
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		levelOrder(queue);
		out.println("\n\n");
	}
	
	private void levelOrder(Queue<TreeNode> queue)
	{
		if(queue.isEmpty())
			return;
		TreeNode node=queue.remove();
		out.print(node.getValue()+" ");
		if(node.getLeft()!=null)
			queue.add(node.getLeft());
		if(node.getRight()!=null)
			queue.add(node.getRight());
		levelOrder(queue); // since queues are FIFO it just does every nodes left and right in order
	}
	
	public void reverseOrder()
	{
		reverseOrder(root);
		out.println("\n\n");
	}

	private void reverseOrder(TreeNode tree) // start at the bottom right and then print any children to its left repeated
	{
		if(tree!=null){
			reverseOrder(tree.getRight());
			out.print(tree.getValue()+" ");
			reverseOrder(tree.getLeft());
		}
	}
	
	public int getNumLevels()
	{
		return getNumLevels(root);
	}

	private int getNumLevels(TreeNode tree)
	{
		if(tree==null)
        	return 0;
    	return Math.max(getNumLevels(tree.getLeft()), getNumLevels(tree.getRight()))+1; // traverse the entire tree and find the longest chain
	}

	public int getNumLeaves()
	{
		return getNumLeaves(root);
	}
	
	private int getNumLeaves(TreeNode tree)
	{
		if(tree==null)
			return 0;
		else if(tree.getLeft()==null && tree.getRight()==null) // if no children add one
			return 1;
		else
			return getNumLeaves(tree.getLeft())+getNumLeaves(tree.getRight()); // traverse the whole tree
	}

	public int getWidth()
	{
		return getWidth(root);
	}
	
	private int getWidth(TreeNode tree) // finds the longest possible traversal length in the tree
	{
		return getNumLevels(tree.getLeft())+getNumLevels(tree.getRight())+1;
	}

	public int getHeight()
	{
		return getHeight(root);
	}
	
	private int getHeight(TreeNode tree) // height is literally just minus 1
	{
		return getNumLevels(tree)-1;
	}
	
	public int getNumNodes(){
		return getNumNodes(root);
	}

	private int getNumNodes(TreeNode tree){
		if(tree==null) return 0;
		else
			return 1+getNumNodes(tree.getLeft())+getNumNodes(tree.getRight()); // adds one for each node and traverses recursively
	}

	public boolean isFull()
	{
		return isFull(root);
	}

	private boolean isFull(TreeNode tree) // if 2^levels-1==number of nodes tree is full
	{
		return Math.pow(2,getNumLevels())-1==getNumNodes();
	}
	
	public boolean search(Comparable value){
		return search(root,value);
	}

	public boolean search(TreeNode tree, Comparable value){
		if(tree!=null){
			int dirTest=value.compareTo(tree.getValue());
			if(dirTest==0)
				return true;
			else if(dirTest<0)
				return search(tree.getLeft(),value);
			else
				return search(tree.getRight(),value);
		}
		return false;
	}
	
	public Comparable maxNode(){
		return maxNode(root).getValue();
	}

	public TreeNode maxNode(TreeNode tree){
		if(tree.getRight()==null)
			return tree;
		return maxNode(tree.getRight()); // return the rightmost node
	}
	
	public Comparable minNode(){
		return minNode(root).getValue(); 
	}

	public TreeNode minNode(TreeNode tree){
		if(tree.getLeft()==null)
			return tree;
		return minNode(tree.getLeft()); // return the leftmost node
	}
	
	public void remove(Comparable value){
		root=remove(root, value);
	}

	public TreeNode remove(TreeNode tree, Comparable value){
		if(tree!=null){
			int dirTest=value.compareTo(tree.getValue());
			if(dirTest<0) // if its less than the current value go left
				tree.setLeft(remove(tree.getLeft(),value));
			else if(dirTest>0) // if its greater than the current value go right
				tree.setRight(remove(tree.getRight(),value));
			else{ // if we found the value
				if(tree.getRight()!=null){ // if it has values to its right, set it to the next smallest value
					TreeNode successor=minNode(tree.getRight());
					tree.setValue(successor.getValue());
					tree.setRight(remove(tree.getRight(),successor.getValue())); // keep replacing with successors until none left
				}
				else
					tree=tree.getLeft(); // set it to the left node left over, if there isn't one it will just become null
			}
		}
		return tree;
	}
	
	public String toString()
	{
		TreeNode[] arr=new TreeNode[]{root};
		return toString(root,arr);
	}

	private int squaredSums(int input){ // find the number of extra spaces for the first row of the toString()
		int ans=1;
		while(input>1){
			ans+=Math.pow(2,input);
			input--;
		}
		return ans;
	}

	private String toString(TreeNode tree, TreeNode[] row){ // level order approach using an array instead (all spacing numbers found through a pattern identified with a min numLevels of 5)
		if(tree==null)
			return "";
		String ans="";
		int maxLength=String.valueOf(maxNode()).length();
		int height=getHeight();
		int between=(int)Math.pow(2,height)*maxLength+squaredSums(height); // distance between values for the first row
		String betweenSpaces=String.format("%"+between+"s","");
		int initialGap=(int)Math.pow(2,height-1)*maxLength+(int)Math.pow(2,height)-2; // length of intial gap on the first row
		String gapSpaces=String.format("%"+initialGap+"s","");
		for(int i=height;i>=0;i--){ // start at the top of the tree and go down
			TreeNode[] nextRow=new TreeNode[row.length*2]; // create the next row to add new nodes to
			if(i!=0) // if we aren't on the last row add the gap
				ans+=gapSpaces;
			else
				betweenSpaces=String.format("%"+maxLength+"s",""); // set the betweenSpaces to max number length
			int spot=0;
			for(TreeNode currNode : row){ // entire current row
				Comparable currValue;
				if(currNode!=null){
					nextRow[spot++]=currNode.getLeft(); // add the null ones too
					nextRow[spot++]=currNode.getRight();
					currValue=currNode.getValue();
				}
				else{ // make sure that the next row keeps these vals as null so the spacing is right
					spot+=2;
					currValue="";
				}
				ans+=String.format("%"+maxLength+"s"+betweenSpaces,currValue); // add the value to the String version of the tree
				if(i==0) // if we are on the last row
					if(betweenSpaces.length()==maxLength) // last row changes each iteration so it is hard coded. Alternates between one spaces and maxlength spaces
						betweenSpaces=" ";
					else
						betweenSpaces=String.format("%"+maxLength+"s","");
			}
			if(i==0) break; // we are done already
			ans+="\n";
			gapSpaces=gapSpaces.substring((int)Math.pow(2,i-2)*maxLength+(int)Math.pow(2,i-1)); // update gap for next row by removing half of the maxLengths and (half of the added nums)-1
			betweenSpaces=betweenSpaces.substring((int)Math.pow(2,i-1)*maxLength+(int)Math.pow(2,i)); // update the spacing by removing half of the maxLengths and removing current amount of maxLengths from the added num
			row=nextRow; // move onto the next row
		}
		return ans;
	}
}