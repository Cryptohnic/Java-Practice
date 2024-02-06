//(c) A+ Computer Science
//www.apluscompsci.com

import static java.lang.System.*;

public class ListFunHouseTwoRunner {

    public static void main(String[] args) {
        ListFunHouseTwo funHouse = new ListFunHouseTwo();

        funHouse.add("go");
        funHouse.add("on");
        funHouse.add("at");
        funHouse.add("34");
        funHouse.add("2.1");
        funHouse.add("-a-2-1");
        funHouse.add("up");
        funHouse.add("over");

        out.println("Original list values\n");
        out.println(funHouse + "\n");

        out.println("num nodes = " + funHouse.nodeCount());
        out.println("\nList values after calling nodeCount\n");
        out.println(funHouse + "\n");

        funHouse.doubleLast(); // passes in a new Pointer pointing to the same place in memory
        out.println("\nList values after calling doubleLast\n");
        out.println(funHouse);
        out.println();

        funHouse.doubleFirst();
        out.println("\nList values after calling doubleFirst\n");
        out.println(funHouse);
        out.println();

        funHouse.removeXthNode(2);
        out.println("\nList values after calling removeXthNode(2)\n");
        out.println(funHouse);
        out.println();

        funHouse.setXthNode(2, "one");
        out.println("\nList values after calling setXthNode(2,one)\n");
        out.println(funHouse);
        out.println();
    }
}
