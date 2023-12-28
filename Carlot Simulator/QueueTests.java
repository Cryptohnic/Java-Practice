import org.junit.Test;
import org.junit.Assert;

public class QueueTests<T> {
    @Test
    public void testConstructor1() {
        Assert.assertEquals("[]\n",new Queue<Integer>().toString());
    }

    @Test
    public void testEnqueue() {
        Queue<Integer> q=new Queue<>();
        q.enqueue(1);
        Assert.assertEquals("[\n1\n]\n",q.toString());
    }

    @Test
    public void testDequeue() {
        Queue<Integer> q=new Queue<>();
        q.enqueue(1);
        q.enqueue(2);
        Assert.assertEquals(1,(int)q.dequeue());
    }

    @Test
    public void testPeek() {
        Queue<Integer> q=new Queue<>();
        q.enqueue(1);
        Assert.assertEquals(1,(int)q.peek());
    }

    @Test
    public void isEmpty1() {
        Queue<Integer> q=new Queue<>();
        Assert.assertEquals(true,q.isEmpty());
    }

    @Test
    public void isEmpty2() {
        Queue<Integer> q=new Queue<>();
        q.enqueue(1);
        Assert.assertEquals(false,q.isEmpty());
    }
}