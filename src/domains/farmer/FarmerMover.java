/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private enum Message {EXCEPTION_OCCURRED, NO_EXCEPTION_OCCURRED};
  
    public FarmerMover(){
    super.addMove(GOES_ALONE, s-> goesAlone(s));
    super.addMove(TAKES_CABBAGE, s-> takesCabbage(s));
    super.addMove(TAKES_GOAT, s-> takesGoat(s));
    super.addMove(TAKES_WOLF, s-> takesWolf(s));
}
    
    public boolean checkSafe(FarmerState state){
        if(state.getCabbage()== state.getGoat())
            return false;
        return state.getWolf() != state.getGoat();        
    }
    
    
    public State goesAlone(State s){
        FarmerState side = (FarmerState)s;
        if(("West".equals(side.getFarmer())) && ("West".equals(side.getWolf())) && ("West".equals(side.getGoat())) && ("West".equals(side.getCabbage())))
            return null;
       String f = "East";
       String w = side.getWolf();
       String g = side.getGoat();
       String c = side.getCabbage();
       if((side.getFarmer()=="East") && (side.getWolf()=="East") && (side.getGoat()=="West") && (side.getCabbage()=="East"))
           return new FarmerState("West",w,g,c);
       return new FarmerState(f,w,g,c);
    }    
    
    
    public State takesCabbage(State s){
        FarmerState side = (FarmerState)s;
        if((side.getWolf()==side.getGoat()) || (side.getFarmer() != side.getCabbage()))//Idk why this isn't working
            return null;
        String f = "East";
        String w = side.getWolf();
        String g = side.getGoat();
        String c = "East";
        
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
        
        if((side.getFarmer()=="East") && (side.getWolf()=="West") && (side.getGoat()=="East") && (side.getCabbage()=="West"))
            return new FarmerState("West",w,"West",c);
        return new FarmerState(f,w,g,c);
    }
    
    public State takesWolf(State s){
        FarmerState side = (FarmerState)s;
        if((side.getWolf() == "West") && (side.getFarmer() == "East"))//idk why this won't work
            return null;
        if((side.getWolf() == "East") && (side.getFarmer() == "West"))
            return null;
        if((side.getGoat() == side.getCabbage()))
            return null;
        String f = "East";
        String w = "East";
        String g = side.getGoat();
        String c = side.getCabbage();
        
        if((side.getFarmer()=="East") && (side.getGoat()=="East") && (side.getWolf()=="East") && (side.getCabbage()=="West"))
            return new FarmerState("West","West",g,c);
        return new FarmerState(f,w,g,c);
    }
     
   }
    
