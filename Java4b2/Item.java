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

    @Override
    public boolean equals(Object o) {
        // Prüft, ob das aktuelle Objekt und das übergebene Objekt identisch sind
        if (this == o) return true;
        // Prüft, ob das übergebene Objekt null ist oder ob die Klassen der beiden Objekte unterschiedlich sind
        if (o == null || getClass() != o.getClass()) return false;
        // Castet das übergebene Objekt zu einem Item
        Item item = (Item) o;
        // Vergleicht die Hashcodes der beiden Items
        return hashCode() == item.hashCode();
    }

    @Override
    public int hashCode() {
        // Verwendet die Objects.hash Methode, um einen Hashcode für das Item zu erzeugen
        return java.util.Objects.hash(name, cost);
    }

    public int betragInteger() {
        return (int) Math.round(cost);
    }
}
