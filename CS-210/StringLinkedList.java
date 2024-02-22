
public class StringLinkedList {

    private int size;
    private StringNode head;

    public StringLinkedList() {
        size = 0;
        head = null;
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
            while (pointer.next != null) {
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
    
    public String toString() {
        StringNode pointer = head;
        StringBuilder ret = new StringBuilder("[");
        while (pointer != null) {
            ret.append(pointer.data);
            if (pointer.next != null) {
                ret.append(", ");
            }
            pointer = pointer.next;
        }
        return ret.toString() + ']';
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
        System.out.println(l.remove(2));
        System.out.println(l);
        System.out.println(l.remove(0));
        System.out.println(l);
        System.out.println(l.get(0));
    }
}
