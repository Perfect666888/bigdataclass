package Day7_7;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class Demo01 {
    public static void main(String[] args) {
        //创建gson对象
        Gson gson =new Gson();
        User user1 =new User("张三",22);
        System.out.println("user格式的输出====="+user1);

        //把user转换为json
        String jstr =gson.toJson(user1,User.class);
        //输出json格式的内容
        System.out.println("json格式的输出====="+jstr);


        //把json格式的字符串转换为对象
        User newuser =gson.fromJson(jstr, User.class);
        System.out.println("转换过来的user======"+newuser);


        System.out.println("---------user集合的json处理------------");
        ArrayList<User> arr =new ArrayList<User>();

        arr.add(new User("小一", 21));
        arr.add(new User("小二", 22));
        arr.add(new User("小三", 23));
        arr.add(new User("小四", 24));
        arr.add(new User("小五", 25));
        arr.add(new User("小六", 26));

        System.out.println("普通集合遍历");
        for (User u : arr) {
            System.out.println(u);
        }

        System.out.println("==========================");

        //转换为json字符串
        String jsarr=gson.toJson(arr);
        System.out.println("集合转换为json字符串的输出");
        System.out.println(jsarr);

        System.out.println("======================");
        //json字符串转换为集合
        ArrayList<User> newarr =gson.fromJson(jsarr, new TypeToken<ArrayList<User>>(){}.getType());
        System.out.println("字符串转换为集合");
        for (User u : newarr) {
            System.out.println(u);
        }




    }
}
