package Entities;

import Services.BattleService;
import Services.PrintingService;
import Utils.Helpers.PrintingStyle;

public class Adventure extends AdventureBase{
    private final GameCharacter host;
    private final GameCharacter opponent;
    private final BattleService battleService;
    private final PrintingService printingService;

    public Adventure(AdventureBase base, GameCharacter host,
                     GameCharacter opponent, BattleService battleService,
                     PrintingService printingService) {
        super(base);
        this.host = host;
        this.opponent = opponent;
        this.printingService = printingService;
        this.battleService = battleService;
    }

    public void start() {
        for (AdventureStep step: getSteps()) {
            executeStep(step);
        }
    }

    private void executeStep(AdventureStep step) {
        switch (step.getStepType()) {
            case EXPOSITION -> {
                String text = step.getText();
                text = text.replaceAll("\\{host}", host.getName())
                            .replaceAll("\\{opponent}", opponent.getName());
                this.printingService.print(text, PrintingStyle.SLOW);
            }
            case DIALOG -> {
                String text = step.getText();
                text = text.replaceAll("\\{host}", host.getName())
                        .replaceAll("\\{opponent}", opponent.getName());
                this.printingService.print(text, PrintingStyle.FAST);
            }
            case BATTLE ->
                this.battleService.initiateBattle(host, opponent);
            case HEAL ->
                this.battleService.heal();
        }
        this.printingService.print('\n');
    }
}
