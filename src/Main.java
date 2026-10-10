/** Entry point: main menu that integrates every component. */
public class Main {
    public static void main(String[] args) {
        ArrayOperations array = new ArrayOperations();
        MyStack stack = new MyStack();
        MyQueue queue = new MyQueue();
        LinkedListOperations list = new LinkedListOperations();
        SearchOperations search = new SearchOperations();
        Graph graph = new Graph();
 
        int choice;
        do {
            System.out.println("\n=============================================");
            System.out.println(" DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("=============================================");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("9. Exit");
            choice = InputHelper.readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> array.menu();
                case 2 -> stack.menu();
                case 3 -> queue.menu();
                case 4 -> list.menu();
                case 5 -> search.menu();
                case 6 -> graph.menu();
                case 9 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice. Please enter 1-9.");
            }
        } while (choice != 9);
    }
}
