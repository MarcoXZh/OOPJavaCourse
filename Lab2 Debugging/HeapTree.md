# Heap Tree

  - The *root* node is the only node that can be directly accessed
  - A *tail* node is helpful for heap sorting


## Initialization -- create an empty heap

  - Simply set *root* to `null`


## Insert new node to heap

  - Step 1: insert node to tree

    + Case 1, empty tree: set *root* and *tail* to *node* and done

    + Case 2, *tail* is *root*: set *root.lChild* and *tail* to *node*, and then heapify upwards from *tail*.

    + Case 3, *tail* is a lChild: set *tail*'s next sibling to *node* then *tail* to *node*,  and heapify upwards from
      *tail*.

    + Case 4, *tail* is a rChild:
        1. In this case, *tail* must be the right-most child of a subtree -- search for the corresponding *subroot*.
        2. If *subroot* is not *roo*t, then set *subroot* to its next sibling.
        3. Search for the left-most child of *subroot*'s subtree -- the insertion position is the child's lChild.
        4. Set lChild and *tail* to *node*, and heapify upwards from *tail*.

Example 1: insert 6 to the heap -- *tail* is 2, *subroot* is 8, *subroot*'s next sibling is A, and the left-most child is
9. So 6 will be inserted as 9's lChild.

Example 2: insert 3 to the heap -- *tail* is 1, *subroot* is *root* B, and the left-most child is 4. So 3 will be
inserted as 4's lChild.

```text
                                                                         ---------------------------------------
                                     -----                               |                  #####              |
                                     | B |                               |           subroot# B #              |
 ---------------------------------   -----   ----------------------      |                  #####              |
 |               +---------------------+------------------+       |      |            +-------+-------+        |
 |             #####             |           |          #####     |      |          -----           -----      |
 |      subroot# 8 #             |           |   sibling# A #     |      |          | 8 |           | A |      |
 |             #####             |           |          #####     |      |          -----           -----      |
 |       +-------+-------+       |           |        +---+---+   |      |        +---+---+       +---+---+    |
 |     -----           -----     |           |      #####   ----- |      |      #####   -----   -----   #####  |
 |     | 4 |           | 7 |     |         left-most# 9 #   | 1 | |    left-most# 4 #   | 7 |   | 9 |   # 1 #  |
 |     -----           -----     |           |      #####   ----- |      |      #####   -----   -----   #####  |
 |   +---+---+       +---+---+   |           |   +---+            |      |    +---+                     tail   |
 | -----   -----   -----   ##### |           | -----              |      |  -----                              |
 | | 3 |   | 0 |   | 5 |   # 2 # |           | | 6 |              |      |  | 3 |                              |
 | -----   -----   -----   ##### |           | -----              |      |  -----                              |
 --------------------------tail---           ----------------------      ---------------------------------------
```


## Heap sort:

  - Step 1, build up the heap by inserting

  - Step 2, swap: swap *root* with *tail*

  - Step 3, remove *tail* -- similar with insertion:

    + Case 1, *tail* is *root*: remove it and sorting is done, return

    + Case 2, *tail* is a rChild: set *tail* to its previous sibling, and remove the old *tail*.

    + Case 3, *tail* is a lChild:
        1. In this case, *tail* must be the left-most child of a subtree -- search for the corresponding *subroot*.
        2. If *subroot* is not *root*, then set *subroot* to its previous sibling.
        3. Search for the right-most child of *subroot*'s subtree -- set *tail* to the child, and remove the old *tail*.

  - Step 4, iterate Step 2 and 3

Example 1: delete 6 from the heap -- *tail* is 6, *subroot* is A, *subroot*'s previous sibling is 8, and the right-most
child is 2. So *tail* will be set to 2.

Example 2: delete 3 from the heap -- *tail* is 3, *subroot* is *root* B, and the right-most child is 1. So *tail* will
be set to 1.

```text
                                                                         ---------------------------------------
                                     -----                               |                  #####              |
                                     | B |                               |           subroot# B #              |
 ---------------------------------   -----   ----------------------      |                  #####              |
 |               +---------------------+------------------+       |      |            +-------+-------+        |
 |             #####             |           |          #####     |      |          -----           -----      |
 |      sibling# 8 #             |           |   subroot# A #     |      |          | 8 |           | A |      |
 |             #####             |           |          #####     |      |          -----           -----      |
 |       +-------+-------+       |           |        +---+---+   |      |        +---+---+       +---+---+    |
 |     -----           -----     |           |      -----   ----- |      |      -----   -----   -----   #####  |
 |     | 4 |           | 7 |     |           |      | 9 |   | 1 | |      |      | 4 |   | 7 |   | 9 |   # 1 #  |
 |     -----           -----     |           |      -----   ----- |      |      -----   -----   -----   #####  |
 |   +---+---+       +---+---+   |           |   +---+            |      |    +---+                right-most  |
 | -----   -----   -----   ##### |           | #####              |      |  #####                              |
 | | 3 |   | 0 |   | 5 |   # 2 # |           | # 6 #              |      |  # 3 #                              |
 | -----   -----   -----   ##### |           | #####              |      |  #####                              |
 ---------------------right-most--           --tail----------------      ---tail--------------------------------
```
