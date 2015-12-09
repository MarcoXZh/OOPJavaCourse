# Assignment 5: Interfaces

  - Source code: [Coffee.java][Code1]; [CoffeeTest.java][Code2]; [PersonTest.java][Code3].


## Exercise 1

Java defines a `Comparable` interface (`java.lang.Comparable`); this interface is a parameterized interface. We will
discuss parameterized classes and interfaces in detail later in the course. For now, you do not need to know too much
about parameterization -- just use it.

Read the code in Coffee.java. You are required to complete the class definition to allow collections of coffees to be
sorted by the strength.

Find the code from CoffeeTest.java. What imports are required to allow it to compile? And how would I rewrite this class
to utilize JUnit? Create a JUnit project as submission.


## Exercise 2

Consider the code below. It describes 5 types either classes or interfaces.

```java
U u; G g; B b; Z z; X x;
```

The following assignments are all legal and compile:

```java
u = z; x = b; g = u; x = u;
```

However, the following assignments are all illegal and cause compilation errors:

```java
u = b; x = g; b = u; z = u; g = x;
```

What can you state about the types and their relationships (to each other)? Provide at least one possible answer.


## Exercise 3

The collections library has a class `TreeSet` (`java.util.TreeSet`). It is another parameterised class which is an
example of a sorted set. That is, elements in this set are kept in order. Construct classes `Person` and
`PersonCompator` to make the `runTest` in PersonTest.java successfully complete. This method checks if `Person` objects
are correctly ordered by their ages (age is the only attribute of `Person`). `PersonComparator` is required to implement
interface `Comparator` (`java.util.Comparator`). `Comparator` is another parameterised interface -- parameterization is
common in Java.

What imports are required to allow it to compile? And how would I rewrite this class to utilize JUnit? Create a JUnit
project as submission.



[Code1]: https://github.com/MarcoXZh/OOPJavaCourse/blob/master/Assignment5%20Interfaces/Coffee.java
[Code2]: https://github.com/MarcoXZh/OOPJavaCourse/blob/master/Assignment5%20Interfaces/CoffeeTest.java
[Code3]: https://github.com/MarcoXZh/OOPJavaCourse/blob/master/Assignment5%20Interfaces/PersonTest.java
