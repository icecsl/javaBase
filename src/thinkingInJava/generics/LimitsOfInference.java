package thinkingInJava.generics;//: generics/LimitsOfInference.java
import java.util.List;
import java.util.Map;

public class LimitsOfInference {
  static void
  f(Map<String, List<? extends String>> petPeople) {
    System.out.println(petPeople);
  }
  public static void main(String[] args) {
     f(New.map()); // Does not compile
  }
} ///:~
