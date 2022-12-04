package org.github.wmaterkowska.zoo.service;

import org.github.wmaterkowska.zoo.model.animals.Animal;
import org.github.wmaterkowska.zoo.model.Zone;
import org.github.wmaterkowska.zoo.model.Zoo;

import java.util.List;
import java.util.Scanner;

public class ZooManager {

    private Zoo zoo;
    private ZooService zooService;

    public ZooManager(Zoo zoo) {
        this.zoo = zoo;
        this.zooService = new ZooService(zoo);
    }

    public void welcome() {
        System.out.println("Welcome to your Zoo.");
    }

    public void getStateOfTheZoo() {
        System.out.println("There are " + zoo.getListOfZones().size() + " zones at your Zoo.");
        System.out.println("There are " + zoo.getListOfAnimals().size() + " animals at your Zoo,");

        List<Zone> zones = zoo.getListOfZones();
        if (zones == null || zones.isEmpty()) {
            System.out.println("you need zones and animals at your Zoo!");
            System.out.println();
        } else {
            for (int nrOfZone = 0; nrOfZone < zoo.getListOfZones().size(); nrOfZone++) {
                System.out.println("where in: " + zones.get(nrOfZone).getName() + " zone, there are "
                        + zones.get(nrOfZone).getListOfAnimals().size() + " animals");
                for (Animal animal : zones.get(nrOfZone).getListOfAnimals()) {
                    System.out.println(animal.getSpecies() + " " + animal.getName());
                }
            }
        }
    }


    private void printListOfChoices() {
        System.out.println();
        System.out.println("If you want to add zone write '1'.");
        System.out.println("If you want to add animal write '2'.");
        System.out.println("If you want to check if all animals have assigned a zone write '3'");
        System.out.println("If you want to assign animal to the zone write '4' ");
        System.out.println("If you want to see the state of the Zoo, write '5'.");
        System.out.println("If you want to exit write '6'.");
    }

    public void mangingTheZoo() {

        Scanner input = new Scanner(System.in);

        while (true) {
            printListOfChoices();
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.println("Write a name of a new zone:");
                zooService.addZone();
                System.out.println("The new zone was created.");
            } else if (choice == 2) {
                System.out.println("Write a species and name of a new animal, for example: lion,Simba");
                zooService.addAnimal();
                System.out.println("You have new animal at the Zoo.");
            } else if (choice == 3) {
                showAnimalsWithoutZone();
            } else if (input.nextInt() == 4) {
                System.out.println("Write animal which you want to assign and the zone, eg. lion,Simba,savanna");
                zooService.assignAnimalToZone();
            } else if (choice == 5 ) {
                getStateOfTheZoo();
            } else if (choice == 6) {
                break;
            } else {
                System.out.println("Incorrect input");
                printListOfChoices();
            }
        }
        input.close();
    }

    public void showAnimalsWithoutZone() {
        List<Animal> animalsWithoutZone = zooService.getAnimalsWithoutZone();

        if (animalsWithoutZone.isEmpty()) {
            System.out.println("All animals have assigned a zone.");
        } else {
            System.out.println("Animals who does not have assigned a zone:");
            for (Animal animal : animalsWithoutZone) {
                System.out.println(animal.getSpecies() + " " + animal.getName());
            }
        }
    }

    public void goodBye() {
        System.out.println("You are leaving the Zoo. Good Bye.");
    }


}
