package session_27_UnitTesting.Homework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import session_26_Exceptions.Homework.Calculator;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static double firstNumber;
    private static double secondNumber;

    @BeforeAll
    static void beforeAll() {
        firstNumber = 2.5;
        secondNumber = 4.5;
    }

    @Test
    void additionOfDoubles_ShouldReturnDouble() {
        double result = Calculator.calculate(firstNumber, secondNumber, '+');

        assertEquals(7.0, result);
        assertNotEquals(0, result);
    }

    @Test
    void subtractionOfDoubles_ShouldReturnDouble() {
        double result = Calculator.calculate(firstNumber, secondNumber, '-');

        assertEquals(-2.0, result);
        assertNotEquals(2, result);
    }

    @Test
    void multiplicationOfDoubles_ShouldReturnDouble() {
        double result = Calculator.calculate(firstNumber, secondNumber, '*');

        assertEquals(11.25, result);
        assertNotEquals(11, result);
    }

    @Test
    void divisionOfDoubles_ShouldReturnDouble() {
        double result = Calculator.calculate(secondNumber, firstNumber, '/');

        assertEquals(1.8, result);
        assertNotEquals(2.0, result);
        assertThrows(ArithmeticException.class,() -> Calculator.calculate(firstNumber, 0, '/'));
    }

    @Test
    void modulusOfDoubles_ShouldReturnDouble() {
        double result = Calculator.calculate(firstNumber, secondNumber, '%');

        assertEquals(2.5, result);
        assertNotEquals(2, result);
    }

    @Test
    void invalidOperator_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.calculate(firstNumber, secondNumber, '?'));
    }
}