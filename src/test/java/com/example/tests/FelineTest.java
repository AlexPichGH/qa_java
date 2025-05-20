package com.example.tests;

import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FelineTest {

    private Feline feline;

    @Before
    public void init() {
        feline = new Feline();
    }

    // проверяем, что метод eatMeat() возвращает список еды хищника
    @Test
    public void eatMeatReturnPredatorFoodListTest() throws Exception {
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(
                String.format("Метод eatMeat() должен возвращать %s", expectedList),
                expectedList,
                feline.eatMeat()
        );
    }

    // проверяем, что метод getFamily() возвращает "Кошачьи"
    @Test
    public void getFamilyReturnFelineTest() {
        String expectedValue = "Кошачьи";
        Assert.assertEquals(
                String.format("Метод getFamily() должен возвращать '%s'", expectedValue),
                expectedValue,
                feline.getFamily()
        );
    }

    // проверяем, что метод getKittens() без аргументов возвращает 1
    @Test
    public void getKittensReturnOneWhenNoArgumentsTest() {
        int expectedValue = 1;
        Assert.assertEquals(
                String.format("Метод getKittens() должен возвращать '%d'", expectedValue),
                expectedValue,
                feline.getKittens()
        );
    }

    // проверяем, что метод getKittens() с аргументом возвращает количество котят
    @Test
    public void getKittensReturnKittensCountWhenArgumentGivenTest() {
        int kittensCount = 7;
        int expectedValue = 7;
        Assert.assertEquals(
                String.format("Метод getKittens('%d') должен возвращать '%d'", kittensCount, expectedValue),
                expectedValue,
                feline.getKittens(kittensCount)
        );
    }
}