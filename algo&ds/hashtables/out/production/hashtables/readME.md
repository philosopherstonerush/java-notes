# Hash Tables:

- Has a hash function that processes a key to give a certain index which specifies a location in memory (like an array index).
- for example, "nails" is the key while 1000 is the value, a key-value pair is {"nails" = 1000} and this is how the values are stored in the array in memory.

# Hash functions:

- Deterministic: A key always gives rise to a specific index. 
- One way: The index cannot be put into the hash function to get the key.

# Collisions:

While inserting key-value pair at the index specified we might come across a key-value pair already present in that case we could use: 
1) linear probing - comes under open addressing
2) Separate chaining - which uses a linked list (the form of hash table that is implemented here)

- linear probing is when there a collision associated with a specific block then you move to the next one.
- separate chaining just adds nodes to the pre-existing nodes to a specific index.

- Collisions are lower when prime number of sizes for arrays are used.

# Big - oh

hash function - O(1) ---> meaning no matter how big the database gets, the method of hashing a particular key is single step - it doesnt scale with items in the database

set function - O(1) ---> Still the items in the database do not have to be considered to set a new value.

get function - O(1) ---> Under the assumption that you have a good hash function that spreads values throughout the array. 

# interview question (how do you compare two lists for common elements efficiently?)

- You could write two nest for loops which will take O(N^2) operations but then you could use a hashmap to create key, boolean pairs to run two non-nested for loops effectively making O(2N) ---> O(N).