package com.study.movieinfo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException{

    String reason;
   public  MovieNotFoundException(String reason)
    {
        this.reason=reason;
    }

    @Override
    public String toString() {
        return "MovieNotFoundException{" +
                "reason='" + reason + '\'' +
                '}';
    }
}
