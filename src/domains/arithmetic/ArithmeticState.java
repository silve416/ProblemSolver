package domains.arithmetic;

import framework.problem.State;
/**
 *
 * @author Maxwell
 */
public class ArithmeticState implements State {
    private final int value;

    public ArithmeticState(int value) {
        this.value = value;
    }  
    
    /**
     * Tests for equality
     * @param other
     * @return true if equal, false if not
     */
    @Override
        public boolean equals(Object other) {
            return ((ArithmeticState)other).value == this.value;            
        }
    /**
     * returns a string saying "The value is" and the current value
     *@return string with value
    **/
    @Override
        public String toString() {
            return "The value is: " + this.value;
        }
        
        /**
         * Getter for value
         * @return value
         */
        public int getValue() {
            return this.value;
        }
}