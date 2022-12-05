package org.github.wmaterkowska.zoo.service;

import exceptions.ExceededLimitOfFoodException;
import exceptions.ZoneAlreadyExistsException;
import org.github.wmaterkowska.zoo.model.animals.Animal;
import org.github.wmaterkowska.zoo.model.Zone;
import org.github.wmaterkowska.zoo.model.Zoo;

import java.util.*;
import java.util.stream.Collectors;

public class ZooService {
    Zoo zoo;

    public ZooService(Zoo zoo) {
        this.zoo = zoo;
    }

    public void addZone(Zone newZone) throws ZoneAlreadyExistsException {
        if (zoo.getListOfZones().contains(newZone)) {
            throw new ZoneAlreadyExistsException("Zone " + newZone + " already exists.");
        } else {
            this.zoo.addZone(newZone);
        }
    }

    public void addAnimal(Animal newAnimal) {

        if (zoo.getListOfAnimals().contains(newAnimal)) {
            throw new IllegalStateException("Animal " + newAnimal + " already exists.");
        } else {
            this.zoo.addAnimal(newAnimal);
        }
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

    public List<Animal> getAnimalsForZone(Zone zone) {
        List<Animal> animalsOfTheZone = zone.getListOfAnimals();
        return animalsOfTheZone;
    }

    public List<Animal> getAnimalWithName(String name) {
        List<Animal> listOfAnimalsWithName = new ArrayList<>();

        for (Animal animal : zoo.getListOfAnimals())  {
            if (animal.getName().equals(name) ) {
                listOfAnimalsWithName.add(animal);
            }
        }
        return listOfAnimalsWithName;
    }

    public Zone getZoneWithMaxAmountOfFood() {
        Map<Zone, Integer> mapZoneAmountOfFood = new HashMap<>();
        for (Zone zone : zoo.getListOfZones()) {
            mapZoneAmountOfFood.put(zone, zone.getAmountOfFood());
        }
        Integer maxAmount = mapZoneAmountOfFood.values().stream().max(Integer::compare).get();

        return mapZoneAmountOfFood.entrySet().stream().filter(entry -> maxAmount.equals(entry.getValue()))
                .map(Map.Entry::getKey).findFirst().get();
    }

    public Zone getZoneWIthMinAnimals() {
        Map<Zone, Integer> mapZoneNumberOfAnimals = new HashMap<>();
        for (Zone zone : zoo.getListOfZones()) {
            mapZoneNumberOfAnimals.put(zone, zone.getListOfAnimals().size());
        }
        Integer minNUmber = mapZoneNumberOfAnimals.values().stream().min(Integer::compare).get();

        return mapZoneNumberOfAnimals.entrySet().stream().filter(entry -> minNUmber.equals(entry.getValue()))
                .map(Map.Entry::getKey).findFirst().get();
    }

}
