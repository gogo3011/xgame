package Utils.Exceptions;

import Entities.Ability;

public class NotEnoughManaException extends CantCastAbilityException {
    public NotEnoughManaException(Ability usedAbility){
        super(usedAbility, "Not enough mana");
    }
}
