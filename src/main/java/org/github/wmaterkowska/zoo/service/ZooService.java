package org.github.wmaterkowska.zoo.service;

import org.github.wmaterkowska.zoo.model.animals.Animal;
import org.github.wmaterkowska.zoo.model.Zone;
import org.github.wmaterkowska.zoo.model.Zoo;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ZooService {
    Zoo zoo;

    public ZooService(Zoo zoo) {
        this.zoo = zoo;
    }

    public void addZone(Zone newZone) {
        // TODO: check if zone exists, exception
        this.zoo.addZone(newZone);
    }

    public void addAnimal(Animal newAnimal) {
        // TODO: check if animal exists, exception WrongStateExceprion
        // throw new IllegalStateException("The animal already exists.");

        this.zoo.addAnimal(newAnimal);
    }


    public List<Animal> getAnimalsWithoutZone() {

        List<Animal> animalsWithoutZone = zoo.getListOfAnimals().stream()
                .filter(a -> a.getZone() == null).collect(Collectors.toList());

        return animalsWithoutZone;
    }

    public void assignAnimalToZone(Animal animalToAssign, Zone zoneToAddAnimal) throws ExceededLimitOfFoodException {

        Animal foundAnimal = zoo.getListOfAnimals().stream()
                .filter(a -> a.getSpecies().equals(animalToAssign.getSpecies()) && a.getName().equals(animalToAssign.getName()) )
                .findFirst().orElseThrow(NoSuchElementException::new);
        Zone foundZone = zoo.getListOfZones().stream()
                .filter(z -> z.getName().equals(zoneToAddAnimal.getName())).findFirst().orElseThrow(NoSuchElementException::new);

        foundAnimal.setZone(foundZone);
        foundZone.addAnimal(foundAnimal);

    }

    public void getAnimalsForZone(Zone zone) {
        zone.getListOfAnimals();
    }

    public void getAnimalWithName(String name) {
        for (Animal animal : zoo.getListOfAnimals())  {

        }

    }

    public void getRaportFeeding() {
    }

    public void getRaportAnimals() {
    }
}
