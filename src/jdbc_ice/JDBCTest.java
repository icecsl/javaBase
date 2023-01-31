package jdbc_ice;

import java.io.UnsupportedEncodingException;
import java.sql.*;

/**
 * @Author: huangbingjing
 * @DATE: 9/29/21
 */
public class JDBCTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String user = "root";
        String password = "123456";
        try {
            // 加载驱动
            Class.forName(driver);
            // 连接数据库
            Connection conn = DriverManager.getConnection(url, user, password);
            if (!conn.isClosed()) {
                System.out.println("Succeeded connecting to the Database!");
            }
            // 创建statement来执行sql语句
            Statement statement = conn.createStatement();

            // 执行
            String querySql = "select * from user_info";
            String updateSql = "INSERT INTO user_info (user_name, password) VALUE ('myName', 'myPassword')";
            statement.executeUpdate(updateSql);
            ResultSet rs = statement.executeQuery(querySql);

            // 结果打印
            System.out.println("执行结果如下所示:");
            System.out.println("-----------------");
            System.out.println(" 姓名" + "\t" + " 密码");
            String lastname = null;
            while (rs.next()) {
                lastname = rs.getString("user_name");
                lastname = new String(lastname.getBytes("ISO-8859-1"), "GB2312");
                System.out.println(rs.getString("password") + "\t" + lastname);
            }
            rs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
