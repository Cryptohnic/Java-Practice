

public class StringLinkedList {

    private int size;
    private StringNode head;

    public StringLinkedList() {
        size = 0;
        head = null;
    }

    public StringLinkedList(StringNode s,int size) {
        this.size = size;
        head = s;
    }

    public int size(){
        return size;
    }

    public String get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        StringNode pointer = head;
        for (int x = 0; x < i; x++) {
            pointer = pointer.next;
        }
        return pointer.data;
    }

    public void add(String s) {
        if (head == null) {
            head = new StringNode(s);
        } else {
            StringNode pointer = head;
            for(int i=0;i<size-1;i++) {
                pointer = pointer.next;
            }
            pointer.next = new StringNode(s);
        }
        size++;
    }

    public void add(int i, String s) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }
        if (i == 0) {
            head = new StringNode(s, head);
        } else {
            StringNode pointer = head;
            for (int x = 0; x < i - 1; x++) {
                pointer = pointer.next;
            }
            pointer.next = new StringNode(s, pointer.next);
        }
        size++;
    }

    public String remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        String removed = "";
        if (i == 0) {
            removed = head.data;
            head = head.next;
        } else {
            StringNode pointer = head;
            for (int x = 0; x < i - 1; x++) {
                pointer = pointer.next;
            }
            removed = pointer.next.data;
            pointer.next = pointer.next.next;
        }
        size--;
        return removed;
    } 

    public void reverse(){
        StringNode current=head;
        StringNode next=head.next;
        StringNode prev=null;
        while(current!=null){
            current.next=prev;
            prev=current;
            current=next;
            if(next!=null)
                next=next.next;
        }
        head=prev;
    }

    public StringLinkedList reversed(){
        return new StringLinkedList(reversed(new StringNode(head.data,head.next),null),size);
    }

    public StringNode reversed(StringNode node, StringNode rev){
        if(node==null)
            return rev;
        return reversed(node.next,new StringNode(node.data,rev));
    }

    public String toString() {
        StringNode pointer = head;
        StringBuilder ret = new StringBuilder("[");
        for(int i=0;i<size;i++){
            ret.append(pointer.data);
            ret.append(", ");
            pointer = pointer.next;
        }
        return ret.toString().substring(0,ret.toString().length()-2) + ']';
    }

    public static void main(String[] args) {
        StringLinkedList l = new StringLinkedList();
        l.add("Brandon");
        System.out.println(l);
        l.add("Hello");
        System.out.println(l);
        System.out.println(l.get(0));
        System.out.println(l.get(1));
        l.add(2, "Test");
        System.out.println(l);
        System.out.println(l.get(0));
        System.out.println(l);
        System.out.println(l.reversed());
        l.reverse();
        System.out.println(l);
    }
}
