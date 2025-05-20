package com.example.tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Spy
    private Feline spyFeline;
    private Lion lion;

    @Before
    public void init() throws Exception {
        lion = new Lion("Самец", spyFeline);
    }

    // проверяем, что при инициализации класса Lion недопустимым значением пола выбрасывается ошибка
    @Test
    public void initLionWithInvalidSexThrowExceptionTest() {
        Assert.assertThrows(
                Exception.class,
                () -> new Lion("львёнок", spyFeline)
        );
    }

    // проверяем, что метод getKittens() класса Lion возвращает 1
    @Test
    public void getKittensReturnOneTest() {
        int expectedValue = 1;
        Assert.assertEquals(
                String.format("Метод getKittens() должен возвращать '%d'", expectedValue),
                expectedValue,
                lion.getKittens()
        );
    }

    // проверяем, что метод getFood() класса Lion возвращает ожидаемый список животных
    @Test
    public void getFoodReturnFoodListFromFelineTest() throws Exception {
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(
                String.format("Метод getFood() должен возвращать %s", expectedList),
                expectedList,
                lion.getFood()
        );
    }

    // проверяем, что в метод getFood() класса Lion пробрасывается исключение метода eatMeat() класса Feline
    @Test
    public void getFoodThrowsExceptionWhenFelineThrowsExceptionTest() throws Exception {
        Mockito.when(spyFeline.getFood("Хищник")).thenThrow(new Exception("Ошибка при получении еды"));
        Assert.assertThrows(
                "В метод getFood() должно пробрасываться исключение из метода eatMeat() класса Feline",
                Exception.class,
                () -> lion.getFood()
        );
    }
}