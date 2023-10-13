
# Input and Output

```java

Input: path = "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.

```

```java

Input: path = "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.

```

```java

Input: path = "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.

```
