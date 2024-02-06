//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class OddEvenSets {

    private Set<Integer> odds;
    private Set<Integer> evens;
    private Set<Integer> perfects;

    public OddEvenSets() {
        odds = new TreeSet<>();
        evens = new TreeSet<>();
        perfects = new TreeSet<>();
    }

    public OddEvenSets(String line) {
        this();
        Scanner s = new Scanner(line);
        while (s.hasNext()) { // fill the odd and even sets
            int num = s.nextInt();
            if (num % 2 != 0) {
                odds.add(num); 
            }else {
                evens.add(num);
            }
        }
        s.close();
        PerfectSet(line);
    }

    private void PerfectSet(String line) {
        Scanner s = new Scanner(line);
        iteratePerfects(evens);
        iteratePerfects(odds);
        s.close();
    }

    private void iteratePerfects(Set<Integer> set) {
        for (int num : set) {
            if (num > 1) {
                int totDivisors = 1;
                double sqrt = Math.sqrt(num);
                for (int i = 2; i <= Math.sqrt(num); i++) // check all divisors leading up to sqrt inclusive
                {
                    if (num % i == 0) {
                        totDivisors += i;
                        totDivisors += num / i;
                    }
                }
                if (sqrt == Math.floor(sqrt)) // remove the sqrts duplicate if it was a perfect square
                {
                    totDivisors -= Math.sqrt(num);
                }
                if (totDivisors == num) {
                    perfects.add(num); // add to perfects

                            }}
        }
    }

    public String toString() {
        return "ODDS : " + odds + "\nEVENS : " + evens + "\nPERFECTS : " + perfects + "\n\n";
    }
}
