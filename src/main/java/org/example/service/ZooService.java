package org.example.service;

import org.example.data.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZooService {
    Zoo zoo;

    public ZooService(Zoo zoo) {
        this.zoo = zoo;
    }

    public void addZone() {

        Scanner newZoneNameInput = new Scanner(System.in);
        if (newZoneNameInput.hasNext()) {
            Zone newZone = new Zone(newZoneNameInput.next());
            zoo.addZone(newZone);
        }
        newZoneNameInput.close();
    }

    public void addAnimal() {

        Scanner newAnimalInput = new Scanner(System.in);

        if (newAnimalInput.hasNext()) {
            String animalDataString = newAnimalInput.next();
            String[] animalData = animalDataString.split(",");

            Lion newAnimal = new Lion(animalData[0], animalData[1]);
            zoo.addAnimal(newAnimal);
        }
        newAnimalInput.close();}


    public List<Animal> getAnimalsWithoutZone() {
        List<Animal> allAnimals = zoo.getListOfAnimals();

        List<Animal> animalsWithoutZone = new ArrayList<>();
        for (Animal animal: allAnimals) {
            if (animal.getZone() == null) {
                animalsWithoutZone.add(animal);
            }
        }
        return animalsWithoutZone;
    }

    public void assignAnimalToZone() {

        Scanner animalZoneInput = new Scanner(System.in);
        if (animalZoneInput.hasNext()) {
            String animalZone = animalZoneInput.next();

        String[] animalZoneData = animalZone.split(",");
        Animal animalToAssign = new Animal(animalZoneData[0], animalZoneData[1]);

        Zone zoneToAddAnimal = new Zone(animalZoneData[2]);
        zoneToAddAnimal.addAnimal(animalToAssign);
        animalToAssign.setZone(zoneToAddAnimal);
        }

        animalZoneInput.close();
    }
}
