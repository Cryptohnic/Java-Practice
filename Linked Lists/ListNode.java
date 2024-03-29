//(c) A+ Computer Science
//www.apluscompsci.com

public class ListNode implements Linkable {

    private Comparable listNodeValue;
    private ListNode nextListNode;

    public ListNode() {
        this(null, null);
    }

    public ListNode(Comparable value, ListNode next) {
        listNodeValue = value;
        nextListNode = next;
    }

    public Comparable getValue() {
        return listNodeValue;
    }

    public ListNode getNext() {
        return nextListNode;
    }

    public void setValue(Comparable value) {
        listNodeValue = value;
    }

    public void setNext(Linkable next) {
        nextListNode = (ListNode) next;
    }
}
