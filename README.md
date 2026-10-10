# Data Structure & Graph Performance Analyzer
 
**Module:** CIT300 Data Structures and Algorithms – Graded Practical Assignment 2
**Language:** Java (console application)
 
## Project Description
A single integrated console application that demonstrates arrays, stacks, queues,
linked lists, searching, graphs (BFS/DFS) and a performance/complexity comparison.
 
## Team Members
> Fill in EVERY member exactly as registered. Wrong or missing details lose marks.
 
**Student Name:** <Full Name>
**Student ID:** <ID>
**Assigned Responsibility:** Array and Searching
**Individual Contribution:**
- Implemented ArrayOperations (insert, delete, search, display)
- Implemented SearchOperations (linear and binary search with step counters)
- Tested and integrated modules with the main application
 
**Student Name:** <Full Name>
**Student ID:** <ID>
**Assigned Responsibility:** Stack and Queue
**Individual Contribution:**
- Implemented MyStack (push, pop, peek, display, overflow/underflow handling)
- Implemented MyQueue (circular array: enqueue, dequeue, front, display)
- Tested and integrated modules with the main application
 
**Student Name:** <Full Name>
**Student ID:** <ID>
**Assigned Responsibility:** Linked List
**Individual Contribution:**
- Implemented LinkedListOperations with a custom Node class
- Insert (head/tail/position), delete, search, display
- Tested and integrated module with the main application
 
**Student Name:** <Full Name>
**Student ID:** <ID>
**Assigned Responsibility:** Graph, Performance Comparison and Integration
**Individual Contribution:**
- Implemented Graph (adjacency list, add vertex/edge, display, BFS, DFS)
- Implemented PerformanceAnalyzer and results log
- Implemented Main menu and InputHelper (input validation)
 
## Technologies Used
Java 17+ (developed on Java 21), Git/GitHub
 
## Main Features
- Array: insert (end/index), delete (index/value), search, display, full/invalid-index handling
- Stack: push, pop, peek, display, overflow and empty-stack handling
- Queue: enqueue, dequeue, front, display, overflow and empty-queue handling
- Linked List: custom nodes; insert head/tail/position, delete, search, display
- Searching: linear vs binary search with step count and time, side-by-side comparison
- Graph: adjacency list; add vertex/edge, display, BFS, DFS, sample graph loader
- Performance Comparison: steps and nanosecond timing for search and graph traversal
- Display All Results: log of every operation result
- Input validation on every menu
 
## How to Run
```bash
cd DSAGraphAnalyzer
mkdir out
javac -d out src/*.java
java -cp out Main
```
 
## Complexity Summary
| Structure / Algorithm | Operation | Complexity |
|---|---|---|
| Array | access / insert, delete / search | O(1) / O(n) / O(n) |
| Stack, Queue | push, pop, enqueue, dequeue | O(1) |
| Linked List | insert head / insert tail, search, delete | O(1) / O(n) |
| Linear Search | search | O(n) |
| Binary Search | search (sorted data) | O(log n) |
| BFS, DFS | traversal | O(V + E) |
