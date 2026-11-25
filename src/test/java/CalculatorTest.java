import calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
    private static final double DELTA = 1e-9;
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 8",
            "0, 0, 0",
            "-2, 2, 0",
            "0.1, 0.2, 0.3"
    })
    @DisplayName("Сложение двух чисел возвращает их сумму")
    void shouldAddTwoNumbers(double a, double b, double expected) {
        double result = calculator.sum(a, b);
        Assertions.assertEquals(expected, result, DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "6, 2, 4",
            "3, 5, -2",
            "0, 0, 0",
            "-4, -4, 0",
            "0.3, 0.1, 0.2"
    })
    @DisplayName("Вычитание второго числа из первого возвращает разность")
    void shouldSubtractTwoNumbers(double a, double b, double expected) {
        double result = calculator.subtract(a, b);
        Assertions.assertEquals(expected, result, DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "3, 3, 9",
            "5, 0, 0",
            "-4, 3, -12",
            "-4, -3, 12",
            "1.5, 2, 3"
    })
    @DisplayName("Умножение двух чисел")
    void shouldMultiplyTwoNumbers(double a, double b, double expected) {
        double result = calculator.multiply(a, b);
        Assertions.assertEquals(expected, result, DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "6, 3, 2",
            "7, 2, 3.5",
            "0, 5, 0",
            "-6, 3, -2",
            "6, -3, -2",
            "-6, -3, 2"
    })
    @DisplayName("Деление первого числа на второе число")
    void shouldDivideTwoNumbers(double a, double b, double expected) {
        double result = calculator.divide(a, b);
        Assertions.assertEquals(expected, result, DELTA);
    }

    @Test
    @DisplayName("Деление на 0 выбрасывает арифмитическое исключение")
    void shouldDivideZeroReturnArithmeticException() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> calculator.divide(4, 0)
        );
    }
}
