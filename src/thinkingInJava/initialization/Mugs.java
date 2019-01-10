package thinkingInJava.initialization;//: initialization/Mugs.java
// Java "Instance Initialization."
class Mug {
  Mug(int marker) {
    System.out.println("Mug(" + marker + ")");
  }
  void f(int marker) {
    System.out.println("f(" + marker + ")");
  }
}

class StaticTest{
  public static final String name = "StaticTest";
  static {
    System.out.println(" StaticTest ");
  }

  public static final int age = 11;
  public static final int len = "StaticTest".length();


}

public class Mugs {


  Mug mug1 = new Mug(7);
  Mug mug2;
  {
    mug1 = new Mug(1);
    mug2 = new Mug(2);
    System.out.println("mug1 & mug2 initialized");
  }


  Mugs() {
    System.out.println("Mugs()");
  }
  Mugs(int i) {
    System.out.println("Mugs(int)");
  }
  public static void main(String[] args) {
    System.out.println("Inside main()");
    new Mugs();
    System.out.println("new Mugs() completed");
    new Mugs(1);
    System.out.println("new Mugs(1) completed");

    System.out.println(StaticTest.name);
    System.out.println(StaticTest.age);
    System.out.println(StaticTest.len);
  }
} /* Output:
Inside main()
Mug(1)
Mug(2)
mug1 & mug2 initialized
Mugs()
new Mugs() completed
Mug(1)
Mug(2)
mug1 & mug2 initialized
Mugs(int)
new Mugs(1) completed
*///:~
