package com.example;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class AnimalTest {

    Animal animal = new Animal();

    // 1. Покрываем метод getFamily()
    @Test
    public void getFamilyReturnsCorrectString() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();
        Assert.assertEquals(expected, actual);
    }

    // 2. Покрываем ветку "Травоядное"
    @Test
    public void getFoodReturnsPlantsForHerbivore() throws Exception {
        List<String> expected = List.of("Трава", "Различные растения");
        List<String> actual = animal.getFood("Травоядное");
        Assert.assertEquals(expected, actual);
    }

    // 3. Покрываем ветку else (выброс исключения)
    @Test(expected = Exception.class)
    public void getFoodThrowsExceptionForUnknownAnimal() throws Exception {
        animal.getFood("Неизвестное");
    }
}
