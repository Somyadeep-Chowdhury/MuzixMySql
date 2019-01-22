package com.stackroute.muzixApplicationTask1.exceptions;

public class TrackDoNotExistsException extends Exception{
    private String message;

    public TrackDoNotExistsException(String message) {
        this.message = message;
    }
}
