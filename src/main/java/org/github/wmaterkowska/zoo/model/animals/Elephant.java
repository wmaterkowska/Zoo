package org.github.wmaterkowska.zoo.model.animals;

public class Elephant extends Animal implements feeding {

    public Elephant(String species, String name ) {
        super(species, name);
        setAmountOfFood(20);
    }

    @Override
    public void setAmountOfFood() {
        setAmountOfFood(20);
    }
}