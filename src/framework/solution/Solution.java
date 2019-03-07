package framework.solution;

import domains.farmer.FarmerState;
import framework.graph.Vertex;
import java.util.LinkedList;
//import org.junit.Test;
//import static org.junit.Assert.*;
public class Solution {

    /**
     * Creates an object that represents a path from a start
     * vertex to an end vertex in a problem solving domain.
     * This constructor will be called after a search has been
     * initiated on the start vertex.
     * If a path from start to end exists, it can be constructed
     * from the predecessor information stored in the end vertex.
     * @param start the start vertex
     * @param end the end vertex
     */
    public Solution(Vertex start, Vertex end) {
        solution = new LinkedList<Vertex>();
        solution.add(end);
        while(end.getPredecessor() != null){
            solution.add(end.getPredecessor());
            end = end.getPredecessor();
        }      
    }

    /**
     * Gets the length of the solution.
     * @return the solution length
     */
    public int getLength() {
      return solution.size();
    }
    
    /**
     * Checks whether there are more vertices in this solution.
     * @return true if there are more vertices in this solution, false
     * otherwise
     */
    public boolean hasNext() {
        return solution.size() > 0;
    }
    
    /**
     * Removes and returns the next vertex in this solution.
     * @return the next vertex in this solution
     * @throws RuntimeException if there are no more vertices
     */
    public Vertex next() {      
       return solution.removeLast();     
    }
    
    
    private LinkedList<Vertex> solution; 
}