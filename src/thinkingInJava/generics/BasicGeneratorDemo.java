package thinkingInJava.generics;//: generics/BasicGeneratorDemo.java

import thinkingInJava.typeinfo.pets.Generator;

public class BasicGeneratorDemo {
  public static void main(String[] args) {
    Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
    for(int i = 0; i < 5; i++)
      System.out.println(gen.next());


    CountedObject object = new CountedObject();
    System.out.println(object);
  }
} /* Output:
CountedObject 0
CountedObject 1
CountedObject 2
CountedObject 3
CountedObject 4
*///:~
