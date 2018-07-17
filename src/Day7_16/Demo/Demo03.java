package Day7_16.Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo03 {
    public static void main(String[] args)  {
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //连接数据库
        Connection connection = null;
        Statement statement=null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo01", "root", "123");
            //创建sql执行器
            statement = connection.createStatement();

            //创建sql语句
            String sqlstr ="update student set name ='test2' where name = 'test'";

            //执行sql语句
            int i = statement.executeUpdate(sqlstr);
            if(i>0){
                System.out.println("数据更新成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(statement!=null){
                statement.close();}
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }



    }
}
