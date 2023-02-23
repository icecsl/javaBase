package thinkingInJava.initialization_5;//: initialization/OrderOfInitialization.java
// Demonstrates initialization order.


/**
 * 测试初始化顺序: 成员变量 -> 构造器 -> 各类方法被调用
 */
public class OrderOfInitialization {
  public static void main(String[] args) {
    House h = new House();
    h.f(); // Shows that construction is done
  }
}



class Window {
  Window(int marker) { System.out.println("Window(" + marker + ")"); }
}


class House {
  Window w1 = new Window(1); // Before constructor

  // 无参构造器
  House() {
    // Show that we're in the constructor:
    System.out.println("House()");
    w3 = new Window(33); // Reinitialize w3
  }

  Window w2 = new Window(2); // After constructor
  void f() { System.out.println("f()"); }
  Window w3 = new Window(3); // At end
}



/* Output:
Window(1)
Window(2)
Window(3)
House()
Window(33)
f()
*///:~
