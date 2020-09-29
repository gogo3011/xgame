package Utils.Exceptions;

import Entities.Attack;

public class CantExecuteAttackException extends Exception {
    public CantExecuteAttackException(Attack attack, String message){
        super("Can't execute attack " + attack + "|" + message);
    }
}
