package com.study.movieinfo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.movieinfo.exception.MovieNotFoundException;
import com.study.movieinfo.model.MovieDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RestController
public class MovieInfoController {

    MovieBuilder movieBuilder;

    @Autowired
    void MovieInfoController(MovieBuilder movieBuilder)
    {
        System.out.println("Constructing the movie data database");
        this.movieBuilder = movieBuilder;
        movieBuilder.buildMovieDatabase();
    }

    @RequestMapping("/details")
    public List getMovieDetail() throws JsonProcessingException {
        return movieBuilder.getMovieDetails();
    }

    @RequestMapping("/details/{movieID}")
    public MovieDetail getSpecificMovie(@PathVariable("movieID") String movieid) throws Exception {
        try {
            Optional<MovieDetail> retVal = Optional.of(movieBuilder.getMovieDetails(movieid));
            return (retVal.get());
        }
        catch (NullPointerException nux)
        {
            throw new MovieNotFoundException("Cannot find movie ID = "+movieid);
        }
    }
}
