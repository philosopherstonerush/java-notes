# Switch cases

It is necessary to terminate a switch statement with a break, if no break is provided as in the accompaning example, case 1, 2 and default will be executed. 

```

    1 is the value
    2 is the value
    default lol

```

# Why break?

The break statements are necessary because without them, statements in switch blocks fall through: All statements after the matching case label are executed in sequence, regardless of the expression of subsequent case labels, until a break statement is encountered.

Don't think about it as series of 'if/else' statements but rather a pointer to some place in your switch statement code you want to start execution. After evaluating which place to jump, the 'case' labels are no longer used and all proceeding code is executed, thus you see the 'fall-through'. When you use 'break' anywhere inside 'switch' statement, if it's executed all instructions remaining in brackets are dropped and program continues from where the switch bracket closes (similar to using 'break' in a for loop). Fall-through is handy when you have eg. layers of logic depending on some sort of status (or state, label, you name it), but it's also a quirk to remember when replacing if-statement.

# You can skip break (JDK 14)

```

    switch (value) {
    case 0 -> {//do stuff}
    case 1 -> {//do other stuff]
    default -> {//Even other stuff}
    }

```

