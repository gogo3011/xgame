package Services;

import Entities.Ability;
import Entities.Attack;
import Entities.GameCharacter;
import Utils.CharacterStatus;
import Utils.Exceptions.InvalidTargetException;
import Utils.Exceptions.NotEnoughManaException;

import java.util.ArrayList;

public class BattleService {
    private static ArrayList<Attack> usedAttacks = new ArrayList<Attack>();
    private static PrintingService printingService = new PrintingService();

    public BattleService() {
    }

    public void attack(GameCharacter init, Ability ability, GameCharacter target) {
        try {
            Attack currAttack = new Attack(init, target, ability);
            target.receiveAttack(currAttack);
            battleReport(currAttack);
            addUsedAttack(currAttack);
        } catch (NotEnoughManaException ex) {
            printingService.print(ex.getMessage());
        } catch (InvalidTargetException ex) {
            printingService.print(ex.getMessage());
        }
    }

    private void battleReport(Attack attack) {
        GameCharacter init = attack.getInit();
        GameCharacter target = attack.getTarget();
        // if target is still alive
        if (target.getStatus() == CharacterStatus.ALIVE) {
            printingService.print(attack);
        } else {
            //target is dead
            printingService.print(init.getName() + " has slain " + target.getName() + "!\n");
        }
    }

    private void addUsedAttack(Attack attack) {
        usedAttacks.add(attack);
    }

    private void postBattleReport(){
        usedAttacks.forEach((el) -> {

        });
    }
}
