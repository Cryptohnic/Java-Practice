//(c) A+ Computer Science
//www.apluscompsci.com

public class MatrixSearch {

    private int[][] mat;

    /*
		 *pre - mat is null
		 *post - mat will be rows X cols
		 *post - mat will contain integers that are <= upper and >= 1
     */
    public MatrixSearch(int rows, int cols, int upper) {
        mat = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                mat[r][c] = (int) (Math.random() * upper) + 1; // set each val in the matrix to a random [1-upper]

            }
        }
    }

    /*
		 *pre - mat is not null
		 *post - count of odd numbers will be returned
		 *post - no values in mat will have been changed
     */
    public int countOdds() {
        int odds = 0;
        for (int[] r : mat) {
            for (int num : r) {
                if (num % 2 == 1) {
                    odds++; // count odds

                }
            }
        }
        return odds;
    }

    /*
		 *pre - mat is not null
		 *post - count of even numbers will be returned
		 *post - no values in mat will have been changed
     */
    public int countEvens() {
        int evens = 0;
        for (int[] r : mat) {
            for (int num : r) {
                if (num % 2 == 0) {
                    evens++; // count evens

                }
            }
        }
        return evens;
    }

    /*
		 *pre - mat is not null
		 *post - count of prime numbers will be returned
		 *post - no values in mat will have been changed
     */
    public int countPrimes() {
        int primes = 0;
        for (int[] r : mat) {
            for (int num : r) {
                if (isPrime(num)) {
                    primes++; // count primes

                }
            }
        }
        return primes;
    }

    /*
		 *pre - num has a value
		 *post - false is returned if num is divisble by any number between 2 and itself
		 *post - true is returned if num is not divisble by any number between 2 and itself
     */
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; // isn't prime

            }
        }
        return true;
    }

    /*
		 *pre - mat is not null
		 *post - all values from mat are concatenated to a string and returned
     */
    public String toString() {
        int max = 0;
        String str = "";
        for (int[] r : mat) {
            for (int num : r) {
                max = Math.max(max, num);
            }
        }
        int spaces = String.valueOf(max).length(); // find number of spaces needed for formatting
        for (int[] r : mat) {
            String line = "";
            for (int num : r) {
                line += String.format("%" + spaces + "d ", num); // adds the number with spaces if needed

            }
            str += line + "\n";
        }
        return str.stripTrailing(); // returns the ans with space trimmed off the end
    }
}
