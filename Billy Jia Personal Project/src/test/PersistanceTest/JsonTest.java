package PersistanceTest;

import model.Material;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JsonTest {
    protected void checkMaterial(String name, double rate, String location, double cost, Material material) {
            assertEquals(name, material.getMaterialName());
            assertEquals(rate, material.getMaterialRate());
            assertEquals(location, material.getMaterialLocation());
            assertEquals(cost, material.getLocationCost());

        }
    }

