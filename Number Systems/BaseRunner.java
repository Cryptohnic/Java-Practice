//(c) A+ Computer Science
//www.apluscompsci.com

import static java.lang.System.*;

public class BaseRunner {

    public static void main(String[] args) {
        BaseConversion bc = new BaseConversion("10", 10);
        out.println(bc + " == " + bc.getNum(2));
        bc = new BaseConversion("AB", 16);
        out.println(bc + " == " + bc.getNum(10));
        bc = new BaseConversion("345", 6);
        out.println(bc + " == " + bc.getNum(4));
        bc = new BaseConversion("25", 10);
        out.println(bc + " == " + bc.getNum(2));
        bc = new BaseConversion("127", 10);
        out.println(bc + " == " + bc.getNum(16));
        bc = new BaseConversion("1024", 7);
        out.println(bc + " == " + bc.getNum(16));
        bc = new BaseConversion("97342", 10);
        out.println(bc + " == " + bc.getNum(16));
        bc = new BaseConversion("1010010010001001", 2);
        out.println(bc + " == " + bc.getNum(16));
    }
}
