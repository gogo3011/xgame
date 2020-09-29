import Entities.*;
import Services.*;

import java.util.Scanner;

public class XGame {
    public static void main(String[] args) {
        CharacterFactory characterFactory = new CharacterFactory();
        FriendlyCharacter link = new FriendlyCharacter(characterFactory.createCharFromJSON("src/main/resources/Characters/link.json"));
        EnemyCharacter roni = new EnemyCharacter(characterFactory.createCharFromJSON("src/main/resources/characters/roni.json"));
        GameCharacter[] arr = {link, roni};
        AIPlayer ai = new AIPlayer();
        GameSession session = new GameSession(ai, arr);
        session.startSession();
    }
}
