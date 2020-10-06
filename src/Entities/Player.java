package Entities;

public abstract class Player {
    protected GameCharacter character;
    public abstract Ability chooseAbility(GameCharacter character);
    public abstract GameCharacter chooseCharacter(GameSession session);
    public abstract AdventureBase chooseAdventure(GameSession session);
    public GameCharacter getCharacter(){
        return character;
    }
}
