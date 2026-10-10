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
    
    /** Reads a whole number within [min, max]. */
    public static int readInt(String prompt, int min, int max) {
        while (true) {
            int v = readInt(prompt);
            if (v >= min && v <= max) return v;
            System.out.println("Please enter a number between " + min + " and " + max + ".");
        }
    }

    /** Reads a non-empty line of text. */
    public static String readLine(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!sc.hasNextLine()) { System.out.println("\nNo more input. Exiting."); System.exit(0); }
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Input cannot be empty.");
        }
    }

    public static void pause() {
        System.out.print("Press Enter to continue...");
        if (sc.hasNextLine()) sc.nextLine();
    }
}