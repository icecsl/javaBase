package thinkingInJava.initialization;

import static sun.misc.Version.print;

public class PrimitiveOverloading {
  void f1(char x) { System.out.print("f1(char) "); }
  void f1(byte x) { System.out.print("f1(byte) "); }
  void f1(short x) { System.out.print("f1(short) "); }
  void f1(int x) { System.out.print("f1(int) "); }
  void f1(long x) { System.out.print("f1(long) "); }
  void f1(float x) { System.out.print("f1(float) "); }
  void f1(double x) { System.out.print("f1(double) "); }

  void f2(byte x) { System.out.print("f2(byte) "); }
  void f2(short x) { System.out.print("f2(short) "); }
  void f2(int x) { System.out.print("f2(int) "); }
  void f2(long x) { System.out.print("f2(long) "); }
  void f2(float x) { System.out.print("f2(float) "); }
  void f2(double x) { System.out.print("f2(double) "); }

  void f3(short x) { System.out.print("f3(short) "); }
  void f3(int x) { System.out.print("f3(int) "); }
  void f3(long x) { System.out.print("f3(long) "); }
  void f3(float x) { System.out.print("f3(float) "); }
  void f3(double x) { System.out.print("f3(double) "); }

  void f4(int x) { System.out.print("f4(int) "); }
  void f4(long x) { System.out.print("f4(long) "); }
  void f4(float x) { System.out.print("f4(float) "); }
  void f4(double x) { System.out.print("f4(double) "); }

  void f5(long x) { System.out.print("f5(long) "); }
  void f5(float x) { System.out.print("f5(float) "); }
  void f5(double x) { System.out.print("f5(double) "); }

  void f6(float x) { System.out.print("f6(float) "); }
  void f6(double x) { System.out.print("f6(double) "); }

  void f7(double x) { System.out.print("f7(double) "); }

  void testConstVal() {
    System.out.println("5: ");
    f1(5);f2(5);f3(5);f4(5);f5(5);f6(5);f7(5); print();
  }
  void testChar() {
    char x = 'x';
    System.out.println("char: ");
    f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x); print();
  }
  void testByte() {
    byte x = 0;
    System.out.println("byte: ");
    f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x); print();
  }
  void testShort() {
    short x = 0;
    System.out.println("short: ");
    f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x); print();
  }
  void testInt() {
    int x = 0;
    System.out.println("int: ");
    f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x); print();
  }
  void testLong() {
    long x = 0;
    System.out.println("long: ");
    f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x); print();
  }
  void testFloat() {
    float x = 0;
    System.out.println("float: ");
    f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x); print();
  }
  void testDouble() {
    double x = 0;
    System.out.println("double: ");
    f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x); print();
  }
  public static void main(String[] args) {
    PrimitiveOverloading p =
      new PrimitiveOverloading();
    p.testConstVal();
    System.out.println();
    p.testChar();
    System.out.println();

    p.testByte();
    System.out.println();

    p.testShort();
    System.out.println();

    p.testInt();
    System.out.println();

    p.testLong();
    System.out.println();

    p.testFloat();
    System.out.println();

    p.testDouble();
  }
} /* Output:
5: f1(int) f2(int) f3(int) f4(int) f5(long) f6(float) f7(double)
char: f1(char) f2(int) f3(int) f4(int) f5(long) f6(float) f7(double)
byte: f1(byte) f2(byte) f3(short) f4(int) f5(long) f6(float) f7(double)
short: f1(short) f2(short) f3(short) f4(int) f5(long) f6(float) f7(double)
int: f1(int) f2(int) f3(int) f4(int) f5(long) f6(float) f7(double)
long: f1(long) f2(long) f3(long) f4(long) f5(long) f6(float) f7(double)
float: f1(float) f2(float) f3(float) f4(float) f5(float) f6(float) f7(double)
double: f1(double) f2(double) f3(double) f4(double) f5(double) f6(double) f7(double)
*///:~
