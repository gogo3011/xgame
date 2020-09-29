package Services;

import Entities.Ability;
import Entities.GameCharacter;
import Entities.GameSession;

import java.util.Scanner;

public class MenuService {
    private PrintingService printingService;
    private Scanner scanner;

    public MenuService(PrintingService printingService, Scanner scanner) {
        this.printingService = printingService;
        this.scanner = scanner;
    }

    public int askForInt(int max) {
        int answer = scanner.nextInt();
        while (answer > max) {
            answer = scanner.nextInt();
        }
        return answer;
    }

    public Ability chooseAbility(GameCharacter character) {
        this.printingService.print("Choose an ability to use:\n");
        listAbilities(character);
        return character.getAbility(
                askForInt(character.getAbilities().length) - 1
        );
    }

    public GameCharacter chooseCharacter(GameSession session) {
        listCharacters(session);
        this.printingService.print("Choose a character:\n");
        return session.getCharacter(
                askForInt(session.getCharacters().length) - 1
        );
    }

    public void listAbilities(GameCharacter character) {
        Ability[] abilities = character.getAbilities();
        for (int i = 0; i < abilities.length; i++) {
            printingService.print(i + 1 + ". " + abilities[i] + '\n');
        }
    }

    public void listCharacters(GameSession session) {
        GameCharacter[] characters = session.getCharacters();
        for (int i = 0; i < characters.length; i++) {
            printingService.print(i + 1 + ". " + characters[i].toString(true) + '\n');
        }
    }
}
