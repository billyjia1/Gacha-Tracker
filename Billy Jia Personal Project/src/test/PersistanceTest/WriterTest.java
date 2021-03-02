package PersistanceTest;

import model.ListOfMaterials;
import model.Material;
import org.junit.jupiter.api.Test;
import persistance.JsonReader;
import persistance.JsonWriter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class WriterTest extends JsonTest{
    @Test
    void testWriterInvalidFile() {
        try {
            ListOfMaterials lom = new ListOfMaterials();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            ListOfMaterials lom = new ListOfMaterials();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(lom);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
            lom = reader.read();
            assertEquals(0, lom.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            ListOfMaterials lom = new ListOfMaterials();
            lom.addMaterial(new Material("Grease", 0.0125, "Salem-2", 20 ));
            lom.addMaterial(new Material("Scales", 0.0125, "Salem-2", 20));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(lom);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            lom = reader.read();
            ListOfMaterials materials = lom;
            assertEquals(2, materials.getSize());
            checkMaterial("Grease", 0.0125, "Salem-2", 20,  materials.getXthMaterial(0));
            checkMaterial("Scales", 0.0125, "Salem-2", 20,  materials.getXthMaterial(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
