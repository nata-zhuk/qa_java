package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundReturnsMeow() {
        // Создаем кота, передавая ему мок Feline
        Cat cat = new Cat(feline);

        String expected = "Мяу";
        String actual = cat.getSound();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFoodReturnsCorrectListUsingMock() throws Exception {
        // Настраиваем мок: "Когда вызовут eatMeat(), верни этот список"
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(feline);

        List<String> actualFood = cat.getFood();
        Assert.assertEquals(expectedFood, actualFood);
    }
}