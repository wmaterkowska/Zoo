import org.github.wmaterkowska.zoo.model.animals.Animal;
import org.github.wmaterkowska.zoo.model.animals.Elephant;
import org.github.wmaterkowska.zoo.model.animals.Lion;
import org.github.wmaterkowska.zoo.model.Zone;
import org.github.wmaterkowska.zoo.model.Zoo;
import org.github.wmaterkowska.zoo.model.animals.Rabbit;
import org.github.wmaterkowska.zoo.service.ExceededLimitOfFoodException;
import org.github.wmaterkowska.zoo.service.ZooService;
import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class ZooServiceTest {

    Zoo zoo;
    ZooService zooService;

    @Test
    public void addZoneTest() {
        zoo = new Zoo();
        zooService = new ZooService(zoo);

        String testZoneName = "savanna";
        Zone testZone = new Zone(testZoneName);
        List<Zone> testListOfZones = new ArrayList<>();
        testListOfZones.add(testZone);

        zooService.addZone(testZone);
        List<Zone> actualListOfZones = zoo.getListOfZones();

        Assert.assertEquals(actualListOfZones, testListOfZones);
    }


    @Test
    public void addAnimalTest(){
        zoo = new Zoo();
        zooService = new ZooService(zoo);

        Animal testAnimal = new Lion("lion", "Simba");
        List<Animal> testListAnimals = new ArrayList<>();
        testListAnimals.add(testAnimal);

        zooService.addAnimal(testAnimal);
        List<Animal> actualListAnimals = zoo.getListOfAnimals();

        Assert.assertEquals(actualListAnimals, testListAnimals);
    }

    @Test
    public void assignAnimalToZoneTest() throws ExceededLimitOfFoodException {
        zoo = new Zoo();
        zooService = new ZooService(zoo);

        Zone testZone = new Zone("savanna");
        Animal testAnimal = new Lion("lion", "Simba");
        testZone.addAnimal(testAnimal);
        testAnimal.setZone(testZone);

        zoo.setListOfZones(asList(testZone));
        zoo.setListOfAnimals(asList(testAnimal));

        zooService.assignAnimalToZone(testAnimal, testZone);

        Assert.assertEquals(zoo.getListOfZones().get(0).getListOfAnimals(), testZone.getListOfAnimals());
        Assert.assertEquals(zoo.getListOfAnimals().get(0).getZone(), testAnimal.getZone());

    }

    @Test
    public void tooManyAnimalsInZoneTest() throws ExceededLimitOfFoodException {
        zoo = new Zoo();
        zooService = new ZooService(zoo);

        Animal elephantDumbo = new Elephant("elephant", "Dumbo");
        Animal elephantMambo = new Elephant("elephant", "Mambo");
        Animal elephantRambo = new Elephant("elephant", "Rambo");

        Animal lionSimba = new Lion("lion", "Simba");
        Animal lionNala = new Lion("lion", "Nala");
        Animal lionMufasa = new Lion("lion", "Mufasa");

        Animal rabbitMicki = new Rabbit("rabbit", "Micki");
        Animal rabbitRicki = new Rabbit("rabbit", "Ricki");
        Animal rabbitKicki = new Rabbit("rabbit", "Kicki");

        Zone zone = new Zone("forest");

        zooService.assignAnimalToZone(elephantDumbo, zone);
        zooService.assignAnimalToZone(elephantMambo, zone);
        zooService.assignAnimalToZone(elephantRambo, zone);

        zooService.assignAnimalToZone(lionSimba, zone);
        zooService.assignAnimalToZone(lionNala, zone);
        zooService.assignAnimalToZone(lionMufasa, zone);

        zooService.assignAnimalToZone(rabbitMicki, zone);

        Assert.assertThrows(ExceededLimitOfFoodException.class, () -> zooService.assignAnimalToZone(rabbitRicki, zone));
    }


}
