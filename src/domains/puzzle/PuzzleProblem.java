package domains.puzzle;

import framework.problem.Problem;

public class PuzzleProblem
  extends Problem
{
  public PuzzleProblem()
  {
    super.setName("8-Puzzle");
    super.setMover(new PuzzleMover(3, 3));
    super.setIntroduction(INTRO);
    super.setInitialState(START);
    super.setCurrentState(START);
    super.setFinalState(GOAL);
  }
  
  private static final PuzzleState START = new PuzzleState(new int[][] { { 2, 8, 3 }, { 1, 6, 4 }, { 7, 0, 5 } });
  private static final PuzzleState GOAL = new PuzzleState(new int[][] { { 1, 2, 3 }, { 8, 0, 4 }, { 7, 6, 5 } });
  private static final String INTRO = "You are given a board in which numbered tiles can slide around. There is one blank space that holds no tile.  A legal move consists of sliding a tile into the blank space if the tile is adjacent to it. The goal is to move tiles around until the board looks like the final state below.\n\n" + GOAL;
}
