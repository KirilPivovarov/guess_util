package ua.com.devEducation.applicationGuess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationGuessTest {

    private final Random random = Mockito.mock(Random.class);
    private final Scanner scanner = Mockito.mock(Scanner.class);
    private final ApplicationGuess application = new ApplicationGuess(scanner);

    @Test
    public void getYourRandomNumberTest() {
        Mockito.when(random.nextInt(1)).thenReturn(1);
        int from = 9;
        int to  = 9;
        Assertions.assertEquals(application.getYourRandomNumber(from,to), 9);
    }

    static Arguments[] validationForValAttemptsTestArg() {
        return new Arguments[]{
          Arguments.arguments(15, 15),
          Arguments.arguments(-1, 0),
          Arguments.arguments(2, 2),
          Arguments.arguments(6, 6),
          Arguments.arguments(345, 0)
        };
    }

    @ParameterizedTest
    @MethodSource("validationForValAttemptsTestArg")
    public void validationForValAttemptsTest(int valAttantion, int result){
        Mockito.when(scanner.nextInt()).thenReturn(valAttantion).thenReturn(0);
            Assertions.assertEquals(application.validationForValAttempts(valAttantion), result);

    }

}