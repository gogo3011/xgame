import Entities.*;
import Services.*;

import java.util.ArrayList;

public class XGame {
    public static void main(String[] args) {
        CharacterFactory characterFactory = new CharacterFactory();
        GameCharacter[] arr = characterFactory.createCharFromResources();
        AIPlayer ai = new AIPlayer();
        GameSession session = new GameSession(ai, arr);
        session.startSession();
    }
}
