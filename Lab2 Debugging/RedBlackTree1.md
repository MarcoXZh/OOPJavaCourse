# Red Black Tree (Part 1)

Reference: https://en.wikipedia.org/wiki/Red%E2%80%93black_tree 

(**Note the rotations in insertion of this reference is buggy!**)


## A RBT is a *binary search tree*

```text
                              -----
                              | 4 |
                              -----
                 +--------------+--------------+
               #####                         #####
               # 2 #                         # 8 #
               #####                         #####
          +------+-----+               +-------+-------+
        -----        -----           -----           -----
        | 1 |        | 3 |           | 6 |           | 9 |
        -----        -----           -----           -----
      +---+---+     +--+--+      +-----+-----+      +--+--+
    #####    NIL   NIL   NIL   #####       #####   NIL   NIL
    # 0 #                      # 5 #       # 7 #
    #####                      #####       #####
   +--+--+                    +--+--+     +--+--+
  NIL   NIL                  NIL   NIL   NIL   NIL

  "##" indicates a red node
```


### Properties of a BST:

  - `node` > `lChild` and `node` < `rChild`

  - In-order traversal returns a sorted list


### Properties of a RBT:

  - *node* has color -- either red or black

  - *root* is black

  - all leaves are *NIL* nodes: *key* and *value* are `null`; *color* is black -- **they are not `null`**

  - a red node's children and parent must all be black

  - every path from a node to any of its descendant *NIL* has the same number of black nodes

  - RBT is balanced (by regulating the colors)


## Initialization

  - Create an empty RBT/Clear a RBT:
    + set *root* to `null`

  - Check empty: check if *root* is `null`


## Count the size

  - Solution 1: recursion -- count the size of *root*s subtree (set *subroot* to *root*)
    + If *subroot* is `null` or *NIL*, then return 0
    + Otherwise, count the size of *lChild*'s subtree *size1* and the size of *rChild*'s subtree *size2*
    + Return 1 + *size1* + *size2*

  - Solution 2 (recommended): use `int` variable as counter


## In-order traversal (recursion)

  - Traverse the *root*'s subtree (set *subroot* to *root*)
    + If *subroot* is `null` or *NIL*, then it is empty, return nothing
    + Otherwise:
        1. First, traverse the *lChild*'s subtree
        2. Then, visit *subroot*
        3. Finally, traverse the *rChild*'s subtree


## Search for a value by key -- search as a BST

  - Solution 1: recursion -- search for *key* from *root*'s subtree (set *subroot* to *root*)
    + If *subroot* is `null` or *NIL*, then search failed, return `null`
    + Otherwise, if *key* = *subroot.key*, then found, return the *value*
    + Otherwise:
        * If *key* < *subroot.key*, search for *key* from *lChild*'s subtree
        * Else (*key* > *suroot.key*), search for *key* from *rChild*'s subtree

  - Solution 2: iteration -- start from *root* (set *current* to *root*)
    + If *subroot* is `null` or *NIL*, then search failed, return `null`
    + Otherwise, if *key* = *suroot.key*, then found, return the *value*
    + Otherwise:
        * If *key* < *subroot.key*, set *current* to *current.lChild*
        * Else (*key* > *subroot.key*), set *current* to *current.rChild*


## Insert a key-value pair

  - Step 1: insert as a BST
    + Search the *key*, recursively or iteratively
    + If *key* found, then update *value*, and insertion done
    + Otherwise, create a new node with the *key-value* to replace the *NIL* node, **add two new *NIL* children to it**,
      and fix its color
    + If it's the first insertion, point *root* to the new node
    + Set the *node*'s color to red, and then balance the tree.

  - Step 2: balance the tree -- `fixInsColor(node)`
    + Case 1, *node* is *root* (first insertion): set color to black, done
    + Case 2, *node*'s *parent* exists and is black: tree still valid, done
    + Case 3, both *parent* and *uncle* exist and are red: set their colors to black, set *grandparent*'s color
      (*grandparent* must exist) to red, and fix *grandparent*'s color -- invoke `fixInsColor(gp)`, done
    + Case 4, *parent* exists and is red; *uncle* exists and is black:
        * If *node* is a rChild and *parent* is a lChild: rotate **left** on **_node_**, set *node* to *node*'s *lChild*,
          and go on to Case 5
        * If *node* is a lChild and *parent* is a rChild: rotate **right** on **_node_**, set *node* to *node*'s *rChild*,
          and go on to Case 5
    + Case 5, *parent* exist and is red; *uncle* exist and is black; both *node* and *parent* shall be lChild/rChild:
      set *parent*'s color to black and *grandparent*'s color to red, and:
        * If *node* is a lChild: rotate **right** on **_parent_**, done
        * If *node* is a rChild: rotate **left** on **_parent_**, done

```text
  ---------------------------------   ------------------------------------   -------------------------------------
  |             -----             |   |               -----              |   |               -----               |
  |             | G |             |   |               | G |              |   |               | G |               |
  |             -----             |   |               -----              |   |               -----               |
  |          +----+----+          |   |           +-----+-----+          |   |           +-----+-----+           |
  |        #####     #####        |   |         #####       -----        |   |         #####       -----         |
  |        # P #     # U #        |   |         # P #       | U |        |   |         # P #       | U |         |
  |        #####     #####        |   |         #####       -----        |   |         #####       -----         |
  |     +----+                    |   |           +-----+                |   |     +-----+                       |
  |   #####                       |   |               #####              |   |   #####                           |
  |   # N #                       |   |               # N #              |   |   # N #                           |
  |   #####                       |   |               #####              |   |   #####                           |
  |              ---              |   |                ---               |   |                ---                |
  |              | |              |   |                | |               |   |                | |                |
  |             \   /             |   |               \   /              |   |               \   /               |
  |              \ /              |   |                \ /               |   |                \ /                |
  |               v               |   |                 v                |   |                 v                 |
  |             #####             |   |               -----              |   |               -----               |
  |             # G #             |   |               | G |              |   |               | P |               |
  |             #####             |   |               -----              |   |               -----               |
  |          +----+----+          |   |           +-----+-----+          |   |           +-----+-----+           |
  |        -----     -----        |   |         #####       -----        |   |         #####       #####         |
  |        | P |     | U |        |   |         # N #       | U |        |   |         # N #       # G #         |
  |        -----     -----        |   |         #####       -----        |   |         #####       #####         |
  |     +----+                    |   |     +-----+                      |   |                       +-----+     |
  |   #####                       |   |   #####                          |   |                           -----   |
  |   # N #                       |   |   # P #                          |   |                           | U |   |
  |   #####                       |   |   #####                          |   |                           -----   |
  ---------------------------------   ------------------------------------   -------------------------------------
               Case 3                                Case 4                                 Case 5
```


## Rotate a binary tree on *node*

  - If *parent* is *root*, then set *root* to *node*

  - **Six** pointers need to be changed:

  Rotate left                                             |  Rotate right                                            |
:-------------------------------------------------------- | :------------------------------------------------------- |
  **L-5**: `parent.rChild` -> `node.lChild`               | **R-3**: `parent.lChild` -> `node.rChild`                |
  **L-8**: `lChild.parent` -> `parent` if *lChild* exists | **R-10**: `rChild.parent` -> `parent` if *rChild* exists |
  **L-6**, **R-4**: `node.parent` -> `grandparent`                                                                  ||
  **L-1**, **R-1**: `gp.lChild` -> `node` if `parent` is a lChild; `gp.rChild` -> `node` if `parent` is a rChild    ||
  **L-7**: `node.lChild` -> `parent`                      | **R-9**: `node.rChild` -> `parent`                       |
  **L-2**, **R-2**: `parent.parent` -> `node`                                                                       ||

```text
  ------------------------------------------------------------------------------------------------------------------
  |                  -----                                                                  -----                  |
  |                  | G |                                                                  | G |                  |
  |                  -----                                                                  -----                  |
  |                L-1 |                                                                  L-1 |                    |
  |                    v                                                                      v                    |
  |                    ^                                                                      ^                    |
  |                L-2 |                                                                  L-6 |                    |
  |                  -----                        ROTATE LEFT ON "N"                        -----                  |
  |                  | P |                      =======================>                    | N |                  |
  |                  -----                                                                  -----                  |
  |               L-3 | | L-5                                                            L-7 | | L-9               |
  |     +-----> <-----+ +-----> <-----+                                        +-----> <-----+ +-----> <-----+     |
  |     | L-4                     L-6 |                                        | L-2                    L-10 |     |
  |   -----                         -----                                    -----                         -----   |
  |   | S |                         | N |                                    | P |                         | R |   |
  |   -----                         -----                                    -----                         -----   |
  |                              L-7 | | L-9                              L-3 | |                                  |
  |                    +-----> <-----+ +-----> <-----+          +-----> <-----+ +-----> <-----+                    |
  |                    | L-8                    L-10 |          | L-4                     L-5 |                    |
  |                  -----                         -----      -----                         -----                  |
  |                  | L |                         | R |      | S |                         | L |                  |
  |                  -----                         -----      -----                         -----                  |
  |                                                                                                                |
  |                                 -----                                    -----                                 |
  |                                 | G |                                    | G |                                 |
  |                                 -----                                    -----                                 |
  |                               R-1 |                                    R-1 |                                   |
  |                                   v                                        v                                   |
  |                                   ^                                        ^                                   |
  |                               R-2 |                                    R-4 |                                   |
  |                                 -----                                    -----                                 |
  |                                 | P |        ROTATE RIGHT ON "N"         | N |                                 |
  |                                 -----       =====================>       -----                                 |
  |                              R-3 | | R-5                              R-7 | | R-9                              |
  |                    +-----> <-----+ +-----> <-----+          +-----> <-----+ +-----> <-----+                    |
  |                    | R-4                     R-6 |          | R-8                     R-2 |                    |
  |                  -----                         -----      -----                         -----                  |
  |                  | N |                         | S |      | L |                         | P |                  |
  |                  -----                         -----      -----                         -----                  |
  |               R-7 | | R-9                                                            R-3 | | R-5               |
  |     +-----> <-----+ +-----> <-----+                                        +-----> <-----+ +-----> <-----+     |
  |     | R-8                    R-10 |                                        | R-10                    R-6 |     |
  |   -----                         -----                                    -----                         -----   |
  |   | L |                         | R |                                    | R |                         | S |   |
  |   -----                         -----                                    -----                         -----   |
  ------------------------------------------------------------------------------------------------------------------
```
