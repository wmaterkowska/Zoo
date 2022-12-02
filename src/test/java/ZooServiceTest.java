import org.example.data.Zone;
import org.example.data.Zoo;
import org.example.service.ZooService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

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

        // assertEquals(testString, getOutput());
        // assertEquals(testListOfZones, zoo.getListOfZones());
        assertTrue(testListOfZones.equals(actualListOfZones) );

    }


    @Test
    public void addAnimalTest(){

    }


}
