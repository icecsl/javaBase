package thinkingInJava.initialization;


public class Flower {

  int petalCount = 0;
  String s = "initial value";

  Flower(int petals) {
    this("a");
    petalCount = petals;
    System.out.println("Constructor w/ int arg only, petalCount= "
      + petalCount);
  }

  Flower(String ss) {
    System.out.println("Constructor w/ String arg only, s = " + ss);
    s = ss;
  }

  Flower(String s, int petals) {
    this(petals); //可以调另一个构造器
//!    this(s); // 但不能同时调2个构造器
    this.s = s; // 区分成员s和参数s
    System.out.println("String & int args");
  }

  Flower() {
    this("hi", 47);
    System.out.println("default constructor (no args)");
  }

  void printPetalCount() {
//! this(11); // 不能在其他方法中调用构造器。
    System.out.println("petalCount = " + petalCount + " s = "+ s);
  }

  public static void main(String[] args) {
    Flower x = new Flower();
    x.printPetalCount();
  }
}

/* Output:
Constructor w/ int arg only, petalCount= 47
String & int args
default constructor (no args)
petalCount = 47 s = hi
*///:~
