import java.util.List;
import java.util.LinkedList;

public class Queue<T>{
    
    private List<T> queue;
    private int length;

    public Queue(){
        queue=new LinkedList<>();
        length=0;
    }

    public int size(){
        return length;
    }

    public void enqueue(T e){
        queue.add(e);
        length++;
    }

    public T dequeue(){
        length--;
        return queue.remove(0); // remove the ones added at the beginning FIFO
    }

    public boolean isEmpty(){
        return length==0;
    }

    public T peek(){
        return queue.get(0);
    }

    public String toString(){
        return length>0 ? queue.toString().replace(", ",",\n").replace("[","[\n").replace("]","\n]\n") : "[]\n";
    }

    public static void main(String[] args){
        Queue<Integer> q=new Queue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q);
        System.out.println(q.dequeue());
        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q.dequeue());
        System.out.println(q);
        System.out.println(q.size());
    }
}

