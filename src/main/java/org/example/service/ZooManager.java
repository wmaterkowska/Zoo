package org.example.service;

import org.example.data.Animal;
import org.example.data.Zone;
import org.example.data.Zoo;

import java.net.Socket;
import java.util.Scanner;

public class ZooService {

    private Zoo zoo;

    public void welcome() {
        System.out.println("Welcome to your Zoo.");
    }

    public void getStateOfTheZoo(){
        System.out.println("There are " + zoo.getNumberOfZones() + " zones at your Zoo.");
        System.out.println("There are " + zoo.getNumberOfAnimals() + " animals at your Zoo,");
        for (Zone zone : zoo.getListOfZones()) {
            System.out.println("where in: " + zone.getName() + " zone, there are "
                    + zone.getListOfAnimals().size() + " animals:");
            for (Animal animal : zone.getListOfAnimals()) {
                System.out.println(animal.getSpecies()+ " " + animal.getName());
            }
        }
    }


    public void mangingTheZoo() {
        System.out.println("If you want to add zone, write z.");
        System.out.println("If you want to add animal, write a.");

        Scanner input = new Scanner(System.in);
        if (input.hasNext()) {

        }
    }


}
