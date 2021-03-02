package ui;

import model.ListOfMaterials;
import model.Material;
import persistance.JsonReader;
import persistance.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FarmingApp {
    private String action;
    private String action1;
    private String action2;
    private String action3;
    private double counter;
    private double counter1;
    private int tracker;
    private int tracker1;
    private Scanner input;
    private Material needle;
    private Material fang;
    private Material bone;
    private Material chain;
    private Material gunpowder;
    private Material fluid;
    private Material proof;
    private Material stake;
    private Material dust;
    private Material steel;
    private Material gear;
    private Material ice;
    private Material page;
    private Material lantern;
    private Material medal;
    private Material ring;
    private Material baby;
    private Material horseshoe;
    private Material crystal;
    private Material feather;
    private Material magatama;
    private Material seed;
    private Material jewel;
    private Material shell;
    private Material grease;
    private Material claw;
    private Material gallstone;
    private Material scale;
    private Material heart;
    private Material lamp;
    private Material wine;
    private Material lanugo;
    private Material scarab;
    private Material root;
    private Material tearstone;
    private Material horn;
    private ListOfMaterials bronzes;
    private ListOfMaterials silvers;
    private ListOfMaterials golds;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/listOfMaterials.json";

    //EFFECTS: runs the farming app
    public FarmingApp() throws FileNotFoundException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runFarmingApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input

    private void runFarmingApp() {
        boolean keepgoing = true;
        String command = null;
        initializeBronze();
        initializeSilver();
        initializeGold();
        initializeLists1();
        initializeLists2();
        initializeLists3();
        while (keepgoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();
            if (command.equals("quit")) {
                keepgoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("thanks for using this!");
    }


    // MODIFIES: this
    //EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("gold")) {
            goGold();
        } else if (command.equals("silver")) {
            goSilver();
        } else if (command.equals("bronze")) {
            goBronze();
        } else {
            System.out.println("No valid Materials...");
        }
    }
    //The save and load methods are credited to the demo given.
    // EFFECTS: saves the gold materials to file

    private void saveListOfMaterialsGold() {
        try {
            jsonWriter.open();
            jsonWriter.write(golds);
            jsonWriter.close();
            System.out.println("Saved golds" + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads gold materials from file
    private void loadListOfMaterialsGold() {
        try {
            golds = jsonReader.read();
            System.out.println("Loaded gold"  + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // EFFECTS: saves the silver materials to file
    private void saveListOfMaterialsSilver() {
        try {
            jsonWriter.open();
            jsonWriter.write(silvers);
            jsonWriter.close();
            System.out.println("Saved silvers" + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // EFFECTS: saves the bronze materials to file
    private void saveListOfMaterialsBronze() {
        try {
            jsonWriter.open();
            jsonWriter.write(bronzes);
            jsonWriter.close();
            System.out.println("Saved bronzes" + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads silver materials from file

    private void loadListOfMaterialsSilver() {
        try {
            silvers = jsonReader.read();
            System.out.println("Loaded silver"  + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
    // MODIFIES: this
    // EFFECTS: loads bronze materials from file

    private void loadListOfMaterialsBronze() {
        try {
            bronzes = jsonReader.read();
            System.out.println("Loaded bronzes"  + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    //MODIFIES: this
    // EFFECTS: initializes all materials.
    private void initializeBronze() {
        needle = new Material("Needle", 0.05, "Camelot-7", 14);
        fang = new Material("Fang", 0.05, "Camelot-7", 14);
        bone = new Material("Bone", 0.05, "Camelot-7", 14);
        chain = new Material("Chain", 0.05, "Camelot-7", 14);
        gunpowder = new Material("Gunpowder", 0.05, "Camelot-7", 14);
        proof = new Material("Proof", 0.05, "Camelot-7", 14);
        stake = new Material("Stake", 0.05, "Camelot-7", 14);
        dust = new Material("Dust", 0.05, "Camelot-7", 14);
    }

    private void initializeSilver() {
        steel = new Material("Steel", 0.025, "Shimousa-5", 18);
        gear = new Material("Gear", 0.025, "Shimousa-5", 18);
        ice = new Material("Ice", 0.025, "Shimousa-5", 18);
        page = new Material("Page", 0.025, "Shimousa-5", 18);
        lantern = new Material("Lantern", 0.025, "Shimousa-5", 18);
        medal = new Material("Medal", 0.025, "Shimousa-5", 18);
        ring = new Material("Ring", 0.025, "Shimousa-5", 18);
        baby = new Material("Baby", 0.025, "Shimousa-5", 18);
        horseshoe = new Material("Horseshoe", 0.025, "Shimousa-5", 18);
        crystal = new Material("Crystal", 0.025, "Shimousa-5", 18);
        feather = new Material("Feather", 0.025, "Shimousa-5", 18);
        magatama = new Material("Magatama", 0.025, "Shimousa-5", 18);
        seed = new Material("Seed", 0.025, "Shimousa-5", 18);
        jewel = new Material("Jewel", 0.025, "Shimousa-5", 18);
        shell = new Material("Shell", 0.025, "Shimousa-5", 18);
    }

    private void initializeGold() {
        grease = new Material("Grease", 0.0125, "Salem-2", 20);
        claw = new Material("Claw", 0.0125, "Salem-2", 20);
        gallstone = new Material("Gallstone", 0.0125, "Salem-2", 20);
        scale = new Material("Scale", 0.0125, "Salem-2", 20);
        heart = new Material("Heart", 0.0125, "Salem-2", 20);
        lamp = new Material("Lamp", 0.0125, "Salem-2", 20);
        wine = new Material("Wine", 0.0125, "Salem-2", 20);
        lanugo = new Material("Lanugo", 0.0125, "Salem-2", 20);
        scarab = new Material("Scarab", 0.0125, "Salem-2", 20);
        root = new Material("Root", 0.0125, "Salem-2", 20);
        tearstone = new Material("Tearstone", 0.0125, "Salem-2", 20);
        horn = new Material("Horn", 0.0125, "Salem-2", 20);
    }

    private void initializeLists1() {
        bronzes = new ListOfMaterials();
        bronzes.addMaterial(needle);
        bronzes.addMaterial(fang);
        bronzes.addMaterial(bone);
        bronzes.addMaterial(chain);
        bronzes.addMaterial(gunpowder);
        bronzes.addMaterial(proof);
        bronzes.addMaterial(stake);
        bronzes.addMaterial(dust);
    }

    private void initializeLists2() {
        silvers = new ListOfMaterials();
        silvers.addMaterial(steel);
        silvers.addMaterial(gear);
        silvers.addMaterial(ice);
        silvers.addMaterial(page);
        silvers.addMaterial(lantern);
        silvers.addMaterial(medal);
        silvers.addMaterial(ring);
        silvers.addMaterial(baby);
        silvers.addMaterial(horseshoe);
        silvers.addMaterial(crystal);
        silvers.addMaterial(feather);
        silvers.addMaterial(magatama);
        silvers.addMaterial(seed);
        silvers.addMaterial(jewel);
        silvers.addMaterial(shell);
    }

    private void initializeLists3() {
        golds = new ListOfMaterials();
        golds.addMaterial(grease);
        golds.addMaterial(claw);
        golds.addMaterial(gallstone);
        golds.addMaterial(scale);
        golds.addMaterial(heart);
        golds.addMaterial(lamp);
        golds.addMaterial(wine);
        golds.addMaterial(lanugo);
        golds.addMaterial(root);
        golds.addMaterial(scarab);
        golds.addMaterial(tearstone);
        golds.addMaterial(horn);
        input = new Scanner(System.in);
    }

    //EFFECTS: displays initial user interactions
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tgold -> gold materials");
        System.out.println("\tsilver -> silver materials");
        System.out.println("\tbronze -> bronze materials");
        System.out.println("\tquit");
    }

    //MODIFIES: this
    //EFFECTS: displays possible actions for gold materials
    private void goGold() {
        System.out.println("What would you like to do? Choose from 'AddPercentage', 'SpecialEvent', 'SeeAll',"
                + "'ExpectedValue', 'AddItem', 'SaveGolds', 'LoadGolds");
        action = input.next();
        if (action.equals("AddPercentage")) {
            addPercentageGold();
        } else if (action.equals("SpecialEvent")) {
            specialEventGold();
        } else if (action.equals("SeeAll")) {
            seeAllGold();
        } else if (action.equals("ExpectedValue")) {
            expectedValueGold();
        } else if (action.equals("AddItem")) {
            addItemGold();
        } else if (action.equals("SaveGolds")) {
            saveListOfMaterialsGold();
        } else if (action.equals("LoadGolds")) {
            loadListOfMaterialsGold();
        } else {
            System.out.println("Selection not valid...");
        }


    }
    //MODIFIES: this
    //EFFECTS: Adds an item to the list of gold materials based on user inputs

    private void addItemGold() {
        System.out.println("What is the name of the Material?");
        action1 = input.next();
        System.out.println("What is the rate of the Material?");
        counter = input.nextDouble();
        System.out.println("Where is the material dropped?");
        action3 = input.next();
        System.out.println("What is the cost per run of the location?");
        counter1 = input.nextDouble();
        Material userMaterial = new Material(action1, counter, action3, counter1);
        golds.addMaterial(userMaterial);
        System.out.println("Ok, your material " + action1 + " with rate of " + Double.toString(counter) + ""
                + " Can be found at " + action3 + " at a cost of " + Double.toString(counter1) + " per run.");
    }


    //MODIFIES: this
    //EFFECTS: displays possible actions for silver materials
    private void goSilver() {
        System.out.println("What would you like to do? Choose from 'AddPercentage', 'SpecialEvent', 'SeeAll',"
                + "'ExpectedValue', 'AddItem', 'SaveSilvers', 'LoadSilvers'");
        action = input.next();
        if (action.equals("AddPercentage")) {
            addPercentageSilver();
        } else if (action.equals("SpecialEvent")) {
            specialEventSilver();
        } else if (action.equals("SeeAll")) {
            seeAllSilver();
        } else if (action.equals("ExpectedValue")) {
            expectedValueSilver();
        }  else if (action.equals("AddItem")) {
            addItemSilver();
        } else if (action.equals("SaveSilvers")) {
            saveListOfMaterialsSilver();
        } else if (action.equals("LoadSilvers")) {
            loadListOfMaterialsSilver();
        } else {
            System.out.println("Selection not valid...");
        }


    }

    //MODIFIES: this
    //EFFECTS: Adds an item to the list of silver materials based on user inputs
    private void addItemSilver() {
        System.out.println("What is the name of the Material?");
        action1 = input.next();
        System.out.println("What is the rate of the Material?");
        counter = input.nextDouble();
        System.out.println("Where is the material dropped?");
        action3 = input.next();
        System.out.println("What is the cost per run of the location?");
        counter1 = input.nextDouble();
        Material userMaterial = new Material(action1, counter, action3, counter1);
        silvers.addMaterial(userMaterial);
        System.out.println("Ok, your material " + action1 + " with rate of " + Double.toString(counter) + ""
                + " Can be found at " + action3 + " at a cost of " + Double.toString(counter1) + " per run.");
    }

    //MODIFIES: this
    //EFFECTS: displays possible actions for bronze materials
    private void goBronze() {
        System.out.println("What would you like to do? Choose from 'AddPercentage', 'SpecialEvent', 'SeeAll',"
                + "'ExpectedValue', 'SaveBronze', 'LoadBronze'");
        action = input.next();
        if (action.equals("AddPercentage")) {
            addPercentageBronze();
        } else if (action.equals("SpecialEvent")) {
            specialEventBronze();
        } else if (action.equals("SeeAll")) {
            seeAllBronze();
        } else if (action.equals("ExpectedValue")) {
            expectedValueBronze();

        } else if (action.equals("AddItem")) {
            addItemBronze();
        } else if (action.equals("SaveBronze")) {
            saveListOfMaterialsBronze();
        } else if (action.equals("LoadBronzes")) {
            loadListOfMaterialsBronze();
        } else {
            System.out.println("Selection not valid...");
        }


    }

    //MODIFIES: this
    //EFFECTS: Adds an item to the list of silver materials based on user inputs
    private void addItemBronze() {
        System.out.println("What is the name of the Material?");
        action1 = input.next();
        System.out.println("What is the rate of the Material?");
        counter = input.nextDouble();
        System.out.println("Where is the material dropped?");
        action3 = input.next();
        System.out.println("What is the cost per run of the location?");
        counter1 = input.nextDouble();
        Material userMaterial = new Material(action1, counter, action3, counter1);
        bronzes.addMaterial(userMaterial);
        System.out.println("Ok, your material " + action1 + " with rate of " + Double.toString(counter) + ""
                + " Can be found at " + action3 + " at a cost of " + Double.toString(counter1) + " per run.");
    }
    //Effects: Returns the expected value of bronze drops per X number of runs

    private void expectedValueBronze() {
        System.out.println("How many runs are you planning to do?");
        counter = input.nextDouble();
        System.out.println("What are the rates of the material?");
        counter1 = input.nextDouble();
        double sum = counter * counter1;
        String s = Double.toString(sum);
        System.out.println("The expected number of drops is " + s);
    }

    //EFFECTS: prints out a list of all bronze materials
    private void seeAllBronze() {
        String los = "";
        for (int i = 0; i < bronzes.getSize(); i++) {
            Material m = bronzes.getXthMaterial(i);
            String name = m.getMaterialName();
            los += name;
            los += ", ";
        }
        System.out.println(los);

    }

    //Effects: Determines whether or not the event is better than the original stage.
    private void specialEventBronze() {
        System.out.println("What is the material drop rate for the event?");
        counter = input.nextDouble();
        if (counter >= fang.getMaterialRate()) {
            System.out.println("This is better than the general average!");
            System.out.println("How many runs are you planning on doing?");
            counter1 = input.nextDouble();
            double c = counter * counter1;
            System.out.println("You are expected to get " + c + " drops.");
        } else {
            System.out.println("This event isn't better than the normal average.");
            System.out.println("How many runs are you planning on doing?");
            counter1 = input.nextDouble();
            double s = counter * counter1;
            String s1 = Double.toString(s);
            double b = fang.getMaterialRate();
            double b1 = b * counter1;
            String b2 = Double.toString(b1);
            System.out.println("You are only expected to get " + s1 + " drops compared to " + b2);
        }
    }

    //Effects: Calculates the increase or decrease in rate based on user data.
    private void addPercentageBronze() {
        System.out.println("How many runs did you do?");
        tracker = input.nextInt();
        System.out.println("How many drops did you get?");
        tracker1 = input.nextInt();
        if (counter1 == 0 && counter >= 1) {
            System.out.println("You can't gain drops from no runs!");
        } else {
            double a = gunpowder.alteredMaterialRate(tracker, tracker1);
            String a1 = Double.toString(a);
            System.out.println("The new expected rate for this item is " + a1);

        }
    }

    //Effects: Returns the expected value of silver drops per X number of runs
    private void expectedValueSilver() {
        System.out.println("How many runs are you planning to do?");
        counter = input.nextDouble();
        System.out.println("What are the rates of the material?");
        counter1 = input.nextDouble();
        double sum = counter * counter1;
        String s = Double.toString(sum);
        System.out.println("The expected number of drops is " + s);
    }

    //EFFECTS: prints out a list of all silver materials
    private void seeAllSilver() {
        String los = "";
        for (int i = 0; i < silvers.getSize(); i++) {
            Material m = silvers.getXthMaterial(i);
            String name = m.getMaterialName();
            los += name;
            los += ", ";
        }
        System.out.println(los);

    }

    //Effects: Determines whether or not the event is better than the original stage.
    private void specialEventSilver() {
        System.out.println("What is the material drop rate for the event?");
        counter = input.nextDouble();
        if (counter >= feather.getMaterialRate()) {
            System.out.println("This is better than the general average!");
            System.out.println("How many runs are you planning on doing?");
            counter1 = input.nextDouble();
            double c = counter * counter1;
            System.out.println("You are expected to get " + c + " drops.");
        } else {
            System.out.println("This event isn't better than the normal average.");
            System.out.println("How many runs are you planning on doing?");
            counter1 = input.nextDouble();
            double s = counter * counter1;
            String s1 = Double.toString(s);
            double b = feather.getMaterialRate();
            double b1 = b * counter1;
            String b2 = Double.toString(b1);
            System.out.println("You are only expected to get " + s1 + " drops compared to " + b2);
        }
    }

    //Effects: Calculates the increase or decrease in rate based on user data.
    private void addPercentageSilver() {
        System.out.println("How many runs did you do?");
        tracker = input.nextInt();
        System.out.println("How many drops did you get?");
        tracker1 = input.nextInt();
        if (counter1 == 0 && counter >= 1) {
            System.out.println("You can't gain drops from no runs!");
        } else {
            double a = feather.alteredMaterialRate(tracker, tracker1);
            String a1 = Double.toString(a);
            System.out.println("The new expected rate for this item is " + a1);

        }
    }

    //Effects: Returns the expected value of gold drops per X number of runs
    private void expectedValueGold() {
        System.out.println("How many runs are you planning to do?");
        counter = input.nextDouble();
        System.out.println("What are the rates of the material?");
        counter1 = input.nextDouble();
        double sum = counter * counter1;
        String s = Double.toString(sum);
        System.out.println("The expected number of drops is " + s);
    }

    //EFFECTS: prints out a list of all gold materials
    private void seeAllGold() {
        String los = "";
        for (int i = 0; i < golds.getSize(); i++) {
            Material m = golds.getXthMaterial(i);
            String name = m.getMaterialName();
            los += name;
            los += ", ";
        }
        System.out.println(los);

    }

    //Effects: Determines whether or not the event is better than the original stage.
    private void specialEventGold() {
        System.out.println("What is the material drop rate for the event?");
        counter = input.nextDouble();
        if (counter >= grease.getMaterialRate()) {
            System.out.println("This is better than the general average!");
            System.out.println("How many runs are you planning on doing?");
            counter1 = input.nextDouble();
            double c = counter * counter1;
            System.out.println("You are expected to get " + c + " drops.");
        } else {
            System.out.println("This event isn't better than the normal average.");
            System.out.println("How many runs are you planning on doing?");
            counter1 = input.nextDouble();
            double s = counter * counter1;
            String s1 = Double.toString(s);
            double b = grease.getMaterialRate();
            double b1 = b * counter1;
            String b2 = Double.toString(b1);
            System.out.println("You are only expected to get " + s1 + " drops compared to " + b2);
        }
    }

    //Effects: Calculates the increase or decrease in rate based on user data.
    private void addPercentageGold() {
        System.out.println("How many runs did you do?");
        tracker = input.nextInt();
        System.out.println("How many drops did you get?");
        tracker1 = input.nextInt();
        if (counter1 == 0 && counter >= 1) {
            System.out.println("You can't gain drops from no runs!");
        } else {
            double a = gunpowder.alteredMaterialRate(tracker, tracker1);
            String a1 = Double.toString(a);
            System.out.println("The new expected rate for this item is " + a1);

        }
    }

}