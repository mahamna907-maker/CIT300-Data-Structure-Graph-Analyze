/** Entry point: main menu that integrates every component. */
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
 
        int choice;
        do {
            System.out.println("\n=============================================");
            System.out.println(" DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("=============================================");
            System.out.println("6. Graph Operations");
            System.out.println("9. Exit");
            choice = InputHelper.readInt("Enter your choice: ");
            switch (choice) {
                case 6 -> graph.menu();
                case 9 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice. Please enter 1-9.");
            }
        } while (choice != 9);
    }
}
