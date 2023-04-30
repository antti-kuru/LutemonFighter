package com.example.lutemonfighter;

import java.io.Serializable;

public class Lutemon implements Serializable {
    protected String name;
    protected String color;
    protected int image;
    protected int attack;
    protected int defence;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected int wins;
    protected int fights;
    protected int trainingSessions;

    // Default constructor for lutemons
    public Lutemon() {

        experience = 0;
        wins = 0;
        fights = 0;
        trainingSessions = 0;
    }

    public int defence(Lutemon lutemon) {
        // In this defence method we calculate and return the damage done by the attacker
        return (lutemon.attack() - defence);
    }

    public int attack() {
        // Here we just return the attack so it's basically a getter
        return attack;
    }

    // Getters and setters

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getImage() {
        return image;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getFights() {
        return fights;
    }

    public void setFights(int fights) {
        this.fights = fights;
    }

    public int getTrainingSessions() {
        return trainingSessions;
    }

    public void setTrainingSessions(int trainingSessions) {
        this.trainingSessions = trainingSessions;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getMaxHealth() {
        return maxHealth;
    }


}
