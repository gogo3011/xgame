package Entities;

import Services.MenuService;
import Services.PrintingService;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private MenuService menuService;

    public HumanPlayer() {
        Scanner scanner = new Scanner(System.in);
        PrintingService printingService = new PrintingService(System.out);
        this.menuService = new MenuService(printingService, scanner);
    }

    public Ability chooseAbility(GameCharacter character) {
        return this.menuService.chooseAbility(character);
    }

    public AdventureBase chooseAdventure(GameSession session){
        return this.menuService.chooseAdventure(session);
    }

    public GameCharacter chooseCharacter(GameSession session) {
        this.character = this.menuService.chooseCharacter(session);
        return character;
    }
}
