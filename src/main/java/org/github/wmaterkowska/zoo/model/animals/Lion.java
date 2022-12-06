package org.github.wmaterkowska.zoo.model.animals;

public class Lion extends Animal {


    public Lion(String species, String name) {
        super(species, name);
        setAmountOfFood(11);
    }

    @Override
    public void setAmountOfFood() {
        setAmountOfFood(11);
    }
}
