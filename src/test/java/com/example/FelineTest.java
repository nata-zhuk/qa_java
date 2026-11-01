package com.example;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class FelineTest {

    Feline feline = new Feline();

    // Проверяем, что семейство возвращается верно
    @Test
    public void getFamilyReturnsCorrectFamily() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        Assert.assertEquals(expected, actual);
    }

    // Проверяем, что по умолчанию 1 котенок
    @Test
    public void getKittensReturnsOneByDefault() {
        int expected = 1;
        int actual = feline.getKittens();
        Assert.assertEquals(expected, actual);
    }

    // Проверяем, что возвращается переданное количество котят
    @Test
    public void getKittensReturnsPassedValue() {
        int expected = 5;
        int actual = feline.getKittens(5);
        Assert.assertEquals(expected, actual);
    }

    // Проверяем метод eatMeat
    @Test
    public void eatMeatReturnsCorrectFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        Assert.assertEquals(expected, actual);
    }
}