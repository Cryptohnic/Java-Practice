/*
 * Copyright 2021 Marc Liberatore.
 */
package hamspam;

import java.util.Scanner;
import java.util.Arrays;

public class HamCommander {

    public static void main(String[] args) {
        Scanner conIn = new Scanner(System.in);
        try {

            System.out.println("Enter a ham number and a spam number:");
            final int hamNumber = conIn.nextInt();
            final int spamNumber = conIn.nextInt();
            System.out.println("Ham number: " + hamNumber);
            System.out.println("Spam number: " + spamNumber);
            HamSpam hs = new HamSpam(hamNumber, spamNumber);

            System.out.println("Enter an integer greater than zero:");
            final int start = conIn.nextInt();
            System.out.println("Enter an integer greater than or equal to the last one:");

            final int end = conIn.nextInt();
            System.out.println("The hamspam arrray from " + start + " to " + end + " is: "
                    + Arrays.toString(hs.getValues(start, end)));

        } finally {
            conIn.close();
        }
    }
}
