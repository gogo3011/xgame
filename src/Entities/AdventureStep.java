package Entities;

import Utils.Helpers.AdventureStepType;

public class AdventureStep {
    private AdventureStepType type;
    private String text;
    public AdventureStep(AdventureStepType type, String text) {
        this.type = type;
        this.text = text;
    }

    public AdventureStepType getStepType() {
        return this.type;
    }

    public String getText() {
        return text;
    }
}
