package domains.puzzle;

import framework.problem.Mover;
import framework.problem.Problem;
import framework.problem.State;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Max Silver
 */
public class PuzzleProblemTest {
    
    /**
     * Declare private instance fields here. For example:
     */
    private final List<String> moveNames;
        
    private final Problem problem;
    private final Mover mover;
    private final String TILE_1, TILE_2, TILE_3, TILE_4,   // move names
                         TILE_5, TILE_6, TILE_7, TILE_8;
    
    public PuzzleProblemTest() {
        problem = new PuzzleProblem();
        mover = problem.getMover();
        
        moveNames = mover.getMoveNames();
        TILE_1 = "SLIDE TILE 1";
        TILE_2 = "SLIDE TILE 2";
        TILE_3 = "SLIDE TILE 3";
        TILE_4 = "SLIDE TILE 4";
        TILE_5 = "SLIDE TILE 5";
        TILE_6 = "SLIDE TILE 6";
        TILE_7 = "SLIDE TILE 7"; 
        TILE_8 = "SLIDE TILE 8";
        
    }

    @Test
    public void testSolution() {

	/**
	 * Display a welcome, the problem introduction, and the initial state.
	 * Perform moves until the problem is solved, making appropriate
	 * assertions along the way.
	 * Use FarmerProblemTest as a model.
	 */   
        
        PuzzleState goal = new PuzzleState(new int[][] { { 1, 2, 3 }, { 8, 0, 4 }, { 7, 6, 5 } });
       
        display("Welcome to the " + problem.getName() + " problem");
        display(problem.getIntroduction());
        display(problem.getCurrentState());
        assertFalse(problem.success());
        
        tryMove(TILE_6);
        assertFalse(problem.success());       
   
        
        tryMove(TILE_8);
        assertFalse(problem.success());
        
        tryMove(TILE_2);
        assertFalse(problem.success());
        
        tryMove(TILE_1);
        assertFalse(problem.success());
        
        tryMove(TILE_8);
        assertTrue(problem.success());  
        
    }
    
    private void tryMove(String move) {
        State next = mover.slide(move, problem.getCurrentState());
        assertTrue(next != null);
        problem.setCurrentState(next);
        display(problem.getCurrentState());
    }
    
    private void display(Object o) {
        System.out.println(o + "\n");
    }
    
}