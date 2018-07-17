
package Day7_10.util;


import Day7_10.bean.Student;
import Day7_10.compare.sumSort;

import java.util.*;

public class SumGradeUtil2 {


    //2.1.1	分班级排名，将排名后的结果保存到文件，
//    需要有学号，姓名，总分，名次。文件名称使用对应科目名称（使用hashmap,arraylist,collections）
    public static void getSumByClass() throws Exception {


        //调用方法获得总分map
        HashMap<String, Integer> summap = Utils.getSumMap();

        //在这基础上再去关联学生表
        List<Student> students = ReadUtil.readData("F:\\BigData\\IDEA\\bigdataclass\\src\\Day7_10\\data\\students.txt", Student.class);

        //分班级排名，所以使用hashmap去存放    key 班级   value   学号，姓名，总分，名次的集合
        //创建hashmap存放
        HashMap<String, ArrayList<String>> getAll = new HashMap<>();

        //通过遍历学生集合，去获得班级，并存入
        for (Student student : students) {
            //获得班级
            String classname = student.getClassname();
            //创建value对象
            ArrayList<String> value = getAll.get(classname);
            //拼接集合中需要存入的字符串
            // 学号，姓名，总分，
            String line = student.getSno() + "\t" + student.getSname() + "\t" + summap.get(student.getSno());

            //比较map里有没有存放过这个班级的数据
            if (value == null) {
                //要先初始化
                value = new ArrayList<String>();
                value.add(line);
                getAll.put(classname, value);
            } else {
                value.add(line);
            }
        }

        //查看获得到map
//        for (Map.Entry<String, ArrayList<String>> entry : getAll.entrySet()) {
//            System.out.println(entry.getKey()+"============================");
//            ArrayList<String> values = entry.getValue();
//            for (String value : values) {
//                System.out.println(value);
//            }
//        }


        //获得了这样结构的hashmap
        //key 班级  value 集合(学号，姓名，总分)未排序
        //对集合排序
        for (Map.Entry<String, ArrayList<String>> entry : getAll.entrySet()) {

            ArrayList<String> values = entry.getValue();
            //排序
            Collections.sort(values, new sumSort());
            //添加序号
            Utils.addRank(values);
            //拼接filename
            String fileName ="F:\\BigData\\IDEA\\bigdataclass\\src\\Day7_10\\Result\\"+entry.getKey()+".txt";

            //调用写入方法完成写入文件
            Utils.saveToFile(values,fileName);

        }
        //查看排序添加编号后的map
//        for (Map.Entry<String, ArrayList<String>> entry : getAll.entrySet()) {
//            System.out.println(entry.getKey()+"============================");
//            ArrayList<String> values = entry.getValue();
//            for (String value : values) {
//                System.out.println(value);
//            }
//        }

        //发现参数相同，直接写入到上面的for循环中
//        //把整理的排序存入到不同文件中
//        for (Map.Entry<String, ArrayList<String>> entry : getAll.entrySet()) {
//            //拼接filename
//            String fileName ="F:\\BigData\\IDEA\\bigdataclass\\src\\Day7_10\\Result\\"+entry.getKey()+".txt";
//            //获得value
//            ArrayList<String> value = entry.getValue();
//            RlUtils.saveToFile(value,fileName);
//
//
//        }




    }

}
