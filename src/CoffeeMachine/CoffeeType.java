package CoffeeMachine;

public enum CoffeeType {
    GROUND("в зернах"),
    BEANS("молотый");
    private String description;

    CoffeeType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
