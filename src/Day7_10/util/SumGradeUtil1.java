
package Day7_10.util;

import Day7_10.bean.Score;
import Day7_10.bean.Student;
import Day7_10.compare.sumSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class SumGradeUtil1 {


//    2.1.2	按总分排名（文理科分开），将排名后的结果保存到文件，
//    需要有学号，姓名，性别，学生班级，总分，名次

    public static void getsummap() throws Exception {


        //调用方法获得总分map
        HashMap<String, Integer> summap = Utils.getSumMap();

        //在这基础上再去关联学生表
        List<Student> students = ReadUtil.readData("F:\\BigData\\IDEA\\bigdataclass\\src\\Day7_10\\data\\students.txt", Student.class);

        //两表之间关联，存入到新的集合
        //文科集合
        ArrayList<String> wkArr = new ArrayList<>();
        //理科集合
        ArrayList<String> lkArr = new ArrayList<>();

        //遍历集合做关联
        for (Student student : students) {
            //获得该学号的总成绩
            Integer sumValue = summap.get(student.getSno());
            //拼接格式        学号  名字 性别  班级  总成绩
            String  line =student.getSno()+"\t"+student.getSname()+"\t"+student.getSex()+"\t"+student.getClassname()+"\t"+sumValue;

           //查看拼接效果
           // System.out.println(line);
            //班级名字是否以XXXX开头
            if(student.getClassname().startsWith("文科")){
                wkArr.add(line);
            }else{
                lkArr.add(line);
            }
        }

        //遍历集合查看结果
//        for (String s : wkArr) {
//            System.out.println(s);
//        }

//        for (String s : lkArr) {
//            System.out.println(s);
//        }


        //已经获得这种格式的集合      学号  名字 性别  班级  总成绩
        //还需要完成排序和增加名次

        //排序
        Collections.sort(wkArr,new sumSort());
        Collections.sort(lkArr,new sumSort());

        //查看排序后效果
//        for (String s : wkArr) {
//            System.out.println(s);
//        }

//        for (String s : lkArr) {
//            System.out.println(s);
//        }

        //已经获得排序集合      学号  名字 性别  班级  总成绩
        //添加名次
        Utils.addRank(wkArr);
        Utils.addRank(lkArr);

//        //查看添加名次后效果
//        for (String s : wkArr) {
//            System.out.println(s);
//        }
//        for (String s : lkArr) {
//            System.out.println(s);
//        }

        //写入文件中
        Utils.saveToFile(wkArr, "F:\\BigData\\IDEA\\bigdataclass\\src\\Day7_10\\Result\\文科.txt");
        Utils.saveToFile(lkArr, "F:\\BigData\\IDEA\\bigdataclass\\src\\Day7_10\\Result\\理科.txt");


    }

}
