package Day7_10.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReadUtil {

    //创建泛型方法
    //         泛型方法标识   方法名
    public static <T> List<T> readData(String filename,Class<T> clazz) throws Exception{
        //            返回值          传递参数  路径名        类的class对象

        //创建List对象存储读取到的东西
        ArrayList<T> arr = new ArrayList<>();

        //先读取文件内容
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line =null;
        while((line=br.readLine())!=null){
            //对line进行切割，获得字段值数组
            String[] strs= line.split(",");
            //strs的长度对应的就是该类(T)的属性个数

            //创建该类(T)的实例化对象，最后添加的就是该对象
            T dx =  clazz.newInstance();
            //等价于clazz.getConstructor().newInstance()

            //获得该Class的属性集合,属性都是私有化的，所以要获取全部属性方法
            Field[] fields = clazz.getDeclaredFields();

            //遍历属性集合
            for (int i = 0; i <fields.length ; i++) {

                //发现对象属性赋值的方法都是set开头的
                // 所以我们需要拼接处 set开头的方法名
                //set方法的命名规则
                //set + 属性名(第一个字母大写)

                //获得属性的名字
                String fieldName = fields[i].getName();

                                            //第一个字母转大写                        拼接上之后的字符串
                String methodName ="set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);

                //set方法，都需要传入一个参数类型,所以需要获得该属性的数据类型
                //获得参数类型
                Class type = fields[i].getType();

                //根据我们拼接出来的名字和数据类型去找方法
                Method method = clazz.getMethod(methodName, type);

                //获得到了方法，我们需要去调用，但是有问题，我们类中的属性有很多类型
                //但是我们获得到的值都是字符串类型的，所以需要去判断去完成类型转换
                if(type == int.class){
                    //传入我们需要设置的对象，以及值
                    // 不需要去接收
                                            //转换类型
                    method.invoke(dx,Integer.parseInt(strs[i]));
                }else {
                    //是字符串类型，就不需要转换，直接调用方法赋值
                    method.invoke(dx,strs[i]);
                }
            }

            //添加对象到集合中
            arr.add(dx);

        }

        //返回集合
        return  arr;
    }

}
