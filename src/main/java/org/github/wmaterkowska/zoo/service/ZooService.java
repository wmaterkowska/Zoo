package org.github.wmaterkowska.zoo.service;

import org.github.wmaterkowska.zoo.model.animals.Animal;
import org.github.wmaterkowska.zoo.model.animals.Elephant;
import org.github.wmaterkowska.zoo.model.animals.Lion;
import org.github.wmaterkowska.zoo.model.Zone;
import org.github.wmaterkowska.zoo.model.Zoo;
import org.github.wmaterkowska.zoo.model.animals.Rabbit;

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
            this.zoo.addZone(newZone);
        }
        // newZoneNameInput.close();
    }

    public void addAnimal() {

        Scanner newAnimalInput = new Scanner(System.in);

        if (newAnimalInput.hasNext()) {
            String animalDataString = newAnimalInput.next();
            String[] animalData = animalDataString.split(",");

            Animal newAnimal;
            if (animalData[0].equals("lion") ) {
                newAnimal = new Lion(animalData[0], animalData[1]);
            } else if (animalData[0].equals("elephant") ) {
                newAnimal = new Elephant(animalData[0], animalData[1]);
            } else if (animalData[0].equals("rabbit") ) {
                newAnimal = new Rabbit(animalData[0], animalData[1]);
            } else {
                newAnimal = null;
            }
            this.zoo.addAnimal(newAnimal);
        }
        // newAnimalInput.close();
    }


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

        zoo.updateAnimalZone(animalToAssign, zoneToAddAnimal);
        }

        // animalZoneInput.close();
    }
}
