package thinkingInJava.innerclass;//: innerclasses/DotNew.java
// Creating an inner class directly using the .new syntax.

public class DotNew {
  public class Inner {}
  private Inner inner = new Inner();
  public static void main(String[] args) {
//    List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
    DotNew dn = new DotNew();
    Inner dni = dn.new Inner();
  }
} ///:~
