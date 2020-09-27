package Entities;

import Utils.CharacterStatus;

public class GameCharacter extends GameEntity {
    private CharacterStatus status;
    private String name;
    private double currHealth;
    private double currMana;
    private Stats stats;
    private Ability[] abilities;

    public GameCharacter(String name, Stats stats, Ability[] abilities){
        this.status = CharacterStatus.ALIVE;
        this.name = name;
        this.stats = stats;
        this.currHealth = this.stats.getMaxHealth();
        this.currMana = this.stats.getMaxMana();
        this.abilities = abilities.clone();
    }

    // if returns false, attack has killed the character
    public CharacterStatus receiveAttack(Attack attack) {
        currHealth -= attack.calculateTotalDmg();
        if(currHealth <= 0) {
            this.status = CharacterStatus.DEAD;
        }
        return this.status;
    }

    public Stats getStats() {
        return stats;
    }

    public CharacterStatus getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public boolean usedAbility(Ability ability) {
        double manaCost = ability.getManaCost();
        if(currMana < manaCost){
            return false;
        }
        currMana -= manaCost;
        return true;
    }
}
