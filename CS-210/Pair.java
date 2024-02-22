
public class Pair<A, B> {

    A one;
    B two;

    public Pair(A a, B b) {
        one = a;
        two = b;
    }

    public A getOne() {
        return one;
    }

    public B getTwo() {
        return two;
    }

    public static void main(String[] args){
        Pair<Integer,String> p=new Pair<>(1,"Hi");
        System.out.println(p.getOne());
        System.out.println(p.getTwo());
    }
}
