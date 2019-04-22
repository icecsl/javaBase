package thinkingInJava.generics;//: generics/FilledListMaker.java
import java.util.*;

public class FilledListMaker<T> {
  List<T> create(T t, int n) {
    List<T> result = new ArrayList<T>();
    for(int i = 0; i < n; i++)
      result.add(t);
    return result;
  }
  public static void main(String[] args) {
    FilledListMaker<String> stringMaker =
      new FilledListMaker<String>();
    List<String> list = stringMaker.create("Hello", 4);
    System.out.println(list);
//
//    FilledListMaker<String>[] a = new FilledListMaker<String>()[10];
//    FilledListMaker<String>[] b;
//    FilledListMaker[] c = new FilledListMaker[2];
//    b=(FilledListMaker<String>[])c;
//    b[0] = new FilledListMaker<String>();
//    List<String>[] l ;
  }
} /* Output:
[Hello, Hello, Hello, Hello]
*///:~
