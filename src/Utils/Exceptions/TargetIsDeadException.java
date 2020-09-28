package Utils.Exceptions;

import Entities.Ability;
import Entities.GameCharacter;

public class TargetIsDeadException extends InvalidTargetException {
    public TargetIsDeadException(Ability usedAbility, GameCharacter target) {
        super(usedAbility, "|" + target.toString() + " is dead");
    }
}
