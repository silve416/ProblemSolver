package framework.solution;

import domains.farmer.FarmerState;
import framework.graph.Vertex;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class tests the Solution class.
 * It creates a simple three-move solution to the FWGC problem
 * and tests its access methods.
 * @author tcolburn
 */
public class SolutionTest {
    
    public SolutionTest() {
        start = new Vertex(new FarmerState("East", 
                                           "East",
                                           "West",
                                           "East"));
        intermediate = 
                new Vertex(new FarmerState("West", 
                                           "East",
                                           "West",
                                           "East"));
        end =   new Vertex(new FarmerState("East", 
                                           "East",
                                           "East",
                                           "East"));
        end.setPredecessor(intermediate);
        intermediate.setPredecessor(start);
        start.setPredecessor(null);
    }
    
    @Test
    public void testSolution() {
        Solution solution = new Solution(start, end);
        assertTrue(solution.hasNext());
        assertTrue(solution.next() == start);
        assertTrue(solution.next() == intermediate);
        assertTrue(solution.next() == end);
        assertFalse(solution.hasNext());
    }

    /**
     * This test prints the solution to standard output.
     */
    @Test
    public void testOutput() {
        Solution solution = new Solution(start, end);
        while (solution.hasNext()) {
            System.out.println(solution.next().toString() + "\n\n");
        }
    }
    
    private final Vertex start;
    private final Vertex intermediate;
    private final Vertex end;
    
}