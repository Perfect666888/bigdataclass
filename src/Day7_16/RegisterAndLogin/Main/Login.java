package Day7_16.RegisterAndLogin.Main;

import Day7_16.RegisterAndLogin.RlUtils.DBUtils;
import Day7_16.RegisterAndLogin.RlUtils.LoginUtil;
import Day7_16.RegisterAndLogin.RlUtils.MD5Util;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) throws SQLException {
        //登陆,需要先判断用户名是否存在
        //框架和注册差不多

        //登陆界面
        System.out.println("---------------登陆----------------");
        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        //创建用户名
        String userName=null;
        //提示
        System.out.println("请输入用户名");
        //设置flag,用户名不对时,一直录入
        boolean flag =true;
        while(flag){
            //获得键盘录入的用户名
            userName = sc.nextLine();
            //判断用户名是否存在
            //存在返回真,存在就可以登陆，需要退出输入用户名界面
            //所以取反
            flag=!LoginUtil.existUserName(userName);

            if(flag){
                System.out.println("用户名不存在，请检查");
                System.out.println("请重新输入用户名");
            }
        }

        //已经获得用户名
        //还需要比对密码，也是死循环，所以设定flag
        //直接对之前的flag重新赋值
        flag=true;
        while(flag){
            //获得键盘录入的密码
            //存入数据库的是加密的，所以也需要加密
            System.out.println("请输入密码");
            String password =MD5Util.getMD5(sc.next());

            //与数据库的内容进行比对
            //连接数据库
            Connection connection = DBUtils.getConnection();
            Statement statement = connection.createStatement();
            //创建sql语句
            String sql ="select * from Day7_16 where userName='"+userName+"'and passWord='"+password+"'";
            System.out.println(sql);
            //执行sql语句
            ResultSet resultSet = statement.executeQuery(sql);
            //判断有没有值,
            //有为真，
            //但需要退出，所以取反
             flag = !resultSet.next();

             if(flag){
                 System.out.println("密码错误 ");
                 System.out.println("请重新输入密码");
             }else{
                 System.out.println("登陆成功");
             }

             //释放资源
            DBUtils.close(connection,statement);

        }

        //登陆成功后选择功能
        while(true){
            System.out.println("1.修改密码");
            System.out.println("2.退出登陆");

            //录入用户选择
            int choose = sc.nextInt();

            if(choose==1){
                //修改密码,需要传入用户名
                LoginUtil.changePassword(userName);
            }else if (choose==2){
                System.out.println("欢迎下次使用");
                System.exit(1);
            }else {
                System.out.println("请重新输入选择");
            }
        }


    }
}
