import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stackverwaltung<String> stackVerwaltung = new Stackverwaltung<>();

        System.out.println("Willkommen zur Stack-Verwaltung!");
        boolean running = true;
//warteschlangen werden bei meiner implementation vorher erstellt

        while (running) {
            System.out.println("\nBitte wählen Sie eine Option:");
            System.out.println("1. Stack erstellen");
            System.out.println("2. Kunden zur warteschlange hinzufügen.");
            System.out.println("3. Oberstes Element anzeigen (Peek)");
            System.out.println("4. Oberstes Element entfernen (Pop)");
            System.out.println("5. Alle Elemente eines Stacks anzeigen");
            System.out.println("6. Beenden");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Geben Sie den Namen des neuen Stacks ein: ");
                    String stackName = scanner.nextLine();
                    stackVerwaltung.erstelleStack(stackName);
                    System.out.println("Stack '" + stackName + "' erstellt.");
                    break;
                case 2:
                 //   System.out.print("Geben Sie den Namen der Warteschlange ein: ");
                 //   String nameZumHinzufuegen = scanner.nextLine();

                   int welcher = scanner.nextInt();
                   //welches getränk wählt der kunde
                   switch(welcher) {
                       case 1:

                          // Capuccino

                           break;
                       case 2:
                         //  Kaffee


                           break;
                       case 3:
                         //  FlatWhite

                           break;
                       case 4:
                        //   ColdBrew

                           break;
                   }



                    System.out.print("Geben Sie den Namen des Elements ein: ");
                    String kundenName = scanner.nextLine();
                    Elementverwaltung.fuegeHinzu(nameZumHinzufuegen, new Knoten(kundenName));
                    System.out.println("Element '" + kundenName + "' hinzugefügt.");
                    break;
                case 3:
                    System.out.print("Geben Sie den Namen des Stacks ein: ");
                    String nameZumAnzeigen = scanner.nextLine();
                    String oberstesElement = stackVerwaltung.peek(nameZumAnzeigen);
                    if (oberstesElement != null) {
                        System.out.println("Oberstes Element: " + oberstesElement);
                    } else {
                        System.out.println("Der Stack ist leer oder existiert nicht.");
                    }
                    break;
                case 4:
                    System.out.print("Geben Sie den Namen des Stacks ein: ");
                    String nameZumEntfernen = scanner.nextLine();
                    String entferntesElement = stackVerwaltung.pop(nameZumEntfernen);
                    if (entferntesElement != null) {
                        System.out.println("Entferntes Element: " + entferntesElement);
                    } else {
                        System.out.println("Der Stack ist leer oder existiert nicht.");
                    }
                    break;
                case 5:
                    System.out.print("Geben Sie den Namen des Stacks ein: ");
                    String nameZumAusgeben = scanner.nextLine();
                    Stack<String> stack = stackVerwaltung.getStack(nameZumAusgeben);
                    if (stack != null) {
                        System.out.println("Elemente im Stack '" + nameZumAusgeben + "':");
                        stack.ausgeben();
                    } else {
                        System.out.println("Der Stack existiert nicht.");
                    }
                    break;
                case 6:
                    running = false;
                    System.out.println("Programm beendet.");
                    break;
                default:
                    System.out.println("Ungültige Auswahl. Bitte versuchen Sie es erneut.");
            }
        }

        scanner.close();
    }
}