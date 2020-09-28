package Entities;

import Services.ColorInterface;
import Utils.Exceptions.InvalidTargetException;
import Utils.Exceptions.NotEnoughManaException;
import Utils.Exceptions.TargetIsDeadException;

public class Attack implements ColorInterface {
    private final GameCharacter init;
    private final GameCharacter target;
    private final Ability usedAbility;

    public Attack(GameCharacter init, GameCharacter target, Ability usedAbility) throws InvalidTargetException, NotEnoughManaException {
        if(!target.isAlive()){
            throw new TargetIsDeadException(usedAbility, target);
        }
        this.init = init;
        this.target = target;
        this.usedAbility = usedAbility;
        this.init.useAbility(this.usedAbility);
        this.target.receiveAttack(this);
    }

    public double calculatePhysicalDmg() {
        double dmg = this.init.getStats().getStrength() * usedAbility.getPhysicalMulti()
                - this.target.getStats().getArmor();
        if(dmg < 0) dmg = 0;
        return dmg;
    }

    public double calculateMagicalDmg() {
        double dmg = this.init.getStats().getIntelligence() *
                usedAbility.getMagicalMulti() - this.target.getStats().getResistance();
        if(dmg < 0) dmg = 0;
        return dmg;
    }

    public double calculateTotalDmg() {
        return calculateMagicalDmg() + calculatePhysicalDmg();
    }

    public GameCharacter getInit() {
        return init;
    }

    public GameCharacter getTarget() {
        return target;
    }

    public Ability getUsedAbility() {
        return usedAbility;
    }

    @Override
    public String toString(){
        GameCharacter init = getInit();
        GameCharacter target = getTarget();
        String result = init.toString() + " used "
                + C_PURPLE + getUsedAbility().getName() + C_END +
                " on " + target.toString() + " for "
                + C_WHITE_BACKGROUND + C_BLACK + calculateTotalDmg() +
                " dmg!" + C_END +"\n";
        if(!target.isAlive()){
            result += C_RED_BACKGROUND + C_YELLOW
                    + init.getName() + " has slain "
                    + target.getName() + "!" + C_END + "\n";
        }
        return result;
    }
}
