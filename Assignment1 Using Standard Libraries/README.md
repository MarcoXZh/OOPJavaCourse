# Assignment 1: Using Standard Libraries

  - Full mark: 10 points

  - Source code: [*daysold.java*][Code1]

A programmer spends a great deal of their time using other people's solutions including predefined solutions which are
part of Java. This implies reading their documentation which is always less than perfect! In fact, the documentation is
often terrible!! However, rebuilding existing solutions is seldom cost effective and hence using pre-existing solutions
is a must for the professional programmer.

So let's have a go ...

Write a piece of Java code, which tells you how old you are -- sounds simple. In other words, you fill the `days` method
(You can use Eclipse to do it if you like), and it outputs:

```
Wrong birthday: 3000-01-01
Wrong day: 2001-02-29
Birthday: January 1 2000; today: January 15 2000 -- you are 14 days old.
Birthday: January 15 2000; today: January 15 2000 -- you are 0 days old.
```

Clearly, the problem gets more complex as the years progress due to leap years.

To write this program you must use Java's [`Calendar`][API1] classes. Good grief, just look at that documentation!!

(ummmm... are there other classes that I need to use??? Good question to ponder)

Remember programming is actually more about reading than writing, and class [`Calendar`][API1] (do I need to know what a
Gregorian calendar is?) is certainly an eye-full.


[Code1]: https://github.com/MarcoXZh/OOPJavaCourse/blob/master/Assignment1%20Using%20Standard%20Libraries/daysold.java
[API1]: http://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html
