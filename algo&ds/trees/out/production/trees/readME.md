# Binary Tree

Each node points to two other nodes. 

IMP : Nodes do not have to be ordered based on their value.

# Terminology

- Full : Each node either points to two other node or zero nodes. 
- Perfect: Each level is completely filled except the last level. For example if we have three level binary tree and a node in the second level has no children, its still full but not perfect.
- Complete: Each level is completely filled except the last level and the last level is filled from left to right. So you could possibly have a non-full, non-perfect complete binary tree when one node in the last level in the far left has a left node.

# Binary Search Tree

Everything that is said to a binary tree applies with also ordering of the nodes based on their value. Lower valued child nodes compared to parent's are placed to the left and higher valued nodes are placed to the right.

# binaryST Big-Oh

Binary search tree employs divide and conquer methodology to most of its operations. If you assume the tree is forked then all of its operations are O(log N).

But if the binaryST is not forked then its essentially a linked list with O(N).

binaryST is faster for lookup and remove (O(log N) as its time complexity) while linked list is faster with insert (O(1) for linked list) 