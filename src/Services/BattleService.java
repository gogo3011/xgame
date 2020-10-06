package Services;

import static Utils.Helpers.ConsoleColorInterface.*;

import Entities.Ability;
import Entities.Attack;
import Entities.GameCharacter;
import Entities.Player;

import java.util.ArrayList;

public class BattleService {
    private final static ArrayList<Attack> usedAttacks = new ArrayList<>();
    private final PrintingService printingService;
    private final Player host;
    private final Player opponent;

    public BattleService(PrintingService printingService, Player host, Player opponent) {
        this.printingService = printingService;
        this.host = host;
        this.opponent = opponent;
    }

    public void initiateBattle(GameCharacter init, GameCharacter target) {
        preBattleReport(init, target);
        while (target.isAlive() && init.isAlive()) {
            Ability abilityH = this.host.chooseAbility(init);
            attack(init, abilityH, target);
            if (target.isAlive()) {
                Ability abilityO = this.opponent.chooseAbility(target);
                attack(target, abilityO, init);
            }
        }
        postBattleReport(init, target);
    }

    public void attack(GameCharacter init, Ability ability, GameCharacter target) {
        try {
            Attack currAttack = new Attack(init, target, ability);
            currAttack.execute();
            attackReport(currAttack);
            addUsedAttack(currAttack);
            currAttack.saveCharactersStates();
        } catch (Exception ex) {
            printingService.print(ex.getMessage());
        }
    }

    public void heal() {
        host.getCharacter().heal();
        opponent.getCharacter().heal();
    }

    private void preBattleReport(GameCharacter init, GameCharacter target) {
        printingService.print(init.toString(true) + target.toString(true));
    }

    private void attackReport(Attack attack) {
        printingService.print(attack);
    }

    private void postBattleReport(GameCharacter init, GameCharacter target) {
        slainReport(init, target);
        usedAttacks.forEach(printingService::print);
    }

    private void slainReport(GameCharacter init, GameCharacter target) {
        if (!target.isAlive()) {
            printingService.print(C_RED_BACKGROUND + C_YELLOW
                    + init.getName() + " has slain "
                    + target.getName() + "!" + C_END + "\n");
        }
    }

    private void addUsedAttack(Attack attack) {
        usedAttacks.add(attack);
    }
}
