package org.example.data;

public class Rabbit extends Animal implements feeding{

    public Rabbit(String species, String name) {
        super(species, name);
        setAmountOfFood(4);
    }

    @Override
    public void setAmountOfFood() {

        setAmountOfFood(4);
    }
}
