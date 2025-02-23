import java.util.Scanner;

public static void main(String[] args) {
    Verwaltung verwaltung = new Verwaltung();
    boolean running = true;
    private Scanner scanner;
    scanner = new Scanner(System.in);

    while (running) {
        System.out.println("\nBitte wählen Sie eine Option:");
        System.out.println("1. Kunde hinzufügen");
        System.out.println("2. Bestellung bearbeiten");
        System.out.println("3. Getränkeliste anzeigen");
        System.out.println("4. Beenden");

        int choice = verwaltung.scanner.nextInt();
        verwaltung.scanner.nextLine(); // Verbrauche den Zeilenumbruch

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
                running = false;
                System.out.println("Programm wird beendet.");
                break;
            default:
                System.out.println("Ungültige Auswahl. Bitte versuchen Sie es erneut.");
        }
    }
    verwaltung.scanner.close();
}

