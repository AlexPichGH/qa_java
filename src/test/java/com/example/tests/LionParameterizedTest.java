package com.example.tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final boolean expectedHasMane;

    private Feline mockFeline;

    public LionParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    // тестовые данные
    @Parameterized.Parameters(name = "sex: {0} => hasMane: {1}")
    public static Object[][] lionTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Before
    public void init() {
        mockFeline = Mockito.mock(Feline.class);
    }

    // проверяем, что метод doesHaveMane() возвращает ожидаемое значение в зависимости от пола
    @Test
    public void doesHaveManeReturnExpectedValueTest() throws Exception {
        Lion lion = new Lion(sex, mockFeline);
        Assert.assertEquals(
                String.format("Для пола '%s' метод doesHaveMane() должен вернуть %s", sex, expectedHasMane),
                expectedHasMane,
                lion.doesHaveMane()
        );
    }
}