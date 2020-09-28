import Entities.GameCharacter;
import Services.BattleService;
import Services.CharacterFactory;

public class XGame {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        CharacterFactory characterFactory = new CharacterFactory();
        GameCharacter link = characterFactory.createCharFromJSON("src/main/resources/Characters/link.json");
        GameCharacter roni = characterFactory.createCharFromJSON("src/main/resources/characters/roni.json");
        BattleService battleService = new BattleService();
        for (int i = 0; i < 7; i++) {
            battleService.attack(link, link.getAbility(0), roni);
        }
    }
}
