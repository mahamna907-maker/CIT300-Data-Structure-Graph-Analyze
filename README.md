# Data Structure & Graph Performance Analyzer

**Module:** CIT300 Data Structures and Algorithms
**Assignment:** Graded Practical Assignment 2 (Week 12)
**Institution:** Sri Lanka Technology Campus (SLTC)
**Language:** Java (console-based application)
**Repository:** https://github.com/mahamna907-maker/CIT300-Data-Structure-Graph-Analyze

---

## Project Description

This project is a single, integrated, menu-driven Java console application that demonstrates the practical use of the data structures and algorithms covered in Weeks 1-11 of CIT300.

The user can work with an **array, stack, queue, linked list and graph**, run **linear and binary search**, and traverse a graph with **BFS and DFS**. A **performance comparison** module measures the number of steps and the execution time of each algorithm so that the results can be related to algorithmic complexity (O(n), O(log n), O(V + E)).

The stack, queue and linked list are implemented manually. No `java.util.Stack`, `Queue` or `LinkedList` classes are used for these components. All user input is validated so that invalid text or out-of-range numbers never crash the program.

---

## Team Members

| | Member 1 | Member 2 | Member 3 | Member 4 |
|---|---|---|---|---|
| **Name** | AUF. Minaal | SF. Hamtha | T. Santhiya | MA. Hamna |
| **Student ID** | 23DA2-0892 | 23DA2-0499 | 23DA2-1053 | 23DA2-0508 |
| **Responsibility** | Array and Searching | Input Validation, Stack and Queue | Linked List and Performance Analysis | Graph and Main Integration |

### Member 1

**Student Name:** AUF. Minaal
**Student ID:** 23DA2-0892
**Assigned Responsibility:** Array and Searching
**Individual Contribution:**
- Assigned the Array and Searching components: `ArrayOperations` (fixed-capacity array with insert, delete, search and display) and `SearchOperations` (step-counted linear search and binary search, manual and random datasets, timed comparison)
- Because of a laptop problem, the code for these components was committed to the repository by MA. Hamna (Member 4) on the branch `feature/array-searching` (8 commits, merged in pull request #5)
- Responsible for understanding and explaining these components, their complexity and their integration in the demonstration video

### Member 2

**Student Name:** SF. Hamtha
**Student ID:** 23DA2-0499
**Assigned Responsibility:** Input Validation, Stack and Queue
**Individual Contribution:**
- Implemented `InputHelper`: one shared `Scanner`, validated integer input, range-checked input, non-empty text input, pause and end-of-input handling
- Implemented `MyStack`: array-based LIFO stack (push, pop, peek, display) with overflow and underflow handling
- Implemented `MyQueue`: circular-array FIFO queue (enqueue, dequeue, front, display) with overflow and empty-queue handling
- Built the stack and queue submenus with result logging (branch `feature/stack-queue-input`, merged in pull request #4)
- Tested the modules and integrated them with the main application

### Member 3

**Student Name:** T. Santhiya
**Student ID:** 23DA2-1053
**Assigned Responsibility:** Linked List and Performance Analysis
**Individual Contribution:**
- Implemented the singly linked list `LinkedListManager` with a custom `Node` class: insert (at the tail), delete, search and display, with its submenu (branch `feature/linked-list`, merged in pull request #1)
- The `PerformanceAnalyzer` class (shared results log and the performance comparison of linear vs binary search and BFS vs DFS), the change of `LinkedListManager` to use the shared `InputHelper`, and the matching change in `Main` were committed by MA. Hamna (Member 4) on the branch `feature/linkedlist-performance` because Member 3 was unavailable
- Responsible for understanding and explaining the linked list and the performance analysis, including why the step counts and times differ, in the demonstration video

### Member 4

**Student Name:** MA. Hamna
**Student ID:** 23DA2-0508
**Assigned Responsibility:** Graph and Main Integration (repository owner)
**Individual Contribution:**
- Implemented `Graph`: undirected graph using an adjacency list, add vertex, add edge (rejects missing vertices, self-loops and duplicates) and display
- Implemented BFS (using a queue) and recursive DFS with step counting, a sample graph loader and a seeded random graph generator
- Built the graph submenu and implemented `Main`, the 9-option main menu that integrates every component
- Created the repository, `.gitignore` and this README; merged pull requests; performed final integration and end-to-end testing
- Also committed the Array and Searching code for Member 1, and the `PerformanceAnalyzer` code and the `InputHelper` / `Main` integration changes for Member 3, because those members were unavailable (see their sections above)

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
| **Array** | Insert (at end or at an index), delete (by index or by value), search, display; handles a full array and invalid indexes |
| **Stack** | Push, pop, peek, display; stack overflow and underflow handling |
| **Queue** | Enqueue, dequeue, front, display (circular array); queue overflow and empty-queue handling |
| **Linked List** | Custom `Node` class; insert (at the tail), delete, search, display; handles an empty list and missing values |
| **Searching** | Linear and binary search with step count and execution time; manual or random dataset (sorted automatically for binary search); side-by-side comparison |
| **Graph** | Adjacency list; add vertex, add edge, display graph, BFS traversal, DFS traversal, sample graph loader |
| **Performance Comparison** | Linear vs binary search and BFS vs DFS, with steps and execution time shown in a comparison table |
| **Display All Results** | Numbered log of the array, stack, queue, search, graph and performance results recorded during the session |
| **Input Validation** | Every menu and prompt asks again on invalid or out-of-range input; bad input never crashes the program |

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

Option 7 with a dataset size of 1000 and 50 graph vertices (steps are exact; times vary from run to run):

```
=============================================
 PERFORMANCE COMPARISON
=============================================
Operation        Algorithm        Steps      Time (ns)
-------------------------------------------------------
Search           Linear Search    1000       15500
Search           Binary Search    10         2800
Graph Traversal  BFS              228        279700
Graph Traversal  DFS              228        195100
=============================================
Search: n = 1000 (worst-case target). Linear is O(n), binary is O(log n).
Graph : V = 50, E = 89. BFS and DFS are both O(V + E);
        step counts are near-equal because both visit every vertex and examine every edge.
Note  : times vary per run (JVM warm-up); steps are the reliable measure.
```

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

**Requirements:** JDK 17 or newer, available in the PATH (check with `javac -version`).

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

On Linux or macOS use `javac -d out src/*.java`.

**3. Run**

```bat
java -cp out Main
```

Type a menu number and press Enter (one number per line). Enter `9` in the main menu to exit.

> Tip: for a clean build, delete the `out` folder first (`rmdir /s /q out`), then repeat steps 2 and 3.

---

## Complexity Summary

| Structure / Algorithm | Operation | Complexity |
|---|---|---|
| Array | access / insert and delete (shifting) / search | O(1) / O(n) / O(n) |
| Stack | push, pop, peek | O(1) |
| Queue (circular array) | enqueue, dequeue, front | O(1) |
| Linked List | insert (at the tail), delete, search | O(n) |
| Linear Search | search | O(n) |
| Binary Search | search (sorted data only) | O(log n) |
| BFS | traversal (queue) | O(V + E) |
| DFS | traversal (recursion) | O(V + E) |

### Why the performance results differ

- **Linear vs binary search:** linear search checks the elements one by one, so its steps grow with `n`. Binary search halves the search range at every step, so its steps grow with `log n`. For 100000 elements the difference is 100000 steps against 17. Binary search needs sorted data, which is why datasets are sorted when they are entered or generated.
- **BFS vs DFS:** both visit every vertex and examine every edge once, so both are O(V + E) and their step counts are almost equal. They differ only in the visiting order: BFS goes level by level using a queue, DFS goes deep first using recursion.
- **Steps vs time:** step counts are exact and repeatable. The execution time in nanoseconds changes from run to run (JVM warm-up, CPU load), so steps are the more reliable measure.

---

## GitHub Collaboration

The project was developed using separate feature branches, small commits and pull requests that were merged into `main`.

| Branch | Content | Committed by |
|---|---|---|
| `feature/linked-list` | `LinkedListManager` | T. Santhiya |
| `feature/stack-queue-input` | `InputHelper`, `MyStack`, `MyQueue` | SF. Hamtha |
| `feature/array-searching` | `ArrayOperations`, `SearchOperations` | MA. Hamna, for AUF. Minaal (laptop problem) |
| `feature/graph-integration` | `Graph`, `Main`, `.gitignore`, README | MA. Hamna |
| `feature/linkedlist-performance` | `PerformanceAnalyzer`, `InputHelper` integration in `LinkedListManager`, `Main` update | MA. Hamna, for T. Santhiya (unavailable) |

Each commit and pull request can be seen on the repository's **Commits**, **Pull requests** and **Insights > Contributors** pages.

---

## Notes

- Binary search only works on sorted data. The searching module sorts the dataset automatically.
- The graph is undirected. Self-loops and duplicate edges are rejected.
- Stack and queue capacity is 10. Array capacity is 20.
- Linked list operations are not written to the results log. The other components are.
