package domains.farmer;

import java.util.List;
import framework.problem.Mover;
import framework.problem.State;
import domains.farmer.FarmerState;
/**
 *
 * @author Maxwell
 */
public class FarmerMover extends Mover{
    
    String GOES_ALONE = "goesAlone";
    String TAKES_CABBAGE = "takesCabbage";
    String TAKES_GOAT = "takesGoat";
    String TAKES_WOLF = "takesWolf";   
  
    public FarmerMover(){
    super.addMove(GOES_ALONE, s-> goesAlone(s));
    super.addMove(TAKES_WOLF, s-> takesWolf(s));
    super.addMove(TAKES_GOAT, s-> takesGoat(s));
    super.addMove(TAKES_CABBAGE, s-> takesCabbage(s));    
    }
    
    
    public State goesAlone(State s){
        FarmerState side = (FarmerState)s;
        if((side.getWolf()==side.getGoat()) || (side.getGoat()==side.getCabbage()))
            return null;
       String f = "East";
       String w = side.getWolf();
       String g = side.getGoat();
       String c = side.getCabbage();
       if(side.getFarmer()=="East")
           return new FarmerState("West",w,g,c);
       return new FarmerState(f,w,g,c);
    }    
    
    public State takesWolf(State s){
        FarmerState side = (FarmerState)s;
        if(((side.getFarmer() != side.getWolf()) || ((side.getGoat() == side.getCabbage()))))
            return null;
        String f = "East";
        String w = "East";
        String g = side.getGoat();
        String c = side.getCabbage();
        
        if(side.getFarmer()=="East")
            return new FarmerState("West","West",g,c);
        return new FarmerState(f,w,g,c);
       }

    public State takesGoat(State s){
        FarmerState side = (FarmerState)s;
        if(side.getGoat() != side.getFarmer())
           return null;
        String f = "East";
        String w = side.getWolf();
        String g = "East";
        String c = side.getCabbage();
        
        if(side.getFarmer()=="East")
            return new FarmerState("West",w,"West",c);
        return new FarmerState(f,w,g,c);
        }   
    
    public State takesCabbage(State s){
        FarmerState side = (FarmerState)s;
        if((side.getWolf()==side.getGoat()) || (side.getFarmer() != side.getCabbage()))
            return null;
        String f = "East";
        String w = side.getWolf();
        String g = side.getGoat();
        String c = "East";
        if(side.getFarmer()=="East")
            return new FarmerState("West",w,g,"West");
        return new FarmerState(f,w,g,c);
        }   

   }
    
