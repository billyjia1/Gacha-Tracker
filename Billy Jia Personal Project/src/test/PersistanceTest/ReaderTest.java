package PersistanceTest;

import model.ListOfMaterials;
import org.junit.jupiter.api.Test;
import persistance.JsonReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ReaderTest extends JsonTest {

        @Test
        void testReaderNonExistentFile() {
            JsonReader reader = new JsonReader("./data/noSuchFile.json");
            try {
                ListOfMaterials lom = reader.read();
                fail("IOException expected");
            } catch (IOException e) {
                // pass
            }
        }

        @Test
        void testReaderEmptyWorkRoom() {
            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkRoom.json");
            try {
                ListOfMaterials lom = reader.read();
                assertEquals(0, lom.getSize());
            } catch (IOException e) {
                fail("Couldn't read from file");
            }
        }

        @Test
        void testReaderGeneralWorkRoom() {
            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkRoom.json");
            try {
                ListOfMaterials lom = reader.read();
                assertEquals("Grease", lom.getFirstMaterial().getMaterialName());

            } catch (IOException e) {
                fail("Couldn't read from file");
            }
        }
    }


