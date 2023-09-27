# Deque

Double ended queue - meaning insertion and popping can happen at the both ends.

In this example, I have inserted integer at the first and removed it from the end.

.contains() method has a time complexity of O(N) - Having it to check possible TimeNotFoundError prevented me from running it in average O(1) time, Apparently I didn't need that check since its guaranteed that the integer will be in the list.