# input and output

```java

Input: s = "1 + 1"
Output: 2

```

```java

Input: s = " 2-1 + 2 "
Output: 3

```

```java

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23

```

# Why number not reset to 0?

The variable number is not reset to 0 when an opening bracket ('(') is encountered because the brackets are used to denote grouping of expressions rather than directly impacting the current number being processed. In this code, the number is only reset when a complete number has been processed and added to the result (or when an operator like + or - is encountered).

Here’s the breakdown of what happens when the ( character is encountered:

Save current result and sign: When you encounter an opening bracket (, you push the current result and sign onto the stack. This is because everything inside the brackets will be treated as a separate subexpression that needs to be evaluated first before adding it back to the outer expression.

Reset result and sign: The result is reset to 0 and the sign to 1 because the subexpression inside the parentheses starts afresh.

At this point, you don't reset number to 0 because the number might not yet be fully formed (it could still be getting parsed from multiple digits). If you reset it, you would lose the value of the current number you are parsing.

Example:
For an expression like "3+(2-1)":

When you encounter the + after 3, you add 3 to result, and then number gets reset to 0.
When you hit the opening parenthesis (, it starts a new subexpression, but number has already been handled by that point.