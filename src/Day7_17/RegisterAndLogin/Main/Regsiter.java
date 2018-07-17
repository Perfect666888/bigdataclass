package Day7_17.RegisterAndLogin.Main;


import Day7_17.RegisterAndLogin.RlUtils.DBUtils;
import Day7_17.RegisterAndLogin.RlUtils.LoginUtil;
import Day7_17.RegisterAndLogin.RlUtils.MD5Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Regsiter {
    public static void main(String[] args) throws SQLException {
        System.out.println("---------------------欢迎注册---------------------");
        //输入用户名
        //需要判断用户名是否存在,存在还需要重新录入，所以需要死循环
        //而且用户名在下面写入数据库时需要用到，所以定义在循环外部

        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        //创建用户名
        String userName = null;
        //设定flag
        boolean flag = true;
        //提示只需打印一遍
        System.out.println("请输入用户名");
        while (flag) {
            //键盘录入用户名
            userName = sc.nextLine();
            //判断是否存在
            //存在返回值为true，还需要重新录入名字
            flag = LoginUtil.existUserName(userName);

            //如果是存在，就输出提示，用户名存在
            if (flag) {
                System.out.println("用户名已存在,请重新输入");
            } else {
                //不存在，打印出提示，退出循环
                System.out.println("该用户名可用");
            }
        }
        //这时已经获得到了用户名

        //这时候需要去录入密码
        System.out.println("请输入密码");
        //对密码进行加密
        String password = MD5Util.getMD5(sc.nextLine());

        //写入数据到数据库
        //连接数据库
        Connection connection = DBUtils.getConnection();


        //创建sql语句
        String sql = "insert into Day7_16 values (?,?)";
        //System.out.println(sql);
        //创建sql预执行对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //赋值
        preparedStatement.setObject(1,userName);
        preparedStatement.setObject(2,password);

        //执行sql命令
        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            //打出提示
            System.out.println("注册成功");
        }

        //释放资源
        sc.close();
      DBUtils.closeAll(connection,preparedStatement);

    }
}
