package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListOfMaterialsTest {
    private ListOfMaterials testListOfMaterials;

    @Test
    public void testMaterial() {
        testListOfMaterials = new ListOfMaterials();
        Material p = new Material("Chains", 0.05, "Camelot-5", 17);
        Material q = new Material("Proofs", 0.5, "Camelot-7", 14);
        Material s = new Material("Shells", 0.05, "Camelot-4", 21);
        testListOfMaterials.addMaterial(p);
        testListOfMaterials.addMaterial(q);
        testListOfMaterials.addMaterial(s);

        assertEquals(p, testListOfMaterials.getFirstMaterial());
        assertEquals(s, testListOfMaterials.getXthMaterial(2));
        testListOfMaterials.removeSelectedMaterial(p);
        testListOfMaterials.removeFirstMaterial();
        assertEquals(s, testListOfMaterials.getFirstMaterial());
        Material r = new Material("Magtama", 0.08, "Shimousa", 18);
        testListOfMaterials.addMaterial(r);
        assertEquals(r, testListOfMaterials.getXthMaterial(1));


    }

    @Test
    public void testRemoveMaterialExist(){
        testListOfMaterials = new ListOfMaterials();
        Material p = new Material("Chains", 0.05, "Camelot-5", 17);
        testListOfMaterials.addMaterial(p);
        try {
            testListOfMaterials.removeFirstMaterial();
            assertEquals(0, testListOfMaterials.getSize());
        } catch (Exception e) {
            System.out.println("Exception not expected, should have removed first item on list.");
        }
    }

    @Test
    public void testRemoveMaterialNotExist(){
        testListOfMaterials = new ListOfMaterials();
        try {
            testListOfMaterials.removeFirstMaterial();
        } catch (Exception e) {
            // Expected Result
        }
    }


}
