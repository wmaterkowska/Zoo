package org.github.wmaterkowska.zoo.model.animals;

public class Rabbit extends Animal {

    public Rabbit(String species, String name) {
        super(species, name);
        setAmountOfFood(4);
    }

    @Override
    public void setAmountOfFood() {

        setAmountOfFood(4);
    }
}
