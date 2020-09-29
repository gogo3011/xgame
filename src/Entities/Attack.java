package Entities;

import static Utils.Helpers.ConsoleColorInterface.*;

import Utils.Exceptions.AttackHasBeenExecutedException;
import Utils.Exceptions.NotEnoughManaException;
import Utils.Exceptions.TargetIsDeadException;

public class Attack {
    private final GameCharacter init;
    private final GameCharacter target;
    private final Ability usedAbility;
    private boolean used;

    public Attack(GameCharacter init, GameCharacter target, Ability usedAbility){
        this.init = init;
        this.target = target;
        this.usedAbility = usedAbility;
    }

    public double calculatePhysicalDmg() {
        double dmg = this.init.getStats().getStrength() * usedAbility.getPhysicalMulti()
                - this.target.getStats().getArmor();
        if (dmg < 0) dmg = 0;
        return dmg;
    }

    public double calculateMagicalDmg() {
        double dmg = this.init.getStats().getIntelligence() *
                usedAbility.getMagicalMulti() - this.target.getStats().getResistance();
        if (dmg < 0) dmg = 0;
        return dmg;
    }

    public double calculateTotalDmg() {
        return calculateMagicalDmg() + calculatePhysicalDmg();
    }

    public void execute() throws NotEnoughManaException, TargetIsDeadException, AttackHasBeenExecutedException{
        if(used){
            throw new AttackHasBeenExecutedException(this);
        }
        if(!target.isAlive()) {
            throw new TargetIsDeadException(usedAbility, target);
        }
        this.init.useAbility(this.usedAbility);
        this.target.receiveAttack(this);
        used = true;
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
    public String toString() {
        return init.toString() + " used "
                + C_PURPLE + getUsedAbility().getName() + C_END +
                " on " + target.toString() + " for "
                + C_WHITE_BACKGROUND + C_BLACK + calculateTotalDmg() +
                " dmg!" + C_END + "\n";
    }
}
