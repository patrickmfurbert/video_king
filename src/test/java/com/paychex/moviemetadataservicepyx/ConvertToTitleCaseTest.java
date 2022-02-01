package com.paychex.moviemetadataservicepyx;


import com.paychex.moviemetadataservicepyx.data.MovieMetadata;
import java.util.ArrayList;
import java.util.List;
import com.paychex.moviemetadataservicepyx.utils.ConvertToTitleCase;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

// Testing Public Methods of ConvertToTitleCase.java
@SpringBootTest
public class ConvertToTitleCaseTest {

    // test processMovies
    @Test
    public void testProcessMovies(){

        // MovieMetadata
        MovieMetadata movie_one = new MovieMetadata("one", 1,  null, null);
        MovieMetadata movie_two = new MovieMetadata("two", 2,  null, null);
        MovieMetadata movie_three = new MovieMetadata("three", 3,  null, null);

        // Create Lists of metadata
        List<MovieMetadata> movies_null = null;
        List<MovieMetadata> movies = new ArrayList<MovieMetadata>();

        assertNull(ConvertToTitleCase.processMovies(movies_null));
        assertNull(ConvertToTitleCase.processMovies(movies));

        // add metadata
        movies.add(movie_one);
        movies.add(movie_two);
        movies.add(movie_three);

        assertNotNull(ConvertToTitleCase.processMovies(movies));

    }
    
    // test toTitleCase
    @Test
    public void testToTitleCase(){

        String empty = null;
        assertNull(ConvertToTitleCase.toTitleCase(empty), "toTitleCase should return null on string of null");

        empty = "";
        assertNull(ConvertToTitleCase.toTitleCase(empty), "toTitleCase should return null on string of size zero");

        String numbers = "12345";
        assertEquals(numbers.compareTo("12345"), 0, "toTitleCase should return" + numbers);

        String test = "u123FF";
        String expected = "U123ff";
        assertEquals(expected.compareTo(ConvertToTitleCase.toTitleCase(test)), 0, "toTitleCase should return" + expected);

        test = "fIRST A AN THE AND BUT FOR AT BY TO IN IS IT OF lAST";
        expected ="First a an the and but for at by to in is it of Last";
        assertEquals(expected.compareTo(ConvertToTitleCase.toTitleCase(test)), 0, "toTitleCase should return" + expected);

        test = "`~!@#$%^&*()-_=+{}:;<>,./?";
        expected ="`~!@#$%^&*()-_=+{}:;<>,./?";
        assertEquals(expected.compareTo(ConvertToTitleCase.toTitleCase(test)), 0, "toTitleCase should return" + expected);

        test = ",,the ,road ,not ,taken";
        expected =",,the ,road ,not ,taken";
        assertEquals(expected.compareTo(ConvertToTitleCase.toTitleCase(test)), 0, "toTitleCase should return" + expected);

    }

}
