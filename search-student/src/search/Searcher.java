/*
 * Copyright 2023 Marc Liberatore.
 */
package search;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

import mazes.Cell;
import mazes.Maze;
import mazes.MazeGenerator;

import java.util.LinkedList;
import java.util.HashSet;
import java.util.HashMap;

/**
 * An implementation of a Searcher that performs an iterative search, storing
 * the list of next states in a Queue. This results in a breadth-first search.
 *
 * @author liberato
 *
 * @param <T> the type for each vertex in the search graph
 */
public class Searcher<T> {

    private final SearchProblem<T> searchProblem;

    /**
     * Instantiates a searcher.
     *
     * @param searchProblem the search problem for which this searcher will find
     * and validate solutions
     */
    public Searcher(SearchProblem<T> searchProblem) {
        this.searchProblem = searchProblem;
    }

    /**
     * Finds and return a solution to the problem, consisting of a list of
     * states.
     *
     * The list should start with the initial state of the underlying problem.
     * Then, it should have one or more additional states. Each state should be
     * a successor of its predecessor. The last state should be a goal state of
     * the underlying problem.
     *
     * If there is no solution, then this method should return an empty list.
     *
     * @return a solution to the problem (or an empty list)
     */
    public List<T> findSolution() {
        Queue<T> frontier = new LinkedList<>(List.of(searchProblem.getInitialState()));
        List<T> solution = new ArrayList<>();
        HashSet<T> checked = new HashSet<>();
        HashMap<T, T> predecessors = new HashMap<>();
        while (!frontier.isEmpty()) {
            T current = frontier.remove();
            if (searchProblem.isGoal(current)) {
                solution.add(current);
                while (predecessors.get(current) != null) {
                    solution.add(0, predecessors.get(current));
                    current = predecessors.get(current);
                }
                return solution;
            }
            checked.add(current);
            for (T successor : searchProblem.getSuccessors(current)) {
                if (!checked.contains(successor)) {
                    frontier.add(successor);
                    predecessors.put(successor, current);
                }
            }
        }
        return new ArrayList<>();
    }

    /**
     * Checks that a solution is valid.
     *
     * THIS METHOD DOES NOT PERFORM SEARCH! It only checks if a provided
     * solution is valid!
     *
     * A valid solution consists of a list of states. The list should start with
     * the initial state of the underlying problem. Then, it should have one or
     * more additional states. Each state should be a successor of its
     * predecessor. The last state should be a goal state of the underlying
     * problem.
     *
     * @param solution
     * @return true iff this solution is a valid solution
     * @throws NullPointerException if solution is null
     */
    public final boolean isValidSolution(List<T> solution) {
        if (solution == null) {
            throw new NullPointerException();
        }
        if (solution.isEmpty() || !searchProblem.getInitialState().equals(solution.get(0))) {
            return false;
        }
        for (int i = 0; i < solution.size() - 1; i++) {
            if (!searchProblem.getSuccessors(solution.get(i)).contains(solution.get(i + 1))) {
                return false;
            }
        }
        return searchProblem.isGoal(solution.get(solution.size() - 1));
    }

    public static void main(String[] args) {
        Maze maze = new MazeGenerator(3, 3, 2).generateDfs();
        final Searcher<Cell> s = new Searcher<Cell>(maze);
        System.out.println(s.findSolution());
    }
}
