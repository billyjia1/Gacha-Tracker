package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaterialTest {
    private Material testMaterial;

    @BeforeEach
    void runBefore() {
        testMaterial = new Material("Hearts", 0.014, "Fuyuki-7", 14);
    }

    @Test
    void testConstructor() {
        assertEquals("Hearts", testMaterial.getMaterialName());
        assertEquals(0.014, testMaterial.getMaterialRate());
        assertEquals("Fuyuki-7", testMaterial.getMaterialLocation());
        assertEquals(14, testMaterial.getLocationCost());

    }

    @Test
    void testNonExistantRate() {
        testMaterial = new Material("Chains", -0.05, "Camelot-5", 17);
        assertEquals("Chains", testMaterial.getMaterialName());
        assertEquals(0, testMaterial.getMaterialRate());
        assertEquals("Camelot-5", testMaterial.getMaterialLocation());
        assertEquals(17, testMaterial.getLocationCost());
    }

    @Test
    void testExpectedDrops() {
        testMaterial = new Material("Proofs", 0.5, "Camelot-7", 21);
        assertEquals(4, testMaterial.expectedDropAmount(8));
    }

    @Test
    void testAlteredDropRate() {
        testMaterial = new Material("Shells", 0.05, "Camelot-4", 21);
        assertEquals((0.05 * 10000 + 10) / (10000 + 10), testMaterial.alteredMaterialRate(10, 10));
    }

    @Test
    void testSumOfCost() {
        testMaterial = new Material("Bones", 0.06, "Fuyuki-8", 7);
        assertEquals(140, testMaterial.sumOfCost(20, testMaterial));


    }
}