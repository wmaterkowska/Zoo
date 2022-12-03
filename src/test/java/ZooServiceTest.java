import org.example.data.Animal;
import org.example.data.Lion;
import org.example.data.Zone;
import org.example.data.Zoo;
import org.example.service.ZooService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class ZooServiceTest {

    Zoo zoo;
    ZooService zooService;

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }


    @Test
    public void addZoneTest() {
        zoo = new Zoo();
        zooService = new ZooService(zoo);

        String testString = "savanna";
        provideInput(testString);

        Zone testZone = new Zone(testString);
        List<Zone> testListOfZones = new ArrayList<>();
        testListOfZones.add(testZone);

        zooService.addZone();

        List<Zone> actualListOfZones = zoo.getListOfZones();

        Assert.assertEquals(actualListOfZones, testListOfZones);
    }


    @Test
    public void addAnimalTest(){
        zoo = new Zoo();
        zooService = new ZooService(zoo);

        String testString = "lion,Simba";
        provideInput(testString);

        Animal testAnimal = new Lion("lion", "Simba");
        List<Animal> testListAnimals = new ArrayList<>();
        testListAnimals.add(testAnimal);

        zooService.addAnimal();

        List<Animal> actualListAnimals = zoo.getListOfAnimals();

        Assert.assertEquals(actualListAnimals, testListAnimals);
    }

    @Test
    public void assignAnimalToZoneTest() {
        zoo = new Zoo();
        zooService = new ZooService(zoo);

        String testString = "lion,Simba,savanna";
        provideInput(testString);

        Zone testZone = new Zone("savanna");
        Animal testAnimal = new Lion("lion", "Simba");
        testZone.addAnimal(testAnimal);
        testAnimal.setZone(testZone);

        zoo.setListOfZones(asList(testZone));
        zoo.setListOfAnimals(asList(testAnimal));

        zooService.assignAnimalToZone();


        Assert.assertEquals(zoo.getListOfZones().get(0).getListOfAnimals(), testZone.getListOfAnimals());
        Assert.assertEquals(zoo.getListOfAnimals().get(0).getZone(), testAnimal.getZone());

    }

}
