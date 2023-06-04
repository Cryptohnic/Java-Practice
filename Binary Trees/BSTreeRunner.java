//(c) A+ Computer Science
//www.apluscompsci.com

import static java.lang.System.out;

public class BSTreeRunner
{
   public static void main( String args[] )
   {
 		BinarySearchTree bs=new BinarySearchTree();
      bs.add(90);
      bs.add(80);
      bs.add(70);
      bs.add(85);
      bs.add(100);
      bs.add(98);
      bs.add(120);
      out.println("IN ORDER");
      bs.inOrder();
      out.println("PRE ORDER");
      bs.preOrder();
      out.println("POST ORDER");
      bs.postOrder();
      out.println("LEVEL ORDER");
      bs.levelOrder();
      out.println("REVERSE ORDER");
      bs.reverseOrder();
      out.println("\nTree height is "+bs.getHeight());
      out.println("Tree width is "+bs.getWidth());
      out.println("Number of leaves is "+bs.getNumLeaves());
      out.println("Number of nodes is "+bs.getNumNodes());
      out.println("Number of levels is "+bs.getNumLevels());
      out.println(bs);
      out.println(bs.isFull() ? "The tree is full.\n" : "The tree is not full.\n");
      bs=new BinarySearchTree();
      bs.add(90);
      bs.add(80);
      bs.add(70);
      bs.add(73);
      bs.add(72);
      bs.add(71);
      bs.add(67);
      bs.add(68);
      bs.add(69);
      //bs.add(120);
      out.println("IN ORDER");
      bs.inOrder();
      out.println("PRE ORDER");
      bs.preOrder();
      out.println("POST ORDER");
      bs.postOrder();
      out.println("LEVEL ORDER");
      bs.levelOrder();
      out.println("REVERSE ORDER");
      bs.reverseOrder();
      out.println("\nTree height is "+bs.getHeight());
      out.println("Tree width is "+bs.getWidth());
      out.println("Number of leaves is "+bs.getNumLeaves());
      out.println("Number of nodes is "+bs.getNumNodes());
      out.println("Number of levels is "+bs.getNumLevels());
      out.println(bs);
      out.println(bs.isFull() ? "The tree is full." : "The tree is not full.");
   }
}