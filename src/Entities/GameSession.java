package Entities;

import Services.BattleService;
import Services.MenuService;
import Services.PrintingService;

import java.util.Scanner;

public class GameSession {
    private final GameCharacter[] characters;
    private Player player1;
    private Player player2;

    public GameSession(Player host, Player opponent, GameCharacter[] characters){
        this.player1 = host;
        this.player2 = opponent;
        this.characters = characters.clone();
    }

    public void startSession() {
        FriendlyCharacter friendly = new FriendlyCharacter(player1.chooseCharacter(this));
        EnemyCharacter enemy = new EnemyCharacter(player2.chooseCharacter(this));
        PrintingService printingService = new PrintingService();
        BattleService battleService = new BattleService(printingService, player1, player2);
        battleService.initiateBattle(friendly,enemy);
    }

    public GameCharacter[] getCharacters() {
        return characters;
    }

    public GameCharacter getCharacter(int i) {
        return characters[i];
    }
}
