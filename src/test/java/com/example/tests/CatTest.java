package com.example.tests;

import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline mockFeline;
    private Cat cat;

    @Before
    public void init() {
        cat = new Cat(mockFeline);
    }

    // проверяем, что метод getSound() класса Cat возвращает "Мяу"
    @Test
    public void getSoundReturnExpectedCatSoundTest() {
        Assert.assertEquals(
                "Метод getSound() должен возвращать ожидаемый звук",
                "Мяу",
                cat.getSound()
        );
    }

    // проверяем, что метод getFood() класса Cat возвращает ожидаемый список животных
    @Test
    public void getFoodReturnFoodListFromFelineTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.eatMeat()).thenReturn(expectedFood);
        Assert.assertEquals(
                "Метод getFood() должен возвращать список еды, полученный от Feline",
                expectedFood,
                cat.getFood()
        );
    }

    // проверяем, что метод в getFood() класса Cat пробрасывается исключение метода eatMeat() класса Feline
    @Test
    public void getFoodThrowsExceptionWhenFelineThrowsExceptionTest() throws Exception {
        Mockito.when(mockFeline.eatMeat()).thenThrow(new Exception("Ошибка при получении еды"));
        Assert.assertThrows(
                "В метод getFood() должно пробрасываться исключение из метода eatMeat() класса Feline",
                Exception.class,
                () -> cat.getFood()
        );
    }
}