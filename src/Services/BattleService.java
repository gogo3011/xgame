package Services;

import Entities.Ability;
import Entities.Attack;
import Entities.GameCharacter;
import Entities.Player;
import Utils.Exceptions.CantCastAbilityException;

import java.util.ArrayList;

public class BattleService {
    private final static ArrayList<Attack> usedAttacks = new ArrayList<>();
    private final PrintingService printingService;
    private final Player initPlayer;
    private final Player targetPlayer;

    public BattleService(PrintingService printingService, Player initPlayer, Player targetPlayer) {
        this.printingService = printingService;
        this.initPlayer = initPlayer;
        this.targetPlayer = targetPlayer;
    }

    public void initiateBattle(GameCharacter init, GameCharacter target) {
        preBattleReport(init, target);
        while (target.isAlive() && init.isAlive()) {
            Ability abilityI = this.initPlayer.chooseAbility(init);
            attack(init, abilityI, target);
            if (target.isAlive()) {
                Ability abilityT = this.targetPlayer.chooseAbility(target);
                attack(target, abilityT, init);
            }
        }
    }

    public void attack(GameCharacter init, Ability ability, GameCharacter target) {
        try {
            Attack currAttack = new Attack(init, target, ability);
            battleReport(currAttack);
            addUsedAttack(currAttack);
        } catch (CantCastAbilityException ex) {
            printingService.print(ex.getMessage());
        }
    }

    private void preBattleReport(GameCharacter init, GameCharacter target) {
        printingService.print(init.toString(true) + target.toString(true));
    }

    private void battleReport(Attack attack) {
        printingService.print(attack);
    }

    private void postBattleReport() {
        usedAttacks.forEach(printingService::print);
    }

    private void addUsedAttack(Attack attack) {
        usedAttacks.add(attack);
    }
}
