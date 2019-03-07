package domains.farmer;

import framework.graph.GraphSearcher;
import framework.graph.Vertex;
import framework.solution.Solution;
import org.junit.Test;

/**
 * A test file for FarmerGraph.
 * @author tcolburn
 */
public class FarmerGraphTest {
    
    public FarmerGraphTest() {
        farmerGraph = new FarmerGraph();
        start = farmerGraph.getStart();
        end = farmerGraph.getEnd();
        graphSearcher = new GraphSearcher(farmerGraph);
    }

    @Test
    public void testBFS1() {
        graphSearcher.breadthFirstSearch(start);
        solution = new Solution(start, end);
        System.out.println("BFS from start to end:\n" + solutionString(solution));
    }

    @Test
    public void testBFS2() {
        graphSearcher.breadthFirstSearch(end);
        solution = new Solution(end, start);
        System.out.println("BFS from end to start:\n" + solutionString(solution));
    }

    @Test
    public void testDFS1() {
        graphSearcher.depthFirstSearch(start);
        solution = new Solution(start, end);
        System.out.println("DFS from start to end:\n" + solutionString(solution));
    }

    @Test
    public void testDFS2() {
        graphSearcher.depthFirstSearch(end);
        solution = new Solution(end, start);
        System.out.println("DFS from end to start:\n" + solutionString(solution));
    }
    
    private String solutionString(Solution solution) {
        StringBuilder builder = new StringBuilder();
        while (solution.hasNext()) {
            builder.append(solution.next().toString());
            builder.append("\n\n");
        }
        return builder.toString();
    }
    
    private final FarmerGraph farmerGraph;
    private final GraphSearcher graphSearcher;
    private final Vertex start;
    private final Vertex end;
    private Solution solution;
}