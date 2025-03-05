import java.util.Scanner;

/**
 * Die Hauptklasse, die das Programm startet und die Benutzerinteraktion steuert.
 */
public class Main {
    /**
     * Die Hauptmethode, die das Programm ausführt.
     * @param args Kommandozeilenargumente (nicht verwendet)
     */
    public static void main(String[] args) {
        Verwaltung verwaltung = new Verwaltung();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nBitte wählen Sie eine Option:");
            System.out.println("1. Kunde hinzufügen");
            System.out.println("2. Bestellung bearbeiten");
            System.out.println("3. Getränkeliste anzeigen");
            System.out.println("4. Getränkeliste auffüllen");
            System.out.println("5. Alle Rechnungen anzeigen");
            System.out.println("6. Alle Kunden in der Warteschlange anzeigen");
            System.out.println("7. Beenden");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    verwaltung.kundeHinzufuegen();
                    break;
                case 2:
                    verwaltung.bearbeiteBestellung();
                    break;
                case 3:
                    verwaltung.zeigeGetraenkeListe();
                    break;
                case 4:
                    verwaltung.fuelleKaffeeListeAuf();
                    break;
                case 5:
                    verwaltung.zeigeAlleRechnungen();
                    break;
                case 6:
                    verwaltung.zeigeAlleKunden();
                    break;
                case 7:
                    running = false;
                    System.out.println("Programm wird beendet.");
                    break;
                default:
                    System.out.println("Ungültige Auswahl. Bitte versuchen Sie es erneut.");
            }
        }
        scanner.close();
    }
}