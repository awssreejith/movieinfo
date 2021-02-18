package com.study.movieinfo;

import com.study.movieinfo.model.MovieDetail;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MovieBuilder {

    private HashMap<String, MovieDetail> movieDB = new HashMap<>();
    public void buildMovieDatabase()
    {
        String id = UUID.randomUUID().toString();
        movieDB.put(id,new MovieDetail(id,"Titanic", "Thriller Movie"));

        id = UUID.randomUUID().toString();
        movieDB.put(id,new MovieDetail(id,"Big Fish", "Drama Movie"));

        id = UUID.randomUUID().toString();
        movieDB.put(id,new MovieDetail(id,"Naked Gun", "Comedy Movie"));

        id = UUID.randomUUID().toString();
        movieDB.put(id,new MovieDetail(id,"Exorcist", "Horror Movie"));

        id = UUID.randomUUID().toString();
        movieDB.put(id,new MovieDetail(id,"Predator", "Action Movie"));
    }

    public List getMovieDetails()
    {
        return Arrays.asList(movieDB.values().toArray());

    }

    public MovieDetail getMovieDetails(String movieId)
    {
        return (movieDB.get(movieId));

    }
}
