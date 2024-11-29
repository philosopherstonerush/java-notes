# Input and Output

```java

Input: x = 2.00000, n = 10
Output: 1024.00000

```

```java

Input: x = 2.10000, n = 3
Output: 9.26100

```

```java

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

```

# Bitwise AND

```html

n = 11
 
8   4   2   1 => binary (2^n) 
1   0   1   1 => 11 in binary
            1 => AND 1, empty spaces are zero
=> 0 0 0 1 => odd which basically means 11 % 2 != 0

```

# Right shit operator


```java

n = 11

8   4   2   1
1   0   1   1 => binary of 11
  1   0   1 => after right shift

therefore => 1 0 1 => 5 which basically is 11 / 2

```

In Java, the >>>= operator is the unsigned right shift assignment operator. It shifts the bits of a number to the right and fills the leftmost bits with zeros, regardless of whether the number is positive or negative (unlike >>, which preserves the sign bit for negative numbers). Then it assigns the result back to the variable.

# Why x *= x

You could use debug feature to see it slowly

```java

x = 7, n = 11

then using BINARY EXPONENTIATION 7^11 can be split as
        
8 4 2 1        
1 0 1 1 => binary of 11

then,

7^8 (skip) 7^2 7^1 [skip if 0]

Multiple all of those,

> 1.977326743E9

we need n & 1 to only multiple when 1 comes
we need x *= x to increase the exponent to the next 2^n 

```