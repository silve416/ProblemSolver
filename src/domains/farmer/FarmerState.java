package domains.farmer;

import framework.problem.State;
       

/**
 *
 * @author Maxwell
 */
public class FarmerState implements State{
    
    private final String farmer;
    private final String wolf;
    private final String goat;
    private final String cabbage;
    
    public static enum Side {
     WEST, EAST;             
    }
    
    public FarmerState(String farmer, String wolf, String goat, String cabbage){
        this.farmer = farmer;
        this.goat = goat;
        this.wolf = wolf;
        this.cabbage = cabbage;     
    }
    
    /**
    public FarmerState(String farmer, String wolf, String goat, String cabbage){
        this(toSide(farmer), toSide(wolf), toSide(goat), toSide(cabbage));
    }
    */
    private static Side toSide(String s){
        if(s.equalsIgnoreCase("west"))              
            return Side.WEST;
        if(s.equalsIgnoreCase("east"))
            return Side.EAST; 
      throw new RuntimeException("Error: " + s + " is bad");
    }
   
    
    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass()){
            return false;
        }
        FarmerState state = (FarmerState)obj;
        return (this.farmer == state.farmer) && (this.goat == state.goat) && (this.wolf == state.wolf) && (this.cabbage == state.cabbage);
    }
    
    public String getFarmer(){
        return this.farmer;
    }    
    public String getWolf(){
        return this.wolf;
    }    
    public String getGoat(){
        return this.goat;
    }
    public String getCabbage(){
        return this.cabbage;
    }
    
    @Override
    public String toString(){
        StringBuilder chck = new StringBuilder();
        
        String start = "   |  |   \n";
        String farmerW = " F |  |   \n"; 
        String farmerE = "   |  | F \n";
        String wolfW = " W |  |   \n";
        String wolfE = "   |  | W \n";
        String goatW = " G |  |   \n";
        String goatE = "   |  | G \n";
        String cabbageW = " C |  |   \n";
        String cabbageE = "   |  | C \n";
        String end = "   |  |   ";       
        
        
        chck.append(start);
        
        chck.append(this.farmer == "West" ? farmerW : farmerE);
        chck.append(this.wolf == "West" ? wolfW : wolfE);
        chck.append(this.goat == "West" ? goatW : goatE);
        chck.append(this.cabbage == "West" ? cabbageW : cabbageE);
        
        chck.append(end);
        
        return chck.toString();
    }
}