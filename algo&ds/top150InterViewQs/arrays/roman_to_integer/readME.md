# Input and Output

```

Input: s = "III"
Output: 3
Explanation: III = 3.

```

```

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

```

```

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

```

# Explanation

1) When a bigger letter precedes a smaller letter, the letters are added. For example: MI, M > I, so MI = M + I = 1000 + 1 = 1001.
2) When a smaller letter precedes a bigger letter, the letters are subtracted. For example: IV, I < V, so IV = V - I = 5 - 1 = 4.
3) When a letter is repeated multiple times, they get added. For example: XXX = X + X + X = 10 + 10 + 10 = 30
4) The same letter cannot be used more than three times in succession.

NOTE: comparing i and i+1 doesnt work. 