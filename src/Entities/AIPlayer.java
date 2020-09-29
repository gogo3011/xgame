package Entities;

import java.util.concurrent.ThreadLocalRandom;

public class AIPlayer extends Player {
    public AIPlayer() {

    }

    public Ability chooseAbility(GameCharacter character) {
        int max = character.getAbilities().length;
        int rand = ThreadLocalRandom.current().nextInt(0, max);
        return character.getAbility(rand);
    }

    public GameCharacter chooseCharacter(GameSession session) {
        int max = session.getCharacters().length;
        int rand = ThreadLocalRandom.current().nextInt(0, max);
        return session.getCharacter(rand);
    }
}
