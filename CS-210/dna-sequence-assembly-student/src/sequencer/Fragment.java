/*
 * Copyright 2021 Marc Liberatore.
 */
package sequencer;

public class Fragment {

    private final String nucleotides;

    /**
     * Creates a new Fragment based upon a String representing a sequence of
     * nucleotides, containing only the uppercase characters G, C, A and T.
     *
     * @param nucleotides
     * @throws IllegalArgumentException if invalid characters are in the
     * sequence of nucleotides
     */
    public Fragment(String nucleotides) throws IllegalArgumentException {
        for (char c : nucleotides.toCharArray()) {
            switch (c) {
                case 'G':
                    continue;
                case 'C':
                    continue;
                case 'A':
                    continue;
                case 'T':
                    continue;
                default:
                    throw new IllegalArgumentException();
            }
        }
        this.nucleotides = nucleotides;
    }

    /**
     * Returns the length of this fragment.
     *
     * @return the length of this fragment
     */
    public int length() {
        return nucleotides.length();
    }

    /**
     * Returns a String representation of this fragment, exactly as was passed
     * to the constructor.
     *
     * @return a String representation of this fragment
     */
    @Override
    public String toString() {
        return nucleotides;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Fragment other = (Fragment) obj;
        if (nucleotides == null) {
            if (other.nucleotides != null) {
                return false;
            }
        } else if (!nucleotides.equals(other.nucleotides)) {
            return false;
        }
        return true;
    }

    /**
     * Returns the number of nucleotides of overlap between the end of this
     * fragment and the start of another fragment, f.
     *
     * The largest overlap is found, for example, CAA and AAG have an overlap of
     * 2, not 1.
     *
     * @param f the other fragment
     * @return the number of nucleotides of overlap
     */
    public int calculateOverlap(Fragment f) {
        int currLength = length();
        int fLength = f.length();
        int overlap = 0;
        for (int i = 1; i <= Math.min(currLength, fLength); i++) {
            if (nucleotides.endsWith(f.toString().substring(0, i))) {
                overlap = i;
            }
        }
        return overlap;
    }

    /**
     * Returns a new fragment based upon merging this fragment with another
     * fragment f.
     *
     * This fragment will be on the left, the other fragment will be on the
     * right; the fragments will be overlapped as much as possible during the
     * merge.
     *
     * @param f the other fragment
     * @return a new fragment based upon merging this fragment with another
     * fragment
     */
    public Fragment mergedWith(Fragment f) {
        int overlap = calculateOverlap(f);
        return new Fragment(nucleotides + f.toString().substring(overlap));
    }
}
