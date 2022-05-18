import Lesson4.Triangle;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangleTest {

    @Test
    @DisplayName("Triangle are calculation test")
    void triangleAreaCalculationTest() {
        float result = Triangle.CalculateArea(3,2,3);
        //Assertions.assertEquals(result, 2.828427);
        Assertions.assertEquals(result, 2.8284270763397217);
    }

    @ParameterizedTest
    @CsvSource({"3, 2, 3, 2.8284270763397217", "3,2,5, 2.828427"})
    void triangleAreaCalculationParametrizedTest(int a, int b, int c, float result) {
        float result1 = Triangle.CalculateArea(3,2,3);
        Assertions.assertEquals(result, result1);
    }

}
