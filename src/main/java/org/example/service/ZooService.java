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

        System.out.println("Write a name of a new zone:");

        Scanner newZoneNameInput = new Scanner(System.in);
        if (newZoneNameInput.hasNext()) {
            Zone newZone = new Zone(newZoneNameInput.next());
            zoo.addZone(newZone);
            System.out.println("The new zone was created.");
        }
        newZoneNameInput.close();
    }

    public void addAnimal() {

        System.out.println("Write a species and name of a new animal, for example: "
        + "lion Simba");

        Scanner newAnimalInput = new Scanner(System.in);

        if (newAnimalInput.hasNext()) {
            String animalDataString = newAnimalInput.next();
            String[] animalData = animalDataString.split(" ");

            Lion newAnimal = new Lion(animalData[0], animalData[1]);
            zoo.addAnimal(newAnimal);
            System.out.println("You have new animal at the Zoo.");
        }
        newAnimalInput.close();
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
        System.out.println("Write animal which you want to assign and the zone, eg. lion Simba SavannaZone");

        Scanner animalZoneInput = new Scanner(System.in);
        String animalZone = "";
        if ( animalZoneInput.hasNext()) {
            animalZone = animalZoneInput.next();
        }

        String[] animalZoneData = animalZone.split(" ");
        Animal animalToAssign = new Animal(animalZoneData[0], animalZoneData[1]);

        Zone zoneToAddAnimal = new Zone(animalZoneData[2]);
        zoneToAddAnimal.addAnimal(animalToAssign);

    }
}
