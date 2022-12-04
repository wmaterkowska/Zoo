package org.github.wmaterkowska.zoo.service;

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
        Zone newZone = null;
        if (input.hasNext()) {
            newZone = new Zone(input.next());
        } else {
            // TODO : throw exception if zone is null IlligalArgumentException
        }

        return newZone;
    }


    public Animal parseAnimal() {
        input = new Scanner(System.in);

        Animal newAnimal = null;

        if (input.hasNext()) {
            String animalDataString = input.next();
            String[] animalData = animalDataString.split(",");
        // TODO : throw exception if array shorter than 2
            if (animalData[0].equals("lion") ) {
                newAnimal = new Lion(animalData[0], animalData[1]);
            } else if (animalData[0].equals("elephant") ) {
                newAnimal = new Elephant(animalData[0], animalData[1]);
            } else if (animalData[0].equals("rabbit") ) {
                newAnimal = new Rabbit(animalData[0], animalData[1]);
            } else {
                newAnimal = null;
                // TODO: exception Unknown Spicies
            }
        }
        return newAnimal;
    }


    public String parseName() {

        return "name";
    }
}
