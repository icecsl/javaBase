package thinkingInJava.initialization_5;


/**
 * 在构造器中调用构造器
 */
public class Flower {

    int petalCount = 0;
    String s = "initial value";

    Flower(int petals) {
        petalCount = petals;
        System.out.println("Constructor w/ int arg only, petalCount= " + petalCount);
        // eg1: 调用另一个构造器的时候，必须将调用放在第一处
        // this("a");
    }

    Flower(String ss) {
        System.out.println("Constructor w/ String arg only, s = " + ss);
        s = ss;
    }

    Flower(String s, int petals) {
        // eg2: 可以调另一个构造器, 但不能同时调2个构造器
        this(petals);
        // this(s);
        this.s = s; // 区分成员s和参数s
        System.out.println("String & int args");
    }

    Flower() {
        this("hi", 47);
        System.out.println("default constructor (no args)");
    }

    void printPetalCount() {
        // eg3: 不能在其他方法中调用构造器。
        //! this(11);
        System.out.println("petalCount = " + petalCount + " s = " + s);
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
