package Day7_16.RegisterAndLogin.RlUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginUtil {
    public static boolean existUserName(String userName) throws SQLException {

        //判断用户名在数据库中是否已经存在
        //连接数据库
        Connection connection = DBUtils.getConnection();
        //创建数据库执行对象
        Statement statement = connection.createStatement();
        //创建数据库查询语句
        String sql="select * from Day7_16 where userName='"+userName+"'";
        System.out.println(sql);
        //执行sql语句
        ResultSet resultSet = statement.executeQuery(sql);

        //判断是不是有结果
        boolean flag = resultSet.next();
        //释放资源
        DBUtils.close(connection,statement);
        return flag;

    }



    public static void changePassword(String userName) throws SQLException {
        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        //创建新密码对象，存储
        String newpass =null;
        //因为密码需要 二次核对，所以还是使用死循环
        boolean flag =true;
        while(flag) {
            System.out.println("请输入第一遍新密码");
            //键盘录入对象存储第一次密码
            String pass1 = sc.next();
            System.out.println("请确认密码");
            //存储第二次密码
            String pass2 = sc.next();

            //判断两次密码是否相同
            if(pass1.equals(pass2)){
                //对新密码赋值
                //需要加密
                newpass=MD5Util.getMD5(pass1);
                flag=false;
            }else{
                System.out.println("两次密码录入不同，请重新录入");
            }
        }
        //获得到了新密码和用户名，把信息写入到数据库中
        //连接数据库
        Connection connection = DBUtils.getConnection();
        //创建sql执行对象
        Statement statement = connection.createStatement();

        //创建sql语句
        String sql ="update Day7_16 set passWord ='"+newpass+"' where userName='"+userName+"'";
        //执行sql
        int i = statement.executeUpdate(sql);
        if(i>0){
            System.out.println("密码更改成功");
        }


    }
}
