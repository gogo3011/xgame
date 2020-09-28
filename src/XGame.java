import Entities.EnemyCharacter;
import Entities.FriendlyCharacter;
import Entities.GameCharacter;
import Services.*;

import java.awt.*;
import java.util.Scanner;

public class XGame {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        CharacterFactory characterFactory = new CharacterFactory();
        FriendlyCharacter link = new FriendlyCharacter(characterFactory.createCharFromJSON("src/main/resources/Characters/link.json"));
        EnemyCharacter roni = new EnemyCharacter(characterFactory.createCharFromJSON("src/main/resources/characters/roni.json"));
        PrintingService printingService = new PrintingService();
        Scanner scanner = new Scanner(System.in);
        MenuService menuService = new MenuService(printingService, scanner);
        PlayerService friendly = new PlayerService(menuService, printingService);
        PlayerService enemy = new PlayerService(menuService, printingService);
        BattleService battleService = new BattleService(printingService, friendly, enemy);
        battleService.initiateBattle(link, roni);
    }
}
