package Day7_16.Demo;

import java.sql.*;
import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) throws Exception {

        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        //建立连接
        Connection client = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo01", "root", "123");

        //创建sql执行器
        Statement sm = client.createStatement();

        //键盘录入需要查询的学生姓名
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要查询的学生名字");
        String scname=sc.nextLine();
        sc.close();

        //创建需要执行的sql命令
//        String sqlstr = "select * from student limit 10";
        String sqlstr = "select * from student where name ='"+scname+"'";
        //执行命令并接收返回值
        ResultSet resultSet = sm.executeQuery(sqlstr);

        //输出结果
        while(resultSet.next()){
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String age = resultSet.getString(3);
            String gender = resultSet.getString(4);
            String clazz = resultSet.getString(5);
            System.out.println(id+"\t"+name+"\t"+age+"\t"+gender+"\t"+clazz+"\t");
        }

        //释放资源
        sm.close();
        client.close();


    }
}
