package Day7_7;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("F:\\BigData\\IDEA\\bigdataclass\\src\\Day7_7\\User.json"));
        //创建Gson对象
        Gson gson =new Gson();

        //定义字符串缓冲区存放的读取到的内容
        StringBuilder sb =new StringBuilder();

        String str=null;
        while ((str=br.readLine())!=null){
            sb.append(str);
        }
        //存储文件内容到集合中
        ArrayList<User> arr =gson.fromJson(sb.toString(), new TypeToken<ArrayList<User>>(){}.getType());
        for (User u : arr) {
            System.out.println(u);
        }


    }
}
