import Entities.*;

import Services.AdventureFactory;
import Services.CharacterFactory;

public class XGame {
    public static void main(String[] args) {
        GameCharacter[] characters = CharacterFactory.createCharFromResources();
        HumanPlayer p1 = new HumanPlayer();
        AIPlayer p2 = new AIPlayer();
        AdventureBase[] bases = AdventureFactory.createAdventureBasesFromResources();
        GameSession session = new GameSession(p1, p2, bases, characters);
        session.startSession();
    }
}
