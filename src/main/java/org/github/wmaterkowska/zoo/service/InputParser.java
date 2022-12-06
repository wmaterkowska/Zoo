package org.github.wmaterkowska.zoo.service;

import exceptions.UnknownSpeciesException;
import org.github.wmaterkowska.zoo.model.Zone;
import org.github.wmaterkowska.zoo.model.animals.Animal;
import org.github.wmaterkowska.zoo.model.animals.Elephant;
import org.github.wmaterkowska.zoo.model.animals.Lion;
import org.github.wmaterkowska.zoo.model.animals.Rabbit;

import java.util.Scanner;

public class InputParser {

    private Scanner input;

    /**
     * Method to scan for user input for a zone (zone name) and create a new zone.
     * @return Zone newZone
     */
    public Zone parseZone() {
        input = new Scanner(System.in);
        Zone newZone;
        if (input.hasNext()) {
            newZone = new Zone(input.next());
        } else {
            throw new IllegalArgumentException();
        }

        return newZone;
    }


    /**
     * Method to scan for user input for an animal (animal species and name) and create a new animal. If the
     * species given is unknown (different from: lion, elephant or rabbit), it throws an exception.
     * @return Animal newAnimal
     * @throws UnknownSpeciesException
     */
    public Animal parseAnimal() throws UnknownSpeciesException {
        input = new Scanner(System.in);

        Animal newAnimal = null;

        if (input.hasNext()) {
            String animalDataString = input.next();
            String[] animalData = animalDataString.split(",");
            if (animalData.length == 2) {
                if (animalData[0].equals("lion")) {
                    newAnimal = new Lion(animalData[0], animalData[1]);
                } else if (animalData[0].equals("elephant")) {
                    newAnimal = new Elephant(animalData[0], animalData[1]);
                } else if (animalData[0].equals("rabbit")) {
                    newAnimal = new Rabbit(animalData[0], animalData[1]);
                } else {
                    throw new UnknownSpeciesException("Unknown species.");
                }
            } else {
                throw new IllegalArgumentException("Animal entry must have 2 fields.");
            }
        }
        return newAnimal;
    }


    /**
     * Method to scan for user input for a name of a searched animal.
     * @return String nameOfAnimal
     */
    public String parseNameOfAnimal() {
        input = new Scanner(System.in);

        String nameOfAnimal;
        if (input.hasNext()) {
            nameOfAnimal = input.next();
        } else {
            throw new IllegalArgumentException();
        }
        return nameOfAnimal;
    }
}
