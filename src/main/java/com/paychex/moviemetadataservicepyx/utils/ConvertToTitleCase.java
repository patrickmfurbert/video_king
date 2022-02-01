package com.paychex.moviemetadataservicepyx.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.paychex.moviemetadataservicepyx.data.MovieMetadata;

/*
*For time consideration and simplicity 
(I am making an assumption on Title Case Rules
*(order of priority… those first on the list are higher priority): 
*Capitalize First and Last words
*Capitalize words four letters or longer
*Will seperate on spaces
*Lower case “a”, “an”, “the”, “and”, “but”, “for”, “at”, “by”, to”, "is", "it", "of"
*/
public class ConvertToTitleCase {

    /*******Stream Processing********/
    public static List<MovieMetadata> processMovies(List<MovieMetadata> movies){
        if(movies == null || movies.size() == 0){
            return null;
        }

        return movies
        .stream() 
        .map((movie) -> ConvertToTitleCase.processMovie(movie))
        .collect(Collectors.toList());
    }

    private static MovieMetadata processMovie(MovieMetadata movie){
        String title = movie.getTitle();
        movie.setTitle(toTitleCase(title));
        return movie;
    }
    
    public static String toTitleCase(String title){

        // Check the length of the string
        if(title == null || title.length() == 0){
            return null;
        }

        //create lower case words ArrayList<string>
        ArrayList<String> lower_case_words = new ArrayList<>(Arrays.asList("a", "an", "the", "and", "but", "for", "at", "by", "to", "in", "is", "it", "of"));

         // create String Builder
        StringBuilder sb = new StringBuilder(title.length());

        // split array on space
        String[] movie_title = title.split(" ");

        // build the new string
        for(int i = 0; i < movie_title.length; i++){
            if(i == 0 || i == movie_title.length-1 || movie_title[i].length() >= 4){
                ConvertToTitleCase.uppercaseFirstLetter(sb, movie_title[i]);
            }else{
                if(lower_case_words.contains(movie_title[i].toLowerCase())){
                    sb.append(movie_title[i].toLowerCase());
                }else{
                    ConvertToTitleCase.uppercaseFirstLetter(sb, movie_title[i]);
                }
            }
            if(i != movie_title.length-1){
                //add space between words
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private static void uppercaseFirstLetter(StringBuilder sb, String word){
        //takes the first letter and converts to upper case
        //appending the result to the string builder
        sb.append(Character.toUpperCase(word.charAt(0)));

        //takes the remaining part of the string converting it to lower
        //case, appending the result to the string builder
        sb.append(word.substring(1).toLowerCase());
    }

}
