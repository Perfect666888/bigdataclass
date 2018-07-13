package Day7_12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Demo01Words {
    public static void main(String[] args) throws Exception {
        //传入文件路径
        String fileName  = "F:\\BigData\\IDEA\\bigdataclass\\src\\Day7_12\\words.txt";

        //调用方法，传入参数
        CountWords(fileName);

    }

    private static void CountWords(String fileName) throws Exception {

        //需求结果像是map
        //key 单词  value 次数
        HashMap<String, Integer> countMap = new HashMap<>();

        //读取文件
        BufferedReader br = new BufferedReader(new FileReader(fileName));


        //开始读取
        String str= null;
        while((str=br.readLine())!=null){
            //按照格式切割数据
            String[] words = str.split(",");
            //遍历数组
            for (String word : words) {
                //查看该word在map中有没有存在值
                Integer value = countMap.get(word);
                if(value==null){
                    value =1;
                    countMap.put(word, value);
                }else {
                    value++;
                    countMap.put(word, value);
                }
            }
        }

        //遍历结果
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey()+"================="+entry.getValue());
        }




    }
}
