import Entities.AIPlayer;
import Entities.EnemyCharacter;
import Entities.FriendlyCharacter;
import Entities.HumanPlayer;
import Services.*;

import java.util.Scanner;

public class XGame {
    public static void main(String[] args) {
        CharacterFactory characterFactory = new CharacterFactory();
        FriendlyCharacter link = new FriendlyCharacter(characterFactory.createCharFromJSON("src/main/resources/Characters/link.json"));
        EnemyCharacter roni = new EnemyCharacter(characterFactory.createCharFromJSON("src/main/resources/characters/roni.json"));
        PrintingService printingService = new PrintingService();
        Scanner scanner = new Scanner(System.in);
        MenuService menuService = new MenuService(printingService, scanner);
        HumanPlayer friendly = new HumanPlayer(menuService);
        AIPlayer enemy = new AIPlayer();
        BattleService battleService = new BattleService(printingService, friendly, enemy);
        battleService.initiateBattle(link, roni);
    }
}
