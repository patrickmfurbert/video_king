package com.paychex.moviemetadataservicepyx;

import com.paychex.moviemetadataservicepyx.utils.ConvertToDecade;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ConvertToDecadeTest {

    @Test
    public void testLessThanZero(){
        int expected = -1;
        int testCase = -45;
        assertEquals(expected, ConvertToDecade.LastDigitToZero(testCase));
    }
    
    @Test
    public void testZero(){
        int expected = 0;
        int testCase = 0;
        assertEquals(expected, ConvertToDecade.LastDigitToZero(testCase));
    }

    @Test
    public void testOne(){
        int expected = 1990;
        int testCase = 1999;
        assertEquals(expected, ConvertToDecade.LastDigitToZero(testCase));
    }

    @Test
    public void testTwo(){
        int expected = 7850;
        int testCase = 7857;
        assertEquals(expected, ConvertToDecade.LastDigitToZero(testCase));
    }

    @Test
    public void testThree(){
        int expected = 0;
        int testCase = 1;
        assertEquals(expected, ConvertToDecade.LastDigitToZero(testCase));
    }

    @Test
    public void testFour(){
        int expected = -1;
        int testCase = -42394203;
        assertEquals(expected, ConvertToDecade.LastDigitToZero(testCase));
    }

    @Test
    public void testFive(){
        int expected = 9827820;
        int testCase = 9827828;
        assertEquals(expected, ConvertToDecade.LastDigitToZero(testCase));
    }
}
