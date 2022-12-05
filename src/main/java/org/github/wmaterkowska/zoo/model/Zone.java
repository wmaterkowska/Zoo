package org.github.wmaterkowska.zoo.model;

import org.github.wmaterkowska.zoo.model.animals.Animal;
import exceptions.ExceededLimitOfFoodException;

import java.util.ArrayList;
import java.util.List;

public class Zone {

    private String name;
    private Integer amountOfFood;
    private final Integer maxAmountOfFood = 100;
    private List<Animal> listOfAnimals;


    public Zone(String name) {
        this.name = name;
        amountOfFood = 0;
        this.listOfAnimals = new ArrayList<>();
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getAmountOfFood() { return amountOfFood; }

    public void setAmountOfFood(Integer amountOfFood) { this.amountOfFood = amountOfFood; }

    public Integer getMaxAmountOfFood() { return maxAmountOfFood; }

    public List<Animal> getListOfAnimals() { return listOfAnimals; }

    public void setListOfAnimals(List<Animal> listOfAnimals) { this.listOfAnimals = listOfAnimals; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Zone zone = (Zone) obj;
        return zone.getName().equals(this.name);
    }


    public void addAnimal(Animal animal) throws ExceededLimitOfFoodException {
        if (this.amountOfFood + animal.getAmountOfFood() <= maxAmountOfFood) {
            this.amountOfFood += animal.getAmountOfFood();
            this.listOfAnimals.add(animal);
        } else {
            throw new ExceededLimitOfFoodException("The maximum amount of food for this zone was exceeded.");
        }
    }
}
