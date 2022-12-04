package org.github.wmaterkowska.zoo.model.animals;

import org.github.wmaterkowska.zoo.model.Zone;

public class Animal {

    private String species;
    private String name;
    private Integer amountOfFood;
    private Zone zone;

    public Animal(String species, String name) {
        this.species = species;
        this.name = name;
        this.amountOfFood = 0;
    }


    public String getSpecies() { return species; }

    public void setSpecies(String species) { this.species = species; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getAmountOfFood() { return amountOfFood; }

    public void setAmountOfFood(Integer amountOfFood) { this.amountOfFood = amountOfFood; }

    public Zone getZone() { return zone; }

    public void setZone(Zone zone) { this.zone = zone; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Animal animal = (Animal) obj;
        if (animal.getSpecies().equals(this.species) && animal.getName().equals(this.name)) {
            return true;
        }
        return false;
    }

}
