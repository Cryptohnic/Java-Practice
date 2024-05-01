/*
 * Copyright 2023 Marc Liberatore.
 */
package puzzle;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

import search.SearchProblem;
import search.Searcher;

/**
 * A class to represent an instance of the eight-puzzle.
 *
 * The spaces in an 8-puzzle are indexed as follows:
 *
 * 0 | 1 | 2
 * --+---+--- 3 | 4 | 5 --+---+--- 6 | 7 | 8
 *
 * The puzzle contains the eight numbers 1-8, and an empty space. If we
 * represent the empty space as 0, then the puzzle is solved when the values in
 * the puzzle are as follows:
 *
 * 1 | 2 | 3
 * --+---+--- 4 | 5 | 6 --+---+--- 7 | 8 | 0
 *
 * That is, when the space at index 0 contains value 1, the space at index 1
 * contains value 2, and so on.
 *
 * From any given state, you can swap the empty space with a space adjacent to
 * it (that is, above, below, left, or right of it, without wrapping around).
 *
 * For example, if the empty space is at index 2, you may swap it with the value
 * at index 1 or 5, but not any other index.
 *
 * Only half of all possible puzzle states are solvable! See:
 * https://en.wikipedia.org/wiki/15_puzzle for details.
 *
 *
 * @author liberato
 *
 */
public class EightPuzzle implements SearchProblem<List<Integer>> {

    final List<Integer> initialState;

    /**
     * Creates a new instance of the 8 puzzle with the given starting values.
     *
     * The values are indexed as described above, and should contain exactly the
     * nine integers from 0 to 8.
     *
     * @param startingValues the starting values, 0 -- 8
     * @throws IllegalArgumentException if startingValues is invalid
     */
    public EightPuzzle(List<Integer> startingValues) {
        if (startingValues.size() != 9) {
            throw new IllegalArgumentException();
        }
        int[] valid = new int[9];
        for (int item : startingValues) {
            if (item < 0 || item > 8) {
                throw new IllegalArgumentException();
            }
            valid[item] += 1;
        }
        for (int item : valid) {
            if (item != 1) {
                throw new IllegalArgumentException();
            }
        }
        initialState = startingValues;
    }

    @Override
    public List<Integer> getInitialState() {
        return initialState;
    }

    private List<Integer> swap(ArrayList<Integer> currentState, int i, int j) {
        int temp = currentState.get(i);
        currentState.set(i, currentState.get(j));
        currentState.set(j, temp);
        return currentState;
    }

    @Override
    public List<List<Integer>> getSuccessors(List<Integer> currentState) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        for (; i < 9; i++) {
            if (currentState.get(i) == 0) {
                break;
            }
        }
        if (i % 3 == 0 || i % 3 == 1) {
            ans.add(swap(new ArrayList<>(currentState), i, i + 1));
        }
        if (i % 3 == 1 || i % 3 == 2) {
            ans.add(swap(new ArrayList<>(currentState), i, i - 1));
        }
        if (i > 2) {
            ans.add(swap(new ArrayList<>(currentState), i, i - 3));
        }
        if (i < 6) {
            ans.add(swap(new ArrayList<>(currentState), i, i + 3));
        }
        return ans;
    }

    @Override
    public boolean isGoal(List<Integer> state) {
        if (state.get(0) == 1) {
            for (int i = 1; i < 8; i++) {
                if (state.get(i) != state.get(i - 1) + 1) {
                    return false;
                }
            }
            if (state.get(8) == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EightPuzzle eightPuzzle = new EightPuzzle(Arrays.asList(new Integer[]{8, 0, 7, 4, 5, 3, 6, 1, 2}));

        List<List<Integer>> solution = new Searcher<List<Integer>>(eightPuzzle).findSolution();
        for (List<Integer> state : solution) {
            System.out.println(state);
        }
        System.out.println(solution.size() + " states in solution");
    }
}
