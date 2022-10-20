//(c) A+ Computer Science
//www.apluscompsci.com

import static java.lang.System.out;

public class MatrixSearchRunner{
    public static void main(String[] args){
    	MatrixSearch ms=new MatrixSearch(20,20,25);
        out.println(ms);
        out.println("Odd count = "+ms.countOdds());
        out.println("Even count = "+ms.countEvens());
        out.println("Prime count = "+ms.countPrimes());
        out.println("\n\n");
        ms=new MatrixSearch(10,10,50);
        out.println(ms);
        out.println("Odd count = "+ms.countOdds());
        out.println("Even count = "+ms.countEvens());
        out.println("Prime count = "+ms.countPrimes());
        out.println("\n\n");
        ms=new MatrixSearch(7,7,100);
        out.println(ms);
        out.println("Odd count = "+ms.countOdds());
        out.println("Even count = "+ms.countEvens());
        out.println("Prime count = "+ms.countPrimes());
    }
}