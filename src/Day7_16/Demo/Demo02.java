package Day7_16.Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02 {
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

            //创建sql语句
            String sqlstr ="insert into student values ('000001','test',13,'男','shja')";

            //执行sql语句
            int flag = statement.executeUpdate(sqlstr);
            if(flag>0){
                System.out.println("执行成功");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源

            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

    }
}
