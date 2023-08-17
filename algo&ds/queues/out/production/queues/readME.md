# Queues

Rule: Enqueue and Dequeue must happen at either ends and not at the same end.

There are two ways to implement queues.
1) Array
2) Linked List

## Array based

enqueuing at the last will be O(1) and so will be dequeuing at that end.

but to enqueue or dequeue at the start it takes O(N).

This makes arrays an unfavourable choice to implement queues.

## Linked List based

Its O(1) to add a node at the end of a linked list but O(N) to remove (since the temp pointer must iterate from head).

Its O(1) to both add and remove a node at the start of the linked list. 

So the caveat here is to perform addition at the end and removal at the start.