package Utils.Exceptions;

import Entities.Ability;

public class InvalidTargetException extends CantCastAbilityException{
    public InvalidTargetException(Ability usedAbility, String message){
        super(usedAbility, "Invalid Target " + message);
    }
}
