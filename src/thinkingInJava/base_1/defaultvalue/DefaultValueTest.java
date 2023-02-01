package thinkingInJava.base_1.defaultvalue;

/**
 * 基础数据类型默认值测试
 * <p>
 * Created by huangbingjing on 18/3/13.
 */
public class DefaultValueTest {

    private boolean aBoolean;
    /**
     * '\u0000' 即null
     */
    private char aChar;
    private byte aByte;
    private short aShort;
    private int anInt;
    private long aLong;
    private float aFloat;
    private double aDouble;

    public static void main(String[] args) {
        DefaultValueTest thinkTest = new DefaultValueTest();
        System.out.println(thinkTest.aBoolean);
        System.out.println(thinkTest.aChar);
        System.out.println(thinkTest.aByte);
        System.out.println(thinkTest.aShort);
        System.out.println(thinkTest.anInt);
        System.out.println(thinkTest.aLong);
        System.out.println(thinkTest.aFloat);
        System.out.println(thinkTest.aDouble);

        System.out.println("=== 显示'\\u0000'字符 === ");
        System.out.println('\u0000');
    }

}

