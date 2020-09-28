package Entities;

public class Ability extends GameEntity {
    private String name;
    private double physicalMulti;
    private double magicalMulti;
    private double manaCost;
    public Ability(){
        setDescription("Empty ability (no effect)");
        setMagicalMulti(0);
        setPhysicalMulti(0);
    }

    public Ability(String name, String description, double physicalMulti, double magicalMulti, double manaCost) {
        setName(name);
        setDescription(description);
        setPhysicalMulti(physicalMulti);
        setMagicalMulti(magicalMulti);
        setManaCost(manaCost);
    }

    public Ability(Ability ability) {
        setName(ability.name);
        setDescription(ability.getDescription());
        setManaCost(ability.manaCost);
        setPhysicalMulti(ability.physicalMulti);
        setMagicalMulti(ability.magicalMulti);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMagicalMulti(double magicalMulti) {
        if(magicalMulti >= 0) {
            this.magicalMulti = magicalMulti;
        }
    }

    public void setPhysicalMulti(double physicalMulti) {
        if (physicalMulti >= 0) {
            this.physicalMulti = physicalMulti;
        }
    }

    public void setManaCost(double manaCost) {
        if (manaCost >= 0) {
            this.manaCost = manaCost;
        }
    }

    public double getMagicalMulti() {
        return magicalMulti;
    }

    public double getPhysicalMulti() {
        return physicalMulti;
    }

    public double getManaCost() {
        return manaCost;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName() + "(" + getManaCost() + ")";
    }
}
