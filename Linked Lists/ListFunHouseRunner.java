//(c) A+ Computer Science
//www.apluscompsci.com

import static java.lang.System.*;

public class ListFunHouseRunner {

    public static void main(String[] args) {
        ListNode z = new ListNode("go", new ListNode("on", // instantiate the ListNode LinkedList
                new ListNode("at",
                        new ListNode("2.1",
                                new ListNode("-a-2-1",
                                        new ListNode("up",
                                                new ListNode("over", null)))))));

        out.println("\nLab15b Test Code\n\n");

        out.println("Original list values\n");
        ListFunHouse.print(z);
        out.println("\n");

        out.println("num nodes = " + ListFunHouse.nodeCount(z));
        out.println("\nList values after calling nodeCount\n");
        ListFunHouse.print(z);
        out.println();

        ListFunHouse.doubleFirst(z); // passes in a new Pointer pointing to the same place in memory
        out.println("\nList values after calling doubleFirst\n");
        ListFunHouse.print(z);
        out.println();

        ListFunHouse.doubleLast(z);
        out.println("\nList values after calling doubleLast\n");
        ListFunHouse.print(z);
        out.println();

        ListFunHouse.skipEveryOther(z);
        out.println("\nList values after calling skipEveryOther\n");
        ListFunHouse.print(z);
        out.println();

        ListFunHouse.setXthNode(z, 2, "one");
        out.println("\nList values after calling setXthNode(2,one)\n");
        ListFunHouse.print(z);
        out.println();

        ListFunHouse.removeXthNode(z, 2);
        out.println("\nList values after calling removeXthNode(2)\n");
        ListFunHouse.print(z);
        out.println();
    }
}
