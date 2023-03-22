package org.amtel.lesson4.DZ;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TriangleAreaTest {

    @Test
    void simpleNegativeTriangleTest() {
        Triangle area = new Triangle(10, 10);
        int result = area.triangleArea();
        Assertions.assertNotEquals(500, result);
    }


    @ParameterizedTest
    @MethodSource("triangleTestDataProvider")
    void triangleTest(Triangle tri, int expArea) {
        Assertions.assertEquals(expArea, tri.triangleArea());
    }

    private static Stream<Arguments> triangleTestDataProvider() {
        return Stream.of(
                Arguments.of(new Triangle(10, 10), 50),
                Arguments.of(new Triangle(10, 20), 100),
                Arguments.of(new Triangle(10, 400), 2000)
                );
    }


}
