
public class StringNode {

    String data;
    StringNode next;

    public StringNode(String data) {
        this.data = data;
        next = null;
    }
    public StringNode(String data,StringNode next) {
        this.data = data;
        this.next = next;
    }

    public static void main(String[] args){
        StringNode n=new StringNode("Brandon");
        System.out.println(n.data);
    }
}
