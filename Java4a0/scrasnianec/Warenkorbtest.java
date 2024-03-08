package Java4a0.scrasnianec;

/**
 * Warenkorbtest
 * @author Stefan Crasnianec
 * @version 05.02.2024
 */
public class Warenkorbtest {
    public static void main(String[] args) {
        Warenkorb warenkorb = new Warenkorb(3);

        // Hinzufügen von Artikeln
        System.out.println(warenkorb.addArtikel(new Artikel("Handy 1", 899.99)) ? "Artikel hinzugefügt." : "Hinzufügen fehlgeschlagen.");
        System.out.println(warenkorb.addArtikel("Handy 2", 849.99) ? "Artikel hinzugefügt." : "Hinzufügen fehlgeschlagen.");
        System.out.println(warenkorb.addArtikel("Handy 3", 79.50) ? "Artikel hinzugefügt." : "Hinzufügen fehlgeschlagen.");

        // Print
        System.out.println(warenkorb.warenkorbtext());

        // Versuch, einen weiteren Artikel hinzuzufügen
        System.out.println(warenkorb.addArtikel("Handy 4", 499.99) ? "Artikel hinzugefügt." : "Hinzufügen fehlgeschlagen.");

        // Print
        System.out.println(warenkorb.warenkorbtext());

        // Erweiterung des Warenkorbs
        warenkorb.vergroessern(4);

        // Versuch, einen weiteren Artikel hinzuzufügen
        System.out.println(warenkorb.addArtikel("Handy 4", 499.99) ? "Artikel hinzugefügt." : "Hinzufügen fehlgeschlagen.");

        // Print
        System.out.println(warenkorb.warenkorbtext());

        // Löschen von Artikeln über einem bestimmten Preis
        warenkorb.loescheUeber(100);

        // Print
        System.out.println(warenkorb.warenkorbtext());
    }
}