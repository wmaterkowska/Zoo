package org.github.wmaterkowska.zoo.model.animals;

public class Elephant extends Animal {

    public Elephant(String species, String name ) {
        super(species, name);
        setAmountOfFood(20);
    }

    @Override
    public void setAmountOfFood() {
        setAmountOfFood(20);
    }
}
