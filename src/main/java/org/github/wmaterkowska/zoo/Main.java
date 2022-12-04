package org.github.wmaterkowska.zoo;

import org.github.wmaterkowska.zoo.model.Zoo;
import org.github.wmaterkowska.zoo.service.ZooManager;

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