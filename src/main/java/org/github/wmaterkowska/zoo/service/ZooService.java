package org.github.wmaterkowska.zoo.service;

import exceptions.ExceededLimitOfFoodException;
import exceptions.ZoneAlreadyExistsException;
import org.github.wmaterkowska.zoo.model.animals.Animal;
import org.github.wmaterkowska.zoo.model.Zone;
import org.github.wmaterkowska.zoo.model.Zoo;

import java.util.*;
import java.util.stream.Collectors;

public class ZooService {
    private Zoo zoo;

    public ZooService(Zoo zoo) {
        this.zoo = zoo;
    }

    /**
     * Method adds new zone to the zoo. If the zone with the same name exists throws exception.
     * @param newZone
     * @throws ZoneAlreadyExistsException
     */
    public void addZone(Zone newZone) throws ZoneAlreadyExistsException {
        if (zoo.getListOfZones().contains(newZone)) {
            throw new ZoneAlreadyExistsException("Zone " + newZone + " already exists.");
        } else {
            this.zoo.addZone(newZone);
        }
    }

    /**
     * Method adds new animal to the zoo. If the animal with the same species and name exists throw exception.
     * @param newAnimal
     */
    public void addAnimal(Animal newAnimal) {

        if (zoo.getListOfAnimals().contains(newAnimal)) {
            throw new IllegalStateException("Animal " + newAnimal + " already exists.");
        } else {
            this.zoo.addAnimal(newAnimal);
        }
    }

    /**
     * Method returns list of animals that are not assigned to any zone.
     * @return List of animals without zone.
     */
    public List<Animal> getAnimalsWithoutZone() {

        List<Animal> animalsWithoutZone = zoo.getListOfAnimals().stream()
                .filter(a -> a.getZone() == null).collect(Collectors.toList());

        return animalsWithoutZone;
    }

    /**
     * Method assign existing animal to the existing zone. If, by adding the animal, the amount of feed needed for the
     * zone will exceed 100 units, method will throw exception.
     * @param animalToAssign
     * @param zoneToAddAnimal
     * @throws ExceededLimitOfFoodException
     */
    public void assignAnimalToZone(Animal animalToAssign, Zone zoneToAddAnimal) throws ExceededLimitOfFoodException {

        Animal foundAnimal = zoo.getListOfAnimals().stream()
                .filter(a -> a.getSpecies().equals(animalToAssign.getSpecies()) && a.getName().equals(animalToAssign.getName()) )
                .findFirst().orElseThrow(NoSuchElementException::new);
        Zone foundZone = zoo.getListOfZones().stream()
                .filter(z -> z.getName().equals(zoneToAddAnimal.getName())).findFirst().orElseThrow(NoSuchElementException::new);

        foundAnimal.setZone(foundZone);
        foundZone.addAnimal(foundAnimal);

    }

    /**
     * Method finds all animals from given zone.
     * @param zone
     * @return List of animals living in the given zone.
     */
    public List<Animal> getAnimalsForZone(Zone zone) {
        List<Animal> animalsOfTheZone = new ArrayList<>();
        if (zoo.getListOfZones().isEmpty()) {
            throw new NoSuchElementException("There are no zones in your zoo");
        } else {
             animalsOfTheZone = zone.getListOfAnimals();
        }
        return animalsOfTheZone;
    }

    /**
     * Method finds all animals with given name.
     * @param name
     * @return List of animals which has the given name.
     */
    public List<Animal> getAnimalWithName(String name) {
        List<Animal> listOfAnimalsWithName = new ArrayList<>();

        for (Animal animal : zoo.getListOfAnimals())  {
            if (animal.getName().equals(name) ) {
                listOfAnimalsWithName.add(animal);
            }
        }
        return listOfAnimalsWithName;
    }

    /**
     * Method finds the zone which needs the highest amount of feed.
     * @return Zone which needs the highest amount of feed.
     */
    public Zone getZoneWithMaxAmountOfFood() {
        Map<Zone, Integer> mapZoneAmountOfFood = new HashMap<>();
        if (zoo.getListOfZones().isEmpty()) {
            throw new NoSuchElementException("There are no zones in your zoo.");
        } else {
            for (Zone zone : zoo.getListOfZones()) {
                mapZoneAmountOfFood.put(zone, zone.getAmountOfFood());
            }
            Integer maxAmount = mapZoneAmountOfFood.values().stream().max(Integer::compare).get();

            return mapZoneAmountOfFood.entrySet().stream().filter(entry -> maxAmount.equals(entry.getValue()))
                    .map(Map.Entry::getKey).findFirst().get();
        }
    }

    /**
     * Method finds the zone, where live the lowest number of animals.
     * @return Zone with the least animals.
     */
    public Zone getZoneWIthMinAnimals() {
        Map<Zone, Integer> mapZoneNumberOfAnimals = new HashMap<>();
        if (zoo.getListOfZones().isEmpty()) {
            throw new NoSuchElementException("There are no zones in your zoo.");
        } else {
            for (Zone zone : zoo.getListOfZones()) {
                mapZoneNumberOfAnimals.put(zone, zone.getListOfAnimals().size());
            }
            Integer minNUmber = mapZoneNumberOfAnimals.values().stream().min(Integer::compare).get();

            return mapZoneNumberOfAnimals.entrySet().stream().filter(entry -> minNUmber.equals(entry.getValue()))
                    .map(Map.Entry::getKey).findFirst().get();
        }
    }

}
