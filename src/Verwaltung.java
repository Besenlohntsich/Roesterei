import nrw.*;
import java.util.Scanner;

/**
 * Die Verwaltungsklasse für die Rösterei.
 * Verwaltet Kunden, Bestellungen, Rechnungen und Getränke.
 */
public class Verwaltung {
    Kundenverwaltung Kundenverwaltung = new Kundenverwaltung();
    private Queue<Kunde> kundenQueue;
    private Stack<Rechnung> rechnungsStack;
    private List<Getraenk> getraenkeListe;
    private Scanner scanner;
    private int rechnungsNummer = 1; // Neue Klassenvariable zur Verfolgung der Rechnungsnummer

    private BinarySearchTree<Kundenprofil> KundenBaum;

    /**
     * Konstruktor für die Verwaltungsklasse.
     * Initialisiert die Datenstrukturen und füllt die Getränkeliste auf.
     */
    public Verwaltung() {
        kundenQueue = new Queue<>();
        rechnungsStack = new Stack<>();
        getraenkeListe = new List<>();
        scanner = new Scanner(System.in);
        fuelleKaffeeListeAuf();
    }

    /**
     * Füllt die Getränkeliste mit Standardgetränken auf.
     */
    public void fuelleKaffeeListeAuf() {
        getraenkeListe.append(new Getraenk("Cappuccino", 350));
        getraenkeListe.append(new Getraenk("Kaffee", 250));
        getraenkeListe.append(new Getraenk("Flat White", 400));
        getraenkeListe.append(new Getraenk("Cold Brew", 300));
    }

    /**
     * Fügt einen neuen Kunden zur Warteschlange hinzu.
     */
    public void kundeHinzufuegen() {
        System.out.print("Name des Kunden: ");
        String name = scanner.nextLine();
        System.out.println("Wählen Sie ein Getränk:");
        int listSize = zeigeGetraenkeListe();
        int wahl = scanner.nextInt();
        scanner.nextLine(); // Verbrauche den Zeilenumbruch

        if (wahl > 0 && wahl <= listSize) {
            getraenkeListe.toFirst();
            for (int i = 1; i < wahl; i++) {
                getraenkeListe.next();
            }
            Getraenk gewaehltesGetraenk = getraenkeListe.getContent();
            Kunde neuerKunde = new Kunde(name, gewaehltesGetraenk.getName());
            neuerKunde.setGeld(1000); // Setze Geld auf 1000 Cent
            kundenQueue.enqueue(neuerKunde);
/**
            String pBenutzername = name;
            String pPw="a";
            Kundenverwaltung.neuenBenutzerAnlegen();
**/

            System.out.println("Kunde " + name + " wurde zur Warteschlange hinzugefügt.");
        } else {
            System.out.println("Ungültige Wahl. Kunde wird nicht hinzugefügt.");
        }
    }
    /**
     * Zeigt die aktuelle Getränkeliste an und gibt die Anzahl der Getränke zurück.
     * @return Die Anzahl der Getränke in der Liste
     */
    public int zeigeGetraenkeListe() {
        System.out.println("Getränkeliste:");
        getraenkeListe.toFirst();
        int index = 1;
        while (getraenkeListe.hasAccess()) {
            Getraenk g = getraenkeListe.getContent();
            System.out.println(index + ". " + g.getName() + " - " + g.getPreis() + " Cent");
            getraenkeListe.next();
            index++;
        }
        return index - 1; // Gibt die Anzahl der Getränke zurück
    }
    /**
     * Bearbeitet die Bestellung des nächsten Kunden in der Warteschlange.
     */
    public void bearbeiteBestellung() {
        if (kundenQueue.isEmpty()) {
            System.out.println("Keine Kunden in der Warteschlange.");
            return;
        }

        Kunde kunde = kundenQueue.front();
        kundenQueue.dequeue();

        Getraenk getraenk = sucheUndEntferneGetraenk(kunde.getWunschGetraenk());
        if (getraenk == null) {
            System.out.println("Getränk nicht verfügbar. Fülle Kaffeeliste auf.");
            fuelleKaffeeListeAuf();
            getraenk = sucheUndEntferneGetraenk(kunde.getWunschGetraenk());
        }

        if (getraenk != null) {
            int betrag = getraenk.getPreis();
            if (kunde.getGeld() >= betrag) {
                kunde.setGeld(kunde.getGeld() - betrag);
                Rechnung rechnung = new Rechnung(java.time.LocalDate.now().toString(), rechnungsNummer, betrag);
                rechnungsStack.push(rechnung);
                rechnungsNummer++; // Erhöhe die Rechnungsnummer für die nächste Rechnung
                kunde.setRechnung(rechnung);
                kunde.setGetraenkErhalten(true);
                kunde.setGetraenk(getraenk);
                System.out.println(kunde.getName() + " hat " + getraenk.getName() + " für " + betrag + " Cent bezahlt und erhalten.");
            } else {
                System.out.println(kunde.getName() + " hat nicht genug Geld für " + getraenk.getName() + ".");
                getraenkeListe.append(getraenk); // Lege das Getränk zurück in die Liste
            }
        } else {
            System.out.println("Getränk konnte nicht gefunden werden.");
        }
    }

    /**
     * Sucht und entfernt ein Getränk aus der Liste.
     * @param name Der Name des zu suchenden Getränks
     * @return Das gefundene Getränk oder null, wenn nicht gefunden
     */
    private Getraenk sucheUndEntferneGetraenk(String name) {
        getraenkeListe.toFirst();
        while (getraenkeListe.hasAccess()) {
            Getraenk getraenk = getraenkeListe.getContent();
            if (getraenk.getName().equalsIgnoreCase(name)) {
                getraenkeListe.remove();
                return getraenk;
            }
            getraenkeListe.next();
        }
        return null;
    }

    /**
     * Gibt alle Rechnungen aus dem Rechnungsstack aus.
     */
    public void zeigeAlleRechnungen() {
        if (rechnungsStack.isEmpty()) {
            System.out.println("Keine Rechnungen vorhanden.");
            return;
        }

        Stack<Rechnung> hilfsStack = new Stack<>();
        System.out.println("Alle Rechnungen:");

        while (!rechnungsStack.isEmpty()) {
            Rechnung rechnung = rechnungsStack.top();
            rechnungsStack.pop();
            System.out.println(rechnung);
            hilfsStack.push(rechnung);
        }

        // Rechnungen zurück in den ursprünglichen Stack transferieren
        while (!hilfsStack.isEmpty()) {
            rechnungsStack.push(hilfsStack.top());
            hilfsStack.pop();
        }
    }

    /**
     * Gibt alle Kunden in der Warteschlange aus.
     */
    public void zeigeAlleKunden() {
        if (kundenQueue.isEmpty()) {
            System.out.println("Keine Kunden in der Warteschlange.");
            return;
        }

        Queue<Kunde> hilfsQueue = new Queue<>();
        System.out.println("Kunden in der Warteschlange:");
        int position = 1;

        while (!kundenQueue.isEmpty()) {
            Kunde kunde = kundenQueue.front();
            kundenQueue.dequeue();
            System.out.println(position + ". " + kunde);
            hilfsQueue.enqueue(kunde);
            position++;
        }

        // Kunden zurück in die ursprüngliche Warteschlange transferieren
        while (!hilfsQueue.isEmpty()) {
            kundenQueue.enqueue(hilfsQueue.front());
            hilfsQueue.dequeue();
        }
    }


        private BinarySearchTree<Kundenprofil> KundenBaum;

        public Kundenverwaltung() {
            KundenBaum = new BinarySearchTree<>();
        }

        public void neuenBenutzerAnlegen() {
            Kundenprofil neuerBenutzer = new Kundenprofil(pBenutzername, pPw);
            KundenBaum.insert(neuerBenutzer);
        }

        public void nutzerLoeschen(String pBenutzername, String pPw) {
            Kundenprofil zuLoeschenderBenutzer = new Kundenprofil(pBenutzername, pPw);
            KundenBaum.remove(zuLoeschenderBenutzer);
        }

        public boolean profilVorhanden(String pBenutzername) {
            Kundenprofil suchProfil = new Kundenprofil(pBenutzername, "");
            return KundenBaum.search(suchProfil) != null;
        }


}