package framework.solution;

import domains.arithmetic.ArithmeticProblem;
import domains.farmer.FarmerProblem;
import domains.farmer.FarmerState;
import domains.puzzle.PuzzleProblem;
import domains.puzzle.PuzzleState;
import framework.graph.Vertex;
import framework.problem.Problem;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * This class tests the StateSpaceSolver class.
 * It creates the vertices in the FWGC problem graph and individually tests
 * the occursOnPath, expand, and solve methods.
 * @author tcolburn
 */
public class StateSpaceSolverTest {
    
    private Vertex v1, v2, v3, v4, v5, v6, v7, v8, v9, v10;
    private Vertex v1Copy, v4Copy, v7Copy, v10Copy;
    
    public StateSpaceSolverTest() {
        v1 = new Vertex(new FarmerState("West", 
                                        "West",
                                        "West",
                                        "West"));
        
        v2 = new Vertex(new FarmerState("West", 
                                        "East", 
                                        "West", 
                                        "East"));
        
        v3 = new Vertex(new FarmerState("West", 
                                        "East", 
                                        "West", 
                                        "West"));
        
        v4 = new Vertex(new FarmerState("West", 
                                        "West", 
                                        "East", 
                                        "West"));
        
        v5 = new Vertex(new FarmerState("West", 
                                        "West", 
                                        "West", 
                                        "East"));
        
        v6 = new Vertex(new FarmerState("East", 
                                        "East", 
                                        "East", 
                                        "East"));
        
        v7 = new Vertex(new FarmerState("East", 
                                        "West", 
                                        "East", 
                                        "West"));
        
        v8 = new Vertex(new FarmerState("East", 
                                        "West", 
                                        "East", 
                                        "East"));
        
        v9 = new Vertex(new FarmerState("East", 
                                        "East", 
                                        "West", 
                                        "East"));
        
        v10 = new Vertex(new FarmerState("East", 
                                         "East", 
                                         "East", 
                                         "West"));
        
        v1Copy = new Vertex(new FarmerState("West",  // Same state as v1
                                            "West",
                                            "West",
                                            "West"));
        
        v4Copy = new Vertex(new FarmerState("West",  // Same state as v4 
                                            "West", 
                                            "East", 
                                            "West"));
        
        v7Copy = new Vertex(new FarmerState("East",  // Same state as v7 
                                            "West", 
                                            "East", 
                                            "West"));
        
        v10Copy = new Vertex(new FarmerState("East",  // Same state as v10 
                                             "East", 
                                             "East", 
                                             "West"));
        
    }
    
    /**
     * This test links vertices such that:
     * 
     *    v1 <- v7 <- v4 <- v10 <- v3 <- v9 <- v2 <- v6
     * 
     * This represents the upper solution of the FWGC problem as shown in the
     * lecture notes.
     * 
     * It then makes assertions about which vertices lie on various solution paths.
     */
    @Test
    public void testOccursOnPath() {
        
        v1.setPredecessor(null);
        v7.setPredecessor(v1);
        v4.setPredecessor(v7);
        v10.setPredecessor(v4);
        v3.setPredecessor(v10);
        v9.setPredecessor(v3);
        v2.setPredecessor(v9);
        v6.setPredecessor(v2);
        
        // v1, v7, v4, and v10 are on the path to v10
        assertTrue(StateSpaceSolver.occursOnPath(v1, v10));
        assertTrue(StateSpaceSolver.occursOnPath(v7, v10));
        assertTrue(StateSpaceSolver.occursOnPath(v4, v10));
        assertTrue(StateSpaceSolver.occursOnPath(v10, v10));
        
        // the rest of the vertices are not on the path to v10
        assertFalse(StateSpaceSolver.occursOnPath(v3, v10));
        assertFalse(StateSpaceSolver.occursOnPath(v9, v10));
        assertFalse(StateSpaceSolver.occursOnPath(v2, v10));
        assertFalse(StateSpaceSolver.occursOnPath(v6, v10));
        assertFalse(StateSpaceSolver.occursOnPath(v8, v10));
        assertFalse(StateSpaceSolver.occursOnPath(v5, v10));
        
        // v8 and v5 are not on the path to v6
        assertFalse(StateSpaceSolver.occursOnPath(v8, v6));
        assertFalse(StateSpaceSolver.occursOnPath(v5, v6));
        
        // the rest of the vertices are on the path to v6
        assertTrue(StateSpaceSolver.occursOnPath(v1, v6));
        assertTrue(StateSpaceSolver.occursOnPath(v7, v6));
        assertTrue(StateSpaceSolver.occursOnPath(v4, v6));
        assertTrue(StateSpaceSolver.occursOnPath(v10, v6));
        assertTrue(StateSpaceSolver.occursOnPath(v3, v6));
        assertTrue(StateSpaceSolver.occursOnPath(v9, v6));
        assertTrue(StateSpaceSolver.occursOnPath(v2, v6));
        assertTrue(StateSpaceSolver.occursOnPath(v6, v6));
        
        // make sure the correct equality test is being used
        assertTrue(StateSpaceSolver.occursOnPath(v1Copy, v10));
        assertTrue(StateSpaceSolver.occursOnPath(v7Copy, v10));
        assertTrue(StateSpaceSolver.occursOnPath(v4Copy, v10));
        assertTrue(StateSpaceSolver.occursOnPath(v10Copy, v10));
    }

    /**
     * This method tests the expand method by first expanding the initial
     * state represented by v1 and then selectively expanding children until
     * the goal state represented by v6 is found.
     * At each step, assertions are made checking the correct size and
     * composition of the child lists produced by calling expand.
     * A helper method called find is used to choose among the child lists
     * which vertex to expand next.
     * This allows the method to test whether predecessor and distance information
     * is being kept correctly.
     * The solution is displayed at the end.
     */
    @Test
    public void testExpand() {
        StateSpaceSolver solver = new StateSpaceSolver(new FarmerProblem(), false);
        
        List<Vertex> children;
        
        v1.setDistance(0);
        
        children = solver.expand(v1);
        assertTrue(children.size()==1);
        assertTrue(children.contains(v7));
        
        children = solver.expand(find(v7, children));
        assertTrue(children.size()==1);
        assertTrue(children.contains(v4));
        
        children = solver.expand(find(v4, children));
        assertTrue(children.size()==2);
        assertTrue(children.contains(v10));
        assertTrue(children.contains(v8));
        
        children = solver.expand(find(v10, children));
        assertTrue(children.size()==1);
        assertTrue(children.contains(v3));
        
        children = solver.expand(find(v3, children));
        assertTrue(children.size()==1);
        assertTrue(children.contains(v9));
        
        children = solver.expand(find(v9, children));
        assertTrue(children.size()==2);
        assertTrue(children.contains(v2));
        assertTrue(children.contains(v5));
        
        Vertex v2Save = find(v2, children);
        
        children = solver.expand(find(v5, children));
        assertTrue(children.size()==1);
        assertTrue(children.contains(v8));
        
        children = solver.expand(find(v8, children));
        assertTrue(children.isEmpty());
        
        children = solver.expand(v2Save);
        assertTrue(children.size()==1);
        assertTrue(children.contains(v6));
        
        Vertex goal = find(v6, children);
        assertTrue(goal.getDistance()==7);
        
        Solution solution = new Solution(v1, goal);
        assertTrue(solution.getLength() == 7);
        System.out.println("From testExpand: \n" + solution.toString());
    }
    
    /**
     * Finds and returns a vertex from a list of vertices that is the same
     * as a given vertex v.
     * Identity criterion used is the equals method.
     * This method is used to find a vertex in a child set so that vertex
     * can be used for testing subsequent expansions in the testExpand method.
     * @param v
     * @param list
     * @return 
     */
    private static Vertex find(Vertex v, List<Vertex> list) {
        int i = list.indexOf(v);
        if ( i == -1 ) {
            return null;
        }
        else {
            return list.get(i);
        }
    }
    
    /**
     * Tests the solve method on the FWGC, Arithmetic, and 8-Puzzle problems.
     * Tries both BFS and DFS and makes assertions about solution lengths.
     */
    @Test
    public void testSolve() {
        solveProblem(new FarmerProblem(), 7);
        solveProblem(new ArithmeticProblem(), 6);
        
        PuzzleState puzzle5 = 
                new PuzzleState(new int[][]{new int[]{2, 8, 3}, 
                                            new int[]{1, 6, 4}, 
                                            new int[]{7, 0, 5}});
        
        PuzzleState puzzle10 = 
                new PuzzleState(new int[][]{new int[]{3, 6, 4}, 
                                            new int[]{1, 0, 2}, 
                                            new int[]{8, 7, 5}});
        
        PuzzleState puzzle13 = 
                new PuzzleState(new int[][]{new int[]{3, 0, 4}, 
                                            new int[]{1, 6, 5}, 
                                            new int[]{8, 2, 7}});
        
        PuzzleState puzzle18 = 
                new PuzzleState(new int[][]{new int[]{2, 1, 3}, 
                                            new int[]{8, 0, 4}, 
                                            new int[]{6, 7, 5}});
        
        PuzzleState puzzle20 = 
                new PuzzleState(new int[][]{new int[]{4, 2, 0}, 
                                            new int[]{8, 3, 6}, 
                                            new int[]{7, 5, 1}});
        
        PuzzleState puzzle24 = 
                new PuzzleState(new int[][]{new int[]{1, 6, 3}, 
                                            new int[]{4, 0, 8}, 
                                            new int[]{7, 2, 5}});
        
        PuzzleState puzzle30 = 
                new PuzzleState(new int[][]{new int[]{5, 2, 7}, 
                                            new int[]{8, 0, 4}, 
                                            new int[]{3, 6, 1}});
        
        PuzzleProblem pp = new PuzzleProblem();
        
        pp.setInitialState(puzzle5);
        pp.setCurrentState(puzzle5);
        solveProblem(pp, 5);
        
        pp.setInitialState(puzzle10);
        pp.setCurrentState(puzzle10);
        solveProblem(pp, 10);
        
        pp.setInitialState(puzzle13);
        pp.setCurrentState(puzzle13);
        solveProblem(pp, 13);
        
        pp.setInitialState(puzzle18);
        pp.setCurrentState(puzzle18);
        solveProblem(pp, 18);
        
        pp.setInitialState(puzzle20);
        pp.setCurrentState(puzzle20);
        solveProblem(pp, 20);
        
        pp.setInitialState(puzzle24);
        pp.setCurrentState(puzzle24);
        solveProblem(pp, 24);
    }
    
    private void solveProblem(Problem p, int minMoves) {
        StateSpaceSolver solver;
        Solution solution;
        
        solver = new StateSpaceSolver(p, true);
        solver.solve();
        solution = solver.getSolution();
        assertTrue(solution.getLength() == minMoves);
        System.out.println(minMoves + "-move " + p.getName() + " problem:\n" + solver.getStatistics().toString());
        
        p.setCurrentState(p.getInitialState());
        solver = new StateSpaceSolver(p, false);
        solver.solve();
        solution = solver.getSolution();
        assertTrue(solution.getLength() >= minMoves);
        System.out.println(minMoves + "-move " + p.getName() + " problem:\n" + solver.getStatistics().toString());
    }
}