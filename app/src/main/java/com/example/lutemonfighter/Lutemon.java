package com.example.lutemonfighter;

public class Lutemon {
    protected String name;
    protected String color;
    protected int image;
    protected int attack;
    protected int superAttack;
    protected int defence;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected int id;
    protected int idCounter;
    protected int wins;
    protected int fights;
    protected int trainingSessions;


    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getExperience() {
        return experience;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public Lutemon(){

        experience = 0;
        wins = 0;
        fights = 0;
        trainingSessions = 0;
    }

    public void defence(Lutemon lutemon){

    }

    public int attack(){
       return attack;
    }

    public int getNumberOfCreatedLutemons(){
        return idCounter;
    }



}
