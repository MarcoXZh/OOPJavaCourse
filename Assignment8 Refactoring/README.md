# Assignment 8: Refactoring

  - Full mark: 20 points

  - Source code: N/A.

For the assignment, you will need to find out information about refactoring patterns, which does not appear in the
lecture slides. The following location is an excellent starting point: http://www.refactoring.com/catalog/index.html.


## 1. Consider the following two code fragments.

Which fragment is more understandable? And why? (Hint: Think code smells)

### A.

```java
double potentialEnergy(double mass, double height) {
    return mass * height * 9.81;
}
```

### B.

```java
static final double g = 9.81;
double potentialEnergy(double mass, double height) {
    return mass * g * height;
}
```


## 2. Consider the following code fragment.

```java
public int funny(int a, int b) {
    int temp = a * b;
    if (temp > 100) {
        return temp * 0.95;
    } else {
        return temp * 0.25;
    }
}
```

Apply the following refactoring patterns to this code fragment:

A. *Inline Temp*

B. *Extract Method Followed by Replace Temp with Query*

C. Discuss the two new code fragments, which refactoring pattern is more appropriate in this situation? And why?


## 3. Consider the following two code fragments.

### A.

```java
private int currentBalance;
int withdrawFromBankAccount(int amountToBeWithdrawn) {
    if (amountToBeWithdrawn > currentBalance)
        return -1;
    else {
        currentBalance -= amountToBeWithdrawn;
        return 0;
    }
}
```

### B.

```java
private int currentBalance;
void withdrawFromBankAccount(int amountToBeWithdrawn) throws BalanceException {
    if (amountToBeWithdrawn > currentBalance)
        throw new BalanceException();       // You can assume that BalanceException is defined
    currentBalance -= amountToBeWithdrawn;
}
```

Which refactoring pattern has been applied to the first fragment to transform it into the second code fragment? Explain
why the second code fragment is superior to the first fragment.


## 4. Consider the following two code fragments (adapted from `java.lang.Long`).

### A.

```java
public static Long valueOf(long l) {
    final int offset = 128;
    if (l >= - 128 && l <= 127) {       // will cache
        return LongCache.cache[(int) l + offset];
    }
    return new Long(l);
}
```

### B.

```java
public static Long valueOf(long l) {
    if (l >= - 128 && l <= 127) {       // will cache
        return LongCache.cache[(int) l + 128];
    }
    return new Long(l);
}
```

Fragment A is translated into Fragment B by applying the *Inline Temp* refactoring; and Fragment B is translated into
Fragment A by applying the *Introduce Explaining Variable* refactoring. Provide possible situations (or contexts) where
it would be advantageous to apply either refactoring to the appropriate code fragment.


## 5. Consider the following two code fragments.

### A.

```java
public class A {
    public int k(long i) {
        return 10;
    }
}
public class B extends A {
    public int k(int i) {
        return 20;
    }
    public static void main(String[] args) {
        System.out.println(new A().k(2));
    }
}
```

### B.

```java
public class A {
    public int k(long i) {
        return 10;
    }
    public int k(int i) {
        return 20;
    }
}
public class B extends A {
    public static void main(String[] args) {
        System.out.println(new A().k(2));
    }
}
```

Which refactoring pattern has been applied to the first fragment to transform it into the second code fragment? Explain
the impact (upon the results from function test) of the transformation.
