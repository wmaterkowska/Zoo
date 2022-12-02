package org.example.data;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private Integer numberOfZones;
    private Integer numberOfAnimals;
    private List<Zone> listOfZones;
    private List<Animal> listOfAnimals;


    public Zoo() {
        this.numberOfZones = 0;
        this.numberOfAnimals = 0;
        this.listOfZones = new ArrayList<>();
        this.listOfAnimals = new ArrayList<>();
    }

    public Integer getNumberOfZones() { return numberOfZones; }

    public void setNumberOfZones(Integer numberOfZones) { this.numberOfZones = numberOfZones; }

    public Integer getNumberOfAnimals() { return numberOfAnimals; }

    public void setNumberOfAnimals(Integer numberOfAnimals) { this.numberOfAnimals = numberOfAnimals; }

    public List<Zone> getListOfZones() { return listOfZones; }

    public void setListOfZones(List<Zone> listOfZones) { this.listOfZones = listOfZones; }

    public List<Animal> getListOfAnimals() { return listOfAnimals; }

    public void setListOfAnimals(List<Animal> listOfAnimals) { this.listOfAnimals = listOfAnimals; }

    public void addZone(Zone zone) {
        this.listOfZones.add(zone);
    }


    public void addAnimal(Animal animal) {
        listOfAnimals.add(animal);
    }
}
