package headFirst.Strategy;

/**
 * Created by huangbingjing on 2016/9/23.
 */
public abstract class Duck {

    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;
    int i;

    //呱呱叫
    public void performQuack(){
        quackBehavior.quack();
    }
    public void performFly(){
        flyBehavior.fly();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    //游泳
    public void swim(){
        System.out.println("all duck can swim");
    }
    //外观
    public abstract void display();
}
