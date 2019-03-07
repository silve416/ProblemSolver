package domains.puzzle;

import framework.problem.Mover;
import framework.problem.State;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Your name here
 */
public class PuzzleMoverTest {
        
    /**
     * Declare private instance fields here. For example:
     */
    
    private final State start;
    private final Mover mover;
    //private final String slide1, slide2, slide3, slide4,  // move names
      //          slide5, slide6, slide7, slide8;
    String TILE_1 = "SLIDE TILE 1";
    String TILE_2 = "SLIDE TILE 2";
    String TILE_3 = "SLIDE TILE 3";
    String TILE_4 = "SLIDE TILE 4";
    String TILE_5 = "SLIDE TILE 5";
    String TILE_6 = "SLIDE TILE 6";
    String TILE_7 = "SLIDE TILE 7";
    String TILE_8 = "SLIDE TILE 8";
    
    public PuzzleMoverTest() {
        int[][] array = new int[3][3];
        array[0][0] = 1;
        array[0][1] = 2;
        array[0][2] = 3;
        array[1][0] = 8;
        array[1][1] = 0;
        array[1][2] = 4;
        array[2][0] = 7;
        array[2][1] = 6;
        array[2][2] = 5;
        
        start = new PuzzleState(array);       
        mover = new PuzzleMover();
    }
    
    /**
     * Test all moves in the methods below by replacing the calls to fail.
     */

    @Test
    public void testSlide1() {
        assertEquals(mover.slide(TILE_1, start), null);        
    }

    @Test
    public void testSlide2() {
        int[][] array = new int[3][3];
        array[0][0] = 1;
        array[0][1] = 0;
        array[0][2] = 3;
        array[1][0] = 8;
        array[1][1] = 2;
        array[1][2] = 4;
        array[2][0] = 7;
        array[2][1] = 6;
        array[2][2] = 5;
        
        State end = new PuzzleState(array);
        
        assertEquals(mover.slide(TILE_2, start), end);    
    }

    @Test
    public void testSlide3() {
        assertEquals(mover.slide(TILE_3, start), null);        
    }

    @Test
    public void testSlide4() {
        int[][] array = new int[3][3];
        array[0][0] = 1;
        array[0][1] = 2;
        array[0][2] = 3;
        array[1][0] = 8;
        array[1][1] = 4;
        array[1][2] = 0;
        array[2][0] = 7;
        array[2][1] = 6;
        array[2][2] = 5;
        
        State end = new PuzzleState(array);
        assertEquals(mover.slide(TILE_4, start), end);       
    }

    @Test
    public void testSlide5() {
        assertEquals(mover.slide(TILE_5, start), null);        
    }

    @Test
    public void testSlide6() {
        int[][] array = new int[3][3];
        array[0][0] = 1;
        array[0][1] = 2;
        array[0][2] = 3;
        array[1][0] = 8;
        array[1][1] = 6;
        array[1][2] = 4;
        array[2][0] = 7;
        array[2][1] = 0;
        array[2][2] = 5;
        
        State end = new PuzzleState(array);
        
        assertEquals(mover.slide(TILE_6, start), end);        
    }

    @Test
    public void testSlide7() {
        assertEquals(mover.slide(TILE_7, start), null);        
    }

    @Test
    public void testSlide8() {
        int[][] array = new int[3][3];
        array[0][0] = 1;
        array[0][1] = 2;
        array[0][2] = 3;
        array[1][0] = 0;
        array[1][1] = 8;
        array[1][2] = 4;
        array[2][0] = 7;
        array[2][1] = 6;
        array[2][2] = 5;
        
        State end = new PuzzleState(array);
        
        assertEquals(mover.slide(TILE_8, start), end);        
    }
    
}