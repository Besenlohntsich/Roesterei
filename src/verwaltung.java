import java.util.Scanner;

public class Verwaltung {
    private Queue<Kunde> kundenQueue;
    private Stack<Rechnung> rechnungsStack;
    private List<Getraenk> getraenkeListe;
    private Scanner scanner;

    public Verwaltung() {
        kundenQueue = new Queue<>();
        rechnungsStack = new Stack<>();
        getraenkeListe = new List<>();
        scanner = new Scanner(System.in);
        fuelleKaffeeListeAuf();
    }

    public void fuelleKaffeeListeAuf() {
        getraenkeListe.append(new Getraenk("Cappuccino", 350));
        getraenkeListe.append(new Getraenk("Kaffee", 250));
        getraenkeListe.append(new Getraenk("Flat White", 400));
        getraenkeListe.append(new Getraenk("Cold Brew", 300));
    }

    public void kundeHinzufuegen() {
        System.out.print("Name des Kunden: ");
        String name = scanner.nextLine();
        System.out.println("Wählen Sie ein Getränk:");
        System.out.println("1. Cappuccino");
        System.out.println("2. Kaffee");
        System.out.println("3. Flat White");
        System.out.println("4. Cold Brew");
        int wahl = scanner.nextInt();
        scanner.nextLine(); // Verbrauche den Zeilenumbruch

        String wunschGetraenk;
        switch (wahl) {
            case 1:
                wunschGetraenk = "Cappuccino";
                break;
            case 2:
                wunschGetraenk = "Kaffee";
                break;
            case 3:
                wunschGetraenk = "Flat White";
                break;
            case 4:
                wunschGetraenk = "Cold Brew";
                break;
            default:
                System.out.println("Ungültige Wahl. Kunde wird nicht hinzugefügt.");
                return;
        }

        Kunde neuerKunde = new Kunde(name, wunschGetraenk);
        neuerKunde.setGeld(1000); // Setze Geld auf 1000 Cent
        kundenQueue.enqueue(neuerKunde);
        System.out.println("Kunde " + name + " wurde zur Warteschlange hinzugefügt.");
    }

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
                Rechnung rechnung = new Rechnung(java.time.LocalDate.now().toString(), rechnungsStack.size() + 1, betrag);
                rechnungsStack.push(rechnung);
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

    public void zeigeGetraenkeListe() {
        System.out.println("Getränkeliste:");
        getraenkeListe.toFirst();
        while (getraenkeListe.hasAccess()) {
            Getraenk g = getraenkeListe.getContent();
            System.out.println(g.getName() + " - " + g.getPreis() + " Cent");
            getraenkeListe.next();
        }
    }
}
