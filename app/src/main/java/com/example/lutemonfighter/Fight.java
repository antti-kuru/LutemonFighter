package com.example.lutemonfighter;

public class Fight {

    private String battleLog;
    private Lutemon attacker;
    private Lutemon defender;

    public String fight() {

        // Get chosen lutemons
        attacker = Storage.getInstance().getMovingLutemons().get(0);
        defender = Storage.getInstance().getMovingLutemons().get(1);


        battleLog = "Ottelu alkaa!\n";

        // While loop controlling the battle
        // Each iteration we check if the lutemon that's going to take the next hit, has
        // enough health points left
        while (defender.getHealth() > 0) {
            int damage = defender.defence(attacker);

            // Display stats for the attacker
            battleLog += ("1: " + attacker.getName() + " (" + attacker.getColor() + ") att: " + attacker.getAttack() + "; def: " + attacker.getDefence() + "; exp: " + attacker.getExperience() + "; health: " + attacker.getHealth() + "/" + attacker.getMaxHealth() + "\n");
            // And stats for the defender
            battleLog += ("2: " + defender.getName() + " (" + defender.getColor() + ") att: " + defender.getAttack() + "; def: " + defender.getDefence() + "; exp: " + defender.getExperience() + "; health: " + defender.getHealth() + "/" + defender.getMaxHealth() + "\n");

            // Generate a random number from 1-10 and check if it's greater than 8, leaving a
            // 20 % change for the super attack that does +2 damage
            if ((int)(Math.random() * 10) + 1 > 8) {
                battleLog += (attacker.getName() + " (" + attacker.getColor() + ") käyttää superiskun.\n");
                // Leaving no chance for the defending lutemon to avoid super attack
                defender.setHealth(defender.getHealth() - (damage + 2));
            }
            else {
                battleLog += (attacker.getName() + " (" + attacker.getColor() + ") iskee puolustajaa.\n");
                // Create a small probability for the lutemon to avoid regular attack
                if ((int)(Math.random() * 10) + 1 > 9) {
                    battleLog += (defender.getName() + " (" + defender.getColor() + ") väisti iskun ja selvisi ilman vahinkoa.\n");
                }
                else {
                    defender.setHealth(defender.getHealth() - damage);
                }
            }

            // After each attack we also check if the defending lutemon stays alive
            if (defender.getHealth() > 0) {
                battleLog += (defender.getName() + " (" + defender.getColor() + ") jäi henkiin " + defender.getHealth() + "/" + defender.getMaxHealth() + "elämäpisteellä.\n");
            }
            // If there is not enough health for the defender, it faints / loses
            else {
                battleLog += (defender.getName() + " (" + defender.getColor() + ") menetti elämäpisteet ja hävisi ottelun.\n");
                battleLog += ("Ottelu päättyi.\n");
                break;
            }

            // After each round we switch places
            Lutemon temporary = attacker;
            attacker = defender;
            defender = temporary;
        }

        // Give both lutemons +1 battling sessions
        attacker.setFights(attacker.getFights() + 1);
        defender.setFights(defender.getFights() + 1);

        // Give the winner a win
        attacker.setWins(attacker.getWins() + 1);

        // Regenerate lutemons to max health
        attacker.setHealth(attacker.maxHealth);
        defender.setHealth(defender.maxHealth);

        // Give the winning lutemon +1 xp and attack point
        attacker.setExperience(attacker.getExperience() + 1);
        attacker.setAttack(attacker.getAttack() + 1);

        Storage.getInstance().getMovingLutemons().clear();
        System.out.println(battleLog);

        return battleLog;
    }
}
