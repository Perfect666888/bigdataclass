package Day7_9.read;

import Day7_9.bean.Cource;
import Day7_9.bean.Score;
import Day7_9.bean.Student;
import Day7_9.util.ForeUtil;
import Day7_9.util.ReadUtil;

import java.util.List;

public class main {
    public static void main(String[] args) throws Exception {
        //调用方法去实现读取数据
        List<Student> students = ReadUtil.readData("F:\\BigData\\IDEA\\bigdataclass\\src\\Day7_9\\data\\students.txt", Student.class);
        List<Score> scores = ReadUtil.readData("F:\\BigData\\IDEA\\bigdataclass\\src\\Day7_9\\data\\score.txt", Score.class);
        List<Cource> cources = ReadUtil.readData("F:\\BigData\\IDEA\\bigdataclass\\src\\Day7_9\\data\\Cource.txt", Cource.class);

        //遍历查看有没有读取到数据
        //ForeUtil.ForList(students, Student.class);
        // ForeUtil.ForList(scores, Score.class);
        ForeUtil.ForList(cources, Cource.class);


    }
}
