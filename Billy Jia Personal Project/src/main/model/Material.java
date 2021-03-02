package model;

import org.json.JSONObject;
import persistance.Writable;

public class Material implements Writable {
    public static final int communityTotal = 10000; // Assumed number of times data has been collected by the community.


    private String materialName;       //Name of Material
    private double materialRate;       //Rate of Material prior to any altering
    private String materialLocation;   //Places where the material can be dropped
    private double locationCost;       //Cost of going to the location once



    //EFFECTS: Constructs a Material
    public Material(String name, double rate, String location, double cost) {
        materialName = name;
        if (rate >= 0) {
            materialRate = rate;
        } else {
            materialRate = 0;
        }
        materialLocation = location;
        locationCost = cost;

    }

    //EFFECTS: return the name of the material
    public String getMaterialName() {
        return materialName;
    }

    //EFFECTS: return the rate of the material
    public double getMaterialRate() {
        return materialRate;
    }

    //EFFECTS: return the location of the material
    public String getMaterialLocation() {
        return materialLocation;
    }
    //EFFECTS: return the cost of the location

    public double getLocationCost() {
        return locationCost;
    }


    //EFFECTS: return the expected number of drops
    public double expectedDropAmount(int runs) {
        return runs * materialRate;
    }

    //EFFECTS: returns the changed materialRate based on own experiences
    public double alteredMaterialRate(int runs, int drops) {
        return (materialRate * communityTotal + drops) / (communityTotal + runs);
    }

    //EFFECTS: given a number of drops and a material, returns the expected cost
    public double sumOfCost(int j, Material m) {
        return j * m.getLocationCost();
    }


    //Below code taken from JsonSerializationDemo, modified slightly to suit my needs

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", materialName);
        json.put("rate", materialRate);
        json.put("location", materialLocation);
        json.put("cost", locationCost);
        return json;
    }
}











