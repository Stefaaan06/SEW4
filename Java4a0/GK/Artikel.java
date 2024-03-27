package Java4a0.GK;


/**
 * Artikel blueprint
 * @author Stefan
 * @version 05.02.2024
 */
public class Artikel {
    private String name;
    private double preis;

    public Artikel(String name, double preis) {
        if(preis < 0){
            preis = 0;
        }

        this.name = name;
        this.preis = preis;
    }

    public String artikeltext() {
        return name + " - " + preis + " €";
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        if(preis < 0) return;

        this.preis = preis;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
