package thinkingInJava.initialization_5;

//: initialization/ExplicitStatic.java
// Explicit static initialization with the "static" clause.


/**
 * 显示的静态初始化
 */
public class ExplicitStatic {
  public static void main(String[] args) {
    System.out.println("Inside main()");
    Cups.cup1.f(99);  // (1)
  }
//   static Cups cups1 = new Cups();  // (2)
//   static Cups cups2 = new Cups();  // (2)
}



class Cup {
  Cup(int marker) {
    System.out.println("Cup(" + marker + ")");
  }
  void f(int marker) {
    System.out.println("f(" + marker + ")");
  }
}

class Cups {

  static {
    System.out.println("Cups static()");
    cup1 = new Cup(1);
    cup2 = new Cup(2);
  }

  static Cup cup2 =new Cup(6);//static 按顺序初始化。
  static Cup cup1;

  Cups() {
    System.out.println("Cups()");
  }
}



/* Output:
Inside main()
Cups static()
Cup(1)
Cup(2)
Cup(6)
f(99)
*///:~
