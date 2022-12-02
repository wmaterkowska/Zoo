package org.example;

import org.example.data.Zoo;
import org.example.service.ZooManager;

public class Main {
    public static void main(String[] args) {

        Zoo zoo = new Zoo();
        ZooManager manager = new ZooManager(zoo);

        manager.welcome();
        manager.getStateOfTheZoo();
        manager.mangingTheZoo();
        manager.getStateOfTheZoo();

        manager.goodBye();
    }
}