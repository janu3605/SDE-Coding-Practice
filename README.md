# SDE Coding Practice

A collection of algorithmic problem solutions organized by problem-solving patterns and techniques. This repository is intended as a personal practice workspace for writing clean, well-structured Java solutions to common coding interview problems.

---

## 📁 Repository Structure

```
SDE-Coding-Practice/
├── README.md
├── Greedy/
│   └── TelecomCoverage.java
├── SlidingWindow/
│   └── CheckoutBuffer.java
└── DynamicProgramming/
```

### 🔍 What each folder represents

- **Greedy/** – Solutions that rely on greedy strategies: make locally optimal choices to build a global solution.
- **SlidingWindow/** – Problems where a subarray/window moves through input data to maintain constraints and compute results efficiently.
- **DynamicProgramming/** – (Empty for now) Placeholder for problems solved with DP techniques (memoization, tabulation, etc.).

---

## 💡 How to Use This Repo

1. **Pick a problem** and create a dedicated Java class under the appropriate technique folder.
2. **Keep it self-contained:** one public class per file, with a clear method signature for inputs/outputs.
3. **Add a short problem description** in comments (like the example in `SlidingWindow/CheckoutBuffer.java`).
4. **Run and test locally** using your preferred Java toolchain (JDK + IDE/CLI).

---

## 🧠 Example Problem (Sliding Window)

The `SlidingWindow/CheckoutBuffer.java` file contains a template for a sliding window problem:

- **Problem:** Find the maximum number of consecutive items that can be scanned without exceeding a weight capacity.
- **Inputs:** an integer array of item weights and a max weight limit.
- **Output:** the maximum length of a contiguous subarray whose sum is within the limit.

---

## ✅ Best Practices

- Name files and classes clearly (e.g., `CheckoutBuffer`, `TelecomCoverage`).
- Document assumptions and edge cases in comments.
- Keep code readable and modular so it’s easy to revisit later for review.

---

Happy coding! 🚀
