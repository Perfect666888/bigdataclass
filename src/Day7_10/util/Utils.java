package Day7_10.util;

import Day7_10.bean.Score;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Utils {

    public static void addRank(List<String> list){
        for (int i = 0; i < list.size(); i++) {
            //获得原先的字符串
            String getLine =list.get(i);
            //拼接新字符串
            //格式   原字符串+ 名次
            String newLine = getLine+"\t"+(i+1);
            //覆盖掉原先位置的字符串
            list.set(i, newLine);
        }
    }


    //把集合存入文件的方法
    public static void saveToFile(List<String> list,String filename) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

        //遍历集合，存储到文件中
        for (String line : list) {
            bw.write(line);
            bw.newLine();
        }

        //释放资源
        bw.close();

    }


    public static HashMap<String, Integer> getSumMap(List<Score> scores) throws Exception{

        //创建hashmap对象存放数据
        HashMap<String, Integer> summap = new HashMap<>();

        for (Score score : scores) {
            //通过学号去找map中对应的总成绩
            Integer value =summap.get(score.getSno());
            if(value==null){
                //没有就添加第一次的成绩
                summap.put(score.getSno(), score.getGrade());
            }else{
                //有，就把成绩累加
                summap.put(score.getSno(), value+score.getGrade());
            }

        }
        return summap;
    }

}
