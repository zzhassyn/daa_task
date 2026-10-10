# Binary Search Tree and Hash Table 

## Overview

This project compares:

- Binary Search Tree (BST)
- Hash Table with separate chaining

Operations tested:

- insert
- search
- delete

Input sizes:

- 100
- 1,000
- 10,000

Each test was run 5 times. Average time was measured with `System.nanoTime()`.

---

## Complexity

### BST

| Operation | Best | Average | Worst |
|---|---:|---:|---:|
| Insert | Θ(1) | O(log n) | O(n) |
| Search | Θ(1) | O(log n) | O(n) |
| Delete | Θ(1) | O(log n) | O(n) |

The BST is not self-balancing, so in the worst case it can become skewed and behave like a linked list.

### Hash Table

| Operation | Best | Expected | Worst |
|---|---:|---:|---:|
| Insert | Θ(1) | O(1) amortized | O(n) |
| Search | Θ(1) | O(1) | O(n) |
| Delete | Θ(1) | O(1) | O(n) |

The Hash Table uses separate chaining and resizes when the load factor is above `0.75`.

Load factor:

```text
α = n / m
```

where `n` is the number of elements and `m` is the number of buckets.

---

## Results

| n | Structure | Insert (ns) | Search (ns) | Delete (ns) |
|---:|---|---:|---:|---:|
| 100 | BST | 182,320 | 26,020 | 44,420 |
| 100 | Hash Table | 59,660 | 11,160 | 14,500 |
| 1,000 | BST | 280,620 | 337,560 | 257,700 |
| 1,000 | Hash Table | 326,100 | 72,860 | 108,160 |
| 10,000 | BST | 2,618,160 | 2,225,440 | 2,818,060 |
| 10,000 | Hash Table | 4,072,340 | 553,180 | 680,680 |

---

## Comparison

- Hash Table was faster for search and delete.
- BST was faster for insert at `n = 1,000` and `n = 10,000`.
- Hash Table insert became slower because resizing and rehashing happened during insertion.
- BST performance depends on tree shape.
- Hash Table performance depends on collisions, load factor, and resizing.

---

## Conclusion

Hash Table is better for fast exact-key lookup.

BST is useful when ordered data is needed.

The best structure depends on the workload.

---

## Run

Compile:

```bash
javac src/*.java
```

Run tests:

```bash
java -cp src Tests
```

Run benchmark:

```bash
java -cp src Benchmark
```
