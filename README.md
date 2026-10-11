# Data Structure & Graph Performance Analyzer

**Module:** CIT300 Data Structures and Algorithms
**Assignment:** Graded Practical Assignment 2 (Week 12)
**Institution:** Sri Lanka Technology Campus (SLTC)
**Language:** Java (console-based application)
**Repository:** https://github.com/mahamna907-maker/CIT300-Data-Structure-Graph-Analyze

---

## Project Description

This project is a single, integrated, menu-driven Java console application that demonstrates the practical use of core data structures and algorithms covered in Weeks 1-11 of CIT300.

The user can work with an **array, stack, queue, linked list and graph**, run **linear and binary search**, and traverse a graph with **BFS and DFS**. A **performance comparison** module measures the number of steps and the execution time of each algorithm, so the results can be related to algorithmic complexity (O(n), O(log n), O(V + E)). Every operation is recorded in a shared results log that can be displayed from the main menu.

All data structures are implemented manually (no `java.util.LinkedList`, `Stack` or `Queue` classes are used for the stack, queue and linked list components), and all user input is validated so that invalid text never crashes the program.

---

## Team Members

| | Member 1 | Member 2 | Member 3 | Member 4 |
|---|---|---|---|---|
| **Name** | AUF. Minaal | SF. Hamtha | T. Santhiya | MA. Hamna |
| **Student ID** | `<23DA2-0892>` | `<23DA2-0499>` | `<23DA2-1053>` | `<23DA2-0508>` |
| **Responsibility** | Array and Searching | Input Validation, Stack and Queue | Linked List and Performance Analysis | Graph and Main Integration (repository owner) |
| **Git branch** | `feature/array-searching` | `feature/stack-queue-input` | `feature/linkedlist-performance` | `feature/graph-integration` |

### Member 1

**Student Name:** AUF. Minaal
**Student ID:** `<23DA2-0892>`
**Assigned Responsibility:** Array and Searching
**Individual Contribution:**
- Implemented `ArrayOperations`: fixed-capacity array (20) with insert at end/index, delete by index/value, search and display, using element shifting
- Added full/empty/invalid-index checks before every change
- Implemented `SearchOperations`: step-counted linear search and binary search
- Added manual dataset entry (parsed, validated and sorted) and random dataset generation
- Added timed search helpers and the side-by-side linear vs binary comparison with logging
- Built the array and searching submenus with input validation
- Tested and integrated both modules with the main application

### Member 2

**Student Name:** SF. Hamtha
**Student ID:** `<23DA2-0499>`
**Assigned Responsibility:** Input Validation, Stack and Queue
**Individual Contribution:**
- Implemented `InputHelper`: one shared `Scanner`, validated integer input, range-checked input, non-empty text input, pause and end-of-input handling
- Implemented `MyStack`: array-based LIFO stack (push, pop, peek, display) with overflow and underflow handling
- Implemented `MyQueue`: circular-array FIFO queue (enqueue, dequeue, front, display) with overflow and empty-queue handling
- Built the stack and queue submenus with result logging
- Tested and integrated the modules with the main application

### Member 3

**Student Name:** T. Santhiya
**Student ID:** `<23DA2-1053>`
**Assigned Responsibility:** Linked List and Performance Analysis
**Individual Contribution:**
- Implemented the singly linked list (`LinkedListManager`) with a custom `Node` class: insert, delete, search and display, with its submenu
- Implemented `PerformanceAnalyzer`: shared results log (`log()`, `showAllResults()`)
- Implemented the performance comparison (`runComparison()`): linear vs binary search and BFS vs DFS, printed as a results table with steps and execution time
- Connected the linked list to `InputHelper` for validated input
- Tested and integrated the modules with the main application

### Member 4

**Student Name:** MA. Hamna
**Student ID:** `<23DA2-0508>`
**Assigned Responsibility:** Graph and Main Integration (repository owner)
**Individual Contribution:**
- Implemented `Graph`: undirected graph using an adjacency list, add vertex, add edge (rejects missing vertices, self-loops and duplicates), display
- Implemented BFS (queue) and recursive DFS with step counting, a sample graph loader and a seeded random graph generator
- Built the graph submenu
- Implemented `Main`: the 9-option main menu that integrates every component
- Created the repository, `.gitignore` and this README; reviewed and merged teammates' pull requests; performed final integration and end-to-end testing

---

## Technologies Used

- Java 17 or newer (JDK)
- Git and GitHub (branches, commits, pull requests)
- Visual Studio Code with the Extension Pack for Java
- Windows Command Prompt for compiling and running

---

## Main System Features

| Component | Features |
|---|---|
| **Array** | Insert (end / index), delete (index / value), search, display; handles full array and invalid index |
| **Stack** | Push, pop, peek, display; stack overflow and underflow handling |
| **Queue** | Enqueue, dequeue, front, display (circular array); queue overflow and empty-queue handling |
| **Linked List** | Custom `Node` class; insert, delete, search, display; handles empty list and missing values |
| **Searching** | Linear search and binary search with step count and time; manual or random dataset (sorted automatically for binary search); side-by-side comparison |
| **Graph** | Adjacency list; add vertex, add edge, display graph, BFS traversal, DFS traversal, sample graph loader |
| **Performance Comparison** | Linear vs binary search and BFS vs DFS with steps and execution time in a comparison table |
| **Display All Results** | Numbered log of every operation result recorded during the session |
| **Input Validation** | Every menu and prompt re-asks on invalid or out-of-range input; no crashes on bad input |

### Main Menu

```
=============================================
 DATA STRUCTURE & GRAPH ANALYZER
=============================================
1. Array Operations
2. Stack Operations
3. Queue Operations
4. Linked List Operations
5. Searching Operations
6. Graph Operations
7. Performance Comparison
8. Display All Results
9. Exit
Enter your choice:
```

### Example Performance Comparison Output

```
=============================================
 PERFORMANCE COMPARISON
=============================================
Operation        Algorithm        Steps      Time (ns)
-------------------------------------------------------
Search           Linear Search    XXXXX      XXXXX
Search           Binary Search    XXXXX      XXXXX
Graph Traversal  BFS              XXXXX      XXXXX
Graph Traversal  DFS              XXXXX      XXXXX
=============================================
```

*(The values above are placeholders. The program prints the real measured values.)*

---

## Project Structure

```
CIT300-Data-Structure-Graph-Analyze/
├── src/
│   ├── Main.java                 # Main menu and integration
│   ├── InputHelper.java          # Validated console input
│   ├── ArrayOperations.java      # Array component
│   ├── MyStack.java              # Stack component
│   ├── MyQueue.java              # Queue component
│   ├── LinkedListManager.java    # Linked list component
│   ├── SearchOperations.java     # Linear and binary search
│   ├── Graph.java                # Graph, BFS and DFS
│   └── PerformanceAnalyzer.java  # Results log and performance comparison
├── .gitignore
└── README.md
```

---

## How to Run

**Requirements:** JDK 17 or newer installed and available in the PATH (check with `javac -version`).

**1. Clone the repository**

```bash
git clone https://github.com/mahamna907-maker/CIT300-Data-Structure-Graph-Analyze.git
cd CIT300-Data-Structure-Graph-Analyze
```

**2. Compile** (Windows Command Prompt)

```bat
mkdir out
javac -d out src\*.java
```

On Linux / macOS use `javac -d out src/*.java`.

**3. Run**

```bat
java -cp out Main
```

Choose an option from the main menu (1-9). Enter `9` to exit.

> Tip: for a clean build, delete the `out` folder first (`rmdir /s /q out`), then repeat steps 2 and 3.

---

## Complexity Summary

| Structure / Algorithm | Operation | Complexity |
|---|---|---|
| Array | access / insert, delete (shifting) / search | O(1) / O(n) / O(n) |
| Stack | push, pop, peek | O(1) |
| Queue (circular array) | enqueue, dequeue, front | O(1) |
| Linked List | insert at head | O(1) |
| Linked List | insert at tail / position, delete, search | O(n) |
| Linear Search | search | O(n) |
| Binary Search | search (sorted data only) | O(log n) |
| BFS | traversal (queue) | O(V + E) |
| DFS | traversal (recursion) | O(V + E) |

### Why the performance results differ

- **Linear vs binary search:** linear search checks elements one by one, so its steps grow with `n`. Binary search halves the search range each step, so its steps grow with `log n`. For large datasets the difference in steps is very large. Binary search requires sorted data, which is why datasets are sorted when they are entered or generated.
- **BFS vs DFS:** both visit every vertex and examine every edge once, so both are O(V + E) and their step counts are almost equal. They differ only in visiting order (BFS goes level by level using a queue, DFS goes deep first using recursion).
- **Steps vs time:** step counts are exact and repeatable. Execution time in nanoseconds varies between runs (JVM warm-up, CPU load), so steps are the more reliable measure.

---

## GitHub Collaboration

The project was developed collaboratively using separate feature branches, small meaningful commits and pull requests that were reviewed and merged into `main`.

| Branch | Owner | Content |
|---|---|---|
| `feature/stack-queue-input` | SF. Hamtha | InputHelper, MyStack, MyQueue |
| `feature/array-searching` | AUF. Minaal | ArrayOperations, SearchOperations |
| `feature/linkedlist-performance` | T. Santhiya | LinkedListManager, PerformanceAnalyzer |
| `feature/graph-integration` | MA. Hamna | Graph, Main, README |

Each member's individual commits and pull requests can be seen in the repository's **Commits**, **Pull requests** and **Insights > Contributors** pages.

---

## Notes

- Binary search only works on sorted data. The searching module sorts the dataset automatically.
- The graph is undirected. Self-loops and duplicate edges are rejected.
- Stack and queue capacity is 10; array capacity is 20.
