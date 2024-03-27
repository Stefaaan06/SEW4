package Java4a0.GK;


/**
 * Warenkorb der Artikel-Objekte speichern kann.
 * @author Stefan
 * @version 05.02.2024
 */
public class Warenkorb {
    private Artikel[] artikelListe;


    public Warenkorb(int kapazitaet) {
        artikelListe = new Artikel[kapazitaet];
    }


    public boolean addArtikel(Artikel artikel) {
        if(artikel == null) return false;

        for (int i = 0; i < artikelListe.length; i++) {
            if (artikelListe[i] == null) {
                artikelListe[i] = artikel;
                return true;
            }
        }
        return false;
    }


    public boolean addArtikel(String name, double preis) {
        Artikel artikel = new Artikel(name, preis);
        return addArtikel(artikel);
    }

    public void loescheUeber(double preisgrenze) {
        for (int i = 0; i < artikelListe.length; i++) {
            if (artikelListe[i] != null && artikelListe[i].getPreis() > preisgrenze) {
                artikelListe[i] = null;
            }
        }
    }

    public String warenkorbtext() {
        StringBuilder sb = new StringBuilder("Warenkorb: ");
        for (Artikel artikel : artikelListe) {
            if (artikel != null) {
                sb.append(artikel.artikeltext()).append("; ");
            }
        }
        return sb.toString().trim();
    }

    public void vergroessern(int neueKapazitaet) {
        Artikel[] neueListe = new Artikel[neueKapazitaet];
        for (int i = 0; i < artikelListe.length; i++) {
            neueListe[i] = artikelListe[i];     //breakpoint here
        }
        artikelListe = neueListe;
    }
}
