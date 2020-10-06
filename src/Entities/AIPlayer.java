package Entities;

import java.util.concurrent.ThreadLocalRandom;

public class AIPlayer extends Player {
    public AIPlayer() {

    }

    public Ability chooseAbility(GameCharacter character) {
        return character.getAbility(
                chooseRandInt(character.getAbilities().length)
        );
    }

    public GameCharacter chooseCharacter(GameSession session) {
        this.character = session.getCharacter(
                chooseRandInt(session.getCharacters().length)
        );
        return this.character;
    }

    public AdventureBase chooseAdventure(GameSession session) {
        return session.getAdventure(
                chooseRandInt(session.getAdventures().length)
        );
    }

    private int chooseRandInt(int max){
        return ThreadLocalRandom.current().nextInt(0, max);
    }
}
