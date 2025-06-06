package Beispiele;

import java.util.Scanner;
import java.util.Arrays;
import java.util.function.IntPredicate;

public class test {
    public void sumTest(int[] input) {
        System.out.println("Wir nehmen das Input Array: " + Arrays.toString(input) + " und summieren alle Indizes zusammen: " +
                Arrays.stream(input)
                        .sum());
    }

    public void sortTest(int[] input) {
        System.out.println("Wir nehmen das Input Array " + Arrays.toString(input) + " und sortieren es Alphanummerisch: " +
                Arrays.toString(Arrays.stream(input)
                        .sorted()
                        .toArray()));
    }

    public void filterTest(int[] input) {
        System.out.println("Wir nehmen das Input Array " + Arrays.toString(input) + " und übernehmen nur die Zahlen die größer als 6 sind: " +
                Arrays.toString(Arrays.stream(input)
                        .filter(x -> x > 6)
                        .toArray()));
    }

    public void filterTest(int[] input, IntPredicate lambda, String beschreibung) {
        System.out.println();
        System.out.println("Wir nehmen das Input Array " + Arrays.toString(input) + " und verwerfen alles für die \"" +
                beschreibung + "\" nicht zutrifft: " +
                Arrays.toString(Arrays.stream(input)
                        .filter(lambda)
                        .toArray()));
        System.out.println("-".repeat(100));
    }

    public void reduceTest(int[] input, String rechenart) {
        System.out.println();
        switch(rechenart) {
            case "+":
                System.out.println(
                        "Wir nehmen das Input Array " + Arrays.toString(input) + " und addieren alle Zahlen aufeinander auf: " +
                                Arrays.stream(input)
                                        .reduce((x, y) -> x + y)
                                        .getAsInt()
                );
                System.out.println("Hier besteht kein Unterschied zu .sum()!");
                System.out.println("-".repeat(100));
                break;

            case "-":
                System.out.println(
                        "Wir nehmen das Input Array " + Arrays.toString(input) + " und subtrahieren alle Zahlen von links nach rechts: " +
                                Arrays.stream(input)
                                        .reduce((x, y) -> x - y)
                                        .getAsInt()
                );
                System.out.println("-".repeat(100));
                break;

            case "*":
                System.out.println(
                        "Wir nehmen das Input Array " + Arrays.toString(input) + " und multiplizieren alle Zahlen von links nach rechts: " +
                                Arrays.stream(input)
                                        .reduce((x, y) -> x * y)
                                        .getAsInt()
                );
                System.out.println("-".repeat(100));
                break;

            case ":":
                System.out.println(
                        "Wir nehmen das Input Array " + Arrays.toString(input) + " und dividieren alle Zahlen von links nach rechts: " +
                                Arrays.stream(input)
                                        .reduce((x, y) -> x / y)
                                        .getAsInt()
                );
                System.out.println("-".repeat(100));
                break;

            default:
                Scanner scanner = new Scanner(System.in);
                System.out.println("Bitte eine gültige Rechenart auswählen: ");
                System.out.println("[ + ] - Addition");
                System.out.println("[ - ] - Subtraktion");
                System.out.println("[ * ] - Multiplikation");
                System.out.println("[ : ] - Division");
                System.out.print("Rechenart: ");
                rechenart = scanner.next();
                reduceTest(input, rechenart);
                return;
        }

    }

    // und jetzt das Ganze in Flo & Alex lesbar :P
    public void forSumTest(int[] input) {
        int summe = 0;
        for (int x : input) {
            summe =+ x;
        }
        System.out.println("Die Gesamtsumme von " + Arrays.toString(input) + " ist " + summe + ".");
    }

    public void forSortTest(int[] input) {
        Arrays.sort(input);
        System.out.println(input);
    }

    public void forFilterTest(int[] input, IntPredicate lambdaForX, String beschreibung) {
        // Erstmal zählen wie groß das neue Array werden muss
        int counter = 0;
        for (int x : input) {
            if (lambdaForX.test(x)) {
                counter++;
            }
        }
        System.out.println("In " + Arrays.toString(input) + " gibt es " + counter + " Zahlen auf welche \"" + beschreibung + "\" zutrifft.");

        // Neues Array erstellen
        int[] filtered = new int[counter];

        // Neues Array befüllen
        int index = 0;
        for (int x : input) {
            if (lambdaForX.test(x)) {
                filtered[index] = x;
                index++;
            }
        }

        // Neues Array ausgeben
        System.out.println(
                "Nach anwenden des Filters \"" + beschreibung + "\" auf " + Arrays.toString(input) + " bleibt noch " + Arrays.toString(filtered) + " übrig."
        );
        System.out.println("-".repeat(100));
    }

    public void forReduceTest(int[] input, String rechenart) {
        System.out.println();
        switch (rechenart) {
            case "+":
                int summe = 0;
                for (int x : input) {
                    summe += x;
                }
                System.out.println(
                        "Wenn man von Links nach Rechts alle Zahlen aus " + Arrays.toString(input) + " aufeinander addiert, erhält man " + summe + "."
                );
                System.out.println("-".repeat(100));
                break;

            case "-":
                int diff = 0;
                for (int x : input) {
                    diff -= x;
                }
                System.out.println(
                        "Wenn man von Links nach Rechts alle Zahlen aus " + Arrays.toString(input) + " voneinander abzieht, erhält man " + diff + "."
                );
                System.out.println("-".repeat(100));
                break;

            case "*":
                int prod = 1;
                for (int x : input) {
                    prod *= x;
                }
                System.out.println(
                        "Wenn man von links nach rechts alle Zahlen aus " + Arrays.toString(input) + " miteinander multipliziert, erhält man " + prod + "."
                );
                System.out.println("-".repeat(100));
                break;

            case ":":
                int quot = 1;
                for (int x : input) {
                    quot /= x;
                }
                System.out.println(
                        "Wenn man von links nach rechts alle Zahlen aus " + Arrays.toString(input) + " durcheinander dividiert, erhält man " + quot + "."
                );
                System.out.println("-".repeat(100));
                break;
                
            default:
                Scanner scanner = new Scanner(System.in);
                System.out.println("Bitte eine gültige Rechenart auswählen: ");
                System.out.println("[ + ] - Addition");
                System.out.println("[ - ] - Subtraktion");
                System.out.println("[ * ] - Multiplikation");
                System.out.println("[ : ] - Division");
                System.out.print("Rechenart: ");
                rechenart = scanner.next();
                forReduceTest(input, rechenart);
                return;
                

        }
    }

    public static void main(String[] args) {
        // tester objekt erstellen welches die testMethoden beinhaltet
        test tester = new test();

        // Test Arrays erstellen zum Herumspielen
        int[] intTest0 = {5, 4, 3, 2, 1, 0, 10, 9, 8, 7, 6};
        int[] intTest = {5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6};
        String stringTest = "Dies ist ein TestString.";
        char[] charTest = stringTest.toCharArray();

        // Lambda-Ausdrücke erklären (in IntelliJ sind Lambda-Ausdrücke "Predicates"
        // Der Lambda-Ausdruck wird für jedes Element des Arrays intTest ausgeführt und geprüft. Bei True wird übernommen bei False verworfen.
        tester.filterTest(intTest0, x -> x == 0, "x == 0");                       // Beispiel Lambda01
        tester.filterTest(intTest0, x -> x % 2 == 0, "x % 2 == 0");               // Beispiel Lambda02
        tester.filterTest(intTest, x -> 3 < x && x < 8, "3 < x < 8");             // Beispiel Lambda03
        tester.filterTest(intTest, x -> Math.pow(x, 2) <= 100, "x² <= 100");      // Beispiel Lambda04
        // Geht natürlich auch komplizierter und vor allem auch mit anderen oder komplexen Datentypen z.B. Strings

        // forFilterTest vorführen                     ^
        //                                            / \
        // sind die gleichen Lambdas wie hier drüber   |
        //                                             |
        tester.forFilterTest(intTest0, x -> x == 0, "x == 0");                    // Beispiel Lambda01
        tester.forFilterTest(intTest0, x -> x % 2 == 0, "x % 2 == 0");            // Beispiel Lambda02
        tester.forFilterTest(intTest, x -> 3 < x && x < 8, "3 < x < 8");          // Beispiel Lambda03
        tester.forFilterTest(intTest, x -> Math.pow(x, 2) <= 100, "x² <= 100");   // Beispiel Lambda04
        
        // forReduceTest vorführen
        tester.forReduceTest(intTest0, "+");
        tester.forReduceTest(intTest0, "-");
        tester.forReduceTest(intTest, "*");    // hier ist es notwendig ein Array !ohne! 0 zu nehmen, da bei "Punkt-Operationen" die 1 das neutrale Element darstellt und nicht die 0!
        tester.forReduceTest(intTest, ":");    // hier ist es notwendig ein Array !ohne! 0 zu nehmen, da bei "Punkt-Operationen" die 1 das neutrale Element darstellt und nicht die 0!
        
        // Ausprobieren
    }
}