# The Heap Sort Algorithm


## Heap is Complete Binary Tree

A complete binary tree satisfies:

  1. it is a full binary tree. Or,
  2. it is a full binary tree except the lowest level, and in the lowest level, the left part is full while the right
     part is empty.

In the heap, any node Satisfies:

  - `node >= node.lChild` and `node >= node.rChild` -- such a heap is a *max heap*; Or,
  - `node <= node.lChild` and `node <= node.rChild` -- such a heap is a *min heap*.

```text
                              -----
                             0| 9 |
                              -----
                +---------------+---------------+
              -----                           -----
             1| 8 |                          2| 6 |
              -----                           -----
        +-------+-------+               +-------+-------+
      -----           -----           -----           -----
     3| 4 |          4| 7 |          5| 2 |          6| 1 |
      -----           -----           -----           -----
    +---+---+       +---+
  -----   -----   -----
 7| 3 |  8| 0 |  9| 5 |
  -----   -----   -----
```

## Complete Binary Tree is Linear Array

```text
        -----------------------------------------
  node  | 9 | 8 | 6 | 4 | 7 | 2 | 1 | 3 | 0 | 5 |
        -----------------------------------------
  index | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
        -----------------------------------------
```

Suppose the index of a node is `x` (`int`):

  - The index of `node.parent` is `(x - 1) / 2`;
  - The index of `node.lChild` is `x * 2 + 1`;
  - The index of `node.rChild` is `x * 2 + 2`;
  - If `x` is 0, then the node is the root, otherwise:
  - If `x % 2 == 1`, then the node is a left child, and may have a next sibling;
  - If `x % 2 == 0`, then the node is a right child, and has a previous sibling.


## The Heap Sort

Use linear array (`int[]` for example) to store the heap. To heap sort another array, follow these steps.

#### Step 1: build a heap from the array

You need a max heap to sort array ascendingly, and a min heap to sort array descendingly.

  1. Append an element as the last leaf (last element of the heap array);
  2. If `node` > `node.parent` in max heap, or `node` < `node.parent` in min heap, then swap them;
  3. Keeps doing (2), until `node` becomes the root.

#### Step 2: swap root with tail

Now the max element goes to the tail. Consider the rest of the heap array (except the tail) as a new heap.

#### Step 3: heapify

Such new heap may not be a legal heap, because the new root might smaller/larger than its children in the max/min heap.
However, if it is illegal, the new root is the only illegal node -- other nodes are all in the legal order. So we
heapify it as follows:

  1. Set `node` to the root
  2. If `node` is not the max among `node`, `node.lChild` and `node.rChild` in max heap, or the min in min heap, then
    swap `node` with the max/min value.
  3. Keeps doing (2), until `node` becomes a leaf.

#### Step 4: iteration Step 2 and 3

In each iteration, the largest/smallest element goes to the end, and the heap's size shrinks 1.
Once the heap becomes empty, the array is sorted.

![Heapsort](https://upload.wikimedia.org/wikipedia/commons/4/4d/Heapsort-example.gif)

"Heapsort-example" by Swfung8 - Own work. Licensed under CC BY-SA 3.0 via Commons

https://commons.wikimedia.org/wiki/File:Heapsort-example.gif#/media/File:Heapsort-example.gif
