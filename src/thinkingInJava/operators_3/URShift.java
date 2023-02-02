package thinkingInJava.operators_3;//: operators_3/URShift.java
// Test of unsigned right shift.

/**
 * 移位操作符
 */
public class URShift {
  public static void main(String[] args) {

    int i = -1;
    System.out.println(Integer.toBinaryString(i));
    i >>>= 10;
    System.out.println(Integer.toBinaryString(i));
    long l = -1;
    System.out.println(Long.toBinaryString(l));
    l >>>= 10;
    System.out.println(Long.toBinaryString(l));

    // short 和 byte操作时候可能不是正确结果，他们会先被转成int类型，再进行右移操作，然后被截断，赋给原来的类型，这样结果就不对
    short s = -1;
    System.out.println(Integer.toBinaryString(s));
    s >>>= 10;
    System.out.println(Integer.toBinaryString(s));
    byte b = -1;
    System.out.println(Integer.toBinaryString(b));
    b >>>= 10;
    System.out.println(Integer.toBinaryString(b));

    // b移位后不再赋值给原先的b, 没有问题。
    b = -1;
    System.out.println(Integer.toBinaryString(b));
    System.out.println(Integer.toBinaryString(b>>>10));
  }
}

/* Output:
11111111111111111111111111111111
1111111111111111111111
1111111111111111111111111111111111111111111111111111111111111111
111111111111111111111111111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
1111111111111111111111
*///:~
