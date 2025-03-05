/**
 * Repräsentiert eine Rechnung in der Rösterei.
 */
public class Rechnung {
    private String datum;
    private int nummer;
    private int betrag;

    /**
     * Konstruktor für eine Rechnung.
     * @param datum Das Datum der Rechnung
     * @param nummer Die Rechnungsnummer
     * @param betrag Der Rechnungsbetrag in Cent
     */
    public Rechnung(String datum, int nummer, int betrag) {
        this.datum = datum;
        this.nummer = nummer;
        this.betrag = betrag;
    }

    // Getter Methoden

    public String getDatum() {
        return datum;
    }

    public int getNummer() {
        return nummer;
    }

    public int getBetrag() {
        return betrag;
    }
    @Override
    public String toString() {
        return "Rechnung #" + getNummer() + " vom " + getDatum() + ", Betrag: " + getBetrag() + " Cent";
    }
}