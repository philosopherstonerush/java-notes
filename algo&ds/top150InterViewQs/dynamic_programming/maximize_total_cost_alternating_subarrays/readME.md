


OMFG THE COST FUNCTION IS BASICALLY SAYING THAT SIGNS ARE BEING CHANGED ALTERNATIVELY

if we have an array {a,b,c,d,e,f}

then cost if we take the whole arr is --> a - b + c - d + e - f

At each element, we have to see if we need to add it to the previous result or proceed to creating a new subarray

            -> a - b + c
   -> a - b or
            -> a - b, c
a   or
            -> a, b - c
   ->  a, b or
            -> a, b, c


```

Input: nums = [1,-2,3,4]

Output: 10

Explanation:

One way to maximize the total cost is by splitting [1, -2, 3, 4] into subarrays [1, -2, 3] and [4]. The total cost will be (1 + 2 + 3) + 4 = 10.

HERE,

1 - (-2) + 3 and 4 is taken, adding will give 10

```

```
Input: nums = [1,-1,1,-1]

Output: 4

Explanation:

One way to maximize the total cost is by splitting [1, -1, 1, -1] into subarrays [1, -1] and [1, -1]. The total cost will be (1 + 1) + (1 + 1) = 4.

```



