package model;



import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListOfMaterials {
    private List<Material> materials;


    //EFFECTS: Creates an empty list of Materials
    public ListOfMaterials() {
        materials = new ArrayList<>();
    }


    //REQUIRES: NonNegative values for materialRate, material doesnt already exist in list
    //MODIFIES: this
    //EFFECTS: adds the Material to the ListOfMaterials
    public void addMaterial(Material p) {
        materials.add(p);
    }

    //EFFECTS: removes the first material off the materials list
    public void removeFirstMaterial() {
        try {
            materials.remove(0);
        } catch (Exception e) {
            System.out.println("There is no Material in the list.");
        }
    }
    //REQUIRES: Selected material must exist in the material list beforehand
    //EFFECTS: removes the selected material off the materials list

    public void removeSelectedMaterial(Material p) {
        materials.remove(p);
    }
    //EFFECTS: returns the first material

    public Material getFirstMaterial() {
        return materials.get(0);
    }
    //EFFECTS: returns the X-th material

    public Material getXthMaterial(int i) {
        return materials.get(i);
    }

    //EFFECTS: returns the size of the materials list
    public int getSize() {
        return materials.size();
    }
    //toJson and materialsToJson were based on demo given.

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("materials", materialsToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray materialsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Material m : materials) {
            jsonArray.put(m.toJson());
        }

        return jsonArray;
    }
}

