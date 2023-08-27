# Graphs

- Has Nodes or Vertices.
- Has edges that connect nodes.

## Directionality
- Bidirectional 
- Uni directional

## Weight

- Edges can be weighted
- Edges can be unweighted

## Linked list is a form of graph

Linked list is a form of a tree and trees are a form of a graph and thereby linkedlist is a form of a graph.

## Adjacency matrix:

It is the tabular representation of a graph.

- Bidirectional and Unweighted graph - if there exists a connection between two vertices then we fill the cell corresponding to the two nodes as 1 and 0 if not. The diagonal (left to right) is always zero meaning, a vertex cannot point to itself. the triangles formed above and below the line are mirrored.
- Bidirectional and weighted - instead of 1, you fill with the weight given
- Directional - upper and lower triangles are no longer similar

## Adjacency list:

its a dict of key-value pair with a node being key and the nodes connecting to it as list of values (nodes).

example:

{
    "A" : ["B", "C"]
}