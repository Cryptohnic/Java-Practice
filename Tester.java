
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Tester {

    public static void main(String[] args) {
        System.out.println(Byte.SIZE);
        System.out.println(Character.SIZE);
        System.out.println(Short.SIZE);
        System.out.println(Integer.SIZE);
        System.out.println(Float.SIZE);
        System.out.println(Long.SIZE);
        System.out.println(Double.SIZE);

        System.out.println("\n\n\n\n");

        String s = new String();
        Object o = new Object();
        System.out.println(s);
        System.out.println(o);
        String[] sarr = new String[3];
        Object[] oarr = new Object[3];
        int[] iarr = new int[3];
        boolean[] barr = new boolean[3];
        float[] farr = new float[3];
        System.out.println(Arrays.toString(sarr));
        System.out.println(Arrays.toString(oarr));
        System.out.println(Arrays.toString(iarr));
        System.out.println(Arrays.toString(barr));
        System.out.println(Arrays.toString(farr));

        System.out.println("\n\n\n\n");

        /*   
            All literals get converted to base 10 during evaluation.
            Chars being assigned a base 10 value will be converted to the ASCII character
            Cannot use multiple characters in single quotes for char assignment unless starting with \ to-
            create a literal such as \ for octal or \\u for unicode (without the first \)
            Only unicode requires 4 digits
            You can create literals by starting with 0 as octal, starting with 0x is hexadecimal, 0b binary.
            You can compare chars to literals because chars get turned into base 10 ASCII and literals get converted-
            to base 10 during evaluation.
            When using a zero and then a letter or no letter to create a literal, all leading zeros of the literal-
            can be ignored
            You can use a \ before the number to create a literal in octal but only in single quotes
            Strings take in literals as decimals rather than converting them to chars the same way concatenating an-
            int would add an int to the string rather than that int's ASCII character.
         */
        char A = 'A';
        System.out.println(A);
        A = '\u0041';
        System.out.println(A);
        A = \u0041;
        System.out.println(A);
        A = 0x41;
        System.out.println(A);
        A = 65;
        System.out.println(A);
        A = 0101;
        System.out.println(A);
        A = '\101';
        System.out.println(A);
        A = 0b1000001;
        System.out.println(A);
        System.out.println(A == 65);
        System.out.println(A == '\101');
        System.out.println(A == 0101);
        System.out.println(A == \u0041);
        System.out.println(A == 'A');
        String B = "";
        B += 0b1000010;
        System.out.println(B);

        System.out.println("\n\n\n\n");


        /*
            Negative numbers in binary are evaluated if the leading bit is a 1. Once java sees a 1 it will evaluate
            the rest of the byte by flipping all bits and adding 1 to the result and adding a negative sign.
            EX: a = 0b11111111
                b = -0b00000001
                a==b -> True
            This is called 2's complement and that is the method java uses for signed number storage.
            When using unsigned shift right the number is always cast to an int so using
            >>>= will always work the same as >>= on a byte because after it gets recasted back to a byte,
            since bytes can only shift a max of 7 times, any effect of zeroes added to the front gets truncated
            since only the last 8 bits are used.
            EX: a = 0b11111111
                a>>>1 -> 2147483647 (0b01111111111111111111111111111111 or max value of an int - no longer a byte)
                a>>>=1 -> -1
         */
        byte a;
        a = 10;
        System.out.println(a += 3);
        a = 15;
        System.out.println(a -= 3);
        a = 20;
        System.out.println(a *= 3);
        a = 25;
        System.out.println(a /= 3);
        a = 30;
        System.out.println(a %= 3);
        a = 35;
        System.out.println(a &= 3);
        a = 40;
        System.out.println(a ^= 3);
        a = 45;
        System.out.println(a |= 3);
        a = 50;
        System.out.println(a <<= 3);
        a = 55;
        System.out.println(a >>= 3);
        a = 60;
        System.out.println(a >>>= 3);
        byte b = (byte) 0b11111111;
        System.out.println(b >>> 1);
        System.out.println(b >>>= 1);
        System.out.println(-0b00000001);
        System.out.println(false & false);
        byte c = 0b00000001;
        System.out.println(~c);

        System.out.println("\n\n\n\n");

        String z = "Chuck";
        String y = "Chuck";
        z = null;
        System.out.println(z + " " + y);

        System.out.println("\n\n\n\n");

        int[] stuff = {3, 4, 5, 6, 11, 18, 91};
        System.out.println(Arrays.binarySearch(stuff, 5));
        System.out.println(Arrays.binarySearch(stuff, 15));

        System.out.println("\n\n\n\n");

        System.out.println(new Integer(5) instanceof Integer);

        System.out.println("\n\n\n\n");

        System.out.printf("%2.2s%n", "Hi there!");

        System.out.println("\n\n\n\n");

        int p = 1;
        int s1 = 0;
        for (int x1 = 0; x1 <= 8; x1++) {
            s1 += p;
            p *= 2;
            System.out.println(s1 + " : " + p);
        }
        System.out.print(s1);

        int x = -234;
        long reverse = 0;
        boolean works = true;
        while (x != 0) {
            reverse = reverse * 10 + x % 10; // always adds a negative or a positive depending on sign so it always works
            if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
                System.out.println(0);
                works = false;
                break;
            }
            x /= 10;
        }
        if (works) {
            System.out.println((int) reverse);
        }

        System.out.println("\n\n\n\n");

        int u = 0;
        int m = 0;
        int val1 = 1 < 2 ? u++ : m++;
        System.out.println("u: " + u + " m: " + m);

        System.out.println("\n\n\n\n");

        System.out.println((int) (Math.random() * 9 + 1));

        String str = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(Arrays.toString(str.split("")));

        System.out.println("\n\n\n\n");

        String[] temp = new String[]{"one", "two", "one"};
        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        for (String st : temp) {
            queue.add(st);
            stack.push(st);
        }
        System.out.println(queue.remove());
        System.out.println(stack.pop());
        System.out.println(queue);
        System.out.println(stack);

        Queue<String> q = new LinkedList<>();
        q.add(null);
        System.out.println(q.toString());
    }
}
