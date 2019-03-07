package framework.solution;

import framework.graph.Vertex;
import framework.problem.Mover;
import framework.problem.Problem;
import framework.problem.State;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
A state Space Solver
@author Maxwel Silver 
*/

public class StateSpaceSolver
  extends Solver
{
  private final boolean bfs;
  
  public StateSpaceSolver(Problem problem, boolean bfs)
  {
      
    super(problem);
    super.setQueue(new LinkedList());
    this.bfs = bfs;
    super.getStatistics().setHeader((bfs ? "Breadth-First" : "Depth-First") + " State Space Search");
  }
  
  public void add(Vertex v)
  {   
    if (this.bfs) {
      ((LinkedList)getQueue()).addLast(v);
    } else {
      ((LinkedList)getQueue()).addFirst(v);
    }
  }
  
  public List<Vertex> expand(Vertex u)
  {  
    Mover mover = getProblem().getMover();
    List<String> moveNames = mover.getMoveNames();
    List<Vertex> children = new ArrayList();
    
    for (String move : moveNames)
    {
      State next = mover.slide(move, (State)u.getData());
      if (next != null)
      {
        Vertex child = new Vertex(next);
        if (!occursOnPath(child, u))
        {
          child.setDistance(u.getDistance() + 1);
          child.setPredecessor(u);
          children.add(child);
        }
      }
    }
    return children;
  }
  
  public static boolean occursOnPath(Vertex v, Vertex ancestor)
  {
    if ( v == null || ancestor == null) {
      return false;
    }
    
    if (v.equals(ancestor)) {
      return true;
    }
    
    return occursOnPath(v, ancestor.getPredecessor());
  }
 
}
