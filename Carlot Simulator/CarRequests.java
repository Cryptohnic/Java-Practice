
public class CarRequests {

    Queue<Integer> requests;

    public CarRequests() {
        requests = new Queue<>();
    }

    public void addRequest(int x) {
        if (x < 1 || x > 3) {
            throw new IllegalArgumentException("your request must be an int 1-3");
        }
        requests.enqueue(x);
    }

    public int getRequest() {
        return requests.dequeue();
    }

    public boolean hasPendingRequests() {
        return !requests.isEmpty();
    }

    public String toString() {
        return requests.toString().replace("[", "[\n").replaceAll(", ", ",\n").replace("]", "\n]\n");
    }

    public static void main(String[] args) {
        CarRequests cr = new CarRequests();
        cr.addRequest(1);
        cr.addRequest(2);
        cr.addRequest(3);
        cr.addRequest(3);
        cr.addRequest(3);
        while (cr.hasPendingRequests()) {
            System.out.println(cr.getRequest());
        }
    }
}
