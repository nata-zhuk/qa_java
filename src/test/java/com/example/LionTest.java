package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    // Тест: если пол "Самец", то hasMane = true
    @Test
    public void doesHaveManeReturnsTrueForMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Assert.assertTrue(lion.doesHaveMane());
    }

    // Тест: если пол "Самка", то hasMane = false
    @Test
    public void doesHaveManeReturnsFalseForFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Assert.assertFalse(lion.doesHaveMane());
    }

    // Тест: проверка выброса исключения при неверном поле
    @Test(expected = Exception.class)
    public void constructorThrowsExceptionForInvalidSex() throws Exception {
        new Lion("Неизвестно", feline);
    }

    // Тест: проверка getKittens через мок
    @Test
    public void getKittensReturnsValueFromFeline() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", feline);
        Assert.assertEquals(3, lion.getKittens());
    }

    // Тест: проверка getFood через мок
    @Test
    public void getFoodReturnsValueFromFeline() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        Lion lion = new Lion("Самец", feline);
        Assert.assertEquals(expected, lion.getFood());
    }
}