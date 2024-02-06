//(c) A+ Computer Science
//www.apluscompsci.com

public class HistoListTwo {

    private ListNode front;

    public HistoListTwo() {
        front = null;
    }

    //ADDS NEW NODE TO THE FRONT OF THE LIST FOR LET IF IT DOES NOT EXIST.
    //IF IT EXISTS, IT BUMPS UP LET'S COUNT BY ONE
    public void add(Object obj) {
        int index = indexOf(obj);
        if (index == -1) {
            front = new ListNode(new ThingCount(obj, 1), front); // create a new ThingCount to put at the front for the new Object
         }else {
            ListNode current = nodeAt(index); // get the already existing Node
            ((ThingCount) current.getValue()).setCount(((ThingCount) current.getValue()).getCount() + 1); // update the count stored of the Object
        }
    }

    //RETURNS THE INDEX POSITION OF LET IN THE LIST
    public int indexOf(Object obj) {
        int spot = 0;
        ListNode current = front;
        while (current != null) {
            if (current.getValue().compareTo(new ThingCount(obj, 0)) == 0) // if the object stored is the same
            {
                return spot;
            }
            current = current.getNext();
            spot++;
        }
        return -1;
    }

    //RETURNS A REFERENCE TO THE NODE AT SPOT
    private ListNode nodeAt(int spot) {
        ListNode current = front;
        for (int i = 0; i < spot; i++) {
            current = current.getNext();
        }
        return current;
    }

    //RETURNS THE LIST AS A BIG STRING
    public String toString() {
        String output = "";
        ListNode current = front;
        while (current != null) {
            output += ((ThingCount) current.getValue()).getThing() + " - " + ((ThingCount) current.getValue()).getCount() + "\t";
            current = current.getNext();
        }
        return output;
    }
}
