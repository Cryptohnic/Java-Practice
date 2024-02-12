/*
 * Copyright 2021 Marc Liberatore.
 */
package hamspam;

public class HamSpam {

    private final int hamNumber;
    private final int spamNumber;

    /**
     * Construct an object that can compute hamspam values for a game of Ham and
     * Spam.
     *
     * @param hamNumber the ham number; it must be greater than 1
     * @param spamNumber the spam number; it must be greater than 1 and not
     * equal to the ham number
     */
    public HamSpam(int hamNumber, int spamNumber) {
        StringBuilder error = new StringBuilder();
        if (hamNumber < 2 || spamNumber < 2) {
            error.append("hamNumber and spamNumber must both be greater than 1");
        }
        if (hamNumber == spamNumber) {
            if (error.length() != 0) {
                error.append(" and ");
            }
            error.append("hamNumber must be different than spamNumber");
        }
        if (error.length() != 0) {
            throw new RuntimeException(error.toString());
        }
        this.hamNumber = hamNumber;
        this.spamNumber = spamNumber;
    }

    /**
     * Returns the nth hamspam value (a number, ham, spam, or hamspam) for this
     * game of Ham and Spam.
     *
     * For example, getValue(1) returns "1".
     *
     * @param n the number to consider; n > 0
     * @return the hamspam value, as a String
     */
    public String getValue(int n) {
        if (n < 1) {
            throw new RuntimeException("integer to check must be greater than 0");
        }
        if (n % hamNumber == 0 && n % spamNumber == 0) {
            return "hamspam";
        } else if (n % hamNumber == 0) {
            return "ham";
        } else if (n % spamNumber == 0) {
            return "spam";
        }
        return Integer.toString(n);
    }

    /**
     * Returns an array of the hamspam values from start to end, inclusive, for
     * this game of Ham and Spam.
     *
     * For example, if the ham number is 3 and the spam number is 4,
     * getValues(2,6) should return an array of Strings:
     *
     * {"2", "ham", "spam", "5", "ham"}
     *
     * @param start the number to start from; start > 0
     * @param end the number to end at; end >= start
     * @return the array of hamspam values
     */
    public String[] getValues(int start, int end) {
        StringBuilder error = new StringBuilder();
        if (start < 1) {
            error.append("range to consider must start at a number greater than 0");
        }
        if (end < start) {
            if (error.length() != 0) {
                error.append(" and ");
            }
            error.append("your start value must not be greater than your end value");
        }
        if (error.length() != 0) {
            throw new RuntimeException(error.toString());
        }
        String[] ans = new String[end - start + 1];
        for (int i = start; i <= end; i++) {
            ans[i - start] = getValue(i);
        }
        return ans;
    }
}
