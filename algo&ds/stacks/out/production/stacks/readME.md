# Stack

One way to implement stack is to use Linked List. This is the most common way to implement a stack datastructure.

Nomenclature, head = top, tail = bottom, length = height

1) The Node that terminates to null must be the bottom most node in the stack.
2) Every operation is performed at the top and thus there is no need for even a bottom node pointer.
3) Both insertion and deletion at the head/top is O(1).