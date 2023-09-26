import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class DecisionTableCalculatorTest {

    @Test
    void checkValidOfInput(){
        Calculator calculator = new Calculator(1, 1, '&');
        assertEquals(false, calculator.checkValidOfInput());
    }

    @Test
    void invalidRes1(){
        Calculator calculator = new Calculator(Integer.MAX_VALUE, 1, '+');
        assertThrows(RuntimeException.class, calculator::checkValueOfResult);
    }
    @Test
    void invalidRes2(){
        Calculator calculator = new Calculator(Integer.MIN_VALUE, -1, '+');
        assertThrows(RuntimeException.class, calculator::checkValueOfResult);
    }

    @Test
    void invalidRes3(){
        Calculator calculator = new Calculator(Integer.MIN_VALUE, 1, '-');
        assertThrows(RuntimeException.class, calculator::checkValueOfResult);
    }

    @Test
    void invalidRes4(){
        Calculator calculator = new Calculator(Integer.MAX_VALUE, -1, '-');
        assertThrows(RuntimeException.class, calculator::checkValueOfResult);
    }

    @Test
    void invalidRes5(){
        Calculator calculator = new Calculator(Integer.MAX_VALUE, 2, '*');
        assertThrows(RuntimeException.class, calculator::checkValueOfResult);
    }

    @Test
    void invalidRes6(){
        Calculator calculator = new Calculator(10, 0, '/');
        assertThrows(RuntimeException.class, calculator::checkValueOfResult);
    }

    @Test
    void addition() {
        Calculator calculator = new Calculator(1, 1, '+');
        assertEquals(2, calculator.calculate());
    }

    @Test
    void subtract(){
        Calculator calculator = new Calculator(10, 1, '-');
        assertEquals(9, calculator.calculate());
    }

    @Test
    void multiply(){
        Calculator calculator = new Calculator(100, 234 , '*');
        assertEquals(23400, calculator.calculate());
    }

    @Test
    void divide1(){
        Calculator calculator = new Calculator(996, 332 , '/');
        assertEquals(3, calculator.calculate());
    }

    @Test
    void divide2(){
        Calculator calculator = new Calculator(10, 3 , '/');
        assertEquals(3.33, calculator.calculate());
    }
}
