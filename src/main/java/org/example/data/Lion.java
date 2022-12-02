package org.example.data;

public class Lion extends Animal implements feeding {


    public Lion(String species, String name) {
        super(species, name);
        setAmountOfFood(11);
    }

    @Override
    public void setAmountOfFood() {
        setAmountOfFood(11);
    }
}
