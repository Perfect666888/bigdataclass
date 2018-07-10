package Day7_7;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class Demo01_2 {

    public static void main(String[] args) {
        //创建gson对象
        Gson gson = new Gson();

        //创建user对象
        User u1 = new User("老王", 24);

        //输出对象
        System.out.println("类的默认toString方法" + u1);

        //转换为json格式输出
        System.out.println("json格式输出" + gson.toJson(u1, User.class));


        //把json格式的转换为user
        System.out.println("转换回user=======" + gson.fromJson((gson.toJson(u1, User.class)), User.class));


        System.out.println("---------user集合的json处理------------");
        ArrayList<User> arr = new ArrayList<User>();

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

        String sarr = gson.toJson(arr);

        System.out.println(sarr);

        //转换为集合
        ArrayList<User> newuarr = gson.fromJson(sarr, new TypeToken<ArrayList<User>>() {
        }.getType());

        for (User user : newuarr) {
            System.out.println(user);
        }


    }
}
