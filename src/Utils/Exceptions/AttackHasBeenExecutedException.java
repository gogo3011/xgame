package Utils.Exceptions;

import Entities.Attack;

public class AttackHasBeenExecutedException extends CantExecuteAttackException{
    public AttackHasBeenExecutedException(Attack attack){
        super(attack, "Attack has been executed");
    }
}
