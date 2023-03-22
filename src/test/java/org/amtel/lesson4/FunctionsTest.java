package org.amtel.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static org.amtel.lesson4.Functions.isPalindrome;
import static org.assertj.core.api.Assertions.assertThat;



public class FunctionsTest {
    private static Logger logger = LoggerFactory.getLogger("FunctionsTest");

    @BeforeAll  //��� ����� ������� ����������� 1 ��� ����� ����� ������� ������
    static void beforeAll() {
        System.out.println("����� ����������� 1 ��� ����� ����� ������� ������");
        //��� � ������� ���� ��� ����� ����� ������� ���������� ���� �������.
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeEach //��� ����� ������� ����� ����������� ������ ��� ����� ������ ������
    void beforeEach() {
        System.out.println("����� ����������� ����� ������ ������ ������");
        //��� ����� ������ ������ ������� ����� ������ �������
        //WebDriver driver = new ChromeDriver();
    }












    @Test
    @DisplayName("����� �������� ���������� � �� ������ ���-�� ��������.")
    void givenPalindromeWhenCallIsPalindromeMethodThenTrue() {
        boolean result = isPalindrome("1234321");
        //Assertions.assertTrue(result);
        Assertions.assertEquals(true, result);
    }

    @Test
    @DisplayName("����� �������� ���������� � ������ ���-�� ��������.")
    void givenPalindromeWhenCallIsPalindromeMethodThenTrue1() {
        boolean result = isPalindrome("123321");
        //Assertions.assertTrue(result);
        Assertions.assertEquals(true, result);
    }


    //���� �������� ���� ���������� - @ValueSource

    //���� ����� ����, ��� ������������ ����, ��� ������ ����, ��� ��������� �������� ������,
    //� ������, ����� �������� ������ �������� ������ ��� ��������� � �������� �����.
    @ParameterizedTest
    @ValueSource(strings = {"123321", "1234321"})
    void siPalindromeTestWithDataProvider(String word) {
        boolean result = isPalindrome(word);
        //Assertions.assertTrue(result);
        Assertions.assertEquals(true, result);
    }

    //��� ������ � ������ ������� ��������� � ��� ������� �������� ���� ����� ��������� ���������.
    @ParameterizedTest
    @CsvSource({"123, false", "123321, true", "1, true", "22, true"})
    void csvTest(String word, boolean expectedResult) {
        boolean actuialResult = isPalindrome(word);
        Assertions.assertEquals(expectedResult, actuialResult);
    }

    //��� ����� ������������ � �������� ��������� �������� ������ �������� �����, ������� �����
    //����������� ��� ������. ��� ����� ������� �������� ����� Cat, ��� � �������� �������
    //������������ �� ����������� ���� �������� ������.
    @ParameterizedTest
    @MethodSource("catAndAgeDataProvider")
    void catEqualsAgeTest(Cat cat, Integer age) {
        Assertions.assertEquals(cat.getAge(), age);
    }

    private static Stream<Arguments> catAndAgeDataProvider() {
        return Stream.of(
                Arguments.of(new Cat("Test1", 10), 10),
                Arguments.of(new Cat("Test2", 11), 11),
                Arguments.of(new Cat("Test3", 12), 12)
        );
    }



    //�������� ����� ���������� AssertJ Fluent Assertions � 3.23.1
    @Test
    void assertJ() {
        assertThat(isPalindrome("1234321")).isTrue();
    }

    //���������
    @Test
    //@Disabled("�� ������ �������� ������")  //��� ��������� �������� �������� ������� ����� ���
        //������� ���� ������ ������
    void assertJDisable() {
        assertThat(isPalindrome("1234321")).isTrue();
    }

    @Test
    @Tag("smoke")  //��� ��������� �������� �������� ��� ������, ��� ���������� ������ ��
        //���������. ��������� ����� � �����. Tag ����� ����� �������� ��������
        // mvn test -D groups=smoke
    void assertJTag() {
        assertThat(isPalindrome("1234321")).isTrue();
    }







    //������ �����������: TRACE, DEBUG, INFO, WARN, ERROR
    //������� � ����� ������ ������ ������ �����.
    @Test
    void loggerTest() {
        logger.info("INFO �����������");
        logger.trace("TRACE �����������");
        logger.debug("DEBUG �����������");
        logger.warn("WARN �����������");
        logger.error("ERROR �����������");
    }








    @AfterEach  //��� ����� ������� ����������� ������ ��� ����� ������� �����
    void afterEach() {
        //��� ������� ������� ����� ������� �����, ����� �� ��������� ������� ������ �������
        //�������, ����� ������� �������� �� �����.
        //driver.quit();
        System.out.println("����� ����������� ����� ������� �����.");
    }

    @AfterAll  //��� ����� ������� ����������� 1 ��� ����� ���� ������ ������
    static void afterAll() {
        System.out.println("����� ����������� 1 ��� ����� ���� ������ ������");
    }

}
