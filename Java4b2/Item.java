package Java4b2;

public record Item(String name, double cost) {

    public Item(String name, double cost) {
        if (name == null || cost < 0) {
            throw new IllegalArgumentException("Name darf nicht null sein und Kosten dürfen nicht negativ sein.");
        }
        this.name = name;
        this.cost = cost;
    }

    public Item(String name) {
        this(name, 0);
    }
    @Override
    public String toString() {
        return "Item[name=" + name + ", cost=" + cost + "]";
    }

    public int betragInteger() {
        return (int) Math.round(cost);
    }
}
