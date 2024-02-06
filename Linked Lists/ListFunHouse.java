//(c) A+ Computer Science
//www.apluscompsci.com

import static java.lang.System.*;

// methods that take in ListNodes will have a new pointer and modify the original that is still pointing at the head
public class ListFunHouse {
    //this method will print the entire list on the screen

    public static void print(ListNode list) {
        while (list != null) { // print the value and then go to the next
            out.print(list.getValue() + " ");
            list = list.getNext();
        }
    }

    //this method will return the number of nodes present in list
    public static int nodeCount(ListNode list) {
        int count = 0;
        while (list != null) { // count the value and then go to the next
            count++;
            list = list.getNext();
        }
        return count;
    }

    //this method will create a new node with the same value as the first node and add this
    //new node to the list.  Once finished, the first node will occur twice.
    public static void doubleFirst(ListNode list) {
        list = new ListNode(list.getValue(), list); // set the next value to the first's value and storing the next Node to double the first
    }

    //this method will create a new node with the same value as the last node and add this
    //new node at the end. Once finished, the last node will occur twice.
    public static void doubleLast(ListNode list) {
        while (list.getNext() != null) // traverse to the last Node
        {
            list = list.getNext();
        }
        list.setNext(new ListNode(list.getValue(), null)); // change the next from null to a new node with the same value pointing to null
    }

    //method skipEveryOther will remove every other node
    public static void skipEveryOther(ListNode list) {
        while (list != null && list.getNext() != null) { // if we have two values left, skip the next value
            list.setNext(list.getNext().getNext());
            list = list.getNext();
        }
    }

    //this method will set the value of every xth node in the list
    public static void setXthNode(ListNode list, int x, Comparable value) {
        int count = 1; // count the first Node
        while (list != null) {
            for (; count < x; count++) // iterate up to the xth Node
            {
                if (list != null) // keep traversing up to count
                {
                    list = list.getNext(); 
                }else {
                    break;
                }
            }
            if (list != null) // if we aren't at the end
            {
                list.setValue(value); // setXthNode to value

                        }count = 0;
        }
    }

    //this method will remove every xth node in the list
    public static void removeXthNode(ListNode list, int x) {
        int count = 1; // count the first Node
        while (list != null) {
            for (; count < x - 1; count++) // iterate up to one before the Node to skip
            {
                if (list != null) // keep traversing up to count
                {
                    list = list.getNext(); 
                }else {
                    break;
                }
            }
            if (list != null && list.getNext() != null) // if we have two Nodes
            {
                list.setNext(list.getNext().getNext()); // skip the second one

                        }count = 0;
        }
    }
}
