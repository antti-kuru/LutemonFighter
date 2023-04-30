package com.example.lutemonfighter;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {

    // Lutemons at home
    protected ArrayList<Lutemon> lutemons = new ArrayList<>();

    private ArrayList<Lutemon> lutemonsInTrainingArea = new ArrayList<>();

    private ArrayList<Lutemon> lutemonsInBattleField = new ArrayList<>();

    private ArrayList<Lutemon> movingLutemons = new ArrayList<>();

    private static Storage lutemonStorage = null; // Initialization of singleton

    public static Storage getInstance() {
        if (lutemonStorage == null) {
            lutemonStorage = new Storage();
        }
        return lutemonStorage;
    }

    // Everytime a lutemon is created it is moved straight to home
    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public void addMovingLutemon(Lutemon lutemon) {
        movingLutemons.add(lutemon);
    }

    public void addLutemonToBattleField(Lutemon lutemon) {
        lutemonsInBattleField.add(lutemon);
    }

    public void addLutemonToTrainingArea(Lutemon lutemon) {
        lutemonsInTrainingArea.add(lutemon);
    }

    public ArrayList<Lutemon> getMovingLutemons() {
        return movingLutemons;
    }

    public ArrayList<Lutemon> getLutemonsInTrainingArea() {
        return lutemonsInTrainingArea;
    }

    public ArrayList<Lutemon> getLutemonsInBattleField() {
        return lutemonsInBattleField;
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    // Printing the stats of the lutemons into the console
    public void listLutemons() {
        for (Lutemon l : lutemons) {
            System.out.println(l.getName() + " " + l.getColor() + " " + l.getAttack() + " " + l.getDefence() + " " + l.getMaxHealth());
        }
    }

    // For saving lutemons
    public void saveLutemons(Context context) {
        try {
            ObjectOutputStream lutemonInHomeWriter = new ObjectOutputStream(context.openFileOutput("lutemons.data", Context.MODE_PRIVATE));
            ObjectOutputStream lutemonInTrainingAreaWriter = new ObjectOutputStream(context.openFileOutput("lutemonsTrainingArea.data", Context.MODE_PRIVATE));
            ObjectOutputStream lutemonInBattleFieldWriter = new ObjectOutputStream(context.openFileOutput("lutemonsBattleField.data", Context.MODE_PRIVATE));
            lutemonInHomeWriter.writeObject(lutemons);
            lutemonInTrainingAreaWriter.writeObject(lutemonsInTrainingArea);
            lutemonInBattleFieldWriter.writeObject(lutemonsInBattleField);
            lutemonInHomeWriter.close();
            lutemonInTrainingAreaWriter.close();
            lutemonInBattleFieldWriter.close();
        } catch (IOException e) {
            System.out.println("Lutemonin tallentaminen ei onnistunut!");
            //throw new RuntimeException(e);
        }
    }

    // For loading lutemons
    public void loadLutemons(Context context) {
        try {
            ObjectInputStream lutemonInHomeReader = new ObjectInputStream(context.openFileInput("lutemons.data"));
            ObjectInputStream lutemonInTrainingAreaReader = new ObjectInputStream(context.openFileInput("lutemonsTrainingArea.data"));
            ObjectInputStream lutemonInBattleFieldReader = new ObjectInputStream(context.openFileInput("lutemonsBattleField.data"));
            lutemons = (ArrayList<Lutemon>) lutemonInHomeReader.readObject();
            lutemonsInTrainingArea = (ArrayList<Lutemon>) lutemonInTrainingAreaReader.readObject();
            lutemonsInBattleField = (ArrayList<Lutemon>) lutemonInBattleFieldReader.readObject();
            lutemonInHomeReader.close();
            lutemonInTrainingAreaReader.close();
            lutemonInBattleFieldReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Tiedoston lukeminen epäonnistui");
        } catch (IOException e) {
            // throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            // throw new RuntimeException(e);
        }
    }
}
