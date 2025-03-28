import nrw.*;

/**
 * Repräsentiert einen Kunden in der Rösterei.
 */
public class Kunde implements ComparableContent <Kunde> {
    private String name;
    private String wunschGetraenk;
    private int geld;
    private Rechnung rechnung;
    private boolean getraenkErhalten;
    private Getraenk getraenk;
    private String password;

    /**
     * Konstruktor für einen Kunden.
     *
     * @param name           Der Name des Kunden
     * @param wunschGetraenk Das gewünschte Getränk des Kunden
     */
    public Kunde(String name, String wunschGetraenk) {
        this.name = name;
        this.password = password;
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

    @Override
    public String toString() {
        return "Kunde: " + getName() + ", Wunschgetränk: " + getWunschGetraenk();
    }
}








        @Override
        public boolean isGreater(Kundenprofil pContent) {
            return this.name.compareTo(pContent.getname()) > 0;
        }

        @Override
        public boolean isLess(Kundenprofil pContent) {
            return this.name.compareTo(pContent.getname()) < 0;
        }

        @Override
        public boolean isEqual(Kundenprofil pContent) {
            return this.name.equals(pContent.getname());
        }

        @Override
        public String toString() {
            return "name: " + name;
        }
    }


