package Entities;

import Services.BattleService;
import Services.MenuService;
import Services.PrintingService;

import java.util.Scanner;

public class GameSession {
    private final GameCharacter[] characters;
    private final AdventureBase[] adventures;
    private Player player1;
    private Player player2;

    public GameSession(Player host, Player opponent, AdventureBase[] adventures,
                       GameCharacter[] characters){
        this.player1 = host;
        this.player2 = opponent;
        this.adventures = adventures.clone();
        this.characters = characters.clone();
    }

    public void startSession() {
        FriendlyCharacter friendly = new FriendlyCharacter(player1.chooseCharacter(this));
        EnemyCharacter enemy = new EnemyCharacter(player2.chooseCharacter(this));
        AdventureBase base = player1.chooseAdventure(this);
        PrintingService printingService = new PrintingService();
        BattleService battleService = new BattleService(printingService, player1, player2);
        Adventure adventure = new Adventure(base, friendly, enemy, battleService, printingService);
        adventure.start();
    }

    public GameCharacter[] getCharacters() {
        return characters;
    }

    public GameCharacter getCharacter(int i) {
        return characters[i];
    }

    public AdventureBase[] getAdventures() {
        return adventures;
    }

    public AdventureBase getAdventure(int i) {
        return adventures[i];
    }
}
