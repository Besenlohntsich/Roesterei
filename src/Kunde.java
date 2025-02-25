/**
 * Repräsentiert einen Kunden in der Rösterei.
 */
public class Kunde {
    private String name;
    private String wunschGetraenk;
    private int geld;
    private Rechnung rechnung;
    private boolean getraenkErhalten;
    private Getraenk getraenk;

    /**
     * Konstruktor für einen Kunden.
     * @param name Der Name des Kunden
     * @param wunschGetraenk Das gewünschte Getränk des Kunden
     */
    public Kunde(String name, String wunschGetraenk) {
        this.name = name;
        this.wunschGetraenk = wunschGetraenk;
        this.geld = 1000;
        this.getraenkErhalten = false;
    }

    // Getter und Setter Methoden

    public String getName() {
        return name;
    }

    public String getWunschGetraenk() {
        return wunschGetraenk;
    }

    public int getGeld() {
        return geld;
    }

    public void setGeld(int geld) {
        this.geld = geld;
    }

    public Rechnung getRechnung() {
        return rechnung;
    }

    public void setRechnung(Rechnung rechnung) {
        this.rechnung = rechnung;
    }

    public boolean isGetraenkErhalten() {
        return getraenkErhalten;
    }

    public void setGetraenkErhalten(boolean getraenkErhalten) {
        this.getraenkErhalten = getraenkErhalten;
    }

    public Getraenk getGetraenk() {
        return getraenk;
    }

    public void setGetraenk(Getraenk getraenk) {
        this.getraenk = getraenk;
    }
}