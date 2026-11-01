package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    @Mock
    Feline feline;

    @Test
    public void alexHasNoKittens() throws Exception {
        Alex alex = new Alex(feline);
        Assert.assertEquals(0, alex.getKittens());
    }

    @Test
    public void getFriendsReturnsCorrectList() throws Exception {
        Alex alex = new Alex(feline);
        List<String> expected = List.of("Марти", "Глория", "Мелман");
        Assert.assertEquals(expected, alex.getFriends());
    }

    @Test
    public void getPlaceOfLivingReturnsNewYorkZoo() throws Exception {
        Alex alex = new Alex(feline);
        Assert.assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }
}