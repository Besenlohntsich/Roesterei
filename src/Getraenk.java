/**
 * Repräsentiert ein Getränk in der Rösterei.
 */
public class Getraenk {
    private String name;
    private int preis;

    /**
     * Konstruktor für ein Getränk.
     * @param name Der Name des Getränks
     * @param preis Der Preis des Getränks in Cent
     */
    public Getraenk(String name, int preis) {
        this.name = name;
        this.preis = preis;
    }

    /**
     * Gibt den Namen des Getränks zurück.
     * @return Der Name des Getränks
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt den Preis des Getränks zurück.
     * @return Der Preis des Getränks in Cent
     */
    public int getPreis() {
        return preis;
    }
}