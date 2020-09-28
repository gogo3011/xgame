package Entities;

public class Stats {
    private double maxHealth;
    private double maxMana;
    // Physical dmg output
    private double strength;
    // Magical dmg output
    private double intelligence;
    // Physical dmg reduction
    private double armor;
    // Magical dmg reduction
    private double resistance;

    public Stats(double maxHealth, double maxMana,
                 double strength, double intelligence, double armor, double resistance) {
        this.maxHealth = maxHealth;
        this.maxMana = maxMana;
        this.strength = strength;
        this.intelligence = intelligence;
        this.armor = armor;
        this.resistance = resistance;
    }

    public double getArmor() {
        return armor;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public double getMaxMana() {
        return maxMana;
    }

    public double getResistance() {
        return resistance;
    }

    public double getStrength() {
        return strength;
    }

    public String toString() {
        return "| Max Health: " + getMaxHealth() + "\n" +
                "| Max Mana: " + getMaxMana() + "\n" +
                "| Strength: " + getStrength() + "\n" +
                "| Intelligence: " + getIntelligence() + "\n" +
                "| Armor: " + getIntelligence() + "\n" +
                "| Resistance: " + getIntelligence() + "\n";
    }
}
