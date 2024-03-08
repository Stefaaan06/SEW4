package Java4b1;

public class Item {
    private String name;
    private double cost;

    public Item(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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

}
