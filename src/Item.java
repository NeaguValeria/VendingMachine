public enum Item {

    MARS(25, "Mars"),
    Twix(35, "Twix"),
    Bounty(45, "Bounty");

    private int price;
    private String name;

    Item(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
