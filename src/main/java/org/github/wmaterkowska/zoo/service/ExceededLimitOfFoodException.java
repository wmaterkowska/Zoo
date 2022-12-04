package org.github.wmaterkowska.zoo.service;

public class ExceededLimitOfFoodException extends Exception{
    public ExceededLimitOfFoodException(String errorMessage) {
        super(errorMessage);
    }
}
