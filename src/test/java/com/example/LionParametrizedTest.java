package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    private final String sex;
    private final boolean expectedHasMane;

    // В конструкторе принимаем параметры
    public LionParametrizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    // Задаем набор тестовых данных (Самец - true, Самка - false)
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void doesHaveManeReturnsCorrectValue() throws Exception {
        Lion lion = new Lion(sex, new Feline());

        Assert.assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}