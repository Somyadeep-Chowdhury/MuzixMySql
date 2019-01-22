package com.stackroute.muzixApplicationTask1.exceptions;

public class EmptyListException extends Exception{
    private String message;

    public EmptyListException(String message) {
        this.message = message;
    }
}
