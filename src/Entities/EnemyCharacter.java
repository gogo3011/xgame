package Entities;

import static Utils.Helpers.ConsoleColorInterface.*;

public class EnemyCharacter extends GameCharacter {
    public EnemyCharacter(String name, Stats stats, Ability[] abilities) {
        super(name, stats, abilities);
    }

    public EnemyCharacter(GameCharacter character) {
        super(character);
    }

    @Override
    public String toString() {
        return C_RED + getName() + C_END +
                "[" + C_GREEN + getCurrHealth() + C_END + "]"
                + "(" + C_CYAN + getCurrMana() + C_END + ")";
    }
}
