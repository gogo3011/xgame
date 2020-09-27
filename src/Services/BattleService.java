package Services;

import Entities.Ability;
import Entities.Attack;
import Entities.GameCharacter;
import Utils.CharacterStatus;

import java.util.ArrayList;

public class BattleService {
    private static ArrayList<Attack> usedAttacks = new ArrayList<Attack>();
    private static PrintingService printingService = new PrintingService();

    public BattleService() {
    }

    public void attack(GameCharacter init, Ability ability, GameCharacter target) {
        if (init.usedAbility(ability)) {
            if (target.getStatus() == CharacterStatus.ALIVE) {
                Attack currAttack = new Attack(init, target, ability);
                target.receiveAttack(currAttack);
                battleReport(currAttack);
                addUsedAttack(currAttack);
            }
        }
    }

    private void battleReport(Attack attack){
        printingService.print(attack.getInit().getName() + " used "
                + attack.getUsedAbility().getName() + " on " + attack.getTarget().getName() + " for "
                + attack.calculateTotalDmg() + "! \n");
    }

    private void addUsedAttack(Attack attack) {
        usedAttacks.add(attack);
    }
}
