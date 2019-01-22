package com.stackroute.muzixApplicationTask1.globalexception;

import com.stackroute.muzixApplicationTask1.exceptions.EmptyListException;
import com.stackroute.muzixApplicationTask1.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixApplicationTask1.exceptions.TrackDoNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Track already exists")
    @ExceptionHandler(TrackAlreadyExistsException.class)
    public void handleTrackAlreadyExistsException(TrackAlreadyExistsException e){
        System.out.println("Track already exists");
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="No track found")
    @ExceptionHandler(TrackDoNotExistsException.class)
    public void handleNoTrackExistsException(TrackDoNotExistsException e){
        System.out.println("trcak not found");
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Empty List found")
    @ExceptionHandler(EmptyListException.class)
    public void handleEmptyFieldException(EmptyListException e){
        System.out.println("track not found");

    }

}
