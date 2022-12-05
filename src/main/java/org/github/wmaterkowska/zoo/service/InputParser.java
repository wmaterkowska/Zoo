package org.github.wmaterkowska.zoo.service;

import exceptions.UnknownSpeciesException;
import org.github.wmaterkowska.zoo.model.Zone;
import org.github.wmaterkowska.zoo.model.animals.Animal;
import org.github.wmaterkowska.zoo.model.animals.Elephant;
import org.github.wmaterkowska.zoo.model.animals.Lion;
import org.github.wmaterkowska.zoo.model.animals.Rabbit;

import java.util.Scanner;

public class InputParser {

    Scanner input;

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
