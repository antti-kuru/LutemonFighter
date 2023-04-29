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
    protected int id;
    protected int idCounter;
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

    // Attack
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    // Defence
    public int getDefence() {
        return defence;
    }

    // Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Health
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    // Image
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    // Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Wins
    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    // Fights
    public int getFights() {
        return fights;
    }

    public void setFights(int fights) {
        this.fights = fights;
    }

    // Training sessions
    public int getTrainingSessions() {
        return trainingSessions;
    }

    public void setTrainingSessions(int trainingSessions) {
        this.trainingSessions = trainingSessions;
    }

    // Experience
    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    // Max Health
    public int getMaxHealth() {
        return maxHealth;
    }

    // Number of created lutemons
    public int getIdCounter() {
        return idCounter;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }

}
