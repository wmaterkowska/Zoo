package org.github.wmaterkowska.zoo;

import org.github.wmaterkowska.zoo.model.Zoo;
import org.github.wmaterkowska.zoo.service.ExceededLimitOfFoodException;
import org.github.wmaterkowska.zoo.service.UserInteraction;

public class Main {
    public static void main(String[] args) throws ExceededLimitOfFoodException {

        Zoo zoo = new Zoo();
        UserInteraction interaction = new UserInteraction(zoo);

        interaction.welcome();
        interaction.getStateOfTheZoo();
        interaction.mangingTheZoo();
        interaction.getStateOfTheZoo();

        interaction.goodBye();
    }
}