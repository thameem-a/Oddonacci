# 🔁 Oddonacci Algorithm Analysis

This project demonstrates and compares three different algorithmic approaches to computing the **Oddonacci** sequence — an integer sequence similar to Fibonacci, where each number is the sum of the previous three numbers.

---

## 📚 Overview

The Oddonacci sequence is defined as:
```
Oddonacci(n) = Oddonacci(n-1) + Oddonacci(n-2) + Oddonacci(n-3)
```
with base cases:
```
Oddonacci(1) = Oddonacci(2) = Oddonacci(3) = 1
```

This project implements and benchmarks the following recursive strategies:

1. **Multiple Recursion** – Basic implementation with exponential time complexity (O(3^n)).
2. **Linear Recursion** – Improved version that avoids recomputation by passing intermediate results (O(n)).
3. **Tail Recursion** – Highly efficient version with minimal stack usage (O(n)).

---

## 📁 Files Included

- `Oddonacci.java` – Contains all three implementations: multiple, linear, and tail-recursive.
- `Driver.java` – Runs and compares the different Oddonacci algorithms.
- `PsuedoCode.txt` – High-level pseudocode for each algorithm.
- `OddoOut.txt` – Tabulated benchmark results (time in nanoseconds) for various `n`.
- `Analysis.txt` – Descriptive analysis comparing performance and time complexity.
- `Analysis2.txt` – Further theoretical explanation and breakdown of the recursion mechanics.

---

## 📈 Sample Results (OddoOut.txt)

| n  | Multiple (ns) | Linear (ns) | Tail (ns) | Result     |
|----|----------------|--------------|------------|------------|
| 5  | 2,201,376      | 7,794        | 5,582      | 5          |
| 10 | 14,210         | 4,491        | 2,645      | 105        |
| 20 | 811,461        | 7,564        | 2,901      | 46,499     |
| 30 | 217,122,414    | 10,805       | 4,587      | 20,603,361 |

⏱️ As shown, **multiple recursion** quickly becomes unscalable, while **tail recursion** maintains excellent performance even at higher `n` values【26†source】.

---

## 🧠 Key Takeaways

- **Multiple Recursion** is elegant but inefficient due to recomputation of overlapping subproblems【27†source】.
- **Linear Recursion** avoids recomputation by passing a 3-element state array【29†source】.
- **Tail Recursion** outperforms all, utilizing a constant stack frame and allowing deeper recursion【28†source】.

---

## ✅ How to Run

Compile and run using any Java compiler:

```bash
javac Driver.java Oddonacci.java
java Driver
```

---
