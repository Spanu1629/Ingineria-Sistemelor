package Lab6.advanced;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NewIntCalculatorTest {
    private NewIntCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new NewIntCalculator().init();
    }

    @Test
    @DisplayName("Adunare cu numere pozitive")
    void testAddPositive() {
        // arrange
        int valoare = 10;

        // act
        int rezultat = calculator.add(valoare).result();

        // assert
        Assertions.assertEquals(10, rezultat);
    }

    @Test
    @DisplayName("Adunare cu numere negative")
    void testAddNegatives() {
        // arrange
        int valoare1 = -10;
        int valoare2 = -5;

        // act
        int rezultat = calculator.add(valoare1).add(valoare2).result();

        // assert
        Assertions.assertEquals(-15, rezultat);
    }

    @Test
    @DisplayName("Scadere cu numere pozitive")
    void testSubtractPositives() {
        // arrange
        calculator.add(20);

        // act
        int rezultat = calculator.subtract(7).result();

        // assert
        Assertions.assertEquals(13, rezultat);
    }

    @Test
    @DisplayName("Scadere cu numere negative")
    void testSubtractNegatives() {
        // arrange
        calculator.add(-10);

        // act
        int rezultat = calculator.subtract(-5).result();

        // assert
        Assertions.assertEquals(-5, rezultat);
    }

    @Test
    @DisplayName("Inmultire cu numere pozitive")
    void testMultiplyPositives() {
        // arrange
        calculator.add(6);

        // act
        int rezultat = calculator.multiply(4).result();

        // assert
        Assertions.assertEquals(24, rezultat);
    }

    @Test
    @DisplayName("Inmultire cu numere negative")
    void testMultiplyNegatives() {
        // arrange
        calculator.add(-6);

        // act
        int rezultat = calculator.multiply(-4).result();

        // assert
        Assertions.assertEquals(24, rezultat);
    }

    @Test
    @DisplayName("Inmultire cu 0")
    void testMultiplyBy0() {
        // arrange
        calculator.add(6);

        // act
        int rezultat = calculator.multiply(0).result();

        // assert
        Assertions.assertEquals(0, rezultat);
    }

    @Test
    @DisplayName("Impartire cu numere pozitive")
    void testDividePositives() {
        // arrange
        calculator.add(20);

        // act
        int rezultat = calculator.divide(5).result();

        // assert
        Assertions.assertEquals(4, rezultat);
    }

    @Test
    @DisplayName("Impartire cu numere negative")
    void testDivideNegatives() {
        // arrange
        calculator.add(-20);

        // act
        int rezultat = calculator.divide(-5).result();

        // assert
        Assertions.assertEquals(4, rezultat);
    }

    @Test
    @DisplayName("Impartire cu 0")
    void testDivideBy0() {
        // arrange
        calculator.add(20);

        // act + assert
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(0));
    }
}