package Day7_16.Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo04 {
    public static void main(String[] args) {
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        Statement statement = null;
        try {
            //连接数据库
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo01", "root", "123");
            //创建sql执行器
            statement = connection.createStatement();

            //sql语句
            String sql = "delete from student where name='test2'";

            //执行语句
            int i = statement.executeUpdate(sql);
            if (i > 0) {
                System.out.println("数据删除成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
