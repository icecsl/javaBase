package leetcode.grid;

/**
 * @Author: huangbingjing
 * @DATE: 2020-04-17
 */
public class IdGenerator {

    private static int ID = 0;

    public static int getId(){
        ID = ID + 1;
        return ID;
    }

}
