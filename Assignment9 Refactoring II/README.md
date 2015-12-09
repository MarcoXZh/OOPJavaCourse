# Assignment 9: Refactoring II

  - Source code: [Refactoring][Refactoring].

In this assignment, you will explore refactoring by using the technique in conjunction with the Eclipse IDE to improve
the quality of a trivial application. This assignment will provide you an existing application with an associated set of
unit tests. Your job is to refactor the application following three checkpoints.


## Background Information

In this assignment, you are provided with the code base for a small movie rental application. Attached with the code
base is a set of associated unit tests, all of which pass without error. The existing solution consists of three
classes: `Customer`, `Rental`, and `Movie`. `Customer` represents a single customer and contains the record of all of
the rentals that are associated with the individual customer. This class also contains a method that outputs a report of
the customer's current rentals. `Rental` exists to associate a movie with the number of days it has been rented.
Finally, `Movie` stores the information about an individual movie. The class contains the movie title and price code
information (regular movie, new release, or children's movie). Although this solution works from a purely functional
perspective, from a quality perspective, the code is overcomplicated, and the implementation does not utilize the
advantages of the object-orientated paradigm.


## Step 1: Move Method (from `Customer` to `Rental`)

The method `Customer.statement` is far too complicated; furthermore, the section that determines the amount for each
rental utilizes the internal variables of `Rental` more than its own, therefore we should apply the *Move Method*
refactor to move this block of code into `Rental`.

Apply the *Move Method* refactor, and re-run the test suite to ensure functionality has not changed.

**CHECKPOINT 1**: Test suite `AllTests` runs without error, and the code has been extracted into `Rental`.


## Step 2: Move Method (from `Rental` to `Movie`)

Upon examination, we can see that the newly created method also relies heavily on values associated with `Movie`. Again,
this is not ideal so we will apply the *Move Method* refactor, to extract the method into `Movie`.

Apply the *Move Method* refactor, and re-run the test suite to ensure functionality has not changed.

**CHECKPOINT 2**: Test suite `AllTests` runs without error, and the code has been extracted into `Movie`.


## Step 3: Replace Conditional with Polymorphism

Upon inspection of `Movie`, we see that the class actually represents three types of movies. This is obvious due to the
switch statement present in the code. This has the potential to become very complicated, and does not represent an
object-orientated solution to the problem; therefore, the *Replace Conditional with Polymorphism* refactor will be
applied. `Movie` will be redefined as an abstract class, and three subclasses will be created: `RegularMovie`,
`NewRelease`, and `ChildrenMovie`, each implementing the previous functionality, and negating the need for the complex
logic.

Apply the *Replace Conditional with Polymorphism* refactor, and re-run the test suite to ensure functionality has not
changed.

**CHECKPOINT 3**: Test suite `AllTests` runs without error, and `Movie` has been abstracted and three new classes have
been created in its place.


## Step 4: Final Component

You will now be responsible to perform two further distinct refactors upon the code. The refactors you choose is up to
your own discretion; however, you are required to justify your decisions. The hand-in portion should have the following
format:

```sh
Refactor Name:
Justification: 
Code Before:
Code After:
```

The hand in should contain the required information for both of the refactors that you choose.



[Refactoring]: https://github.com/MarcoXZh/OOPJavaCourse/blob/master/Assignment9%20Refactoring%20II/Refactoring/
