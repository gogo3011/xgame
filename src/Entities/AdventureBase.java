package Entities;

public class AdventureBase {
    private String name;
    private String author;
    private AdventureStep[] steps;

    public AdventureBase(String name, String author, AdventureStep[] steps) {
        this.name = name;
        this.author = author;
        this.steps = steps;
    }

    public AdventureBase(AdventureBase base) {
        this.name = base.name;
        this.author = base.author;
        this.steps = base.steps.clone();
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public AdventureStep[] getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        return name + " by " + author + "| Steps: " + steps.length;
    }
}
