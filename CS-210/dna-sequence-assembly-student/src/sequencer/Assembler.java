/*
 * Copyright 2021 Marc Liberatore.
 */
package sequencer;

import java.util.ArrayList;
import java.util.List;

public class Assembler {

    private List<Fragment> list;

    /**
     * Creates a new Assembler containing a list of fragments.
     *
     * The list is copied into this assembler so that the original list will not
     * be modified by the actions of this assembler.
     *
     * @param fragments
     */
    public Assembler(List<Fragment> fragments) {
        list = new ArrayList<>(fragments);
    }

    /**
     * Returns the current list of fragments this assembler contains.
     *
     * @return the current list of fragments
     */
    public List<Fragment> getFragments() {
        return list;
    }

    /**
     * Attempts to perform a single assembly, returning true iff an assembly was
     * performed.
     *
     * This method chooses the best assembly possible, that is, it merges the
     * two fragments with the largest overlap, breaking ties between merged
     * fragments by choosing the shorter merged fragment.
     *
     * Merges must have an overlap of at least 1.
     *
     * After merging two fragments into a new fragment, the new fragment is
     * inserted into the list of fragments in this assembler, and the two
     * original fragments are removed from the list.
     *
     * @return true iff an assembly was performed
     */
    public boolean assembleOnce() {
        int size = -1; // size of largest combination
        int largestFirst = -1; // position of the first to combine so we can remove it
        int largestSecond = -1; // position of the second to combine so we can remove it
        Fragment assembled = null;
        for (int i = 0; i < list.size(); i++) {
            Fragment iFragment = list.get(i); // current i fragment
            for (int j = i + 1; j < list.size(); j++) { //
                Fragment jFragment = list.get(j); // current j fragment
                int firstOverlap = iFragment.calculateOverlap(jFragment);
                int secondOverlap = jFragment.calculateOverlap(iFragment);
                int currSize = firstOverlap > secondOverlap ? firstOverlap : secondOverlap; // size of current overlap
                if (currSize > 0 && currSize >= size) { // if we have a new max or equal the max
                    Fragment newCombined = currSize == firstOverlap ? iFragment.mergedWith(jFragment) : jFragment.mergedWith(iFragment);
                    if (currSize > size || newCombined.length() < assembled.length()) { // update our string to add if we have a longer combo sequence or if hte sequence length is the same and the result is shorter
                        size = currSize; // update size
                        largestFirst = currSize == firstOverlap ? i : j; // update positions
                        largestSecond = largestFirst == i ? j : i;
                        assembled = newCombined;
                    }
                }
            }
        }
        if (assembled != null) { // if we have found an assembly, add it and remove its old counterparts while returning true
            list.add(assembled);
            list.remove(largestFirst);
            list.remove(largestFirst < largestSecond ? largestSecond - 1 : largestSecond);
            return true;
        }
        return false;
    }

    /**
     * Repeatedly assembles fragments until no more assembly can occur.
     */
    public void assembleAll() {
        while (list.size() > 1) {
            assembleOnce();
        }
    }
}
