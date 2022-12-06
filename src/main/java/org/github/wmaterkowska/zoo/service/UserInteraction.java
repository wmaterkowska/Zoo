package org.github.wmaterkowska.zoo.service;

import exceptions.ExceededLimitOfFoodException;
import exceptions.UnknownSpeciesException;
import exceptions.ZoneAlreadyExistsException;
import org.github.wmaterkowska.zoo.model.animals.Animal;
import org.github.wmaterkowska.zoo.model.Zone;
import org.github.wmaterkowska.zoo.model.Zoo;

import java.util.List;
import java.util.Scanner;

public class UserInteraction {

    private final Zoo zoo;
    private final ZooService zooService;

    public UserInteraction(Zoo zoo) {
        this.zoo = zoo;
        this.zooService = new ZooService(zoo);
    }

    /**
     * Welcome message.
     */
    public void welcome() {
        System.out.println("Welcome to your Zoo.");
    }

    /**
     * Method gives the state of the zoo: how many zones and how many animals is in the zoo,
     * and which animal is in which zone.
     */
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


    /**
     * List od choices for user to manage the zoo.
     */
    private void printListOfChoices() {
        System.out.println();
        System.out.println("If you want to add zone write '1'. ");
        System.out.println("If you want to add animal write '2'. ");
        System.out.println("If you want to check if all animals have assigned a zone write '3'. ");
        System.out.println("If you want to assign animal to the zone write '4'. ");
        System.out.println("If you want to see the state of the Zoo, write '5'. ");
        System.out.println("If you want to get animals for one zone, write '6'. ");
        System.out.println("If you want to find animal with name, write '7'. ");
        System.out.println("If you want a Report, which zone need the most feed, write '8'. ");
        System.out.println("If you want a Report, in which zone is the least animals, write '9'. ");
        System.out.println("If you want to exit write '0'.");
    }

    /**
     * Main method for managing the zoo. It checks the user choice what to do (based on the list) and calls
     * the appropriate methods from ZooService Class.
     * @throws ExceededLimitOfFoodException
     * @throws UnknownSpeciesException
     * @throws ZoneAlreadyExistsException
     */
    public void mangingTheZoo() throws ExceededLimitOfFoodException, UnknownSpeciesException, ZoneAlreadyExistsException {

        Scanner input = new Scanner(System.in);
        InputParser parser = new InputParser();

        while (true) {
            printListOfChoices();
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.println("Write a name of a new zone:");
                zooService.addZone(parser.parseZone());
                System.out.println("The new zone was created.");
            } else if (choice == 2) {
                System.out.println("Write a species and name of a new animal, for example: lion,Simba");
                zooService.addAnimal(parser.parseAnimal());
                System.out.println("You have new animal at the Zoo.");
            } else if (choice == 3) {
                showAnimalsWithoutZone();
            } else if (choice == 4) {
                System.out.println("Write animal which you want to assign, eg. lion,Simba");
                Animal animalToAssign = parser.parseAnimal();
                System.out.println("Write zone to which you want to assign the animal, eg. savanna");
                Zone zoneToAddAnimal = parser.parseZone();
                zooService.assignAnimalToZone(animalToAssign, zoneToAddAnimal);
            } else if (choice == 5 ) {
                getStateOfTheZoo();
            } else if (choice == 6 ) {
                System.out.println("Write the name of the zone, for which you want to see animals.");
                Zone zone = parser.parseZone();
                System.out.println(zooService.getAnimalsForZone(zone));
            } else if (choice == 7 ) {
                System.out.println("Write the name of animal you want to find.");
                String name = parser.parseNameOfAnimal();
                System.out.println(zooService.getAnimalWithName(name));
            } else if (choice == 8 ) {
                String nameOfTheZone = zooService.getZoneWithMaxAmountOfFood().getName();
                System.out.println("The zone, which needs the most feed: " + nameOfTheZone + "." );
            } else if (choice == 9 ) {
                String nameOfTheZone = zooService.getZoneWIthMinAnimals().getName();
                System.out.println("the zone with the fewest animals: " + nameOfTheZone + ".");
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Incorrect input");
                printListOfChoices();
            }
        }
        input.close();
    }

    private void showAnimalsWithoutZone() {
        List<Animal> animalsWithoutZone = zooService.getAnimalsWithoutZone();

        if (zoo.getListOfAnimals().isEmpty()) {
            System.out.println("There are no animals in your zoo.");
        } else {

            if (animalsWithoutZone.isEmpty()) {
                System.out.println("All animals have assigned zone.");
            } else {
                System.out.println("Animals who does not have assigned zone:");
                for (Animal animal : animalsWithoutZone) {
                    System.out.println(animal.getSpecies() + " " + animal.getName());
                }
            }
        }
    }

    /**
     * Goodbye message.
     */
    public void goodBye() {
        System.out.println();
        System.out.println("You are leaving the Zoo. Good Bye.");
    }


}
