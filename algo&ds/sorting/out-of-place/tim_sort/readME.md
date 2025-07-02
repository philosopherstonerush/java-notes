
# Why is time complexity O(n log n) 

I was particulary confused to see time complexity as O(n log n) as insertion sort would run over the elemnts multiple times. 

Apparently this is the answer:

```declarative

Insertion sort is used only on small chunks

- Each of these runs is short, so the cost of insertion sort stays limited.

- For example, if a run size is fixed at 32, insertion sort is only sorting 32 elements, which is a constant-sized problem.

- This results in a total cost across the entire array of O(n)O(n) for this phase.

```

time complexity of insertion sort in worst case or average case: O(n^2) 

but:

```declarative

You're absolutely right to raise this — it might **seem** like using **insertion sort**, which is $O(n^2)$ in the worst case, should ruin Timsort’s efficiency. But in **Timsort**, that doesn’t happen. Let’s go deep into **why**.

---

### ✅ Key Insight: Insertion Sort is Bounded in Timsort

Even though **insertion sort** has a worst-case of $O(n^2)$ in general, Timsort uses it **only on small slices (called "runs")** of the array — typically **32 to 64 elements long**.

This makes a **huge** difference.

#### Example:

If you have an array of $n = 1,000,000$ elements, and the run size is 32, you’ll have around:

$$
\frac{1{,}000{,}000}{32} \approx 31{,}250 \text{ runs}
$$

Each run of 32 elements is sorted with insertion sort, and sorting 32 elements costs at most:

$$
O(32^2) = O(1024)
$$

Which is **constant**, since 32 is a constant.

Now multiply:

$$
O(1024) \times 31{,}250 = O(n)
$$

So even if **each tiny insertion sort is quadratic**, the total cost over the entire array remains **linear** in $n$. It **never becomes $O(n^2)$**.

---

### 🧠 Timsort is Engineered to Avoid Global Quadratic Behavior

Timsort takes several smart precautions:

1. **It finds natural runs**: It scans the array to find already sorted sequences (very common in real-world data).
2. **Insertion sort is applied only to small, mostly sorted runs**.
3. **Merge sort** takes over for the heavy lifting, and that dominates the time complexity at $O(n \log n)$.
4. **Merge strategies are optimized** (e.g., "galloping mode") to reduce overhead.

---

### 🔁 Summary

| Sorting Algorithm | Worst-case Time | When It's Used in Timsort                    |
| ----------------- | --------------- | -------------------------------------------- |
| Insertion Sort    | $O(n^2)$        | On **tiny chunks**, so it’s **O(n)** overall |
| Merge Sort        | $O(n \log n)$   | On entire data, dominates complexity         |

So yes, insertion sort **is** $O(n^2)$ in general — but in **Timsort**, it's never applied to large data. That’s why **Timsort overall is still $O(n \log n)$** in the worst case.

---

Would you like to see a real-world example in Python where Timsort performs better than naive insertion sort even on worst-case input?


```

so it is effectively O(N)

then considering max(O(N), O(i * log(N))) --> O(N * log(N)) dominates so thats why O(N * log(N)) is considered as the time complexity. 

```declarative

You run 1 km every day ⇒ O(n)
But you also climb a hill that gets 1 meter taller each day ⇒ O(nlogn)
Over time, the hill climbing dominates your effort — the flat running becomes trivial in comparison.

```

# Why only add +1 when calculating leftArrLen but not when doing rightArrLen

Great question — this is one of those subtle details in merge sort that trips up a lot of people. Let's break it down clearly.

### First, understand the indices:

You're given:

```java
merge(arr, left, right, mid)
```

This assumes:

* `arr[left...mid]` is the **left half**
* `arr[mid+1...right]` is the **right half**

This means:

* The left half **includes** the element at `mid`
* The right half **starts** from `mid + 1` and includes `right`

---

### So let's look at the lengths:

#### Left subarray:

* Starts at `left`, ends at `mid`
* Number of elements = `mid - left + 1`
  (We add `+1` because both `left` and `mid` are included)

#### Right subarray:

* Starts at `mid + 1`, ends at `right`
* Number of elements = `right - (mid + 1) + 1 = right - mid`

So that’s why:

```java
int leftArrLen = mid - left + 1;
int rightArrLen = right - mid;
```

---

### Why **not** add `+1` to `right - mid`?

Because `mid + 1` is already the first element of the right half. So you’re just counting from `mid + 1` to `right` inclusive, which is `right - mid` elements.

---

### In short:

| Subarray | Start     | End     | Length Formula   |
| -------- | --------- | ------- | ---------------- |
| Left     | `left`    | `mid`   | `mid - left + 1` |
| Right    | `mid + 1` | `right` | `right - mid`    |

Let me know if you want a visual example with array values!
