package Utils.Exceptions;

import Entities.Ability;

public class CantCastAbilityException extends Exception {
    public CantCastAbilityException(Ability usedAbility, String message) {
        super("Can't cast " + usedAbility + "|" + message + '\n');
    }
}
