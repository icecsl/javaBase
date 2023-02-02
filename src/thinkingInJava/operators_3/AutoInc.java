package thinkingInJava.operators_3;//: operators_3/AutoInc.java
// Demonstrates the ++ and -- operators_3.

/**
 * i++、 ++i的测试
 */
public class AutoInc {
  public static void main(String[] args) {
    int i = 1;
    System.out.println("i : " + i);
    System.out.println("++i : " + ++i); // Pre-increment
    System.out.println("i++ : " + i++); // Post-increment
    System.out.println("i : " + i);
    System.out.println("--i : " + --i); // Pre-decrement
    System.out.println("i-- : " + i--); // Post-decrement
    System.out.println("i : " + i);
  }
}

/* Output:
i : 1
++i : 2
i++ : 2
i : 3
--i : 2
i-- : 2
i : 1
*///:~
