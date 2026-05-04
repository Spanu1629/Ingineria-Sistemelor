package Lab6.advanced;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DoubleCalculatorTest {
    private DoubleCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new DoubleCalculator().init();
    }

    @Test
    @DisplayName("Adunare cu numere pozitive")
    void testAddPositive() {
        // arrange
        double valoare = 10.5;

        // act
        double rezultat = calculator.add(valoare).result();

        // assert
        Assertions.assertEquals(10.5, rezultat, 0.0001);
    }

    @Test
    @DisplayName("Adunare cu numere negative")
    void testAddNegatives() {
        // arrange
        double valoare1 = -10.5;
        double valoare2 = -2.5;

        // act
        double rezultat = calculator.add(valoare1).add(valoare2).result();

        // assert
        Assertions.assertEquals(-13.0, rezultat, 0.0001);
    }

    @Test
    @DisplayName("Scadere cu numere pozitive")
    void testSubtractPositives() {
        // arrange
        calculator.add(20.5);

        // act
        double rezultat = calculator.subtract(7.2).result();

        // assert
        Assertions.assertEquals(13.3, rezultat, 0.0001);
    }

    @Test
    @DisplayName("Scadere cu numere negative")
    void testSubtractNegatives() {
        // arrange
        calculator.add(-10.5);

        // act
        double rezultat = calculator.subtract(-5.0).result();

        // assert
        Assertions.assertEquals(-5.5, rezultat, 0.0001);
    }

    @Test
    @DisplayName("Inmultire cu numere pozitive")
    void testMultiplyPositives() {
        // arrange
        calculator.add(6.0);

        // act
        double rezultat = calculator.multiply(4.5).result();

        // assert
        Assertions.assertEquals(27.0, rezultat, 0.0001);
    }

    @Test
    @DisplayName("Inmultire cu numere negative")
    void testMultiplyNegatives() {
        // arrange
        calculator.add(-6.0);

        // act
        double rezultat = calculator.multiply(-4.5).result();

        // assert
        Assertions.assertEquals(27.0, rezultat, 0.0001);
    }

    @Test
    @DisplayName("Inmultire cu 0")
    void testMultiplyBy0() {
        // arrange
        calculator.add(6.0);

        // act
        double rezultat = calculator.multiply(0.0).result();

        // assert
        Assertions.assertEquals(0.0, rezultat, 0.0001);
    }

    @Test
    @DisplayName("Impartire cu numere pozitive")
    void testDividePositives() {
        // arrange
        calculator.add(20.0);

        // act
        double rezultat = calculator.divide(5.0).result();

        // assert
        Assertions.assertEquals(4.0, rezultat, 0.0001);
    }

    @Test
    @DisplayName("Impartire cu numere negative")
    void testDivideNegatives() {
        // arrange
        calculator.add(-20.0);

        // act
        double rezultat = calculator.divide(-5.0).result();

        // assert
        Assertions.assertEquals(4.0, rezultat, 0.0001);
    }

    @Test
    @DisplayName("Impartire cu 0")
    void testDivideBy0() {
        // arrange
        calculator.add(20.0);

        // act + assert
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(0.0));
    }
}