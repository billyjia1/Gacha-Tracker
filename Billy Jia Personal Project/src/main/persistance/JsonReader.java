package persistance;

import model.ListOfMaterials;
import model.Material;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JsonReader {
    private String source;
    //A majority of this code was taken from demo given, altered slightly to fulfil my needs

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads ListOfMaterials from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ListOfMaterials read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseListOfMaterials(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private ListOfMaterials parseListOfMaterials(JSONObject jsonObject) {
        ListOfMaterials lom = new ListOfMaterials();
        addMaterials(lom, jsonObject);
        return lom;
    }

    // MODIFIES: listofmaterials
    // EFFECTS: parses materials from JSON object and adds them to listofMaterials
    private void addMaterials(ListOfMaterials lom, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("materials");
        for (Object json : jsonArray) {
            JSONObject nextMaterial = (JSONObject) json;
            addMaterial(lom, nextMaterial);
        }
    }

    // MODIFIES: listofmaterials
    // EFFECTS: parses material from JSON object and adds it to workroom
    private void addMaterial(ListOfMaterials lom, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Double rate = jsonObject.getDouble("rate");
        String location = jsonObject.getString("location");
        Double cost = jsonObject.getDouble("cost");
        Material m = new Material(name, rate, location, cost);
        lom.addMaterial(m);
    }
}
