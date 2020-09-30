import Entities.AIPlayer;
import Entities.GameCharacter;
import Entities.GameSession;

import Entities.HumanPlayer;
import Services.CharacterFactory;

public class XGame {
    public static void main(String[] args) {
        CharacterFactory characterFactory = new CharacterFactory();
        GameCharacter[] arr = characterFactory.createCharFromResources();
        AIPlayer ai = new AIPlayer();
        AIPlayer ai2 = new AIPlayer();
        GameSession session = new GameSession(ai2, ai, arr);
        session.startSession();
    }
}
