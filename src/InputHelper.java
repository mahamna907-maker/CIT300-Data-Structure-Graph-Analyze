import java.util.Scanner;

/** Central place for validated console input so invalid text never crashes the app. */
public class InputHelper {
    private static final Scanner sc = new Scanner(System.in);

    /** Reads any whole number, re-prompting until valid. */
    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!sc.hasNextLine()) { System.out.println("\nNo more input. Exiting."); System.exit(0); }
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }
}