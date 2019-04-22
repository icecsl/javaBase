package thinkingInJava.arrays;//: arrays/ArrayOptions.java
// Initialization & re-assignment of arrays.
import java.util.Arrays;

public class ArrayOptions {
  public static void main(String[] args) {
    // Arrays of objects:
    ArrayOptions[] a; // Local uninitialized variable
    ArrayOptions[] b = new ArrayOptions[5];
    // The references inside the array are
    // automatically initialized to null:
    System.out.println("b: " + Arrays.toString(b));
    ArrayOptions[] c = new ArrayOptions[4];
    for(int i = 0; i < c.length; i++)
      if(c[i] == null) // Can test for null reference
        c[i] = new ArrayOptions();
    // Aggregate initialization:
    ArrayOptions[] d = { new ArrayOptions(),
      new ArrayOptions(), new ArrayOptions()
    };
    // Dynamic aggregate initialization:
    a = new ArrayOptions[]{
      new ArrayOptions(), new ArrayOptions(),
    };
    // (Trailing comma is optional in both cases)
    System.out.println("a.length = " + a.length);
    System.out.println("b.length = " + b.length);
    System.out.println("c.length = " + c.length);
    System.out.println("d.length = " + d.length);
    a = d;
    System.out.println("a.length = " + a.length);

    // Arrays of primitives:
    int[] e; // Null reference
    int[] f = new int[5];
    // The primitives inside the array are
    // automatically initialized to zero:
    System.out.println("f: " + Arrays.toString(f));
    int[] g = new int[4];
    for(int i = 0; i < g.length; i++)
      g[i] = i*i;
    int[] h = { 11, 47, 93 };
    // Compile error: variable e not initialized:
    //!System.out.println("e.length = " + e.length);
    System.out.println("f.length = " + f.length);
    System.out.println("g.length = " + g.length);
    System.out.println("h.length = " + h.length);
    e = h;
    System.out.println("e.length = " + e.length);
    e = new int[]{ 1, 2 };
    System.out.println("e.length = " + e.length);

    char[] chars =  new char[5];
    System.out.println("chars = " + Arrays.toString(chars));
    boolean[] booleans =  new boolean[5];
    System.out.println("chars = " + Arrays.toString(booleans));
  }
} /* Output:
b: [null, null, null, null, null]
a.length = 2
b.length = 5
c.length = 4
d.length = 3
a.length = 3
f: [0, 0, 0, 0, 0]
f.length = 5
g.length = 4
h.length = 3
e.length = 3
e.length = 2
*///:~
