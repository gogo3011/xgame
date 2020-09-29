package Entities;

import static Utils.Helpers.ConsoleColorInterface.*;

public class FriendlyCharacter extends GameCharacter {
    public FriendlyCharacter(String name, Stats stats, Ability[] abilities) {
        super(name, stats, abilities);
    }

    public FriendlyCharacter(GameCharacter character) {
        super(character.getName(), character.getStats(), character.getAbilities());
    }

    @Override
    public String toString() {
        return C_BLUE + getName() + C_END +
                "[" + C_GREEN + getCurrHealth() + C_END + "]"
                + "(" + C_CYAN + getCurrMana() + C_END + ")";
    }
}
