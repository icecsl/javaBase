package thinkingInJava.polymorphism.dynamicBinding;

/**
 * @Author: huangbingjing
 * @DATE: 2021-03-22
 */
public class DynamicBindTest {

    public static void main(String[] args) {

        DynamicBindTest d = new DynamicBindTest();
        d.doSth(new Son());
    }

    public void doSth(Father f) {
        f.play_static();
        //f.play_private(); 无法访问父类的private方法，编译器报错。
        f.play_final();
        f.play_other();
    }

}

class Father{
    public String name = "Father";

    static void play_static() {
        System.out.println("Father static play");
    }

    final void play_final() {
        System.out.println("Father final play");
    }

    private void play_private() {
        System.out.println("Father private play");
    }

    void play_other() {
        System.out.println("Father common play");
    }
}

class Son extends Father{
    public String name = "Son";

    static void play_static() {
        System.out.println("Son static play");
    }

    /*final void play_final() {  // 无法重写父类的final方法， 否则编译器标错。
        System.out.println("Son play");
    }*/

    private void play_private() {
        System.out.println("Son private play");
    }

    @Override
    void play_other() {
        System.out.println("Son common play");
    }
}

/**
 Father play
 Father play
 Son play
 Father play
 Father play
 Father play
 */