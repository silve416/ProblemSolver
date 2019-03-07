package domains.puzzle;

import framework.problem.State;
import java.util.Arrays;
import framework.problem.Mover;
/**
 *
 * @author Maxwell
 */
public class PuzzleMover extends Mover{
    
    String TILE_1 = "SLIDE TILE 1";
    String TILE_2 = "SLIDE TILE 2";
    String TILE_3 = "SLIDE TILE 3";
    String TILE_4 = "SLIDE TILE 4";
    String TILE_5 = "SLIDE TILE 5";
    String TILE_6 = "SLIDE TILE 6";
    String TILE_7 = "SLIDE TILE 7";
    String TILE_8 = "SLIDE TILE 8";
    
    public PuzzleMover(){
    addMove(TILE_1, b-> doMove(TILE_1,b));
    addMove(TILE_2, b-> doMove(TILE_2,b));
    addMove(TILE_3, b-> doMove(TILE_3,b));
    addMove(TILE_4, b-> doMove(TILE_4,b));
    addMove(TILE_5, b-> doMove(TILE_5,b));
    addMove(TILE_6, b-> doMove(TILE_6,b));
    addMove(TILE_7, b-> doMove(TILE_7,b));
    addMove(TILE_8, b-> doMove(TILE_8,b));
    }
    
    public PuzzleState doMove(String a, State b){
        int tile = Integer.parseInt(String.valueOf(a.charAt(a.length()-1)));
        if(tile >= 1 && tile <= 8){
            PuzzleState puzzle = (PuzzleState)b;
            int row = puzzle.getLocation(tile).getRow();
            int col = puzzle.getLocation(tile).getColumn();
            
            int row0 = puzzle.getLocation(0).getRow();
            int col0 = puzzle.getLocation(0).getColumn();
            
            int distance = Math.abs(row - row0) + Math.abs(col - col0);
                if(distance == 1){
                    int[][] tiles = puzzle.getTiles();
                    tiles[row0][col0] = tiles[row][col];
                    
                    tiles[row][col] = 0;

                    return new PuzzleState(tiles);
                }
                else return null;
        }
        else return null;
    }
}