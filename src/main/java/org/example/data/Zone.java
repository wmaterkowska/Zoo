package org.example.data;

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
        if (zone.getName().equals(this.name)) {
            return true;
        }
        return false;
    }


    public void addAnimal(Animal animal) {
        this.amountOfFood += animal.getAmountOfFood();
        if (this.amountOfFood <= maxAmountOfFood) {
            this.listOfAnimals.add(animal);
        } else {
            System.out.println("PrzekroczonyLimitJedzeniaException");
        }

    }
}
