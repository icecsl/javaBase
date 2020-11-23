//: polymorphism/Sandwich.java
// Order of constructor calls.
package thinkingInJava.polymorphism;
class Meal {
  Meal() {
    System.out.println("Meal()"); }
  static {
    System.out.println("Meal() static field");
  }
  {
    System.out.println("Meal filed create");
  }
}

class Bread {
  static {
    System.out.println("Bread() static field");
  }
  Bread() { System.out.println("Bread()"); }
}

class Cheese {
  static {
    System.out.println("Cheese() static field");
  }
  Cheese() { System.out.println("Cheese()"); }
}

class Lettuce {
  static {
    System.out.println("Lettuce() static field");
  }
  Lettuce() { System.out.println("Lettuce()"); }
}

class Lunch extends Meal {
  static {
    System.out.println("Lunch() static field");
  }
  Lunch() { System.out.println("Lunch()"); }
}

class PortableLunch extends Lunch {
  static {
    System.out.println("PortableLunch() static field");
  }
  PortableLunch() { System.out.println("PortableLunch()");}
}

public class Sandwich extends PortableLunch {
  static {
    System.out.println("Sandwich() static field");
  }
  private Bread b = new Bread();
  private Cheese c = new Cheese();
  private Lettuce l = new Lettuce();
  public Sandwich() { System.out.println("Sandwich()"); }
  public static void main(String[] args) {
    System.out.println("begin----");
    new Sandwich();
  }
} /* Output:
Meal()
Lunch()
PortableLunch()
Bread()
Cheese()
Lettuce()
Sandwich()
*///:~
