
import java.util.Arrays;

public class StringArrayList {

    String[] array;
    int size;

    public StringArrayList() {
        array = new String[3];
        size = 0;
    }

    public int size() {
        return size;
    }

    public String get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[i];
    }

    public void add(String s) {
        if (array.length == size) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = s;
    }

    public void add(int i, String s) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }
        if (i == size) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        for (int j = size++; j > i; j--) {
            array[j] = array[j - 1];
        }
        array[i] = s;
    }

    public String remove(int i) {
        if (i < 0 || i >= size--) {
            throw new IndexOutOfBoundsException();
        }
        String removed = array[i];
        for (int j = i; j < size; j++) {
            array[j] = array[j + 1];
        }
        return removed;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }

    public static void main(String[] args) {
        StringArrayList arr = new StringArrayList();
        arr.add("Hello");
        arr.add("Hi");
        arr.add("Hello");
        arr.add("Hi");
        arr.add("Hello");
        arr.add("Hi");
        arr.add("Hello");
        arr.add("Hi");
        System.out.println(arr);
        arr.remove(0);
        System.out.println(arr);
        arr.add(1,"Brandon");
        System.out.println(arr);
    }
}
