package Entities;

import Utils.CharacterStatus;
import Utils.Exceptions.NotEnoughManaException;

public class GameCharacter extends GameEntity {
    private CharacterStatus status;
    private String name;
    private double currHealth;
    private double currMana;
    private Stats stats;
    private Ability[] abilities;

    public GameCharacter(String name, Stats stats, Ability[] abilities) {
        this.status = CharacterStatus.ALIVE;
        this.name = name;
        this.stats = stats;
        this.currHealth = this.stats.getMaxHealth();
        this.currMana = this.stats.getMaxMana();
        this.abilities = abilities.clone();
    }

    public GameCharacter(GameCharacter src) {
        this.status = src.status;
        this.name = src.name;
        this.stats = src.stats;
        this.currHealth = src.currHealth;
        this.currMana = src.currMana;
        this.abilities = src.abilities.clone();
    }

    public void receiveAttack(Attack attack) {
        currHealth -= attack.calculateTotalDmg();
        if (currHealth <= 0) {
            this.status = CharacterStatus.DEAD;
            currHealth = 0;
        }
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

    public Ability[] getAbilities() {
        return abilities;
    }

    public Ability getAbility(int index) {
        return abilities[index];
    }

    public double getCurrHealth() {
        return currHealth;
    }

    public double getCurrMana() {
        return currMana;
    }

    public boolean isAlive() {
        return getStatus() == CharacterStatus.ALIVE;
    }

    private void setCurrHealth(double value){
        if(isAlive()){
            if(value > stats.getMaxHealth())
                value = stats.getMaxHealth();
            currHealth = value;
        }
    }

    public void useAbility(Ability ability) throws NotEnoughManaException {
        double manaCost = ability.getManaCost();
        if (currMana < manaCost) {
            throw new NotEnoughManaException(ability);
        }
        currMana -= manaCost;
    }

    public void heal() {
        setCurrHealth(stats.getMaxHealth());
    }

    public void heal(double healAmount) {
        setCurrHealth(healAmount);
    }

    public String getResources(){
        return "[" + getCurrHealth() + "]" + "(" + getCurrMana() + ")";
    }

    @Override
    public String toString() {
        return getName() + "[" + getCurrHealth() + "]" + "(" + getCurrMana() + ")";
    }

    public String toString(boolean withStats) {
        String result = toString();
        if(withStats)
            result += getStats().toString();
        return result;
    }
}
