package com.example.lutemonfighter;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {

    protected ArrayList<Lutemon> lutemons = new ArrayList<>();

    private ArrayList<Lutemon> movingLutemons = new ArrayList<>();


    private ArrayList<Lutemon> lutemonsInTrainingArea = new ArrayList<>();

    private ArrayList<Lutemon> lutemonsInBattleField = new ArrayList<>();

    private static Storage lutemonStorage = null; // Initialization of singleton

    public static Storage getInstance() {
        if (lutemonStorage == null) {
            lutemonStorage = new Storage();
        }
        return lutemonStorage;
    }

    // addLutemon

    public ArrayList<Lutemon> getMovingLutemons() {
        return movingLutemons;
    }

    public void addLutemon(Lutemon lutemon){
        lutemons.add(lutemon);
    }

    public void addMovingLutemon(Lutemon lutemon) {movingLutemons.add(lutemon);}

    public void addLutemonToBattleField(Lutemon lutemon) {lutemonsInBattleField.add(lutemon);}

    public void addLutemonToTrainingArea(Lutemon lutemon) {lutemonsInTrainingArea.add(lutemon);}


    public ArrayList<Lutemon> getLutemonsInTrainingArea() {
        return lutemonsInTrainingArea;
    }

    public ArrayList<Lutemon> getLutemonsInBattleField() {
        return lutemonsInBattleField;
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }
    // getLutemon
    // listLutemons

    public void listLutemons(){
        for(Lutemon l : lutemons){
            System.out.println(l.getName() + " " + l.getColor() + " " + l.getAttack() + " " + l.getDefence()+ " " + l.getMaxHealth());
        }


    }

    public void saveLutemons(Context context){
        try {
            ObjectOutputStream lutemonWriter = new ObjectOutputStream(context.openFileOutput("lutemons.data", Context.MODE_PRIVATE));
            lutemonWriter.writeObject(lutemons);
            lutemonWriter.close();
        } catch (IOException e) {
            System.out.println("Lutemonin tallentaminen ei onnistunut!");
            //throw new RuntimeException(e);
        }

    }

    // For loading users
    public void loadLutemons(Context context){
        try {
            ObjectInputStream lutemonReader = new ObjectInputStream(context.openFileInput("lutemon.data"));
            lutemons = (ArrayList<Lutemon>) lutemonReader.readObject();
            lutemonReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Tiedoston lukeminen epäonnistui");
        } catch (IOException e) {
            // throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            // throw new RuntimeException(e);
        }
    }
}
