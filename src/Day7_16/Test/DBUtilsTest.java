package Day7_16.Test;

import Day7_16.Utils.DBUtils;

import java.util.ArrayList;

public class DBUtilsTest {
    public static void main(String[] args) {
        String sql = "select * from student limit 3";
        ArrayList<ArrayList<String>> selectArr = DBUtils.select(sql);
        for (ArrayList<String> StrArr : selectArr) {
            for (String s : StrArr) {
                System.out.print(s+"\t");
            }
            System.out.println();
        }
    }
}
