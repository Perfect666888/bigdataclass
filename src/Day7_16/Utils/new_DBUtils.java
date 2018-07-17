package Day7_16.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class new_DBUtils {
    static String Driver;
    static String Url;
    static String Username;
    static String Password;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("F:\\BigData\\IDEA\\bigdataclass\\src\\Day7_16\\Utils\\DBUtils.properties"));
            //获得Driver,等值
            Driver = properties.getProperty("Driver");
            Url = properties.getProperty("Url");
            Username = properties.getProperty("Username");
            Password = properties.getProperty("Password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //创建获得连接方法，返回connetion对象
    public static Connection getConnection() throws SQLException {
        //加载驱动
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //创建连接
        Connection connection = null;

        connection = DriverManager.getConnection(Url, Username, Password);

        return connection;
    }

    public static <T> List<T> select(String sql, Class<T> c) {

        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet resultSet = null;

        //创建集合存储数据
        ArrayList<T> arrayLists = new ArrayList<>();

        try {
            //连接数据库
            connection = getConnection();
            //创建sql预执行器
            pstm = connection.prepareStatement(sql);

            //获得预处理结果
             resultSet = pstm.executeQuery();

             while (resultSet.next()) {
                 System.out.println("1");
                 //获得类对象的属性集合
                 Field[] fields = c.getDeclaredFields();
                 //创建Class的实例化对象
                 T t = c.newInstance();
                 //遍历集合,赋值
                 for (int i = 0; i < fields.length; i++) {

                     //根据属性名字去拼接set方法
                     String fieldName = fields[i].getName();
                     //拼接方法
                     String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                     //根据拼接的名字去获得方法
                     Method method = c.getMethod(methodName, fields[i].getType());
                     Object value = null;
                     try {
                         //根据属性名字，去获得在结果中的值,可能有空值
                         value = resultSet.getObject(fieldName);
                         //调用方法赋值
                         method.invoke(t, value);
                     } catch (InvocationTargetException e) {
                         System.out.println(fieldName + "不存在这样的字段");
                     }

                 }
                 //把结果添加到集合中
                 arrayLists.add(t);
             }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            close(connection, pstm, resultSet);
        }


        //返回集合
        return arrayLists;
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
