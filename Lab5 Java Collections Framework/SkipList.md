# Skip List

Reference: http://www.sable.mcgill.ca/~dbelan2/cs251/skip_lists.html


## Terminology

  - A **forward** pointer is a pointer that points to a node ahead in the list.
  - A **level i** node is a node that has **i** forward pointers.


## Skip List VS. Regular List

Compared with regualr list, the skip list trades space for speed.

```text
  Regular list:
                     --------   -----   -----   ------   ------   ------   ------   ------   ------   --------
                     | head |==>| 3 |==>| 6 |==>| 11 |==>| 15 |==>| 24 |==>| 30 |==>| 32 |==>| 42 |==>| null |
                     --------   -----   -----   ------   ------   ------   ------   ------   ------   --------
  Skip List:
                     --------                            ------                              ------   --------
    fastest list: 2  |      |===========================>|    |=============================>|    |==>|      |
                     |------|           -----            |----|            ------            -----|   |      |
     faster list: 1  |      |==========>|   |===========>|    |===========>|    |===========>|    |==>| null |
                     |------|   -----   |---|   ------   |----|   ------   |----|   ------   |----|   |      |
    regular list: 0  | head |==>| 3 |==>| 6 |==>| 11 |==>| 15 |==>| 24 |==>| 30 |==>| 32 |==>| 42 |==>|      |
                     --------   -----   -----   ------   ------   ------   ------   ------   ------   --------

  "==>" indicates the links between nodes.
```

If `current` is the node "6" (the 2nd node), then its level is to (that is, the size of `current.forwards` is 2);
forward0 and forward1 of `current` (`current.forwards[0]`) are the node "11" and "15", respectively.


## Initialization

An empty skip list contains only a head whose level is 1 and point it to `null`.


## Search the *value* by a *key*

  - Start from *head*'s top level (fastest list);
  - *forward* is `null`, or *current.key* < *key* <= *forward.key*:
    + *forward* not `null` and *forward.key* = *key*: target found, return *forward.value*;
    + Already at the lowest level: target not found, return `null`;
    + Otherwiase: move down to level-1, and *current* is a **turning node**;
  - Otherwise: move forward.

Example: search for 35 (note the right-most "+" in each level indicates the turning node).

```text
        -----                           -----                                                   --
     3  | ################################+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>||
        |---|                           | # |           -----                                   ||
     2  |   |==========================>| +###############+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>||
        |---|           -----           |---|           | # |   -----                   -----   ||
     1  |   |==========>|   |==========>|   |==========>| +#######+~~~~~~~~~~~~~~~~~~~~>|   |==>||
        |---|   -----   |---|   -----   |---|   -----   |---|   | # |   -----   -----   |---|   ||
     0  |   |==>|   |==>|   |==>|   |==>|   |==>|   |==>|   |==>| +#######+~~~~~~>X |==>|   |==>||
        -----   -----   -----   -----   -----   -----   -----   -----   -----   -----   -----   --
        head      2       4       5       9      15      19      28      33      35      42    null

    "###+###" indicates the search path, where "+" is a turning node;
    "~~~~~~>" indicastes current.forward.
```


## Insert a *key*-*value* pair as new element

  - Search for the key first, and maintain a list of pointers -- *updates* -- containing all the turning nodes;
  - *key* found: update the *value*, and finish inserting;
  - *key* not found: create a *new node* with a **random** level, and point its *forwards* in each level to `null` 
    (the tail of the list) first;
  - From level 0 to `min(current level, new level) - 1`:
    + Set *new node*'s *forward* to the *forward* of *update* (the turning node);
    + Set *forward* of *update* to the *new node*;
  - If *new level* > *current level*: raise *head*'s level, and point *head*'s all new *forwards* to *new node*.

Example 1: how did we insert 35?

*updates* contains (top-down) 9, 19, 28, and 33. As the level of the new node 35 is 1, only 33's *forwards* needs
to be updated.

```text
        -----                           -----                                                   --
     3  | ################################+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>||
        |---|                           | # |           -----                                   ||
     2  |   |==========================>| +###############+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>||
        |---|           -----           |---|           | # |   -----                   -----   ||
     1  |   |==========>|   |==========>|   |==========>| +#######+~~~~~~~~~~~~~~~~~~~~>|   |==>||
        |---|   -----   |---|   -----   |---|   -----   |---|   | # |   -----   -----   |---|   ||
     0  |   |==>|   |==>|   |==>|   |==>|   |==>|   |==>|   |==>| +#######+::::::::::::::>x |==>||
        -----   -----   -----   -----   -----   -----   -----   -----   -----   -----   -----   --
        head      2       4       5       9      15      19      28      33     (35)     42    null

   ":::::::>" indicates that the *update* needs to be updated.
```

Example 2: how did we insert 9 (note the skip list's level was 3 before inserting)?

*updates* contains (top-down) head, 4, and 5. As the level of the new node 9 is 4, all of *updates*' *forwards* need to
be updated. Besides, *head* needs to add one more level.

```text
        -----                           -----                                                   --
    (3) |   |**************************>|   |==================================================>||
        |---|                           |---|           -----                                   ||
     2  | +::::::::::::::::::::::::::::::::::::::::::::>|   |==================================>||
        | # |           -----           |---|           |---|   -----                   -----   ||
     1  | +###############+::::::::::::::::::::::::::::>|   |==>|   |==================>|   |==>||
        |---|   -----   | # |   -----   |---|   -----   |---|   |---|   -----   -----   |---|   ||
     0  |   |==>|   |==>| +#######+::::::::::::::>x |==>|   |==>|   |==>|   |==>|   |==>|   |==>||
        -----   -----   -----   -----   -----   -----   -----   -----   -----   -----   -----   --
        head      2       4       5      (9)     15      19      28      33      35      42    null

   "*******>" inidcates the new links of head in its raised levels.
```


## Delete an element by the *key*

  - Similar as insertion -- search, and maintain *updates*, where turning nodes as: *current.key* < *key* <=
    *forward.key* (*forward* being `null` is NOT a turning node);
  - *key* not found: deletion failed, and return `null`;
  - In each level of *updates*:
    + If *forward* is not `null`, then unlink the current node: set *forward* of *update* to the *forward*'s *forward*;
  - Remove levels, where *forward* of *head* is `null`;
  - Return *forward*'s *value*.

Example 1: how to delete 28?

*updates* contains (top-down) `null`, `null`, 19, and 19. The two non-null nodes' *forwards* need to be updated.

```text
        -----                           -----                                                   --
     3  | #################################~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>||
        |---|                           | # |           -----                                   ||
     2  |   |==========================>| #################~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>||
        |---|           -----           |---|           | # |   -----                   -----   ||
     1  |   |==========>|   |==========>|   |==========>| +::::::>X |==================>|   |==>||
        |---|   -----   |---|   -----   |---|   -----   | # |   |---|   -----   -----   |---|   ||
     0  |   |==>|   |==>|   |==>|   |==>|   |==>|   |==>| +::::::>X |==>|   |==>|   |==>|   |==>||
        -----   -----   -----   -----   -----   -----   -----   -----   -----   -----   -----   --
        head      2       4       5       9      15      19     (28)     33      35      42    null
```

Example 2: how to delete 9?

*updates* contains (top-down) *head*, *head*, 4, and 5. all of their *forwards* need to be updated. Besides, level 3
becomes empty after deletion, so this level needs to be removed, too.

```text
        -----                           -----                                                   --
    (3) | +::::::::::::::::::::::::::::>|   |==================================================>||
        | # |                           |---|           -----                                   ||
     2  | +::::::::::::::::::::::::::::>|   |==========>|   |==================================>||
        | # |           -----           |---|           |---|   -----                   -----   ||
     1  | +###############+::::::::::::>|   |==========>|   |==>|   |==================>|   |==>||
        |---|   -----   | # |   -----   |---|   -----   |---|   |---|   -----   -----   |---|   ||
     0  |   |==>|   |==>| +#######+::::>|   |==>|   |==>|   |==>|   |==>|   |==>|   |==>|   |==>||
        -----   -----   -----   -----   -----   -----   -----   -----   -----   -----   -----   --
        head      2       4       5      (9)     15      19      28      33      35      42    null
```
