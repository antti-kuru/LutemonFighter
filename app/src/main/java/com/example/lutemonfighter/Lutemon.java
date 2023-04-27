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


    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

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

    public int getHealth() {
        return health;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setSuperAttack(int superAttack) {
        this.superAttack = superAttack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setFights(int fights) {
        this.fights = fights;
    }

    public void setTrainingSessions(int trainingSessions) {
        this.trainingSessions = trainingSessions;
    }

    public int getSuperAttack() {
        return superAttack;
    }

    public int getId() {
        return id;
    }

    public int getIdCounter() {
        return idCounter;
    }

    public int getWins() {
        return wins;
    }

    public int getFights() {
        return fights;
    }

    public int getTrainingSessions() {
        return trainingSessions;
    }

    public void setHealth(int health) {
        this.health = health;
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
