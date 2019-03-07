package domains.farmer;

import framework.graph.Graph;
import framework.graph.Vertex;

/**
 * A graph for the FWGC problem.
 * @author Max Silver Sec 12
 */
public class FarmerGraph extends Graph {
    
    Vertex state9;
    Vertex state1;
    Vertex state2;
    Vertex state3;
    Vertex state4;
    Vertex state5;
    Vertex state6;
    Vertex state7;
    Vertex state8;    
    Vertex state10;
                
    public FarmerGraph() {
        state1 = new Vertex(new FarmerState("West",
                                   "West",
                                   "West",
                                   "West"));
       state7 = new Vertex(new FarmerState("East",
                                   "West",
                                   "East",
                                   "West"));
       state4 = new Vertex(new FarmerState("West",
                                   "West",
                                   "East",
                                   "West"));
       state10 = new Vertex(new FarmerState("East",
                                   "East",
                                   "East",
                                   "West"));
       state3 = new Vertex(new FarmerState("West",
                                   "East",
                                   "West",
                                   "West"));
       state9 = new Vertex(new FarmerState("East",
                                   "East",
                                   "West",
                                   "East"));
       state2 = new Vertex(new FarmerState("West",
                                   "East",
                                   "West",
                                   "East"));       
       state5 = new Vertex(new FarmerState("West",
                                   "West",
                                   "West",
                                   "East"));
       state8 = new Vertex(new FarmerState("East",
                                   "West",
                                   "East",
                                   "East"));
       state6 = new Vertex(new FarmerState("East",
                                   "East",
                                   "East",
                                   "East"));
        
        addEdge(state1, state7);
        addEdge(state7, state1);
        
        addEdge(state7, state4);
        addEdge(state4, state7);
        
        addEdge(state4, state10);
        addEdge(state10, state4);
        
        addEdge(state4, state8);
        addEdge(state8, state4);
        
        addEdge(state10, state3);
        addEdge(state3, state10);
        
        addEdge(state8, state5);
        addEdge(state5, state8);
        
        addEdge(state3, state9);
        addEdge(state9, state3);
        
        addEdge(state5, state9);
        addEdge(state9, state5);
        
        addEdge(state9, state2);
        addEdge(state2, state9);
        
        addEdge(state2, state6);
        addEdge(state6, state2);                
    }
    
    public Vertex getStart() {
        return this.state1;        
    }
    
    public Vertex getEnd() {
        return this.state6;
    }
    
    /* private fields and methods follow */
    
}