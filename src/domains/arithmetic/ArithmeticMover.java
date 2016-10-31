package domains.arithmetic;

import domains.arithmetic.ArithmeticState;
import framework.problem.Mover;
import framework.problem.State;

/**
 *
 * @author Maxwell
 */
public class ArithmeticMover extends Mover{

    public static final String ADD3 = "Add 3";
    public static final String SUB5 = "Subtract 5";
    public static final String DIV2 = "Divide by 2";
    public static final String MUL2 = "Multiply by 2";
    
    /**
     * Constructs Arithmetic Mover for possible moves
     */
    public ArithmeticMover() {
        super.addMove(ADD3, s -> Add3(s));
        super.addMove(SUB5, s -> Sub5(s));
        super.addMove(DIV2, s -> Div2(s));
        super.addMove(MUL2, s -> Mul2(s));        
    }
    /**
     * Adds 3 to the current state value and returns it
     * @param state
     * @return the result of adding 3
     */
    private State Add3(State state) {
        ArithmeticState object = (ArithmeticState)state;
        int value = object.getValue();
        object = new ArithmeticState(value + 3);
        
       return object;
        }
    /**
     * Subtracts 5 from the current state and returns it
     * @param state
     * @return the result of subtracting 5
     */
        private State Sub5(State state) {
        ArithmeticState object = (ArithmeticState)state;
        int value = object.getValue();
        object = new ArithmeticState(value - 5);
        
        return object;
        }
    /**
     * Divides 2 from the current state and returns it
     * @param state
     * @return the result of dividing by 2
     */
        private State Div2(State state) {
        ArithmeticState object = (ArithmeticState)state;
        int value = object.getValue();
        object = new ArithmeticState(value / 2);
        
        return object;
        }
    /**
     * Multiplies the current state by 2 and returns it
     * @param state
     * @return the result of multiplying by 2
     */
        private State Mul2(State state) {
        ArithmeticState object = (ArithmeticState)state;
        int value = object.getValue();
        object = new ArithmeticState(value * 2);
        
        return object;
        }
}
  
