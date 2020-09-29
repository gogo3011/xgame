package Entities;

public abstract class Player {
    public abstract Ability chooseAbility(GameCharacter character);
    public abstract GameCharacter chooseCharacter(GameSession session);
}
