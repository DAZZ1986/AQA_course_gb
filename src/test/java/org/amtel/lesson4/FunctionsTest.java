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

    @BeforeAll  //это метод который выполняется 1 раз ПЕРЕД ВСЕМИ тестами класса
    static void beforeAll() {
        System.out.println("Метод выполняется 1 раз перед всеми тестами класса");
        //Тут к примеру один раз перед всеми тестами подключаем Хром драйвер.
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeEach //это метод который будет выполняться каждый раз ПЕРЕД каждым тестом
    void beforeEach() {
        System.out.println("Метод выполняется перед каждым тестом класса");
        //тут перед каждым тестом создаем новый чистый драйвер
        //WebDriver driver = new ChromeDriver();
    }












    @Test
    @DisplayName("Метод проверки палиндрома с НЕ четным кол-во символов.")
    void givenPalindromeWhenCallIsPalindromeMethodThenTrue() {
        boolean result = isPalindrome("1234321");
        //Assertions.assertTrue(result);
        Assertions.assertEquals(true, result);
    }

    @Test
    @DisplayName("Метод проверки палиндрома с четным кол-во символов.")
    void givenPalindromeWhenCallIsPalindromeMethodThenTrue1() {
        boolean result = isPalindrome("123321");
        //Assertions.assertTrue(result);
        Assertions.assertEquals(true, result);
    }


    //НИЖЕ ДОБАВИЛИ ДАТА ПРОВАЙДЕРЫ - @ValueSource

    //Ниже пишем тест, без дублирования кода, как делали выше, при изменении тестовых данных,
    //а просто, будем подавать разные тестовые данные как аргументы в тестовый метод.
    @ParameterizedTest
    @ValueSource(strings = {"123321", "1234321"})
    void siPalindromeTestWithDataProvider(String word) {
        boolean result = isPalindrome(word);
        //Assertions.assertTrue(result);
        Assertions.assertEquals(true, result);
    }

    //Тут массив с даными которые проверяем и для каждого значения сами пишем ожидаемый результат.
    @ParameterizedTest
    @CsvSource({"123, false", "123321, true", "1, true", "22, true"})
    void csvTest(String word, boolean expectedResult) {
        boolean actuialResult = isPalindrome(word);
        Assertions.assertEquals(expectedResult, actuialResult);
    }

    //Тут будем использовать в качестве источника тестовых данных реальный метод, который будет
    //высчитывать эти данные. Для этого примера создадми класс Cat, что в качестве примера
    //использовать не примитивные типы тестовых данных.
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



    //проверка через библиотеку AssertJ Fluent Assertions » 3.23.1
    @Test
    void assertJ() {
        assertThat(isPalindrome("1234321")).isTrue();
    }

    //АННОТАЦИИ
    @Test
    //@Disabled("Не готовы тестовые данные")  //эта аннотация выключит проверку данного тесте при
        //запуске всех тестов класса
    void assertJDisable() {
        assertThat(isPalindrome("1234321")).isTrue();
    }

    @Test
    @Tag("smoke")  //эта аннотация является заметкой или эпиком, для разделения тестов по
        //критериям. Запустить тесты с опред. Tag можно через терминал командой
        // mvn test -D groups=smoke
    void assertJTag() {
        assertThat(isPalindrome("1234321")).isTrue();
    }







    //Уровни логирования: TRACE, DEBUG, INFO, WARN, ERROR
    //создаем в самом начале класса объект логер.
    @Test
    void loggerTest() {
        logger.info("INFO логирование");
        logger.trace("TRACE логирование");
        logger.debug("DEBUG логирование");
        logger.warn("WARN логирование");
        logger.error("ERROR логирование");
    }








    @AfterEach  //это метод который выполняется каждый раз ПОСЛЕ каждого теста
    void afterEach() {
        //Тут удаляем драйвер после каждого теста, чтобы не оставлять объекты сжигая попусту
        //ресурсы, таким образом подчищая за собой.
        //driver.quit();
        System.out.println("Метод выполняется после каждого теста.");
    }

    @AfterAll  //это метод который выполняется 1 раз ПОСЛЕ ВСЕХ тестов класса
    static void afterAll() {
        System.out.println("Метод выполняется 1 раз после всех тестов класса");
    }

}
